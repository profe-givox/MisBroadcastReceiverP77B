package net.ivanvega.misbroadcastreceiverp77b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MiReceiverPersonalizado extends BroadcastReceiver {

    private static final String TAG = "MyBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.
            getAction()
            .equals
            (TelephonyManager.ACTION_PHONE_STATE_CHANGED)){
            Toast.
            makeText
                    (context,
                            "ENtro al IF",
                            Toast.LENGTH_SHORT).show();

        }
        if(intent.
                getAction()
                .equals
                        ("com.example.broadcast.MY_NOTIFICATION")){
            Toast.
                    makeText
                            (context,
                                    "Mi difusion ",
                                    Toast.LENGTH_SHORT).show();

        }

        StringBuilder sb = new StringBuilder();
        sb.append("Action: " + intent.getAction() + "\n");
        sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
        String log = sb.toString();
        Log.d(TAG, log);
        Toast.makeText(context, log, Toast.LENGTH_LONG).show();
    }
}
