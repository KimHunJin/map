package dxmnd.com.zigbang.java.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import dxmnd.com.zigbang.R;
import dxmnd.com.zigbang.java.dto.ItemMainMapList;
import dxmnd.com.zigbang.java.utils.ChangeMoney;

/**
 * Created by HunJin on 2017-03-16.
 */

public class MainMapViewHolder extends BaseViewHolder {

    private ImageView mImgBuilding;
    private TextView mTxtBuildingName, mTxtBuildingInfoDateHoldsScore, mTxtBuildingPriceFloorAreaBrand;
    private View mView;

    public MainMapViewHolder(View view) {
        super(view);
        this.mView = view;
        this.mImgBuilding = (ImageView) view.findViewById(R.id.img_item_map);
        this.mTxtBuildingName = (TextView) view.findViewById(R.id.txt_map_detail_name);
        this.mTxtBuildingInfoDateHoldsScore = (TextView) view.findViewById(R.id.txt_item_map_info_date_holds_score);
        this.mTxtBuildingPriceFloorAreaBrand = (TextView) view.findViewById(R.id.txt_map_price_floor_area_brand);

    }

    @Override
    public void setDataOnView(int position, List<ItemMainMapList> items) {
        ItemMainMapList data = items.get(position);
        Glide.with(mView.getContext()).load(data.getmImageUrl()).into(mImgBuilding);
        mTxtBuildingName.setText(data.getmName());
        mTxtBuildingInfoDateHoldsScore.setText("완공시기 : " + data.getmBuildDate() + "· 세대수 : " + data.getmHouseHolds() + "· 평점 : " + data.getmScore());
        if(data.getmBrand().equals("")) {
            mTxtBuildingPriceFloorAreaBrand.setText("가격 : " + ChangeMoney.changeMoney(data.getmPrice()) + "/" + data.getmFloorArea());
        } else {
            mTxtBuildingPriceFloorAreaBrand.setText("가격 : " + ChangeMoney.changeMoney(data.getmPrice()) + "/" + data.getmFloorArea() + "· 브랜드 : " + data.getmBrand());
        }
    }
}
