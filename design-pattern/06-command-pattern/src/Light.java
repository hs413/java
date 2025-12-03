public class Light {
    private String position;

    public Light() {

    }

    public Light(String position) {
        this.position = position;
    }

    public void off() {
        System.out.println("light off" + position);
    }

    public void on() {
        System.out.println("light on" + position);
    }
}
