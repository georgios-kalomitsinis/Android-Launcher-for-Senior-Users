package com.example.HCI.launcher;

import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class giveData extends AsyncTask <String,Void,Void> {
    String data ="";

    String dataParsed = "";
    String singleParsed ="",singleParsed3="",singleParsed2 ="",singleParsed4="",singleParsed5="",singleParsed6="";

    @Override
    protected  Void doInBackground(String...url1) {

        try {
            URL url = new URL("https://www.json-generator.com/api/json/get/cpNimMMEBK?indent=2");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);

            JSONObject JO = (JSONObject) JA.get(0);
            singleParsed="" + JO.get("name") ;

            JSONObject JO1 = (JSONObject) JA.get(1);
            singleParsed2="" +JO1.get("name") ;

            JSONObject JO2 = (JSONObject) JA.get(2);
            singleParsed3="" +JO2.get("name") ;

            JSONObject JO3 = (JSONObject) JA.get(3);
            singleParsed4="" +JO3.get("name") ;

            JSONObject JO4 = (JSONObject) JA.get(4);
            singleParsed5="" +JO4.get("name") ;

            JSONObject JO5 = (JSONObject) JA.get(5);
            singleParsed6="" +JO5.get("name") ;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Activity2.allData.setText(this.singleParsed);
        Activity2.allData2.setText(this.singleParsed2);
        Activity2.allData3.setText(this.singleParsed3);
        Activity2.allData4.setText(this.singleParsed4);
        Activity2.allData5.setText(this.singleParsed5);
        Activity2.allData6.setText(this.singleParsed6);
    }
}