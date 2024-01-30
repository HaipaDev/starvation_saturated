package haipadev.starvationsaturated.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;

@Debug(export=true,print=true)
@Mixin(HungerManager.class)
public abstract class HungerManagerMixin {
	@Shadow public abstract int getFoodLevel();
	@Shadow public abstract float getSaturationLevel();
	///
	@Unique
	int starvationsaturated$hungerCap=20;
	@Unique
	float starvationsaturated$saturationCap=20;
	/**
	 * @author haipadev
	 * @reason Don't let hunger go below 0
	 */
	@Redirect(method = "add", at = @At(value = "INVOKE", target = "Ljava/lang/Math;min(II)I"),allow=1)
	private int starvationsaturated$modifyHunger(int a, int b, int food, float saturationModifier) {
		return Math.max(Math.min(food + this.getFoodLevel(), starvationsaturated$hungerCap),0);
	}
	/**
	 * @author haipadev
	 * @reason Uncap saturation above hunger and don't let it go below 0
	 */
	@Redirect(method = "add", at = @At(value = "INVOKE", target = "Ljava/lang/Math;min(FF)F"),allow=1)
	private float starvationsaturated$modifySaturation(float a, float b, int food, float saturationModifier) {
		return Math.max(Math.min(this.getSaturationLevel() + saturationModifier, starvationsaturated$saturationCap),0);
	}
	/**
	 * @author haipadev
	 * @reason Make healing based on purely saturation, replace >= 20 with >=1 hunger tho so saturation wont weirdly save you from starving
	 */
	@ModifyExpressionValue(method = "update", at= @At(value = "CONSTANT", args = "intValue=20"), allow=1)
	private int starvationsaturated$replaceHunger20check(int i) {
		return 1;
	}
	/**
	 * @author haipadev
	 * @reason Disable slow regen when hunger >= 18
	 */
	@ModifyExpressionValue(method = "update", at= @At(value = "CONSTANT", args = "intValue=18"), allow=1)
	private int starvationsaturated$disableSlowRegen(int i) {
		return 99;
	}
	/**
	 * @author haipadev
	 * @reason Disable difficulty check for starvation
	 */
	@ModifyExpressionValue(method = "update", at={
			@At(value="FIELD", target="Lnet/minecraft/world/Difficulty;NORMAL:Lnet/minecraft/world/Difficulty;"),
			@At(value="FIELD", target="Lnet/minecraft/world/Difficulty;HARD:Lnet/minecraft/world/Difficulty;")
	}
	)
	private Difficulty starvationsaturated$ignoreDifCheck(Difficulty original, @Local Difficulty difficulty) {
		return difficulty;
	}
	/**
	 * @author haipadev
	 * @reason Disable normal difficulty check for > 1 health
	 */
	@ModifyExpressionValue(method = "update", at=@At(value="CONSTANT", args="floatValue=1.0"), slice = @Slice(
			from=@At(value = "FIELD",target = "Lnet/minecraft/world/Difficulty;HARD:Lnet/minecraft/world/Difficulty;"),
			to=@At(value = "FIELD",target = "Lnet/minecraft/world/Difficulty;NORMAL:Lnet/minecraft/world/Difficulty;")
	))
	private float starvationsaturated$normalHealthCheckDisable(float i) {
		return 0;
	}

	///
	@Unique
	int peacefulDealStarveDamageTill=4;
	@Unique
	int easyDealStarveDamageTill=4;
	@Unique
	int normalDealStarveDamageTill=4;
	@Unique
	int hardDealStarveDamageTill=4;
	/**
	 * @author haipadev
	 * @reason Replace the starvation check for health with a configured value
	 */
	@ModifyExpressionValue(method = "update", at=@At(value="CONSTANT", args="floatValue=10.0"), slice = @Slice(
			from=@At(value= "INVOKE",target = "Lnet/minecraft/entity/player/PlayerEntity;getHealth()F")
	), allow = 1)
	private float starvationsaturated$starvationHealthCheckPerDifficulty(float i, PlayerEntity player) {
		switch(player.getWorld().getDifficulty()){
			case PEACEFUL -> {
				return peacefulDealStarveDamageTill;
			}
			case EASY -> {
				return easyDealStarveDamageTill;
			}
			case NORMAL -> {
				return normalDealStarveDamageTill;
			}
			case HARD -> {
				return hardDealStarveDamageTill;
			}
		}
		return 0;
	}

	///
	@Unique
	int peacefulDealStarveDamage=1;
	@Unique
	int easyDealStarveDamage=1;
	@Unique
	int normalDealStarveDamage=2;
	@Unique
	int hardDealStarveDamage=4;
	/**
	 * @author haipadev
	 * @reason Replace the starvation damage with a configured value
	 */
	@ModifyArg(method = "update", at=@At(value="INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"),index=1)
	private float starvationsaturated$starvationDamagePerDifficulty(float amount, @Local PlayerEntity player) {
		switch(player.getWorld().getDifficulty()){
			case PEACEFUL -> {
				return peacefulDealStarveDamage;
			}
			case EASY -> {
				return easyDealStarveDamage;
			}
			case NORMAL -> {
				return normalDealStarveDamage;
			}
			case HARD -> {
				return hardDealStarveDamage;
			}
		}
		return 1;
	}

	///
	@Unique
	int peacefulStarveDamageRate=80;
	@Unique
	int easyDealStarveDamageRate=80;
	@Unique
	int normalDealStarveDamageRate=80;
	@Unique
	int hardDealStarveDamageRate=80;
	/**
	 * @author haipadev
	 * @reason Replace the starvation damage with a configured value
	 */
	@ModifyExpressionValue(method = "update", at= @At(value = "CONSTANT", args = "intValue=80", ordinal = 1))
	private int starvationsaturated$starvationDamageRatePerDifficulty(int amount, @Local PlayerEntity player) {
		switch(player.getWorld().getDifficulty()){
			case PEACEFUL -> {
				return peacefulStarveDamageRate;
			}
			case EASY -> {
				return easyDealStarveDamageRate;
			}
			case NORMAL -> {
				return normalDealStarveDamageRate;
			}
			case HARD -> {
				return hardDealStarveDamageRate;
			}
		}
		return 80;
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
	@Unique
	int regenerationTimer=0;
	/**
	 * @author haipadev
	 * @reason Set healing timer to instant
	 */
	@ModifyExpressionValue(method = "update", at= @At(value = "CONSTANT", args = "intValue=10"), slice = @Slice(
			from=@At(value= "INVOKE",target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z")
	), allow=1)
	private int starvationsaturated$setRegenTimer(int original) {
		return regenerationTimer;
	}
	/**
	 * @author haipadev
	 * @reason On exhaustion; take saturation down only when healing, if not, take hunger (kinda glitchy, when healing to full health it will take a bit of hunger, lets call it [intentional game design]
	 */
	@ModifyExpressionValue(method = "update", at= @At(value = "CONSTANT", args = "floatValue=0.0F", ordinal = 0), slice = @Slice(
			from = @At(value= "FIELD",target = "Lnet/minecraft/entity/player/HungerManager;saturationLevel:F"),
			to = @At(value = "FIELD", target = "Lnet/minecraft/world/Difficulty;PEACEFUL:Lnet/minecraft/world/Difficulty;")
	))
	private float starvationsaturated$takeSaturationOnlyWhenHealing(float original, PlayerEntity player) {
		System.out.println("hp: "+player.getHealth()+" / "+player.getMaxHealth());
		if(player.getHealth()<player.getMaxHealth()){System.out.println("taking from saturation");return 0.0F;}
		System.out.println("taking from HUNGER");
		return player.getHungerManager().getFoodLevel();
	}
}