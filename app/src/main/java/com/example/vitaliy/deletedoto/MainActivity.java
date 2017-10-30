package com.example.vitaliy.deletedoto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewSwitcher;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.vitaliy.deletedoto.R.id.vs;

public class MainActivity extends AppCompatActivity {
    Animation s_left, s_right;
    @BindView(R.id.vs)ViewSwitcher vs;
    @BindView(R.id.button1)Button gt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        s_left = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        s_right = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        vs.setAnimation(s_left);
        vs.setAnimation(s_right);
    //    submit();
    }
    @OnClick(R.id.button)
    public void submit(){
        vs.showNext();
    }
    @OnClick(R.id.button1)
    public void GOtO(){
        startActivity(new Intent(this, FormActivity.class));
    }
}
