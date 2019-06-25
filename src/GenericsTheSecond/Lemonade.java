package GenericsTheSecond;

public class Lemonade implements Comparable<Lemonade>{

    private String name;

    private double volume;

    private double cost;

    public Lemonade(String name, double volume, double cost) {
        this.name = name;
        this.volume = volume;
        this.cost = cost;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(Lemonade lemonade) {
        int result = this.name.compareTo(lemonade.name);
        return Integer.compare(result, 0);
    }
}