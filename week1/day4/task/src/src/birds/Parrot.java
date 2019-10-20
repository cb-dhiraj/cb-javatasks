package src.birds;

public class Parrot extends Birds {
    @Override
    public boolean isHerbivorous() {
        return false;
    }

    @Override
    public String modeOfLoco() {
        return "air";
    }
}
