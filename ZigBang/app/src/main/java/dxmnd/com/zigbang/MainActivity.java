package dxmnd.com.zigbang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.daum.mf.map.api.MapView;

import dxmnd.com.zigbang.java.map.MapActivity;

/**
 * 처음에는 자바 버전과 코틀린 버전을 모두 만들어볼 생각이었으나,
 * 처음 사용하는 코틀린에 MVP 패턴 적용에 익숙하지 않아 우선 자바부터 완성.
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(getApplicationContext(), MapActivity.class));
        finish();
    }
}
