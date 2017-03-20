package dxmnd.com.zigbang.java.map;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import dxmnd.com.zigbang.java.Object.realm.MapInfo;
import dxmnd.com.zigbang.java.network.MarkerImageAsyncTask;
import dxmnd.com.zigbang.java.utils.RealmTask;
import io.realm.RealmResults;

/**
 * Created by HunJin on 2017-03-15.
 */

public class BaseMapActivity extends AppCompatActivity implements MapView.OpenAPIKeyAuthenticationResultListener,
        MapView.MapViewEventListener,
        MapView.CurrentLocationEventListener,
        MapView.POIItemEventListener {

    private static final String TAG = BaseMapActivity.class.getSimpleName();

    private MapPoint START_POINT = MapPoint.mapPointWithGeoCoord(37.51139337574741, 127.01835497289554);

    @Override
    public void onCurrentLocationUpdate(MapView mapView, MapPoint mapPoint, float v) {

    }

    @Override
    public void onCurrentLocationDeviceHeadingUpdate(MapView mapView, float v) {

    }

    @Override
    public void onCurrentLocationUpdateFailed(MapView mapView) {

    }

    @Override
    public void onCurrentLocationUpdateCancelled(MapView mapView) {

    }

    /**
     * 맵이 처음 초기화 됐을 때
     * 지정한 좌표로 이동
     * @param mapView
     */
    @Override
    public void onMapViewInitialized(MapView mapView) {
        mapView.setMapCenterPoint(START_POINT, true);
    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    private RealmResults<MapInfo> result;

    /**
     * 지도의 움직임을 끝마쳤을 때의 이벤트
     * 움직임이 끝났을 때 지도의 좌측 하단 좌표와 우측 상단 좌표를 계산하여
     * 그 사이에 있는 마커들의 정보를 가져옴.
     * @param mapView
     * @param mapPoint
     */
    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {
        MapPoint bottomLeft = mapView.getMapPointBounds().bottomLeft;
        MapPoint topRight = mapView.getMapPointBounds().topRight;

        result = new RealmTask().getSearch(bottomLeft, topRight);
        mapView.removeAllPOIItems();

        for (int i = 0; i < result.size(); i++) {
            int tag = (int) result.get(i).getId();
            String name = result.get(i).getName();
            String markerSmall = result.get(i).getMarkerSmallBase();
            String markerSmallSelect = result.get(i).getMarkerSmallSelect();
            MapPoint point = MapPoint.mapPointWithGeoCoord(result.get(i).getLat(), result.get(i).getLng());

            AsyncTask<Object, Void, Void> markerImageAsyncTask = new MarkerImageAsyncTask()
                    .execute(getApplicationContext(), mapView, tag, name, markerSmall, markerSmallSelect, point);

        }
    }

    @Override
    public void onDaumMapOpenAPIKeyAuthenticationResult(MapView mapView, int i, String s) {

    }

    /**
     * 마커 클릭 이벤트
     * @param mapView
     * @param mapPOIItem
     */
    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {
        Intent it = new Intent(getApplicationContext(),MapDetailActivity.class);
        it.putExtra("tag",mapPOIItem.getTag());
        startActivity(it);
    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }
}
