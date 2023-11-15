package com.example.weatherapp2;

import com.example.wetherapp.City;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;
import org.json.*;

public class HelloController {


    private List<City> init()
    {
        List<City> list = new ArrayList<>();
        list.add(new City("Minsk","27.567444","53.893009"));
        list.add(new City("Vitebsk","30.205116","55.187222"));
        list.add(new City("Gomel","29.524830","52.308670"));
        list.add(new City("Grodno","23.813131","53.669353"));
        list.add(new City("Brest","23.734051","52.097622"));
        list.add(new City("Mogilev","30.351590","53.874772"));
        list.add(new City("Moscow","37.617298","55.755825"));
        list.add(new City("Berlin","13.404954","52.520008"));
        list.add(new City("Washington, D.C.","-77.036873","38.907192"));
        list.add(new City("New York","-74.005973","40.712775"));
        list.add(new City("Los Angeles","-118.204651","34.020795"));
        list.add(new City("Las Vegas","-115.150452","36.177791"));
        return list;
    }
    @FXML
    private Label temperatureIs;
    @FXML
    private Label feelsValue;
    @FXML
    private Label tempMinValue;
    @FXML
    private Label tempMaxValue;
    @FXML
    private ComboBox comboBox;
    @FXML
    protected void onHelloButtonClick() throws IOException {

        String main, textCity,lon = "", lat = "" ;
        List<City> list = new ArrayList<>();
        list.addAll(init());
        textCity = comboBox.getSelectionModel().getSelectedItem().toString();
        for (City item: list)
        {
            if(item.getName().equals(textCity))
            {
                lon = item.getLongitude();
                lat = item.getLatitude();
                break;
            }
        }
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=b81fb9e1e634c5b4d4b838db4b2a6c4d");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String str= bufferedReader.readLine();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double tempC = 0;
        JSONObject jsonObject = new JSONObject(str);
        main = jsonObject.get("main").toString();
        JSONObject jsonObjectMain = new JSONObject(main);
        tempC = (Double.valueOf(jsonObjectMain.get("temp").toString())-273);
        temperatureIs.setText("Temperature in "+textCity+" is: "+decimalFormat.format(tempC)+" Celsius");
        feelsValue.setText("Feels like: "+ decimalFormat.format(Double.valueOf(jsonObjectMain.get("feels_like").toString())-273)+" Celsius");
        tempMinValue.setText("Temp min: "+ decimalFormat.format(Double.valueOf(jsonObjectMain.get("temp_min").toString())-273)+" Celsius");
        tempMaxValue.setText("Temp max: "+ decimalFormat.format(Double.valueOf(jsonObjectMain.get("temp_max").toString())-273)+" Celsius");
    }


    public void initialize()
    {
        List<City> list = new ArrayList<>();
        list.addAll(init());
        for (City item : list)
        {
            comboBox.getItems().add(item.getName());
        }
    };


}