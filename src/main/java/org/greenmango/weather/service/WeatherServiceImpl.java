package org.greenmango.weather.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.greenmango.weather.model.Weather;
import org.greenmango.weather.model.CurrentObservation;
import org.greenmango.weather.model.DisplayModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/*
 * Copyright (c) 2013 Sony John 
 * Contact me @ greenmangoquery@gmail.com
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of
 *  this software and associated documentation files (the "Software"), to deal in
 *  the Software without restriction, including without limitation the rights to
 *  use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 *  the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 *  FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 *  COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 *  IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *  CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
@Service("helloBean")

public class WeatherServiceImpl implements IWeatherService {

    private static final Logger logger = Logger.getLogger( "WeatherServiceImpl" );
    @Autowired
    Environment env;
    @Value("http://api.wunderground.com/api/")
    private String apiCode;
    @Value("Mozilla/5.0")
    private String userAgent;

    @PostConstruct
    private void updateApiUrl() {
        apiCode = apiCode + env.getProperty("apicode");
    }

    public String weatherjsonByZipCode(String zip) throws ZipNotFoundException {

        String url = apiCode + zip + ".json";//"9417.json";
        Gson gson = new GsonBuilder().create();
        StringBuilder sb = new StringBuilder();
        InputStream input = null;
         DisplayModel model = new DisplayModel();
         if (zip.trim().length() !=5)
         {
             model.setErrorMessage("invalid zip code format");
             return gson.toJson(model);
         }
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");

            connection.setRequestProperty("User-Agent", userAgent);

            int responseCode = connection.getResponseCode();
            System.out.println("Resp result " + responseCode);
            input = connection.getInputStream();
            BufferedReader br = null;

            String line;
            br = new BufferedReader(new InputStreamReader(input));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            input.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new ZipNotFoundException(e.getMessage());
        }
        Weather weather = gson.fromJson(sb.toString(), Weather.class);
       
        model.setValid(false);
        if (weather != null && weather.getCurrent_observation() != null) {

            model.setCity(weather.getCurrent_observation().getObservation_location().getCity());
            model.setState(weather.getCurrent_observation().getObservation_location().getState());
            model.setTemp_f(weather.getCurrent_observation().getTemp_f());
            model.setValid(true);
            return gson.toJson(model);
        }
        model.setErrorMessage("Not found Zip Code");

        //print result
        return gson.toJson(model);

    }

    @Override
    public DisplayModel getDisplayModelFromJson(String json) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, DisplayModel.class);
    }

}
