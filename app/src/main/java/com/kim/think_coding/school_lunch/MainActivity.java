package com.kim.think_coding.school_lunch;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.kim.think_coding.test.String_Maker;
import com.kim.think_coding.test.Toast_message;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity{
    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyyMMdd");

    private WebView mWebView;
    private WebSettings mWebSettings;
    public TextView adv;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mWebView = (WebView)findViewById(R.id.webview_login);
        mWebView.setWebViewClient(new WebViewClient());
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);




        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);



        mWebView.loadUrl("http://p-namsan.ms.kr/asp/food/FOOD_1001/main.html?siteid=p-namsanms&boardid=food&uid="+mFormat.format(mDate)+"&pagemode=view");


        ExampleThread thread = new ExampleThread();
        thread.start();


        Toast.makeText(getApplicationContext(),mFormat.format(mDate)+"",Toast.LENGTH_LONG).show();
        String a = mFormat.format(mDate) + "";

//        Test mTest = new Test(a);

        Toast_message mToast_message =  new Toast_message(a, getApplicationContext());

        adv = (TextView) findViewById(R.id.made);
        String_Maker mString_Maker = new String_Maker("wkchoib12345", 20190203);
        adv.setText(mString_Maker.send_string);
    }




    private class ExampleThread extends Thread {
        private static final String TAG = "ExampleThread";

        public ExampleThread() {
            // 초기화 작업
        }

        public void run() {
            // 스레드에게 수행시킬 동작들 구현
//            while (true) {
//                Log.i("test_1", "message");
//            }
            Message msg = handler.obtainMessage();
            msg.what = 100;
            handler.sendMessage(msg);
        }
    }

    //스마트폰 화면들 구성 할수 있게
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case 100:

                    break;



            }
        }
    };

    public class Test{

        private Test(String toast){
            Toast.makeText(getApplicationContext(),toast,Toast.LENGTH_LONG).show();

        }

    }





}
