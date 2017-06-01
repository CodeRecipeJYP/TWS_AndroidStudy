package com.asuscomm.yangyinetwork.andstudy09_recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asuscomm.yangyinetwork.andstudy09_recyclerview.R;
import com.asuscomm.yangyinetwork.andstudy09_recyclerview.domain.AColumnStonePoints;
import com.asuscomm.yangyinetwork.andstudy09_recyclerview.domain.StonePoint;

import java.util.List;

/**
 * Created by jaeyoung on 2017. 4. 30..
 */

public class StonePointAdapter extends RecyclerView.Adapter<StonePointAdapter.ViewHolder>{
    private String TAG = getClass().getSimpleName();
    List<StonePoint> mStonePoints;

    public StonePointAdapter(List<StonePoint> mStonePoints) {
        this.mStonePoints = mStonePoints;
    }

    public StonePointAdapter(AColumnStonePoints aColumnStonePoints) {
        this.mStonePoints = aColumnStonePoints.getStonePoints();
    }

    @Override
    public StonePointAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_board_a_point, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+mStonePoints.size());
        return mStonePoints.size();
    }

    @Override
    public void onBindViewHolder(StonePointAdapter.ViewHolder holder, int position) {
        StonePoint stonePoint = mStonePoints.get(position);
        holder.tvStoneStatus.setText(stonePoint.getStoneStatus()+"");
        holder.tvSomeWhat.setText(stonePoint.getSomeWhat());

        Log.d(TAG, "onBindViewHolder: "+stonePoint.getStoneStatus() +" "+stonePoint.getSomeWhat());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvStoneStatus;
        public final TextView tvSomeWhat;
    
        public ViewHolder(View v) {
            super(v);
            this.mView = v;
    
            this.tvStoneStatus = (TextView) v.findViewById(R.id.tvStoneStatus);
            this.tvSomeWhat = (TextView) v.findViewById(R.id.tvSomeWhat);
        }
    }
    
    public void add(StonePoint message) {
        this.mStonePoints.add(message);
    }
}
