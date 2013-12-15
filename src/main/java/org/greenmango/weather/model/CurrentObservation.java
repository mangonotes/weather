
package org.greenmango.weather.model;

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
public class CurrentObservation {
private String weather;
private Location observation_location;
private String temp_f;

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }



    public Location getObservation_location() {
        return observation_location;
    }

    public void setObservation_location(Location observation_location) {
        this.observation_location = observation_location;
    }

    @Override
    public String toString() {
        return "CurrentObservation{" + "weather=" + weather + ", observation_location=" + observation_location + ", temp_f=" + temp_f + '}';
    }

    

    public String getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(String temp_f) {
        this.temp_f = temp_f;
    }


}
