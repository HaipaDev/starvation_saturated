package haipadev.starvationsaturated.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.terraformersmc.modmenu.util.mod.Mod;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import haipadev.starvationsaturated.ModConfig;

@Debug(export=true,print=true)
@Mixin(HungerManager.class)
public abstract class HungerManagerMixin {
	@Shadow public abstract int getFoodLevel();
	@Shadow public abstract float getSaturationLevel();
	@Shadow private int foodLevel;
	@Shadow private float saturationLevel;
	@Shadow public abstract void setSaturationLevel(float saturationLevel);


	@Inject(method = "<init>",at=@At("TAIL"))
	private void starvationsaturated$setStartHungerAndSaturation(CallbackInfo ci){
		this.foodLevel=ModConfig.INSTANCE.hungerStart;
		this.saturationLevel=ModConfig.INSTANCE.saturationStart;
	}


	/**
	 * @author haipadev
	 * @reason Don't let hunger go below 0
	 */
	@Redirect(method = "add", at = @At(value = "INVOKE", target = "Ljava/lang/Math;min(II)I"),allow=1)
	private int starvationsaturated$modifyHunger(int a, int b, int food, float saturationModifier) {
		return Math.max(
				Math.min(food + this.getFoodLevel(), ModConfig.INSTANCE.hungerCapOnAdd)
				,0);
	}

	/**
	 * @author haipadev
	 * @reason Uncap saturation above hunger and don't let it go below 0
	 */
	@Redirect(method = "add", at = @At(value = "INVOKE", target = "Ljava/lang/Math;min(FF)F"),allow=1)
	private float starvationsaturated$modifySaturation(float a, float b, int food, float saturationModifier) {
		float actualCap=ModConfig.INSTANCE.saturationCapOnAdd;
		if(ModConfig.INSTANCE.capSaturationToHunger){actualCap=food;}
		return Math.max(
				Math.min(this.getSaturationLevel() + saturationModifier, actualCap)
				, 0);
	}

	/**
	 * @author haipadev
	 * @reason Limit saturation to player health difference
	 */
	@Inject(method = "update", at= @At("HEAD"))
	private void starvationsaturated$capSaturationToMissingHealthMixin(PlayerEntity player, CallbackInfo ci){
		if(ModConfig.INSTANCE.capSaturationToMissingHealth) {
			float playerHealthDif=player.getMaxHealth()-player.getHealth();
			setSaturationLevel(Math.max(
					Math.min(getSaturationLevel(), playerHealthDif),
					ModConfig.INSTANCE.capSaturationToMissingHealthOverride
			));
		}
	}

	/**
	 * @author haipadev
	 * @reason Make healing based on purely saturation, replace >= 20 with >=1 hunger tho so saturation wont weirdly save you from starving
	 */
	@ModifyExpressionValue(method = "update", at= @At(value = "CONSTANT", args = "intValue=20"), allow=1)
	private int starvationsaturated$replaceHunger20check(int i) {
		return ModConfig.INSTANCE.hungerFastRegenOverride;
	}

	/**
	 * @author haipadev
	 * @reason Disable slow regen when hunger >= 18
	 */
	@ModifyExpressionValue(method = "update", at= @At(value = "CONSTANT", args = "intValue=18"), allow=1)
	private int starvationsaturated$disableSlowRegen(int i) {
		return ModConfig.INSTANCE.hungerSlowRegenOverride;
	}

	/**
	 * @author haipadev
	 * @reason Ignore the difficulty check for HARD & NORMAL
	 */
	@ModifyExpressionValue(method = "update", at= {
			@At(value = "FIELD", target = "Lnet/minecraft/world/Difficulty;HARD:Lnet/minecraft/world/Difficulty;"),
			@At(value="FIELD", target="Lnet/minecraft/world/Difficulty;NORMAL:Lnet/minecraft/world/Difficulty;")
	})
	private Difficulty starvationsaturated$ignoreHardDifCheck(Difficulty original, @Local Difficulty difficulty) {
		switch(difficulty){
			case PEACEFUL, EASY, HARD -> {return Difficulty.NORMAL;}
            case NORMAL -> {return Difficulty.HARD;}
        }
		return difficulty;
	}

	/**
	 * @author haipadev
	 * @reason Disable normal difficulty check for > 1 health || Useless if im already ignoring the check above
	 */
	@ModifyExpressionValue(method = "update", at=@At(value="CONSTANT", args="floatValue=1.0"), slice = @Slice(
			from=@At(value = "FIELD",target = "Lnet/minecraft/world/Difficulty;HARD:Lnet/minecraft/world/Difficulty;"),
			to=@At(value = "FIELD",target = "Lnet/minecraft/world/Difficulty;NORMAL:Lnet/minecraft/world/Difficulty;")
	))
	private float starvationsaturated$normalHealthCheckDisable(float i) {
		return 20;
	}

	/**
	 * @author haipadev
	 * @reason Replace the starvation check for health with a configured value
	 */
	@ModifyExpressionValue(method = "update", at=@At(value="CONSTANT", args="floatValue=10.0"), slice = @Slice(
			from=@At(value= "INVOKE",target = "Lnet/minecraft/entity/player/PlayerEntity;getHealth()F")
	), allow = 1)
	private float starvationsaturated$starvationHealthCheckPerDifficulty(float i, PlayerEntity player) {
		return ModConfigHelper.INSTANCE.getDealStarveDamageTillPerDifficulty(player.getWorld().getDifficulty());
	}

	/**
	 * @author haipadev
	 * @reason Replace the starvation damage with a configured value
	 */
	@ModifyArg(method = "update", at=@At(value="INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"),index=1)
	private float starvationsaturated$starvationDamagePerDifficulty(float amount, @Local(argsOnly = true) PlayerEntity player) {
		return ModConfigHelper.INSTANCE.getStarveDamagePerDifficulty(player.getWorld().getDifficulty());
	}

	/**
	 * @author haipadev
	 * @reason Replace the starvation damage rate with a configured value
	 */
	@ModifyExpressionValue(method = "update", at= @At(value = "CONSTANT", args = "intValue=80", ordinal = 1))
	private int starvationsaturated$starvationDamageRatePerDifficulty(int amount, @Local(argsOnly = true) PlayerEntity player) {
		return ModConfigHelper.INSTANCE.getStarveDamageRatePerDifficulty(player.getWorld().getDifficulty());
	}

	/**
	 * @author haipadev
	 * @reason Ignore check for limiting hunger only if not peaceful
	 */
	@ModifyExpressionValue(method = "update", at=@At(value="FIELD", target="Lnet/minecraft/world/Difficulty;PEACEFUL:Lnet/minecraft/world/Difficulty;"), allow = 1)
	private Difficulty starvationsaturated$peacefulCheck(Difficulty original, @Local Difficulty difficulty) {
		if(difficulty==Difficulty.PEACEFUL){return Difficulty.NORMAL;}
		return Difficulty.PEACEFUL;
	}

	/**
	 * @author haipadev
	 * @reason Set healing timer
	 */
	@ModifyExpressionValue(method = "update", at= @At(value = "CONSTANT", args = "intValue=10"), slice = @Slice(
			from=@At(value= "INVOKE",target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z")
	), allow=1)
	private int starvationsaturated$setRegenTimer(int original, @Local Difficulty difficulty) {
		return ModConfigHelper.INSTANCE.getSaturationHealRatePerDifficulty(difficulty);
	}

	/**
	 * @author haipadev
	 * @reason On exhaustion; take saturation down only when healing, if not, take hunger
	 * 		(kinda glitchy, when healing to full health it will take a bit of hunger, lets call it [intentional game design])
	 */
	@ModifyExpressionValue(method = "update", at= @At(value = "CONSTANT", args = "floatValue=0.0F", ordinal = 0), slice = @Slice(
			from = @At(value= "FIELD",target = "Lnet/minecraft/entity/player/HungerManager;saturationLevel:F"),
			to = @At(value = "FIELD", target = "Lnet/minecraft/world/Difficulty;PEACEFUL:Lnet/minecraft/world/Difficulty;")
	))
	private float starvationsaturated$takeSaturationOnlyWhenHealing(float original, PlayerEntity player) {
//		System.out.println("hp: "+player.getHealth()+" / "+player.getMaxHealth());
		if(
				(player.getHealth()<player.getMaxHealth() && ModConfigHelper.INSTANCE.getTryTakeSaturationOnlyWhenHealing(player.getWorld().getDifficulty()))
		){
//			System.out.println("taking from saturation");
			return 0.0F;
		}
//		System.out.println("taking from HUNGER");
		return player.getHungerManager().getFoodLevel();
	}
}