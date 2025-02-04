package transaction;

public class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.city = c;
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader: "+this.name + "in " + this.city;
    }
}