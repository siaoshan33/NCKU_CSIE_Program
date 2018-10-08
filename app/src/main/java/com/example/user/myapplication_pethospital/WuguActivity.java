package com.example.user.myapplication_pethospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class WuguActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wugu);

        TextView textView_C_W = ( TextView ) findViewById ( R.id.textView_City_W );
        TextView textView_A_W = ( TextView ) findViewById ( R.id.textView_W );

        Intent intent_W = getIntent();
        Bundle bundle_W = intent_W.getExtras();

        String city_W = bundle_W.getString( "city" );
        String area_W = bundle_W.getString( "area" );

        textView_C_W.setText(city_W);
        textView_A_W.setText(area_W);

        Button button_returnMain = ( Button ) findViewById ( R.id.button_return_Main );
        button_returnMain.setOnClickListener( RETURN_MAIN );

        Button button_enter_W = ( Button ) findViewById ( R.id.button_enter_W );
        button_enter_W.setOnClickListener( ENTER_Wugu );
    }

    private View.OnClickListener RETURN_MAIN = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_returnMain = new Intent ( WuguActivity.this , MainActivity_Pet_Hospital.class );
            startActivity ( intent_returnMain );

        }
    };

    private View.OnClickListener ENTER_Wugu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            RadioButton radioButton_W1 = ( RadioButton ) findViewById ( R.id.radioButton_W1 );
            RadioButton radioButton_W2 = ( RadioButton ) findViewById ( R.id.radioButton_W2 );

            if( radioButton_W1.isChecked() ){

                Intent intent_W1 = new Intent( WuguActivity.this, Wugu_One.class );
                startActivity( intent_W1 );

            }

            else if( radioButton_W2.isChecked() ){

                Intent intent_W2 = new Intent( WuguActivity.this, Wugu_Two.class );
                startActivity( intent_W2 );

            }

            if ((radioButton_W1.isChecked()==false) && (radioButton_W2.isChecked()==false)){

                Toast toast_W =Toast.makeText( WuguActivity.this, "請選擇您要搜尋的醫院！", Toast.LENGTH_LONG );
                toast_W.show();
            }
        }
    };
}
