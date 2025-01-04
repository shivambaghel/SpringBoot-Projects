package Adapter;

public class NewWeatherServiceAdapter implements WeatherService {
    
    private NewWeatherService newWeatherService;

    public NewWeatherServiceAdapter(NewWeatherService newWeatherService) {
        this.newWeatherService = newWeatherService;
    }

    @Override
    public String getWeatherData() {
        String json = newWeatherService.fetchWeather();
        return json;
    }
}