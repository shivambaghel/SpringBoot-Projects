package Adapter;

public class NewWeatherService {
    
    private String temperature;
    private String condition;

    public NewWeatherService(String temperature, String condition) {
        this.temperature = temperature;
        this.condition = condition;
    }

    public String fetchWeather() {
        return "{\"temperature\": " + temperature + ", \"condition\": \"" + condition + "\"}";
    }
}