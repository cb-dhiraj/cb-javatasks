package src.birds;

public class Ostrich extends Birds {
    @Override
    public boolean isHerbivorous() {
        return false;
    }

    @Override
    public String modeOfLoco() {
        return "ground";
    }
}
