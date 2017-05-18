package com.example.svanh.testproject.api;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.svanh.testproject.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiTest extends AppCompatActivity {
    private String json_result;

    public String getJson_Result(){
        return json_result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apitest);
    }
    public void getJSON (View view){
            new BackgroundTask(this).execute();
    }

    public void parseJSON(View view){

        if(json_result != null){
            Intent intent = new Intent(this,DisplayListView.class);
            intent.putExtra("json_data", json_result);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "First Get the JSON with the Get JSON Button!" , Toast.LENGTH_LONG).show();
        }
    }

    private void setJsonString(String result) {
        json_result = result;
    }


    class BackgroundTask extends AsyncTask<Void, Void, String> {
        String json_url;
        String json_result = "";
        ApiTest owner;

        public BackgroundTask(ApiTest owner){
            this.owner = owner;
        }

        @Override
        protected void onPreExecute() {
            json_url = "http://api.hostdalem.nl/json_get_data.php";
        }

        @Override
        protected String doInBackground(Void... params) {

            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine())!= null)
                {
                    stringBuilder.append(line+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                this.json_result = stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
                this.json_result = "Foute url";
            } catch (IOException e) {
                e.printStackTrace();
            }
            return this.json_result;
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
        @Override
        protected void onPostExecute(String result) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(result);
            owner.setJsonString(result);
        }
    }

}


