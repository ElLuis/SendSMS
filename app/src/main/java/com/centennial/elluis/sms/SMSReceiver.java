package com.centennial.elluis.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //---get the SMS message passed in---
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        StringBuilder str = new StringBuilder("SMS from ");
        if (bundle != null)
        {
//---retrieve the SMS message received---
            msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            for (SmsMessage msg : msgs) {
                str.append(msg.getMessageBody());
            }
//---get the message body---
        }
//---display the new SMS message---
        Toast.makeText(context, str.toString(), Toast.LENGTH_SHORT).show();
        Log.d("SMSReceiver", str.toString());
    }
    }

