package Facade;

public class HomeTheaterFacade {
    
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;
    private LightingControl lightingControl;

    public HomeTheaterFacade() {
        this.dvdPlayer = new DVDPlayer();
        this.projector = new Projector();
        this.soundSystem = new SoundSystem();
        this.lightingControl = new LightingControl();
    }

    public void watchMovie(int dimmingPercentage, int volumeLevel) {
        System.out.println("Get ready to watch a movie");
        lightingControl.dim(dimmingPercentage);
        projector.on();
        projector.setInput();
        soundSystem.on();
        soundSystem.setVolume(volumeLevel);
        dvdPlayer.play();
        System.out.println("Movie is ready to watch!");
    }
}