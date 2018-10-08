package com.example.user.myapplication_pethospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Wugu_One extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wugu__one);

        TextView textView_W_One = ( TextView ) findViewById ( R.id.textView_W_One );
        textView_W_One.setText("醫師介紹\n\n醫師：李維淵\n" +
                "\n" +
                "地理位置：新北市五股區工商路40號\n\n" +
                "\n" +
                "聯絡方式：02-82958237");

        Button button_return_W = ( Button ) findViewById ( R.id.button_return_W );
        button_return_W.setOnClickListener( RETURN_Wugu);

        Button button_comment = ( Button ) findViewById ( R.id.button_comment );
        button_comment.setOnClickListener( COMMENT);

    }

    private View.OnClickListener RETURN_Wugu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_R_W = new Intent( Wugu_One.this, WuguActivity.class );
            startActivity( intent_R_W );
        }
    };

    private View.OnClickListener COMMENT = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_comment = new Intent( Wugu_One.this, You_comment.class );
            startActivity( intent_comment );
        }
    };
}
