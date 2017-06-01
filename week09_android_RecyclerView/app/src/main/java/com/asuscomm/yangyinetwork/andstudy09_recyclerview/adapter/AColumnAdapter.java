package com.asuscomm.yangyinetwork.andstudy09_recyclerview.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asuscomm.yangyinetwork.andstudy09_recyclerview.R;
import com.asuscomm.yangyinetwork.andstudy09_recyclerview.domain.AColumnStonePoints;
import com.asuscomm.yangyinetwork.andstudy09_recyclerview.domain.StonePoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaeyoung on 2017. 4. 30..
 */

public class AColumnAdapter extends RecyclerView.Adapter<AColumnAdapter.ViewHolder>{
    private List<AColumnStonePoints> mAColumnStonePointsList;
    private List<StonePointAdapter> mStonePointAdapters;

    public AColumnAdapter(List<AColumnStonePoints> mAColumnStonePointsList) {
        this.mAColumnStonePointsList = mAColumnStonePointsList;
        this.mStonePointAdapters = new ArrayList<StonePointAdapter>();
        for (AColumnStonePoints aColumnStonPoints:
             mAColumnStonePointsList) {
            mStonePointAdapters.add(new StonePointAdapter(aColumnStonPoints));
        }
    }

    @Override
    public AColumnAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_board_a_column, parent, false);

        return new AColumnAdapter.ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return mAColumnStonePointsList.size();
    }

    @Override
    public void onBindViewHolder(AColumnAdapter.ViewHolder holder, int position) {
//        AColumnStonePoints aColumnStonePoints = mAColumnStonePointsList.get(position);
        holder.aColumnRecyclerView.setAdapter(mStonePointAdapters.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final RecyclerView aColumnRecyclerView;

        public ViewHolder(View v) {
            super(v);
            this.mView = v;

            this.aColumnRecyclerView = (RecyclerView) v.findViewById(R.id.aColumnRecyclerView);
            LinearLayoutManager layoutManager = new LinearLayoutManager(v.getContext());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            this.aColumnRecyclerView.setLayoutManager(layoutManager);
        }
    }

    public void add(AColumnStonePoints aColumnStonePoints) {
        this.mAColumnStonePointsList.add(aColumnStonePoints);
    }
}