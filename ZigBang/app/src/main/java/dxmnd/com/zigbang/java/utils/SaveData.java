package dxmnd.com.zigbang.java.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by HunJin on 2017-03-12.
 * 데이터 저장 클래스 (Realm에 데이터가 저장되어있는지 체크)
 * json파일을 문서로 하여 받았기에 사용.
 * 네트워크 통신이었다면 retrofit을 이용했을거라 이 클래스를 사용하지 않았을 듯함.
 */

public class SaveData {
    public static void setAppPreferences
            (Context context, String key, String value) {
        SharedPreferences pref = null;
        pref = context.getSharedPreferences("logo", 0);
        SharedPreferences.Editor prefEditor = pref.edit();
        prefEditor.putString(key, value);

        prefEditor.commit();
    }

    public static String getAppPreferences
            (Context context, String key) {
        String returnValue = null;

        SharedPreferences pref = null;
        pref = context.getSharedPreferences("logo", 0);
        returnValue = pref.getString(key, "");
        return returnValue;
    }
}
