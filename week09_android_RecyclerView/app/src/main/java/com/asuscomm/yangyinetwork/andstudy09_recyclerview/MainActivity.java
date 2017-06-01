package com.asuscomm.yangyinetwork.andstudy09_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.asuscomm.yangyinetwork.andstudy09_recyclerview.adapter.AColumnAdapter;
import com.asuscomm.yangyinetwork.andstudy09_recyclerview.adapter.StonePointAdapter;
import com.asuscomm.yangyinetwork.andstudy09_recyclerview.domain.AColumnStonePoints;
import com.asuscomm.yangyinetwork.andstudy09_recyclerview.domain.StonePoint;

import java.util.ArrayList;
import java.util.List;

import static com.asuscomm.yangyinetwork.andstudy09_recyclerview.consts.CONSTS.BLACK;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "JYP/"+getClass().getSimpleName();
    private AColumnAdapter mAColumnAdapter;
    private RecyclerView mStonePointRecyclerView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        makeSample();
    }

    void initView() {
        List<AColumnStonePoints> aColumnStonePointsList = new ArrayList<>();
        mAColumnAdapter = new AColumnAdapter(aColumnStonePointsList);
        mStonePointRecyclerView = (RecyclerView) findViewById(R.id.boardRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mStonePointRecyclerView.setLayoutManager(layoutManager);
//        mStonePointRecyclerView.setAdapter(mAColumnAdapter);

        // Initialize progress bar
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mProgressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    void makeSample() {
        ArrayList<StonePoint> stonePoints = new ArrayList<StonePoint>();
        stonePoints.add(new StonePoint(BLACK));
        stonePoints.add(new StonePoint(BLACK));
        stonePoints.add(new StonePoint(BLACK));
        stonePoints.add(new StonePoint(BLACK));
//        ArrayList<AColumnStonePoints> aColumnStonePointsList = new ArrayList<AColumnStonePoints>();
        mAColumnAdapter.add(new AColumnStonePoints(stonePoints));
        mAColumnAdapter.add(new AColumnStonePoints(stonePoints));
        mAColumnAdapter.add(new AColumnStonePoints(stonePoints));
        mAColumnAdapter.notifyDataSetChanged();
        mStonePointRecyclerView.setAdapter(mAColumnAdapter);
        StonePointAdapter stonePointAdapter = new StonePointAdapter(stonePoints);

//        mStonePointRecyclerView.setAdapter(stonePointAdapter);
    }
}
