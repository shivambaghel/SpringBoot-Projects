package org.prateek.CreationalPatterns.SingletonPattern.Solution;


public class SingletonPattern {
    public static void main(String[] args) {
        AppSettings appSettings = AppSettings.getInstance(); //change this code
        AppSettings appSettingsCopy = AppSettings.getInstance();

        System.out.println(appSettingsCopy.getApiKey());
        System.out.println(appSettings.getApiKey());

        //More memory
        System.out.println(appSettings==appSettingsCopy);

    }
}