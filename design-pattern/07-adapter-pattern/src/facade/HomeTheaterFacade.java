package facade;

public class HomeTheaterFacade {
    Amplifier amp;
    Tuner tuner;
    StreamingPlayer player;
    Projector projector;
    TheaterLights lights;
    Screen screen;

    public HomeTheaterFacade(
        Amplifier amp,
        Tuner tuner,
        StreamingPlayer player,
        Projector projector,
        TheaterLights lights,
        Screen screen
    ) {
        this.amp = amp;
        this.tuner = tuner;
        this.player = player;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
    }

    public void watchMovie(String movie) {
        System.out.println("movie ~~");
        lights.dim(10);
        screen.down();
        projector.on();
        amp.on();
    }

    public void endMovie() {
        System.out.println("end movie ~~");
        lights.off();
        screen.up();
        projector.off();
        amp.off();
    }
}
