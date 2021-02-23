package ru.geekbrains.lessons11;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {


    private static final String API_KEY = "hNIADY6ngYPd6OQqzsK9EkLTLOoOvD4n";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String LOCATIONS = "locations";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";
    private static final String CITY = "Санкт-Петербург";
    private static final String FILE = "forecast.json";

    public static void main(String args[]) throws IOException {

        System.out.printf("Хотите узнать погоду в городе %s?\n", CITY);


        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        System.out.printf("Вы ответили: %s, а прогноз в городе %s смотрите в файле %s \n", answer, CITY, FILE);

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();



        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", CITY)
                .build();



        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response responseGetLocationKey = client.newCall(request).execute();

        if(responseGetLocationKey.code() != 200){
            System.out.println("Не получится узнать погоду, извините.");
            return;
        }

        String responseBody = responseGetLocationKey.body().string();
        //System.out.println(responseBody);


        String locationKey = responseBody.split(":")[2];

        locationKey = locationKey.split(",")[0];
        locationKey = locationKey.replaceAll("[^\\p{L}\\p{Nd}]+", "");
        //System.out.println(locationKey);



        url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(locationKey)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();



        request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response responseGetForecast = client.newCall(request).execute();

        if(responseGetForecast.code() != 200){
            System.out.println("Не получится узнать погоду, извините.");
            return;
        }

        responseBody = responseGetForecast.body().string();
        //System.out.println(responseBody);


        try (PrintWriter out = new PrintWriter(FILE)) {
            out.println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}














