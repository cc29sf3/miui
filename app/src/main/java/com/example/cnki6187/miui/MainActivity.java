package com.example.cnki6187.miui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.cnki6187.loginUtil.LoginThread;

import static android.app.ProgressDialog.STYLE_SPINNER;

public class MainActivity extends AppCompatActivity {

    public static final int LOGIN_SUCCESS=1;
    public static final int LOGIN_FAIL=0;

    private Button btn_Login;
    private Button btn_Cancel;

    ProgressDialog progressDialog = null;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Intent intent;
            progressDialog.cancel();
            switch(msg.what)
            {
                case LOGIN_SUCCESS:
                    intent=new Intent(MainActivity.this,SucActivity.class);
                    startActivity(intent);
                    break;
                case LOGIN_FAIL:
                    intent=new Intent(MainActivity.this,FailActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_Login=(Button)findViewById(R.id.button3);
        btn_Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //TODO 成功登录
                showProgress();
                LoginThread  lt=new LoginThread(handler,LOGIN_SUCCESS);
                new Thread(lt).start();
            }
        });
        btn_Cancel=(Button)findViewById(R.id.button2);
        btn_Cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //TODO 异常登录
                showProgress();
                LoginThread  lt=new LoginThread(handler,LOGIN_FAIL);
                new Thread(lt).start();
            }
        });
    }



    public void showProgress(){
        progressDialog=new ProgressDialog(this,STYLE_SPINNER);
        progressDialog.setTitle("登录ing...");
        progressDialog.setMessage("这是一个圆形进度条对话框");
        progressDialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
