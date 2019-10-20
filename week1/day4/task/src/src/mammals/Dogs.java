package src.mammals;

public class Dogs extends Mammals {
    @Override
    public boolean isHerbivorous() {
        return false;
    }

    @Override
    public String modeOfLoco() {
        return "ground";
    }

    @Override
    public void hasMammaryGlands(){ System.out.println("No mammary glands");;}
}
