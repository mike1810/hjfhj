package GenericsTheSecond;

public class Vine implements Comparable<Vine>{

    private String name;

    private double volume;

    private double alcoholPercent;

    private double cost;

    public Vine(String name, double volume, double alcoholPercent, double cost) {
        this.name = name;
        this.volume = volume;
        this.alcoholPercent = alcoholPercent;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(Vine comparedVine) {
        int result = this.name.compareTo(comparedVine.name);
        return Integer.compare(result, 0);
    }
}