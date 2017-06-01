package com.asuscom.yangyinetwork.andstudy_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn; // instance?
    TextView tview1;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeActivity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.act1_btn1);
        btn.setOnClickListener(listener);

        tview1 = (TextView)findViewById(R.id.act1_text1);
    }

    private void changeActivity() {
        tview1.setText("액티비티2로 ㄱㄱ");
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        MainActivity.this.startActivity(intent);
    }
}
