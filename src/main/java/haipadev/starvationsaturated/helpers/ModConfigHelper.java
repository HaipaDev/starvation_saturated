package haipadev.starvationsaturated.helpers;

import haipadev.starvationsaturated.ModConfig;
import net.minecraft.world.Difficulty;

public class ModConfigHelper {
    private ModConfigHelper(){
    }
    public static ModConfigHelper INSTANCE;
    private final boolean _debug=false;
    public static void init() {
        if(INSTANCE==null) {
            INSTANCE = new ModConfigHelper();
        }
    }
    public boolean getIsFoodAlwaysEdible(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.isFoodAlwaysEdible;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.isFoodAlwaysEdible;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.isFoodAlwaysEdible;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.isFoodAlwaysEdible;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return true;
    }
    public boolean getIsFoodSnack(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.isFoodSnack;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.isFoodSnack;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.isFoodSnack;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.isFoodSnack;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return false;
    }
    public int getConsumeDefaultTime(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.consumeDefaultTime;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.consumeDefaultTime;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.consumeDefaultTime;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.consumeDefaultTime;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 32;
    }
    public int getConsumeSnackTime(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.consumeSnackTime;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.consumeSnackTime;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.consumeSnackTime;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.consumeSnackTime;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 16;
    }
    public boolean getIsFoodInstaUse(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.isFoodInstaUse;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.isFoodInstaUse;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.isFoodInstaUse;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.isFoodInstaUse;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return false;
    }
    public int getFoodStackSizeOverride(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.foodStackSizeOverride;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.foodStackSizeOverride;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.foodStackSizeOverride;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.foodStackSizeOverride;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 0;//DONT OVERRIDE AT ALL
    }
    public int getHungerStart(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.hungerStart;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.hungerStart;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.hungerStart;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.hungerStart;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 20;
    }
    public float getSaturationStart(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.saturationStart;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.saturationStart;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.saturationStart;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.saturationStart;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 5;
    }
    public float getSaturationCapOnAdd(Difficulty difficulty) {
        if(difficulty!=null){
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.saturationCapOnAdd;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.saturationCapOnAdd;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.saturationCapOnAdd;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.saturationCapOnAdd;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 20;
    }
    public int getHungerCapOnAdd(Difficulty difficulty) {
        if(difficulty!=null){
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.hungerCapOnAdd;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.hungerCapOnAdd;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.hungerCapOnAdd;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.hungerCapOnAdd;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 20;
    }
    public boolean getCapSaturationToHunger(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.capSaturationToHunger;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.capSaturationToHunger;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.capSaturationToHunger;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.capSaturationToHunger;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return false;
    }
    public boolean getCapSaturationToMissingHealth(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.capSaturationToMissingHealth;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.capSaturationToMissingHealth;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.capSaturationToMissingHealth;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.capSaturationToMissingHealth;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return true;
    }
    public float getCapSaturationToMissingHealthOverride(Difficulty difficulty){
        if(difficulty!=null) {
            switch (difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.capSaturationToMissingHealthOverride;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.capSaturationToMissingHealthOverride;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.capSaturationToMissingHealthOverride;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.capSaturationToMissingHealthOverride;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 0;
    }
    public int getHungerFastRegenOverride(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.hungerFastRegenOverride;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.hungerFastRegenOverride;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.hungerFastRegenOverride;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.hungerFastRegenOverride;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 1;
    }
    public int getHungerSlowRegenOverride(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.hungerSlowRegenOverride;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.hungerSlowRegenOverride;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.hungerSlowRegenOverride;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.hungerSlowRegenOverride;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 99;
    }
    public int getHungerSlowHealRate(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.hungerSlowHealRate;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.hungerSlowHealRate;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.hungerSlowHealRate;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.hungerSlowHealRate;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 80;
    }
    public int getSaturationFastHealRate(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.saturationFastHealRate;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.saturationFastHealRate;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.saturationFastHealRate;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.saturationFastHealRate;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 10;
    }
    public boolean getTryTakeSaturationOnlyWhenHealing(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.tryTakeSaturationOnlyWhenHealing;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.tryTakeSaturationOnlyWhenHealing;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.tryTakeSaturationOnlyWhenHealing;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.tryTakeSaturationOnlyWhenHealing;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return true;
    }
    public boolean getTryTakeSaturationOnlyWhenSprinting(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.tryTakeSaturationOnlyWhenSprinting;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.tryTakeSaturationOnlyWhenSprinting;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.tryTakeSaturationOnlyWhenSprinting;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.tryTakeSaturationOnlyWhenSprinting;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return true;
    }
    public int getHungerForSprint(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.hungerForSprint;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.hungerForSprint;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.hungerForSprint;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.hungerForSprint;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 6;
    }
    public float getSaturationForSprint(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.saturationForSprint;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.saturationForSprint;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.saturationForSprint;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.saturationForSprint;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 0;
    }
    public float getSprintExhaustion(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.sprintExhaustion;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.sprintExhaustion;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.sprintExhaustion;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.sprintExhaustion;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 0.1F;
    }
    public float getSprintJumpExhaustion(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.sprintJumpExhaustion;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.sprintJumpExhaustion;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.sprintJumpExhaustion;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.sprintJumpExhaustion;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 0.2F;
    }
    public float getJumpExhaustion(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.jumpExhaustion;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.jumpExhaustion;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.jumpExhaustion;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.jumpExhaustion;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 0.05F;
    }
    public int getStarveDamage(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty) {
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.starveDamage;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.starveDamage;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.starveDamage;
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
                    return ModConfig.INSTANCE.peacefulHungerValues.starveDamageRate;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.starveDamageRate;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.starveDamageRate;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.starveDamageRate;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 80;
    }
    public int getDealStarveDamageTill(Difficulty difficulty){
        if(difficulty!=null) {
            switch(difficulty){
                case PEACEFUL -> {
                    return ModConfig.INSTANCE.peacefulHungerValues.dealStarveDamageTill;
                }
                case EASY -> {
                    return ModConfig.INSTANCE.easyHungerValues.dealStarveDamageTill;
                }
                case NORMAL -> {
                    return ModConfig.INSTANCE.normalHungerValues.dealStarveDamageTill;
                }
                case HARD -> {
                    return ModConfig.INSTANCE.hardHungerValues.dealStarveDamageTill;
                }
            }
        }else if(_debug){System.out.println("DIFFICULTY IS NULL");}
        return 0;
    }
}
