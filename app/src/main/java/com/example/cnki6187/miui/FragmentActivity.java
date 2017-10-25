package com.example.cnki6187.miui;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cnki6187.fragment.f1;
import com.example.cnki6187.fragment.f2;
import com.example.cnki6187.fragment.f3;

public class FragmentActivity extends AppCompatActivity implements f1.OnFragmentInteractionListener,f2.OnFragmentInteractionListener,f3.OnFragmentInteractionListener{

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        button=(Button)findViewById(R.id.frButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                f3 fragment3=new f3();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager. beginTransaction();
                transaction.replace(R.id.right_layout, fragment3);
                transaction.commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
