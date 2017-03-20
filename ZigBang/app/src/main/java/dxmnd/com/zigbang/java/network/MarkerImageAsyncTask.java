package dxmnd.com.zigbang.java.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import com.bumptech.glide.Glide;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.util.concurrent.ExecutionException;

/**
 * Created by HunJin on 2017-03-15.
 * 마커에 이미지를 찍기 위해 asynctask를 활용
 *
 */

public class MarkerImageAsyncTask extends AsyncTask<Object, Void, Void> {

    private static final String TAG = MarkerImageAsyncTask.class.getSimpleName();

    private MapPOIItem mMarker;
    private Bitmap mBitMapBase;
    private Bitmap mBitMapSelect;
    private MapView mMapView;
    private String mName;
    private int mTag;
    private MapPoint mMapPoint;
    private Context mContext;
    private String baseImage;
    private String selectImage;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mMarker = new MapPOIItem();
    }

    @Override
    protected Void doInBackground(Object... params) {
        mContext = (Context) params[0];
        mMapView = (MapView) params[1];
        mTag = (int) params[2];
        mName = (String) params[3];
        baseImage = (String) params[4];
        selectImage = (String) params[5];
        mMapPoint = (MapPoint) params[6];

        try {
            mBitMapBase = Glide.with(mContext).load(baseImage).asBitmap().into(-1, -1).get();
            mBitMapSelect = Glide.with(mContext).load(selectImage).asBitmap().into(-1, -1).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        mMarker.setTag(mTag);
        mMarker.setItemName(mName);
        mMarker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
        mMarker.setSelectedMarkerType(MapPOIItem.MarkerType.CustomImage);
        mMarker.setCustomImageBitmap(mBitMapBase);
        mMarker.setCustomSelectedImageBitmap(mBitMapSelect);
        mMarker.setMapPoint(mMapPoint);


        mMapView.addPOIItem(mMarker);
    }
}
