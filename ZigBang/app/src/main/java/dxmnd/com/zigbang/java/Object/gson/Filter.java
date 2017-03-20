package dxmnd.com.zigbang.java.Object.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HunJin on 2017-03-12.
 */

public class Filter {
    @SerializedName("id")
    public long id;
    @SerializedName("name")
    public String name;
    @SerializedName("sido")
    public String sido;
    @SerializedName("gugun")
    public String gugun;
    @SerializedName("dong")
    public String dong;
    @SerializedName("bunji")
    public String bunji;
    @SerializedName("lat")
    public double lat;
    @SerializedName("lng")
    public double lng;
    @SerializedName("households")
    public int households;
    @SerializedName("buildDate")
    public String buildDate;
    @SerializedName("score")
    public double score;
    @SerializedName("brand")
    public String brand;
    @SerializedName("image")
    public String image;
    @SerializedName("price")
    public int price;
    @SerializedName("floorArea")
    public double floorArea;
    @SerializedName("marker")
    public Marker marker;
}
