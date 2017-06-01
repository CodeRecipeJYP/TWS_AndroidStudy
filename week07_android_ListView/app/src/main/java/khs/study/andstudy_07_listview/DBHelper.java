package khs.study.andstudy_07_listview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaeyoung on 2017. 4. 2..
 */

public class DBHelper {
    private ArrayList<String> db;

    public DBHelper() {
        db = new ArrayList<>();
    }

    public void saveText(String text){
        db.add(text);
    }

    public String readText(int no) {
        return db.get(no);
    }

    public ArrayList<String> getDBList() {
        return db;
    }

    public int size() {
        return db.size();
    }
}
