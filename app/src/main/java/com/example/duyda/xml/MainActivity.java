package com.example.duyda.xml;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView lbShow;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lbShow = (TextView) findViewById(R.id.lbShow);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                lbShow.setText(SharedPreManager.getmInstance(MainActivity.this).getToken());
            }
        };

        if (SharedPreManager.getmInstance(this).getToken() != null) {
            lbShow.setText(SharedPreManager.getmInstance(MainActivity.this).getToken());
            Log.d("myfcmtokenshared", SharedPreManager.getmInstance(this).getToken());
        }

        registerReceiver(broadcastReceiver, new IntentFilter(MyFirebaseInstanceIDService.TOKEN_BROADCAST));

    }
}
