package dxmnd.com.zigbang.java.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import dxmnd.com.zigbang.java.dto.ItemMainMapList;

/**
 * Created by HunJin on 2017-03-16.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
   public BaseViewHolder(View view) {
       super(view);
   }
    public abstract void setDataOnView(int position, List<ItemMainMapList> items);
}