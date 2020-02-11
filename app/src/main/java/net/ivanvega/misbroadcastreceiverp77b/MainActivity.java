package net.ivanvega.misbroadcastreceiverp77b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MiReceiverPersonalizado miReceiverPersonalizado =
            new MiReceiverPersonalizado();

    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
        intentFilter.addAction("com.example.broadcast.MY_NOTIFICATION");

        registerReceiver(miReceiverPersonalizado, intentFilter);

    }

    public void btnSend_click(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.broadcast.MY_NOTIFICATION");
        intent.putExtra("data","Notice me senpai!");
        sendBroadcast(intent);
    }
}
