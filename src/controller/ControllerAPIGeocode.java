/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.Binder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Samsumg
 */
public class ControllerAPIGeocode {

    private URL url;

    public ControllerAPIGeocode(String address) throws MalformedURLException {

        this.url = new URL("http://maps.googleapis.com/maps/api/geocode/xml?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA" + address + "&sensor=false");
    }

    public void getGeocode() throws IOException, JAXBException {
        HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
        InputStream content = connection.getInputStream();
        InputStreamReader contentReader = new InputStreamReader(content);
        BufferedReader bufferLeitura = new BufferedReader(contentReader);
        String text = bufferLeitura.readLine();
        while (text != null) {
            System.out.println(text);

            text = bufferLeitura.readLine();
        }

        JAXBContext context = JAXBContext.newInstance("br.com.caelum");
        Binder bind = context.createBinder();
        System.out.println(bind.toString());
    }

}
