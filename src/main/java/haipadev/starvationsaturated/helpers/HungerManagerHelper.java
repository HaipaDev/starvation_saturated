package haipadev.starvationsaturated.helpers;

import haipadev.starvationsaturated.ModConfig;
import net.minecraft.world.Difficulty;

public class HungerManagerHelper {
    private HungerManagerHelper(){
    }
    public static HungerManagerHelper INSTANCE;
    public static void init() {
        if(INSTANCE==null){INSTANCE = new HungerManagerHelper();}
    }
    Difficulty difficulty;
    public Difficulty getDifficulty(){return difficulty;}
    public void setDifficulty(Difficulty value){difficulty=value;}
}