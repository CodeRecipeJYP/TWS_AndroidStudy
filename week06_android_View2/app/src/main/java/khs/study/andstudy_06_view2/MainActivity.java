package khs.study.andstudy_06_view2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final String TAG = "JYP/"+getClass().getSimpleName();
    private Button mBtn;
    private TextView mTv;
    private ProgressBar mProgressBar;

    private int progress;
    private int nStatus = 1;
    private final int baseProgress = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        Log.d(TAG, "onCreate: initView");
        progress = baseProgress;
        mProgressBar.setProgress(progress);

    }

    void initView(){
        mBtn = (Button)findViewById(R.id.button);
        mBtn.setOnClickListener(this);
        mTv = (TextView) findViewById(R.id.textView);
        mTv.setOnClickListener(this);
        mProgressBar = (ProgressBar)findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
                progress = baseProgress*nStatus;
                break;
            case R.id.textView:
                nStatus++;
                break;
        }
        refreshView();
    }

    void refreshView(){
        Log.d(TAG, "refreshView: progress"+progress);
        mBtn.setText("Progress : "+progress);
        mProgressBar.setProgress(progress%mProgressBar.getMax());
        mTv.setText("Status X " + nStatus);
    }
}
