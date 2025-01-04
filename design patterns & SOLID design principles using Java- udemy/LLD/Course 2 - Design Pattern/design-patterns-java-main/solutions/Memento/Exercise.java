package Memento;

import java.util.Scanner;

public class Exercise {

    public void run() {
        
        Scanner sc = new Scanner(System.in);
        GraphicEditor graphicEditor = new GraphicEditor();
        Caretaker caretaker = new Caretaker();

        for (int i = 0; i < 3; i++) {
            String shape = sc.next(); // Read shape name
            int x = sc.nextInt();     // Read x position
            int y = sc.nextInt();     // Read y position
            String color = sc.next(); // Read color
            int size = sc.nextInt();  // Read size

            // Set shape attributes based on input
            graphicEditor.setShape(shape, x, y, color, size);
            caretaker.saveState(graphicEditor);
        }
        sc.close();

        // Perform an undo operation
        caretaker.undo(graphicEditor);

        // Print the current shape after undo
        System.out.println(graphicEditor.getShape());
    }
}
