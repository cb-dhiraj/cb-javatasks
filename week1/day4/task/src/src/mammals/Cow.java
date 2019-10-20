package src.mammals;

public class Cow extends Mammals{

    @Override
    public boolean isHerbivorous() {
        return true;
    }

    @Override
    public String modeOfLoco() {
        return "ground";
    }

    @Override
    public void hasMammaryGlands(){ System.out.println("Cow has mammary glands");}
}
