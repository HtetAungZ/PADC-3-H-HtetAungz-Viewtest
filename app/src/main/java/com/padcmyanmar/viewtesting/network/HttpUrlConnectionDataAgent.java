package com.padcmyanmar.viewtesting.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.padcmyanmar.viewtesting.MMNewsApp;
import com.padcmyanmar.viewtesting.data.vo.NewsVO;
import com.padcmyanmar.viewtesting.events.LoadedNewsEvent;
import com.padcmyanmar.viewtesting.network.reponses.GetNewsResponse;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * Created by ICE on 23-12-2017.
 */

public class HttpUrlConnectionDataAgent implements NewsDataAgent {

    private static HttpUrlConnectionDataAgent sObjectInstance;

    private HttpUrlConnectionDataAgent() {

    }

    public static HttpUrlConnectionDataAgent getsObjectInstance() {
        if (sObjectInstance == null) {
            sObjectInstance = new HttpUrlConnectionDataAgent();
        }
        return sObjectInstance;
    }


    @Override
    public void loadNews() {

        Log.d("", "Log in main thread");
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                Log.d("", "Log in background thread");

                URL url;
                BufferedReader reader = null;
                StringBuilder stringBuilder;

                try {
                    // create the HttpURLConnection
                    //http://padcmyanmar.com/padc-3/mm-news/apis/v1/getMMNews.php
                    url = new URL("http://padcmyanmar.com/padc-3/mm-news/apis/v1/getMMNews.php"); //1.
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //2.

                    // just want to do an HTTP POST here
                    connection.setRequestMethod("POST"); //3.

                    // uncomment this if you want to write output to this url
                    //connection.setDoOutput(true);

                    // give it 15 seconds to respond
                    connection.setReadTimeout(15 * 1000); //4. ms

                    connection.setDoInput(true); //5. network time load process loat nay yin ta char har run naing pho
                    connection.setDoOutput(true);

                    //put the request parameter into NameValuePair list.
                    List<NameValuePair> params = new ArrayList<>(); //6.
                    params.add(new BasicNameValuePair("access_token", "b002c7e1a528b7cb460933fc2875e916"));
                    params.add(new BasicNameValuePair("page", "1"));

                    //write the parameters from NameValuePair list into connection obj.
                    OutputStream outputStream = connection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(outputStream, "UTF-8"));
                    writer.write(getQuery(params));
                    writer.flush();
                    writer.close();
                    outputStream.close();

                    connection.connect(); //7. *** connect with api ***

                    // read the output from the server
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); //8. line by line read
                    stringBuilder = new StringBuilder();

                    String line = null;// data packet by packet transfer. ta khu chin si loop loat pee pyan sit
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }

                    String responseString = stringBuilder.toString(); //9. compose to string
                    Log.d(MMNewsApp.Log_TAG, "responseString : " + responseString);
                    Gson gson = new Gson();
                   GetNewsResponse getNewsResponse = gson.fromJson(responseString, GetNewsResponse.class);
                    Log.d(MMNewsApp.Log_TAG,"getnewsresponse Size" + getNewsResponse.getMmNews().size());
                   LoadedNewsEvent event = new LoadedNewsEvent(getNewsResponse.getMmNews());
                   EventBus.getDefault().post(event);
                } catch (Exception e) {

                    Log.e(MMNewsApp.Log_TAG, e.getMessage());
                    /*
                    Log.e(MyanmarAttractionsApp.TAG, e.getMessage());
                    AttractionModel.getInstance().notifyErrorInLoadingAttractions(e.getMessage());
                    */
                } finally {
                    // close the reader; this can throw an exception too, so
                    // wrap it in another try/catch block.
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                }


                return null;
            }
        }.execute();

    }

    //GetQuery ka http address ko append loat pay
    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }

}
