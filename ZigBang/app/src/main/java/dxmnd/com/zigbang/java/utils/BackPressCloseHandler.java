package dxmnd.com.zigbang.java.utils;

import android.app.Activity;

/**
 * Created by HunJin on 2017-03-19.
 *
 * 뒤로 가기 키를 누르면 일어나는 이벤트
 */

public class BackPressCloseHandler {
    private long backKeyPressedTime = 0;
    private Activity activity;

    public BackPressCloseHandler(Activity context) {
        this.activity = context;
    }

    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            activity.finish();
        }
    }
}
