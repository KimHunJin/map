package dxmnd.com.zigbang.java.Object.gson;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by HunJin on 2017-03-12.
 * Gson 라이브러리를 활용하여 .json 문서를 읽어들임
 */

public class GsonMapInfo {
    @SerializedName("filtered")
    public ArrayList<Filter> filter = new ArrayList();
}





