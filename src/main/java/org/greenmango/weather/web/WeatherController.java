
package org.greenmango.weather.web;

import java.util.Set;
import org.greenmango.weather.service.IWeatherService;
import org.greenmango.weather.service.WeatherServiceImpl;
import org.greenmango.weather.service.ZipNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
@Controller
@RequestMapping(value="/weatherJson")
public class WeatherController {
@Autowired
private WeatherServiceImpl weather;
	
        @RequestMapping(value = "/{zip}", method = RequestMethod.GET)
    public @ResponseBody
    String  getWeather(@PathVariable String zip)  throws ZipNotFoundException{
	
		
                
		return weather.weatherjsonByZipCode(zip); //adding of str object as 'message' parameter

		//return view;
	}

}
