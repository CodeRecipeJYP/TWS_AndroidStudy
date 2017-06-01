package khs.study.andstudy_07_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;

// Button Drawable
    /*
    * 배경화면, 다이나믹한
     */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {
    private final String TAG = getClass().getSimpleName();
    EditText inputText;
    Button postBtn;
    ListView list;

    CustomAdapter adapter;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper();
        dbHelper.saveText("hi");
        inputText = (EditText) findViewById(R.id.inputText);
        inputText.addTextChangedListener(this);
        postBtn = (Button) findViewById(R.id.postBtn);
        postBtn.setOnClickListener(this);
        list = (ListView) findViewById(R.id.list);
        adapter = new CustomAdapter(dbHelper.getDBList());
        list.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: before switch");
        switch (v.getId()) {
            case R.id.postBtn:
                Log.d(TAG, "onClick: after switch");
                dbHelper.saveText(inputText.getText().toString());// Editable이기때문에
                v.setEnabled(false);
                inputText.setText("");
                adapter.notifyDataSetChanged();
                break;
        }
    }

    // TextWatcher
    // char sequence
    CharSequence curText;
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        curText = s;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        postBtn.setEnabled(true);
        if(s.toString().equals("")){
            postBtn.setEnabled(false);
        }
    }
}
