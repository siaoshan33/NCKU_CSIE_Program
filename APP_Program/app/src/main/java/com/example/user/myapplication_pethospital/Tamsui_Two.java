package com.example.user.myapplication_pethospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tamsui_Two extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamsui__two);

        TextView textView_T_Two = ( TextView ) findViewById ( R.id.textView_T_Two );
        textView_T_Two.setText("醫師介紹\n\n醫院院長： 王昌瑋\n" +
                "學/經歷： 國立台灣大學獸醫系畢\n\n" +
                "地理位置：新北市淡水區學府路4號\n\n" +
                "主要服務項目：內、外、產科、皮膚科\n\n" +
                "聯絡方式：02-26225750");

        Button button_return_T = ( Button ) findViewById ( R.id.button_return_T );
        button_return_T.setOnClickListener( RETURN_Tamsui);

        Button button_comment = ( Button ) findViewById ( R.id.button_comment );
        button_comment.setOnClickListener( COMMENT);

    }

    private View.OnClickListener RETURN_Tamsui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_R_T = new Intent( Tamsui_Two.this, TamsuiActivity.class );
            startActivity( intent_R_T );
        }
    };

    private View.OnClickListener COMMENT = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_comment = new Intent( Tamsui_Two.this, You_comment.class );
            startActivity( intent_comment );
        }
    };
}
