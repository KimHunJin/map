package dxmnd.com.zigbang.java.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dxmnd.com.zigbang.R;
import dxmnd.com.zigbang.java.dto.ItemMainMapList;
import dxmnd.com.zigbang.java.holders.BaseViewHolder;
import dxmnd.com.zigbang.java.holders.MainMapViewHolder;

/**
 * Created by HunJin on 2017-03-16.
 * <p>
 * 리사이클러뷰 어댑터
 */

public class MainMapListRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private View mView;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<ItemMainMapList> items;

    public MainMapListRecyclerViewAdapter(Context context) {
        super();
        this.mContext = context;
        items = new ArrayList<>();
    }

    /**
     * 아이템을 가져와 onClick 이벤트를 처리하기 위한 메서드
     * @return item list
     */
    public List<ItemMainMapList> getItem() {
        return items;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = mLayoutInflater.inflate(R.layout.item_main_map_list, viewGroup, false);
        return new MainMapViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setDataOnView(position, items);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * 데이터를 리스트에 저장하는 메서드
     * @param item
     */
    public void addData(ItemMainMapList item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

}
