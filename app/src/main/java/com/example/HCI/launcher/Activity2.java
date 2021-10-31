package com.example.HCI.launcher;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

   public static TextView allData,allData2,allData3,allData4,allData5,allData6;

    public static String num="",num2="",num3="",num4="",num5="",num6="";
    public static String[] mStrings = new String[6];
    private TextView text1,text2,text3,text4,text5,text6;
    private Button callbutton1,callbutton2,callbutton3,callbutton4,callbutton5,callbutton6;
    private String d="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        allData= (TextView) findViewById(R.id.txt1);
        allData2= (TextView) findViewById(R.id.txt2);
        allData3= (TextView) findViewById(R.id.txt3);
        allData4= (TextView) findViewById(R.id.txt4);
        allData5= (TextView) findViewById(R.id.txt5);
        allData6= (TextView) findViewById(R.id.txt6);


        callbutton1=(Button) this.findViewById(R.id.call_1);
        callbutton2=(Button) this.findViewById(R.id.call_2);
        callbutton3=(Button) this.findViewById(R.id.call_3);
        callbutton4=(Button) this.findViewById(R.id.call_4);
        callbutton5=(Button) this.findViewById(R.id.call_5);
        callbutton6=(Button) this.findViewById(R.id.call_6);

        giveNumber processnum= new giveNumber();
        giveData processdata= new giveData();

        String a="https://www.json-generator.com/api/json/get/bURLaGbecy?indent=2";

        processdata.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,a);
        processnum.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,a);

        callbutton1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent intent = new Intent(Intent.ACTION_DIAL);
                                            intent.setData(Uri.parse("tel:"+num));
                                            startActivity(intent);    }
                                    }
        );

     callbutton2.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                      Intent intent = new Intent(Intent.ACTION_DIAL);
                                      intent.setData(Uri.parse("tel:"+num2));
                                      startActivity(intent);    }
                                    }
     );

     callbutton3.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                      Intent intent = new Intent(Intent.ACTION_DIAL);
                                      intent.setData(Uri.parse("tel:"+num3));
                                      startActivity(intent);    }
                                    }
     );

     callbutton4.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                      Intent intent = new Intent(Intent.ACTION_DIAL);
                                      intent.setData(Uri.parse("tel:"+num4));
                                      startActivity(intent);    }
                                    }
     );

     callbutton5.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                      Intent intent = new Intent(Intent.ACTION_DIAL);
                                      intent.setData(Uri.parse("tel:"+num5));
                                      startActivity(intent);    }
                                    }
     );

     callbutton6.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                      Intent intent = new Intent(Intent.ACTION_DIAL);
                                      intent.setData(Uri.parse("tel:"+num6));
                                      startActivity(intent);    }
                                    }
     );
    }
}


