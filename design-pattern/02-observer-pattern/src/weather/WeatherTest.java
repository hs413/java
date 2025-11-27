package weather;

public class WeatherTest {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
//        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
//        ForecastDisplay forecastDisplay = new ForecastDisplay();

        weatherData.setMeasurements(60, 60, 60);
        weatherData.setMeasurements(70, 70, 70);
        weatherData.setMeasurements(80, 80, 80);
    }

}
