package com.asuscom.yangyinetwork.andstudy_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button btn1; // instance?
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
        setContentView(R.layout.activity_main2);

        btn1 = (Button)findViewById(R.id.act2_btn1);
        btn1.setOnClickListener(listener);
        tview1 = (TextView)findViewById(R.id.act2_text1);
    }

    private void changeActivity() {
        tview1.setText("액티비티 바꿈");
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP); // cleartop 밑에거무조건지움
        Main2Activity.this.startActivity(intent);
    }
}
