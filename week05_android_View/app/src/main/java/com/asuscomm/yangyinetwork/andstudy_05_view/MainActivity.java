package com.asuscomm.yangyinetwork.andstudy_05_view;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.asuscomm.yangyinetwork.andstudy_05_view.Models.Message;
import com.asuscomm.yangyinetwork.andstudy_05_view.Models.MessageDto;
import com.asuscomm.yangyinetwork.andstudy_05_view.Models.Model;
import com.asuscomm.yangyinetwork.andstudy_05_view.Post.Post;
import com.asuscomm.yangyinetwork.andstudy_05_view.Post.PostNetworkServiceImpl;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import static android.content.ContentValues.TAG;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity implements Model,PostNetworkServiceImpl.Listener {
    Presenter presenter;
    @ViewById
    ToggleButton toggleButton;
    @ViewById
    CheckBox checkBox;
    @ViewById
    RadioGroup radioGroup;
    @ViewById
    Spinner spinner;
    @ViewById
    ProgressBar progressBar;
    @ViewById
    SeekBar seekBar;
    @ViewById
    RatingBar ratingBar;
    @ViewById
    Switch mSwitch;
    @ViewById
    EditText editText;
    @ViewById
    ListView listView;
    List<Message> messageList;
    ListAdapter adapter;

    PostNetworkServiceImpl mPostService;

    @Override
    public void onGetPostsSuccess(List<Post> posts) {
        Log.d(TAG, "onGetPostsSuccess: "+ posts.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPostService = new PostNetworkServiceImpl(this);
        mPostService.getPosts();

        presenter = new NetworkService(this);
        //init_views();
        set_listener_views();
    }

    void init_views() {
        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        mSwitch = (Switch)findViewById(R.id.mSwitch);
        editText = (EditText)findViewById(R.id.editText);
        listView = (ListView)findViewById(R.id.listView);
    }

    @AfterViews
    void set_listener_views() {
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "토글 "+isChecked, Toast.LENGTH_SHORT).show();
                adapter = new ArrayAdapter<Message>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,messageList);
                listView.setAdapter(adapter);
            }
        });

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listView.setAdapter(new ArrayAdapter<Message>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,messageList));
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                presenter.getMessageDto();
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });

        progressBar.setMax(1000);
        progressBar.setProgress(500);

        seekBar.setMax(10000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    editText.setText(progress+"");
                    // 그 위치로 영상이동하기
                } else {
                    //아무것도 하면안됨
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //사용자가 끌어당기기 시작한상태
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //사용자가 놓는순간
                //해당위치로 영상이동
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //사용자가 텍스트를 체인지하고나서
                int progress = Integer.parseInt(s.toString());
                progressBar.setProgress(progress);
            }
        });

        listView.setAdapter(new BaseAdapter(){
            String[] datas = new String[] {
                    "짜장면", "짬뽕", "탕수육", "양장피"
            };

            @Override
            public int getCount() {
                return datas.length+2;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
                // 사실 이러면안됨
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView != null){
                    //뷰가 만들어져있음
                    return convertView;
                }
                View v = View.inflate(MainActivity.this, android.R.layout.simple_list_item_1, null);
                ((TextView)v.findViewById(android.R.id.text1)).setText(datas[position]);
                return v;
            }
        });

    }

    @Override
    public void setMessageDto(MessageDto<Message> messageDto){
        Toast.makeText(this, messageDto.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setMessageList(List<Message> messageList){
        Toast.makeText(this, messageList.toString(), Toast.LENGTH_SHORT).show();
        this.messageList = messageList;
    }

    @Override
    public void setMessage(Message message) {
        Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show();
    }
}

