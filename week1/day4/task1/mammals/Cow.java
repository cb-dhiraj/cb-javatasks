package week1.day4.task1.mammals;

public class Cow extends Mammals{

    @Override
    public boolean isHerbivorous() {
        return true;
    }

    @Override
    public String modeOfLoco() {
        return "ground";
    }
}
