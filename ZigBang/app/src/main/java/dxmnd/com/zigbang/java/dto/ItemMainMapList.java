package dxmnd.com.zigbang.java.dto;

/**
 * Created by HunJin on 2017-03-16.
 * <p>
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


public class ItemMainMapList {
    private int mTag;
    private String mImageUrl;
    private String mName;
    private double mFloorArea;
    private double mScore;
    private String mBuildDate;
    private int mHouseHolds;
    private String mBrand;
    private int mPrice;

    public ItemMainMapList(int tag, String imageUrl, String name, double floorArea, double score, String buildDate, int houseHolds, String brand, int price) {
        this.mTag = tag;
        this.mImageUrl = imageUrl;
        this.mName = name;
        this.mFloorArea = floorArea;
        this.mScore = score;
        this.mBuildDate = buildDate;
        this.mHouseHolds = houseHolds;
        this.mBrand = brand;
        this.mPrice = price;
    }

    public int getmTag() {
        return mTag;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmName() {
        return mName;
    }

    public double getmFloorArea() {
        return mFloorArea;
    }

    public double getmScore() {
        return mScore;
    }

    public String getmBuildDate() {
        return mBuildDate;
    }

    public int getmHouseHolds() {
        return mHouseHolds;
    }

    public String getmBrand() {
        return mBrand;
    }

    public int getmPrice() {
        return mPrice;
    }
}
