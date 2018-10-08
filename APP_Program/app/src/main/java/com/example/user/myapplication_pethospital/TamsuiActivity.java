package com.example.user.myapplication_pethospital;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class TamsuiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamsui);

        TextView textView_C_T = ( TextView ) findViewById ( R.id.textView_City_T );
        TextView textView_A_T = ( TextView ) findViewById ( R.id.textView_T );

        Intent intent_T = getIntent();
        Bundle bundle_T = intent_T.getExtras();
        String city_T = bundle_T.getString( "city" );
        String area_T = bundle_T.getString( "area" );
        textView_C_T.setText( city_T );
        textView_A_T.setText( area_T );

        Button button_returnMain = ( Button ) findViewById ( R.id.button_return_Main );
        button_returnMain.setOnClickListener( RETURN_MAIN );

        Button button_enter_T = ( Button ) findViewById ( R.id.button_enter_T );
        button_enter_T.setOnClickListener( ENTER_Tamsui );
    }

    private View.OnClickListener RETURN_MAIN = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_returnMin = new Intent( TamsuiActivity.this, MainActivity_Pet_Hospital.class );
            startActivity( intent_returnMin );
        }
    };

    private View.OnClickListener ENTER_Tamsui = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            RadioButton radioButton_T1 = ( RadioButton ) findViewById ( R.id.radioButton_T1 );
            RadioButton radioButton_T2 = ( RadioButton ) findViewById ( R.id.radioButton_T2 );
            RadioButton radioButton_T3 = ( RadioButton ) findViewById ( R.id.radioButton_T3 );
            RadioButton radioButton_T4 = ( RadioButton ) findViewById ( R.id.radioButton_T4 );
            RadioButton radioButton_T5 = ( RadioButton ) findViewById ( R.id.radioButton_T5 );

            if( radioButton_T1.isChecked()){

                Intent intent_T1 = new Intent( TamsuiActivity.this, Tamsui_One.class );
                startActivity( intent_T1 );

            }
            else if( radioButton_T2.isChecked()){

                Intent intent_T2 = new Intent( TamsuiActivity.this,  Tamsui_Two.class );
                startActivity( intent_T2 );

            }
            else if( radioButton_T3.isChecked()){

                Intent intent_T3 = new Intent( TamsuiActivity.this,  Tamsui_Three.class );
                startActivity( intent_T3 );

            }

            if((radioButton_T1.isChecked()==false)&&(radioButton_T2.isChecked()==false)&&(radioButton_T3.isChecked()==false)
                &&(radioButton_T4.isChecked()==false)&&(radioButton_T5.isChecked()==false)){

                Toast toast_T = Toast.makeText( TamsuiActivity.this, "請選擇您要搜尋的醫院", Toast.LENGTH_LONG );
                toast_T.show();

            }
        }
    };
}
