package top.wuhaojie.resender.utils;

import android.telephony.SmsManager;

/**
 * Class for send sms.
 * Created by wuhaojie on 2016/2/24.
 */
public class SmsSender {

    /**
     * send a common sms.
     *
     * @param address phone number
     * @param text    sms body
     * @return send succeed return true, failed return false
     */
    public static boolean sendSMS(String address, String text) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(address, null, text, null, null);
        return true;
    }
}
