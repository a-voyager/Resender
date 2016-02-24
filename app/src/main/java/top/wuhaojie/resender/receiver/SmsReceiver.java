package top.wuhaojie.resender.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {

    public static final String TAG = "SmsReceiver";

    public SmsReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // 如果收到短信
        if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
            abortBroadcast();
            Bundle extras = intent.getExtras();
            Object[] pdus = (Object[]) extras.get("pdus");
            SmsMessage[] smsMessages = new SmsMessage[pdus.length];
            for (int i = 0; i < pdus.length; i++) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], "3gpp");
                } else {
                    smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
            }
            for (SmsMessage message : smsMessages) {
                String address = message.getDisplayOriginatingAddress();
                String body = message.getDisplayMessageBody();
                Log.i(TAG, address + " : " + body);
            }
        }
    }
}
