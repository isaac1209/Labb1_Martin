package com.example.labb1_martin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void updateTemp(View view) {

        Runnable inBackground = new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = XMLParser.getDOM();
                    if(doc!=null){
                        NodeList nodeList=doc.getElementsByTagName("*");
                        String res = GetVal(nodeList);
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

        System.out.println("Tja");
    }

    public String GetVal(NodeList nodeList){
        for(int i=0; i<nodeList.getLength();i++){
            Element element = (Element)nodeList.item(i);
            if(element.getNodeName().equals("humidity")){
                return element.getAttribute("value");
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