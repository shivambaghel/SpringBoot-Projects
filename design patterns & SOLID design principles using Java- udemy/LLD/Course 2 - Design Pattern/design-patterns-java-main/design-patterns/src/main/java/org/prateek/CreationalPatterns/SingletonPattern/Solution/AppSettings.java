package org.prateek.CreationalPatterns.SingletonPattern.Solution;

public class AppSettings {
    // Step 1: Private static instance of the class
    private static AppSettings instance;

    private String databaseUrl;
    private String apiKey;

    //Step 2 : Private constructor to prevent direct object creation
    private AppSettings(){
        //Read settings from a config file
        databaseUrl = "jdbc:mysql://localhost:3306/mydatabase";
        apiKey = "12345-ABCDE";
    }

    //Step 3: Public static method to get the single instance
    public static AppSettings getInstance(){
        if(instance==null){
            instance = new AppSettings();
        }
        return instance;
    }

    public String getDatabaseUrl(){
        return databaseUrl;
    }
    public String getApiKey(){
        return apiKey;
    }
}
