package com.asuscomm.yangyinetwork.andstudy09_recyclerview.domain;

import java.util.List;

/**
 * Created by jaeyoung on 2017. 4. 30..
 */

public class AColumnStonePoints {
    private List<StonePoint> stonePoints;

    public AColumnStonePoints(List<StonePoint> stonePoints) {
        this.stonePoints = stonePoints;
    }

    public AColumnStonePoints() {

    }

    public List<StonePoint> getStonePoints() {
        return stonePoints;
    }

    public void setStonePoints(List<StonePoint> stonePoints) {
        this.stonePoints = stonePoints;
    }
}
