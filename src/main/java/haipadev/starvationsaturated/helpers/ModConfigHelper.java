package haipadev.starvationsaturated.helpers;

import haipadev.starvationsaturated.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.minecraft.world.Difficulty;
import org.apache.commons.lang3.builder.Diff;

import static net.minecraft.world.Difficulty.PEACEFUL;
import static net.minecraft.world.Difficulty.EASY;
import static net.minecraft.world.Difficulty.NORMAL;
import static net.minecraft.world.Difficulty.HARD;

public class ModConfigHelper {
    private ModConfigHelper(){
    }
    public static ModConfigHelper INSTANCE;
    public static void init() {
        if(INSTANCE==null) {
            INSTANCE = new ModConfigHelper();
        }
    }
    public int getDealStarveDamageTillPerDifficulty(Difficulty difficulty){
        switch(difficulty){
            case PEACEFUL -> {
                return ModConfig.INSTANCE.peacefulHugerValues.dealStarveDamageTill;
            }
            case EASY -> {
                return ModConfig.INSTANCE.easyHugerValues.dealStarveDamageTill;
            }
            case NORMAL -> {
                return ModConfig.INSTANCE.normalHugerValues.dealStarveDamageTill;
            }
            case HARD -> {
                return ModConfig.INSTANCE.hardHungerValues.dealStarveDamageTill;
            }
        }
        return 0;
    }
    public int getStarveDamagePerDifficulty(Difficulty difficulty){
        switch(difficulty){
            case PEACEFUL -> {
                return ModConfig.INSTANCE.peacefulHugerValues.starveDamage;
            }
            case EASY -> {
                return ModConfig.INSTANCE.easyHugerValues.starveDamage;
            }
            case NORMAL -> {
                return ModConfig.INSTANCE.normalHugerValues.starveDamage;
            }
            case HARD -> {
                return ModConfig.INSTANCE.hardHungerValues.starveDamage;
            }
        }
        return 1;
    }
    public int getStarveDamageRatePerDifficulty(Difficulty difficulty){
        switch(difficulty){
            case PEACEFUL -> {
                return ModConfig.INSTANCE.peacefulHugerValues.starveDamageRate;
            }
            case EASY -> {
                return ModConfig.INSTANCE.easyHugerValues.starveDamageRate;
            }
            case NORMAL -> {
                return ModConfig.INSTANCE.normalHugerValues.starveDamageRate;
            }
            case HARD -> {
                return ModConfig.INSTANCE.hardHungerValues.starveDamageRate;
            }
        }
        return 80;
    }
    public int getSaturationHealRatePerDifficulty(Difficulty difficulty){
        switch(difficulty){
            case PEACEFUL -> {
                return ModConfig.INSTANCE.peacefulHugerValues.saturationHealRate;
            }
            case EASY -> {
                return ModConfig.INSTANCE.easyHugerValues.saturationHealRate;
            }
            case NORMAL -> {
                return ModConfig.INSTANCE.normalHugerValues.saturationHealRate;
            }
            case HARD -> {
                return ModConfig.INSTANCE.hardHungerValues.saturationHealRate;
            }
        }
        return 10;
    }
    public boolean getTryTakeSaturationOnlyWhenHealing(Difficulty difficulty){
        switch(difficulty){
            case PEACEFUL -> {
                return ModConfig.INSTANCE.peacefulHugerValues.tryTakeSaturationOnlyWhenHealing;
            }
            case EASY -> {
                return ModConfig.INSTANCE.easyHugerValues.tryTakeSaturationOnlyWhenHealing;
            }
            case NORMAL -> {
                return ModConfig.INSTANCE.normalHugerValues.tryTakeSaturationOnlyWhenHealing;
            }
            case HARD -> {
                return ModConfig.INSTANCE.hardHungerValues.tryTakeSaturationOnlyWhenHealing;
            }
        }
        return true;
    }
}
