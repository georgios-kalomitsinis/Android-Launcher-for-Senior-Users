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

public class giveNumber  extends AsyncTask<String,Void,String> {
    String data ="";
    String dataParsed = "";
    String singleParsed ="",singleParsed2="",singleParsed3="",singleParsed4="",singleParsed5="",singleParsed6="";
    String var="",var2="",var3="",var4="",var5="",var6="";
    String last="";
    String p="";
    public static String val;

    int i=0;
    @Override
    protected  String doInBackground(String...url1) {


        try {
            URL url = new URL("https://www.json-generator.com/api/json/get/bURLaGbecy?indent=2");
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
            singleParsed =  "Number:" + JO.get("num") ;

            JSONObject JO1 = (JSONObject) JA.get(1);
            singleParsed2 =  "Number:" + JO1.get("num") ;

            JSONObject JO2 = (JSONObject) JA.get(2);
            singleParsed3 =  "Number:" + JO2.get("num") ;

            JSONObject JO3 = (JSONObject) JA.get(3);
            singleParsed4 =  "Number:" + JO3.get("num") ;

            JSONObject JO4 = (JSONObject) JA.get(4);
            singleParsed5 =  "Number:" + JO4.get("num") ;

            JSONObject JO5 = (JSONObject) JA.get(5);
            singleParsed6 =  "Number:" + JO5.get("num") ;

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
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
        var=singleParsed.replaceAll("\\D+","");
        var2=singleParsed2.replaceAll("\\D+","");
        var3=singleParsed3.replaceAll("\\D+","");
        var4=singleParsed4.replaceAll("\\D+","");
        var5=singleParsed5.replaceAll("\\D+","");
        var6=singleParsed6.replaceAll("\\D+","");


        Activity2.num=(this.var);
        Activity2.num2=(this.var2);
        Activity2.num3=(this.var3);
        Activity2.num4=(this.var4);
        Activity2.num5=(this.var5);
        Activity2.num6=(this.var6);
    }

}
