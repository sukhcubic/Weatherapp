package com.example.weatherapp.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.weatherapp.R;

public abstract class BaseActivity extends AppCompatActivity {

    public ProgressBar progressBar;

    @Override
    public void setContentView(int layoutResID) {
//        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.base_activity, null);
//        FrameLayout frameLayout = constraintLayout.findViewById(R.id.activity_content);
//        progressBar = constraintLayout.findViewById(R.id.progress_bar);
//        getLayoutInflater().inflate(layoutResID,frameLayout, true);
//        super.setContentView(layoutResID);
    }

    public void showProgress(boolean visible){
        //progressBar.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }
}
