package dxmnd.com.zigbang.java.map;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import net.daum.mf.map.api.MapView;

import java.util.ArrayList;

import dxmnd.com.zigbang.R;
import dxmnd.com.zigbang.java.utils.BackPressCloseHandler;
import dxmnd.com.zigbang.java.utils.RealmTask;
import dxmnd.com.zigbang.java.utils.SaveData;
import dxmnd.com.zigbang.key.APIKey;
import io.realm.Realm;

/**
 * Created by HunJin on 2017-03-15.
 */


public class MapActivity extends BaseMapActivity {

    private static final String TAG = MapActivity.class.getSimpleName();

    private Realm mRealm;
    private MapView mapView;
    private RelativeLayout mapContent;
    private BackPressCloseHandler backPressCloseHandler;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mRealm.init(getApplicationContext());
        backPressCloseHandler = new BackPressCloseHandler(this);

        new TedPermission(this)
                .setPermissionListener(permissionListener)
                .setRationaleMessage("지도를 쓸거에요.")
                .setDeniedMessage("거부하면 못써요..")
                .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET)
                .check();

        /**
         * 저장이 되있는지를 체크하여 1일 경우 아무런 작업을 하지 않고,
         * 그 외의 경우 Realm에 데이터를 저장함 (json 문서로부터 파일을 읽어)
         * realm에 데이터를 저장하기 위해 앱을 설치했을 시 한 번만 실행
         */
        if (SaveData.getAppPreferences(getApplicationContext(), "hasData").equals("1")) {

        } else {
            new RealmTask().setData(getApplicationContext());
        }
    }

    PermissionListener permissionListener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            Toast.makeText(getApplicationContext(), "권한 허가", Toast.LENGTH_SHORT).show();
            mapSetting();
        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            Toast.makeText(getApplicationContext(), "권한 거부", Toast.LENGTH_SHORT).show();
            finish();
        }
    };

    void mapSetting() {
        Log.e(TAG, "mapSetting");
        mapView = new MapView(this);
        mapView.setDaumMapApiKey(APIKey.API_KEY);
        mapContent = (RelativeLayout) findViewById(R.id.layout_content_map);
        mapContent.addView(mapView);
        mapView.setMapViewEventListener(this);
        mapView.setPOIItemEventListener(this);
    }

    public void onClick(View v) {
        Double latBottomLeft = mapView.getMapPointBounds().bottomLeft.getMapPointGeoCoord().latitude;
        Double lngBottomLeft = mapView.getMapPointBounds().bottomLeft.getMapPointGeoCoord().longitude;
        Double latTopRight = mapView.getMapPointBounds().topRight.getMapPointGeoCoord().latitude;
        Double lngTopRight = mapView.getMapPointBounds().topRight.getMapPointGeoCoord().longitude;
        Intent it = new Intent(getApplicationContext(), MapListActivity.class);
        it.putExtra("latBottomLeft", latBottomLeft);
        it.putExtra("lngBottomLeft", lngBottomLeft);
        it.putExtra("latTopRight", latTopRight);
        it.putExtra("lngTopRight", lngTopRight);
        startActivity(it);
        overridePendingTransition(R.anim.anim_slide_in_bottom, R.anim.anim_slide_out_bottom);
    }

    @Override
    public void onBackPressed() {
        //핸들러 작동
        backPressCloseHandler.onBackPressed();
        Toast.makeText(getApplicationContext(), "한 번 더 누르면 앱이 종료됩니다", Toast.LENGTH_SHORT).show();
    }
}
