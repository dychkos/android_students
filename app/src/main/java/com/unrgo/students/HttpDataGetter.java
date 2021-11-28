package com.unrgo.students;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class HttpDataGetter implements Runnable{
    private String data;
    private String url;

    public HttpDataGetter(String url) {
        this.url = url;
    }

    @Override
    public void run(){
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Mozzila/5.0");
            connection.setRequestProperty("Accept-Charset","UTF-8");
            InputStream response = connection.getInputStream();
            Scanner s = new Scanner(response).useDelimiter("\\A");
        } catch (IOException e) {
           data = e.getMessage();
        }
    }


    public String getData() {
        Thread thread = new Thread(this);
        thread.start();
        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return  data;
    }
}
