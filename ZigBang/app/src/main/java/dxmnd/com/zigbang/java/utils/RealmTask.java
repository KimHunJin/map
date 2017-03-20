package dxmnd.com.zigbang.java.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;

import net.daum.mf.map.api.MapPoint;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import dxmnd.com.zigbang.java.Object.gson.GsonMapInfo;
import dxmnd.com.zigbang.java.Object.realm.MapInfo;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by HunJin on 2017-03-15.
 */

public class RealmTask {

    private static final String TAG = RealmTask.class.getSimpleName();
    private GsonMapInfo gsonMapInfo;

    Realm mRealm;

    public RealmTask() {
        mRealm = Realm.getDefaultInstance();
    }

    public RealmResults<MapInfo> getSearch(MapPoint bottomLeft, MapPoint topRight) {
        return mRealm.where(MapInfo.class)
                .between("lat", bottomLeft.getMapPointGeoCoord().latitude, topRight.getMapPointGeoCoord().latitude)
                .between("lng", bottomLeft.getMapPointGeoCoord().longitude, topRight.getMapPointGeoCoord().longitude)
                .findAll();
    }

    public RealmResults<MapInfo> getSearch(int tag) {
        return mRealm.where(MapInfo.class)
                .equalTo("id",tag)
                .findAll();
    }

    private void getJson(Context context) {
        Log.e(TAG, "json parsing");
        AssetManager assetManager = context.getAssets();
        InputStream source = null;

        try {
            source = assetManager.open("mobile.json");
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        Gson gson = new Gson();
        Reader reader = new InputStreamReader(source);
        gsonMapInfo = gson.fromJson(reader, GsonMapInfo.class);

        insertData();
        SaveData.setAppPreferences(context,"hasData","1");
    }

    private void insertData() {
        for (int i = 0; i < gsonMapInfo.filter.size(); i++) {
            mRealm.beginTransaction();
            MapInfo mapInfo = mRealm.createObject(MapInfo.class);
            mapInfo.setId(gsonMapInfo.filter.get(i).id);
            mapInfo.setName(
                    gsonMapInfo.filter.get(i).sido + " " +
                            gsonMapInfo.filter.get(i).gugun + " " +
                            gsonMapInfo.filter.get(i).dong + " " +
                            gsonMapInfo.filter.get(i).bunji + " " +
                            gsonMapInfo.filter.get(i).name
            );
            mapInfo.setLat(gsonMapInfo.filter.get(i).lat);
            mapInfo.setLng(gsonMapInfo.filter.get(i).lng);
            mapInfo.setImage(gsonMapInfo.filter.get(i).image);
            mapInfo.setMarkerLargeBase(gsonMapInfo.filter.get(i).marker.large.size.base);
            mapInfo.setMarkerLargeSelect(gsonMapInfo.filter.get(i).marker.large.size.selected);
            mapInfo.setMarkerSmallBase(gsonMapInfo.filter.get(i).marker.small.size.base);
            mapInfo.setMarkerSmallSelect(gsonMapInfo.filter.get(i).marker.small.size.selected);
            mapInfo.setBrand(gsonMapInfo.filter.get(i).brand);
            mapInfo.setFloorArea(gsonMapInfo.filter.get(i).floorArea);
            mapInfo.setBuildDate(gsonMapInfo.filter.get(i).buildDate);
            mapInfo.setHouseholds(gsonMapInfo.filter.get(i).households);
            mapInfo.setPrice(gsonMapInfo.filter.get(i).price);
            mapInfo.setScore(gsonMapInfo.filter.get(i).score);
            mRealm.commitTransaction();
        }
    }

    public void setData(Context context) {
        Log.e(TAG, "setData");
        getJson(context);
    }
}
