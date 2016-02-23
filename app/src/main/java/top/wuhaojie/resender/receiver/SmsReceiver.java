package top.wuhaojie.resender.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SmsReceiver extends BroadcastReceiver {
    public SmsReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // 如果收到短信
        if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
        }
    }
}
