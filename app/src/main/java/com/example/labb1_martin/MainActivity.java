
package com.example.labb1_martin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class MainActivity extends AppCompatActivity {

    private Button refreshButton;
    private TextView viewContainer;
    private TextView temperatureView;
    private TextView windView;
    private TextView cloudView;
    private TextView rainView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link layout to variables START
        refreshButton = findViewById(R.id.refreshButton);
        viewContainer = findViewById(R.id.weathercontainer);
        temperatureView = findViewById(R.id.temperature);
        windView = findViewById(R.id.windspeed);
        cloudView = findViewById(R.id.cloudiness);
        rainView = findViewById(R.id.rain);
        imageView = findViewById(R.id.weatherImage);
        //Link layout to variables END

        refreshButton.setOnClickListener(view -> {

            Runnable inBackground = new Runnable() {
                @Override
                public void run(){
                    try {
                        Document doc = XMLParser.getDOM();
                        if(doc != null){
                            NodeList nodeList = doc.getElementsByTagName("*");
                            rainView.setText("Rain: " + GetRain(nodeList));
                            temperatureView.setText("Temperature: " + getTemperature(nodeList));
                            cloudView.setText("Cloudiness: " + getCloudiness(nodeList));
                            int resId = getResources().getIdentifier(GetImage(nodeList), "drawable", getPackageName());
                            imageView.setImageResource(resId);
                            //KOD FÖR ATT SKRIVA UT PÅ SKÄRMEN HÄR---------------

                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };

            Thread thread = new Thread(inBackground);
            thread.start();

        });
    }


    public void updateTemp(View view) {
        Runnable inBackground = new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = XMLParser.getDOM();
                    if(doc!=null){
                        NodeList nodeList=doc.getElementsByTagName("*");
                        String res = getTemperature(nodeList);
                        System.out.print(res);

                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(inBackground);
        thread.start();

    }

    public String getTemperature(NodeList nodeList){
        for(int i=0; i<nodeList.getLength();i++){
            Element element = (Element)nodeList.item(i);
            if(element.getNodeName().equals("temperature")){
                return element.getAttribute("value");
                        }
        }
        return "";
    }

  public String GetImage(NodeList nodeList){
        for(int i=0; i<nodeList.getLength();i++){
            Element element = (Element)nodeList.item(i);
            if(element.getNodeName().equals("symbol")){
                return element.getAttribute("code");
            }
        }
        return "";
    }


    public String getWind(NodeList nodeList){
        for(int i=0; i<nodeList.getLength();i++){
            Element element = (Element)nodeList.item(i);
            if(element.getNodeName().equals("windSpeed")){
                return element.getAttribute("mps");
            }
        }
        return "";
    }
    public String GetPressure(NodeList nodeList){
        for(int i=0; i<nodeList.getLength();i++){
            Element element = (Element)nodeList.item(i);
            if(element.getNodeName().equals("pressure")){
                return element.getAttribute("value");
            }
        }
        return "";
    }

    public String GetRain(NodeList nodeList) {
        String max = "";
        String min = "";
        String minMax = "";
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            if (element.getNodeName().equals("precipitation")) {
                max = element.getAttribute("minvalue");
                min = element.getAttribute("maxvalue");

                return minMax = "Max = " +  max +  " Min = " + min;
            }
        }

        return "";
    }

    public String getCloudiness(NodeList nodeList){
        for(int i=0; i<nodeList.getLength();i++){
            Element element = (Element)nodeList.item(i);
            if(element.getNodeName().equals("cloudiness")){
                return element.getAttribute("percent");
            }
        }
        return "";
    }

}


//Hej Emil & Emil
//Test
//hahahahahaha


//Test Vestin
//Test Alfred
//Test Filip