package week1.day4.task1.birds;

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
