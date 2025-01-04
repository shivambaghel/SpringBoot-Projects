package State;

import java.util.Scanner;

public class Exercise {

    public void run() {
        
        MediaPlayer mediaPlayer = new MediaPlayer();
        Scanner sc = new Scanner(System.in);
        
        String choice = sc.next();
        
        switch (choice) {
            case "Play":
                mediaPlayer.play();
                break;
            case "Pause":
                mediaPlayer.setState(new PausedState());
                mediaPlayer.pause();
                break;
            case "Stop":
                mediaPlayer.setState(new StoppedState());
                mediaPlayer.stop();
                break;
            default:
                System.out.println("Invalid choice");
        }
        
        mediaPlayer.displayState();

        sc.close();
    }
}