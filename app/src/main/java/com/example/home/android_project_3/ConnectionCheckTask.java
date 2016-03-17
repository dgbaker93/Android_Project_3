package com.example.home.android_project_3;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by David on 3/17/16.
 */
public class ConnectionCheckTask extends AsyncTask<String, Void, Boolean> {
    @Override
    protected Boolean doInBackground(String... params) {
        URL url = null;
        int code = 0;
        try {
            url = new URL(params[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            code = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return code == 200;
    }
}