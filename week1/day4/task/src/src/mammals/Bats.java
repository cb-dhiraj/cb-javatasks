package src.mammals;

public class Bats extends Mammals {
    @Override
    public boolean isHerbivorous() {
        return false;
    }

    @Override
    public String modeOfLoco() {
        return "air";
    }

    @Override
    public void hasMammaryGlands(){ System.out.println("No mammary glands");}
}
