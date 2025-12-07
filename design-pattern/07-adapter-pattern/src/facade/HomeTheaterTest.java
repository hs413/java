package facade;

public class HomeTheaterTest {

    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, player, projector, screen, lights);

        homeTheater.watchMovie("ww");
        homeTheater.endMovie();
    }

}
