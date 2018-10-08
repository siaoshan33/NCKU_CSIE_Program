package com.example.user.myapplication_pethospital;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class Tamsui_One extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamsui__one);

        TextView textView_T_One = ( TextView ) findViewById ( R.id.textView_T_One );
        textView_T_One.setText("醫師介紹\n\n醫院院長： 鹿介生\n" +
                "學/經歷： 中興大學畢業，二十餘年臨床獸醫師經驗，中華民國小動物臨床研究會理事長。\n\n" +
                "地理位置：新北市淡水區中山路159~2號\n\n" +
                "主要服務項目：小動物內、外科、骨科、胸腔外科、針炙治療\n\n" +
                "聯絡方式：02-26217987");

        WebView WebView_T = ( WebView ) findViewById ( R.id.WebView_T );

        //縮放
        WebView_T.getSettings().setBuiltInZoomControls( true );

        WebView_T.getSettings().setJavaScriptEnabled( true );

        WebView_T.setWebViewClient( new WebViewClient() );
        WebView_T.loadUrl("https://www.google.com.tw/maps/place/251%E6%96%B0%E5%8C%97%E5%B8%82%E6%B7%A1%E6%B0%B4%E5%8D%80%E4%B8%AD%E5%B1%B1%E8%B7%AF159-2%E8%99%9F/@25.1731907,121.4384374,17z/data=!3m1!4b1!4m5!3m4!1s0x3442a5574f5e17af:0x5091b881387551cf!8m2!3d25.1731859!4d121.4406261");

        Button button_return_T = ( Button ) findViewById ( R.id.button_return_T );
        button_return_T.setOnClickListener( RETURN_Tamsui);

        Button button_comment = ( Button ) findViewById ( R.id.button_comment );
        button_comment.setOnClickListener( COMMENT);

    }

    private View.OnClickListener RETURN_Tamsui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Tamsui_One.this.finish();

            //Intent intent_R_T = new Intent( Tamsui_One.this, TamsuiActivity.class );
            //startActivity( intent_R_T );
        }
    };

    private View.OnClickListener COMMENT = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_comment = new Intent( Tamsui_One.this, You_comment.class );
            startActivity( intent_comment );
        }
    };
}
