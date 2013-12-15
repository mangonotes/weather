/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.greenmango.weather.test;

import org.greenmango.weather.config.AppConfig;
import org.greenmango.weather.config.WebConfig;
import org.greenmango.weather.model.DisplayModel;
import org.greenmango.weather.service.IWeatherService;
import org.greenmango.weather.service.WeatherServiceImpl;
import org.greenmango.weather.service.ZipNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 *
 * @author alone
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = {AppConfig.class},
 loader = AnnotationConfigContextLoader.class )
public class ServiceTest {
    @Autowired
private IWeatherService weather;
    public ServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testZipCode() throws ZipNotFoundException
    {
        String zipCode = "94117";
        String json =  weather.weatherjsonByZipCode(zipCode);
        DisplayModel model = weather.getDisplayModelFromJson(json);
        assertNotNull("model emtpy not valid zip", model);
        assertTrue("zip code not available", model.isValid());
        System.out.println(json);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
