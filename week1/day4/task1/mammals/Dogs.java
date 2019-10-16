package week1.day4.task1.mammals;

public class Dogs extends Mammals {
    @Override
    public boolean isHerbivorous() {
        return false;
    }

    @Override
    public String modeOfLoco() {
        return "ground";
    }
}
