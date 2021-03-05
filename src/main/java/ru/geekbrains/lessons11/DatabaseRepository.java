package ru.geekbrains.lessons11;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseRepository {
    boolean saveWeatherData(WeatherResponse weatherResponse) throws SQLException;

    List<WeatherResponse> getAllSavedData() throws IOException;
}
