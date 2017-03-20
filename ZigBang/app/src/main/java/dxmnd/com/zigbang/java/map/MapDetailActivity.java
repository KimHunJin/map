package dxmnd.com.zigbang.java.map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import dxmnd.com.zigbang.R;
import dxmnd.com.zigbang.java.Object.realm.MapInfo;
import dxmnd.com.zigbang.java.utils.ChangeMoney;
import dxmnd.com.zigbang.java.utils.RealmTask;
import io.realm.RealmResults;

/**
 * id : 기본키
 * image : 이미지URL
 * brand : 브랜드명
 * price : 가격 (만원)
 * name : 이름 (시 구군 동 번지 이름)
 * score : 평점
 * floorArea : 면적
 * buildDate : 완공시기
 * households : 가구수
 */
public class MapDetailActivity extends AppCompatActivity {

    private static final String TAG = MapDetailActivity.class.getSimpleName();

    ImageView imgDetailMap;
    TextView txtDetailMapName, txtDetailMapInfo, txtDetailMapPrice;
    RealmResults<MapInfo> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_map_detail);


        Intent it = getIntent();
        int tag = it.getExtras().getInt("tag");

        initialization();

        results = new RealmTask().getSearch(tag);

        Glide.with(getApplicationContext()).load(results.get(0).getImage()).into(imgDetailMap);
        txtDetailMapName.setText(results.get(0).getName());
        txtDetailMapInfo.setText("완공시기 : " + results.get(0).getBuildDate() + "·세대수 : " + results.get(0).getHouseholds() + "· 평점 : " + results.get(0).getScore());
        if (results.get(0).getBrand().equals("")) {
            txtDetailMapPrice.setText("가격 : " + ChangeMoney.changeMoney(results.get(0).getPrice()) + "/" + results.get(0).getFloorArea());
        } else {
            txtDetailMapPrice.setText("가격 : " + ChangeMoney.changeMoney(results.get(0).getPrice()) + "/" + results.get(0).getFloorArea() + " 브랜드 : " + results.get(0).getBrand());
        }
    }

    void initialization() {
        imgDetailMap = (ImageView) findViewById(R.id.img_marker_detail);
        txtDetailMapInfo = (TextView) findViewById(R.id.txt_marker_detail_info_date_holds_score);
        txtDetailMapName = (TextView) findViewById(R.id.txt_marker_detail_name);
        txtDetailMapPrice = (TextView) findViewById(R.id.txt_marker_detail_price_floor_area_brand);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_marker_detail_close: {
                finish();
                break;
            }
        }
    }
}
