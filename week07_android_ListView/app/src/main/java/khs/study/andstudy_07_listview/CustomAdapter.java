package khs.study.andstudy_07_listview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jaeyoung on 2017. 4. 2..
 */

public class CustomAdapter extends BaseAdapter {
    ArrayList<String> db;

    public CustomAdapter(ArrayList<String> db) {
        this.db = db;
    }

    @Override
    public int getCount() {
        return db.size();
    }

    @Override
    public Object getItem(int position) {
        return db.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) { // 새로 만들어줘야함(최초)
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.simple_list_item, parent,false);
        }

        Button numb = (Button) convertView.findViewById(R.id.numb);
        numb.setText(position+"");
        TextView content = (TextView) convertView.findViewById(R.id.content);
        content.setText(db.get(position));

        return convertView;
    }
}
