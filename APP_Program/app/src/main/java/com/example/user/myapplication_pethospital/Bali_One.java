package com.example.user.myapplication_pethospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Bali_One extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bali__one);

        TextView textView_B_One = ( TextView ) findViewById ( R.id.textView_B_One );
        textView_B_One.setText("醫師介紹\n\n醫院院長： 張寶榮\n" +
                "學/經歷： 台大獸醫學系畢業。\n\n" +
                "地理位置：台北市北投區明德路150巷30號\n\n" +
                "主要服務項目： 小動物內、外科\n\n" +
                "聯絡方式：02-28261000");

        Button button_return_B = ( Button ) findViewById ( R.id.button_return_W );
        button_return_B.setOnClickListener( RETURN_Bali);

        Button button_comment = ( Button ) findViewById ( R.id.button_comment );
        button_comment.setOnClickListener( COMMENT);

    }

    private View.OnClickListener RETURN_Bali = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_R_B = new Intent( Bali_One.this, Specific_area.class );
            startActivity( intent_R_B );
        }
    };

    private View.OnClickListener COMMENT = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_comment = new Intent( Bali_One.this, You_comment.class );
            startActivity( intent_comment );
        }
    };
}
