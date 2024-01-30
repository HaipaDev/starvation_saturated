package haipadev.starvationsaturated.helpers;

import haipadev.starvationsaturated.ModConfig;
import net.minecraft.world.Difficulty;

public class ModConfigHelper {
    private ModConfigHelper(){
    }
    public static ModConfigHelper INSTANCE;
    public static void init() {
        if(INSTANCE==null) {
            INSTANCE = new ModConfigHelper();
        }
    }
    public boolean getIsFoodAlwaysEdible(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHugerValues.isFoodAlwaysEdible;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHugerValues.isFoodAlwaysEdible;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHugerValues.isFoodAlwaysEdible;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.isFoodAlwaysEdible;
                }
            }
        }else{System.out.println("DIFFICULTY IS NULL");}
        return true;
    }
    public boolean getIsFoodSnack(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHugerValues.isFoodSnack;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHugerValues.isFoodSnack;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHugerValues.isFoodSnack;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.isFoodSnack;
                }
            }
        }else{System.out.println("DIFFICULTY IS NULL");}
        return true;
    }
    public int getHungerStart(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHugerValues.hungerStart;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHugerValues.hungerStart;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHugerValues.hungerStart;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.hungerStart;
                }
            }
        }else{System.out.println("DIFFICULTY IS NULL");}
        return 20;
    }
    public float getSaturationStart(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHugerValues.saturationStart;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHugerValues.saturationStart;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHugerValues.saturationStart;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.saturationStart;
                }
            }
        }else{System.out.println("DIFFICULTY IS NULL");}
        return 5;
    }
    public float getSaturationCapOnAdd(Difficulty difficulty) {
        if(difficulty!=null){
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHugerValues.saturationCapOnAdd;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHugerValues.saturationCapOnAdd;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHugerValues.saturationCapOnAdd;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.saturationCapOnAdd;
                }
            }
        }else{System.out.println("DIFFICULTY IS NULL");}
        return 20;
    }
    public int getHungerCapOnAdd(Difficulty difficulty) {
        if(difficulty!=null){
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHugerValues.hungerCapOnAdd;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHugerValues.hungerCapOnAdd;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHugerValues.hungerCapOnAdd;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.hungerCapOnAdd;
                }
            }
        }else{System.out.println("DIFFICULTY IS NULL");}
        return 20;
    }
    public boolean getCapSaturationToHunger(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHugerValues.capSaturationToHunger;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHugerValues.capSaturationToHunger;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHugerValues.capSaturationToHunger;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.capSaturationToHunger;
                }
            }
        }else{System.out.println("DIFFICULTY IS NULL");}
        return false;
    }
    public boolean getCapSaturationToMissingHealth(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHugerValues.capSaturationToMissingHealth;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHugerValues.capSaturationToMissingHealth;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHugerValues.capSaturationToMissingHealth;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.capSaturationToMissingHealth;
                }
            }
        }else{System.out.println("DIFFICULTY IS NULL");}
        return true;
    }
    public float getCapSaturationToMissingHealthOverride(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHugerValues.capSaturationToMissingHealthOverride;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHugerValues.capSaturationToMissingHealthOverride;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHugerValues.capSaturationToMissingHealthOverride;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.capSaturationToMissingHealthOverride;
                }
            }
        }else{System.out.println("DIFFICULTY IS NULL");}
        return 0;
    }
    public boolean getTryTakeSaturationOnlyWhenHealing(Difficulty difficulty){
        if(difficulty!=null) {
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
        }else{System.out.println("DIFFICULTY IS NULL");}
        return true;
    }
    public int getHungerFastRegenOverride(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHugerValues.hungerFastRegenOverride;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHugerValues.hungerFastRegenOverride;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHugerValues.hungerFastRegenOverride;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.hungerFastRegenOverride;
                }
            }
        }else{System.out.println("DIFFICULTY IS NULL");}
        return 1;
    }
    public int getHungerSlowRegenOverride(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHugerValues.hungerSlowRegenOverride;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHugerValues.hungerSlowRegenOverride;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHugerValues.hungerSlowRegenOverride;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.hungerSlowRegenOverride;
                }
            }
        }else{System.out.println("DIFFICULTY IS NULL");}
        return 99;
    }
    public int getStarveDamage(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty) {
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
        }else{System.out.println("DIFFICULTY IS NULL!");}
        return 1;
    }
    public int getStarveDamageRate(Difficulty difficulty){
        if(difficulty!=null) {
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
        }else{System.out.println("DIFFICULTY IS NULL");}
        return 80;
    }
    public int getDealStarveDamageTill(Difficulty difficulty){
        if(difficulty!=null) {
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
        }else{System.out.println("DIFFICULTY IS NULL");}
        return 0;
    }
    public int getSaturationHealRate(Difficulty difficulty){
        if(difficulty!=null) {
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
        }else{System.out.println("DIFFICULTY IS NULL");}
        return 10;
    }
}
