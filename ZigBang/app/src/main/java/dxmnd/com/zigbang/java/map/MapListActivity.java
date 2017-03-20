package dxmnd.com.zigbang.java.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import net.daum.mf.map.api.MapPoint;

import dxmnd.com.zigbang.R;
import dxmnd.com.zigbang.java.Object.realm.MapInfo;
import dxmnd.com.zigbang.java.adpater.MainMapListRecyclerViewAdapter;
import dxmnd.com.zigbang.java.dto.ItemMainMapList;
import dxmnd.com.zigbang.java.utils.RealmTask;
import dxmnd.com.zigbang.java.utils.RecyclerViewOnItemClickListener;
import io.realm.RealmResults;

public class MapListActivity extends Activity {

    private RecyclerView rcvMainList;
    private MainMapListRecyclerViewAdapter mainMapListRecyclerViewAdapter;
    private LinearLayout mainLayout;

    private static final String TAG = MapListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_list);

        initialize();

        Intent it = getIntent();
        MapPoint bottomLeft = MapPoint.mapPointWithGeoCoord(it.getExtras().getDouble("latBottomLeft"), it.getExtras().getDouble("lngBottomLeft"));
        MapPoint topRight = MapPoint.mapPointWithGeoCoord(it.getExtras().getDouble("latTopRight"), it.getExtras().getDouble("lngTopRight"));
        RealmResults<MapInfo> results = new RealmTask().getSearch(bottomLeft, topRight);

        addData(results);
    }

    void initialize() {
        rcvMainList = (RecyclerView) findViewById(R.id.rcv_main_map_list);
        mainLayout = (LinearLayout) findViewById(R.id.activity_map_list);
        mainMapListRecyclerViewAdapter = new MainMapListRecyclerViewAdapter(getApplicationContext());
        rcvMainList.setHasFixedSize(true);
        rcvMainList.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        rcvMainList.setAdapter(mainMapListRecyclerViewAdapter);

        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        clickEvent();
    }

    /**
     * 리사이클러뷰를 클릭했을 때의 이벤트
     */
    void clickEvent() {
        rcvMainList.addOnItemTouchListener(new RecyclerViewOnItemClickListener(getApplicationContext(), rcvMainList, new RecyclerViewOnItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent it = new Intent(getApplicationContext(), MapDetailActivity.class);
                it.putExtra("tag", mainMapListRecyclerViewAdapter.getItem().get(position).getmTag());
                startActivity(it);
            }

            @Override
            public void onItemLongClick(View v, int position) {

            }
        }));
    }

    /**
     * 리사이클러뷰에 항목을 추가하는 메서드
     *
     * @param results
     */
    void addData(RealmResults<MapInfo> results) {
        for (int i = 0; i < results.size(); i++) {
            int id = (int) results.get(i).getId();
            String image = results.get(i).getImage();
            String name = results.get(i).getName();
            double floorArea = results.get(i).getFloorArea();
            double score = results.get(i).getScore();
            String buildDate = results.get(i).getBuildDate();
            int houseHolds = results.get(i).getHouseholds();
            String brand = results.get(i).getBrand();
            int price = results.get(i).getPrice();
            mainMapListRecyclerViewAdapter.addData(new ItemMainMapList(
                    id,
                    image,
                    name,
                    floorArea,
                    score,
                    buildDate,
                    houseHolds,
                    brand,
                    price
            ));
        }
        mainMapListRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_slide_in_bottom, R.anim.anim_slide_out_bottom);
    }
}
