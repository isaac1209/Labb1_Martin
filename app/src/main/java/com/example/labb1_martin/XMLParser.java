package com.example.labb1_martin;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLParser
{

    public static Document getDOM()
    {
        try {
            System.setProperty("http.agent", "Chrome");
            URL url = new URL("https://api.met.no/weatherapi/locationforecast/2.0/classic?lat=62.39&lon=17.30");
            URLConnection connection = url.openConnection();
            Document doc = parseXML(connection.getInputStream());
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Document parseXML(InputStream stream)
            throws Exception
    {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch(Exception ex)
        {
            throw ex;
        }

        return doc;
    }
}