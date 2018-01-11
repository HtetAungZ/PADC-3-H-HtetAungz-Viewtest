package com.padcmyanmar.viewtesting.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.padcmyanmar.viewtesting.MMNewsApp;
import com.padcmyanmar.viewtesting.events.LoadedNewsEvent;
import com.padcmyanmar.viewtesting.network.reponses.GetNewsResponse;

import org.greenrobot.eventbus.EventBus;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by ICE on 06-01-2018.
 */

public class OkHttpDataAgent implements NewsDataAgent {

    private static OkHttpDataAgent objectInstance;

    private OkHttpDataAgent() {
    }


    public static OkHttpDataAgent getObjectInstance() {
        if (objectInstance == null) {
            objectInstance = new OkHttpDataAgent();
        }
        return objectInstance;
    }

    @Override
    public void loadNews() {

        new LoadNewsTask()
                .execute("http://padcmyanmar.com/padc-3/mm-news/apis/v1/getMMNews.php");
    }

    private static class LoadNewsTask extends AsyncTask<String, Void, String> {

        @Override
        //        return                first parameter(String...= string array)
        protected String doInBackground(String... urls) {

            String url = urls[0];//for pass url into array
            OkHttpClient httpClient = new OkHttpClient.Builder() //1.
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build();

            RequestBody formBody = new FormBody.Builder() //2.
                    .add("access_token", "b002c7e1a528b7cb460933fc2875e916")
                    .add("page", "1")
                    .build();

            Request request = new Request.Builder() //3
                    .url(url)
                    .post(formBody)
                    .build();

            try {
                Response response = httpClient.newCall(request).execute(); //4.
                if (response.isSuccessful() && response.body() != null) {
                    String responseString = response.body().string();
                    return responseString;
                }
            } catch (IOException e) {
                Log.e(MMNewsApp.Log_TAG, e.getMessage());
            }

            return null;

        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            Gson gson = new Gson();
            GetNewsResponse getNewsResponse = gson.fromJson(response, GetNewsResponse.class);
            LoadedNewsEvent event = new LoadedNewsEvent(getNewsResponse.getMmNews());
            EventBus eventBus = EventBus.getDefault();
            eventBus.post(event);

        }
    }
}