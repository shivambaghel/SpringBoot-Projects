package State;

public class MediaPlayer {
    
    private State state;
    
    public MediaPlayer() {
        // Initial state is playing
        state = new PlayingState();
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    public void play() {
        state.pressPlay();
    }

    public void stop() {
        state.pressStop();
    }

    public void pause() {
        state.pressPause();
    }

    public void displayState() {
        state.display();
    }
}