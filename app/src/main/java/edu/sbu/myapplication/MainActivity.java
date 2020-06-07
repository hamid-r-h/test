package edu.sbu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showProgressDialog(View view){
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Progress dialoging");
        progressDialog.setMessage("please wait");
        progressDialog.show();
        final long progress=3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        },progress);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(progressDialog.getProgress()<progressDialog.getMax()){
                    progressDialog.incrementProgressBy(2);
                }
                else{
                    progressDialog.dismiss();
                }
            }
        },0,progress);
    }
}
