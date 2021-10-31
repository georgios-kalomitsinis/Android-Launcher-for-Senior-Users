package com.example.HCI.launcher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;


public class MainActivity extends AppCompatActivity {


    private Button camerabut,gallerybut,messagesbut,call,contactsbut;
    private Button  popupphonenum;
    private Button  mapbut;


    private static final int CAMERA_REQUEST = 5;
    private final int ACTIVITY_SELECT_IMAGE = 1234;


    private BroadcastReceiver batteryinforeceiver= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level= intent.getIntExtra("level",0);


            TextView tv=findViewById(R.id.textfield);
            tv.setText(Integer.toString(level) +"%" );

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camerabut = (Button) findViewById(R.id.camerabut);
        gallerybut = (Button) findViewById(R.id.gallerybut);
        messagesbut = (Button) findViewById(R.id.messagesbut);
        call= (Button) findViewById(R.id.call);
//        quick_call= (Button) findViewById(R.id.quick_call);
        contactsbut=(Button) findViewById(R.id.contacts);
        popupphonenum=(Button)findViewById(R.id.myphone);
        mapbut=(Button)findViewById(R.id.maps);

        registerReceiver(batteryinforeceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        camerabut.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Intent cameraintent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                                             startActivity(cameraintent);    }
                                     }
        );


        gallerybut.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent galleryintent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));

                                              startActivity(galleryintent);
                                          }
                                      }
        );


        messagesbut.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Intent messagesintent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/messages"));
                                                 startActivity(messagesintent);
//                                                 Intent messages = new Intent();
//                                                 messages.setClassName("com.sec.android.app.messages","com.sec.android.app.popupmessages.Messages");
//                                                 startActivity(messages);
                                             }
                                         }
        );


        call.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent callintent = new Intent(Intent.ACTION_DIAL);
                                        // intent.setData(Uri.parse("tel:"+phone));
                                        startActivity(callintent);
                                    }
                                }
        );


        contactsbut.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent myI = new Intent(MainActivity.this,Activity2.class);
                                               startActivity(myI);
                                           }
                                       }
        );
//
//
        popupphonenum.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent myI = new Intent(MainActivity.this,Popup.class);
                                               startActivity(myI);
                                           }
                                       }

        );

        mapbut.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Intent myI = new Intent(MainActivity.this,MapActivity.class);
                                                 startActivity(myI);
                                             }
                                         }

        );


        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView tdate = findViewById(R.id.date);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy\nhh:mm a");
                                String dateString = sdf.format(date);
                                tdate.setText(dateString);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();
    }
}