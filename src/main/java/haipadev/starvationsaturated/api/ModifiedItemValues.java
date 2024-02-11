package haipadev.starvationsaturated.api;

public class ModifiedItemValues {
    public ModifiedItemValues(){
    }
    private int modifiedStackSize;

    public ModifiedItemValues(int modifiedStackSize) {
        this.modifiedStackSize = modifiedStackSize;
    }

    public int modifiedStackSize() {
        return modifiedStackSize;
    }

    public void setModifiedStackSize(int modifiedStackSize) {
        this.modifiedStackSize = modifiedStackSize;
    }
}
