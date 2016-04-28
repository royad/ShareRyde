package com.example.roya.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout tab1, tab2, tab3, tab4 ;
    Button viewProfileButton , requestRideButton, paymentsdButton, logoutButon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab1 = (LinearLayout) findViewById(R.id.tab1);
        tab2 = (LinearLayout) findViewById(R.id.tab2);
        tab3 = (LinearLayout) findViewById(R.id.tab3);
        viewProfileButton = (Button) findViewById(R.id.viewProfileButton);


        //button implementation

        viewProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ViewProfile.class);
                startActivity(i);
            }
        });

        requestRideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RequestRide.class);
                startActivity(i);
            }
        });

        paymentsdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Payments.class);
                startActivity(i);
            }
        });

        logoutButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        // Set up TabHost
        TabHost th = (TabHost)findViewById(R.id.tabHost);
        th.setup();


        //----Set up a tab 1
        TabHost.TabSpec specs = th.newTabSpec("tag1");
        specs.setContent(R.id.tab1); //this will hold the content of the tab
        specs.setIndicator("Main"); //this is the name of the tab
        th.addTab(specs); //add tab to TabHost
        //-----//

        // List of Notifications
        String[] notification = {"Driver sent you a message", "Payment notification", "System notification"}; //for demo purposes
        ListAdapter notificationAdapter = new CustomAdapter(this, notification);
        ListView notificationListView = (ListView) findViewById(R.id.notificationListView);
        notificationListView.setAdapter(notificationAdapter);

        // Post-Click actions
        notificationListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String notification = String.valueOf(parent.getItemAtPosition(position));
                        // Silly display of notification for demo purposes
                        Toast.makeText(MainActivity.this, notification, Toast.LENGTH_LONG).show();
                    }
                }
        );
        //End of Notifications

    } // End of onCreate

}



