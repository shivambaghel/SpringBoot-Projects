package Proxy;

import java.util.Scanner;

public class Exercise {

    public void run() {
        
        NetworkService networkService = new NetworkServiceProxy();
        Scanner sc = new Scanner(System.in);

        String userInput = sc.nextLine();

        // First call: should fetch from the remote server
        String firstFetch = networkService.fetchData(userInput);
        System.out.println(firstFetch);

        // Second call: should retrieve from the cache
        String secondFetch = networkService.fetchData(userInput);
        System.out.println(secondFetch);

        sc.close();
    }
}