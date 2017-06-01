package com.asuscomm.yangyinetwork.andstudy09_recyclerview.domain;

import static com.asuscomm.yangyinetwork.andstudy09_recyclerview.consts.CONSTS.BLACK;
import static com.asuscomm.yangyinetwork.andstudy09_recyclerview.consts.CONSTS.NAMEOFBLACK;
import static com.asuscomm.yangyinetwork.andstudy09_recyclerview.consts.CONSTS.NAMEOFNONE;
import static com.asuscomm.yangyinetwork.andstudy09_recyclerview.consts.CONSTS.NAMEOFWHITE;
import static com.asuscomm.yangyinetwork.andstudy09_recyclerview.consts.CONSTS.NONE;
import static com.asuscomm.yangyinetwork.andstudy09_recyclerview.consts.CONSTS.WHITE;

/**
 * Created by jaeyoung on 2017. 4. 30..
 */

public class StonePoint {
    private int stoneStatus;
    private String someWhat;

    public StonePoint() {
    }

    public StonePoint(int stoneStatus) {
        this.stoneStatus = stoneStatus;
        this.someWhat = matchStoneName(this.stoneStatus);
    }

    private String matchStoneName(int stoneStatus) {
        String matchedStoneName = NAMEOFNONE;
        switch(stoneStatus) {
            case BLACK:
                matchedStoneName = NAMEOFBLACK;
                break;
            case WHITE:
                matchedStoneName = NAMEOFWHITE;
                break;
            case NONE:
                matchedStoneName = NAMEOFNONE;
                break;
        }

        return matchedStoneName;
    }

    public StonePoint(int stoneStatus, String someWhat) {
        this.stoneStatus = stoneStatus;
        this.someWhat = someWhat;
    }

    public int getStoneStatus() {
        return stoneStatus;
    }

    public void setStoneStatus(int stoneStatus) {
        this.stoneStatus = stoneStatus;
    }

    public String getSomeWhat() {
        return someWhat;
    }

    public void setSomeWhat(String someWhat) {
        this.someWhat = someWhat;
    }
}
