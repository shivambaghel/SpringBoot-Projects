package Factory;

import java.util.Scanner;

public class Exercise {
    
    public void run() {
        
        Scanner sc = new Scanner(System.in);

        String documentType = sc.nextLine();

        try {
            Document document = DocumentFactory.createDocument(documentType);
            document.displayType();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}