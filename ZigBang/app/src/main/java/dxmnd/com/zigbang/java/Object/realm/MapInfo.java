package dxmnd.com.zigbang.java.Object.realm;

import io.realm.RealmModel;
import io.realm.RealmObject;

/**
 * Created by HunJin on 2017-03-12.
 * 리얼름에 데이터를 저장하기 위한 오브젝트 파일
 */

public class MapInfo extends RealmObject {

    long id;
    String name;
    double lat;
    double lng;
    String image;
    int price;
    String markerSmallBase;
    String markerSmallSelect;
    String markerLargeBase;
    String markerLargeSelect;
    double score;
    double floorArea;
    String buildDate;
    String brand;
    int households;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(double floorArea) {
        this.floorArea = floorArea;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public int getHouseholds() {
        return households;
    }

    public void setHouseholds(int households) {
        this.households = households;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setMarkerSmallBase(String markerSmallBase) {
        this.markerSmallBase = markerSmallBase;
    }

    public void setMarkerSmallSelect(String markerSmallSelect) {
        this.markerSmallSelect = markerSmallSelect;
    }

    public void setMarkerLargeBase(String markerLargeBase) {
        this.markerLargeBase = markerLargeBase;
    }

    public void setMarkerLargeSelect(String markerLargeSelect) {
        this.markerLargeSelect = markerLargeSelect;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }

    public String getMarkerSmallBase() {
        return markerSmallBase;
    }

    public String getMarkerSmallSelect() {
        return markerSmallSelect;
    }

    public String getMarkerLargeBase() {
        return markerLargeBase;
    }

    public String getMarkerLargeSelect() {
        return markerLargeSelect;
    }
}
