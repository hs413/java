public enum Planet {
    MERCURY(1, 1),
    VENUS(2, 2),
    EARTH(3, 3),
    MARS(4, 4),
    JUPITER(5, 5),
    SATURN(6, 6),
    URANUS(7, 7),
    NEPTUNE(8, 8);

    private final double mass;
    private final double radius;
    private final double surfaceGravity;

    private static final double G = 10;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() { return mass; }
    public double radius() { return radius; }
    public double surfaceGravity() { return surfaceGravity; }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }

}
