
package com.example.user.myapplication_pethospital;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.user.myapplication_pethospital.R.id.radioButton_B1;

public class Specific_area extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_area);

        TextView textView_City = (TextView) findViewById ( R.id.textView_City );
        TextView textView_Area = (TextView) findViewById ( R.id.textView_Area );

        Intent intent_specific = getIntent() ;
        Bundle bundle_specific = intent_specific.getExtras();

        String city_position = bundle_specific.getString( "city" );
        String area_position = bundle_specific.getString( "area" );
        textView_City.setText(city_position);
        textView_Area.setText(area_position);


        Button Return_Main = ( Button ) findViewById ( R.id.Return_Main );
        Return_Main.setOnClickListener( RETURN_Main );

        Button enter_Bali = ( Button ) findViewById ( R.id.button_enter_B );
        enter_Bali.setOnClickListener( ENTER_Bali );

    }

    private View.OnClickListener RETURN_Main = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_Return_Main = new Intent ( Specific_area.this , MainActivity_Pet_Hospital.class );
            //Intent intent_Return_Main = new Intent ( Specific_area.this , You_comment.class );
            startActivity(intent_Return_Main);
        }
    };

    private View.OnClickListener ENTER_Bali = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            RadioButton radioButton_B1 = ( RadioButton ) findViewById ( R.id.radioButton_B1);
            RadioButton radioButton_B2 = ( RadioButton ) findViewById ( R.id.radioButton_B2 );

            if(radioButton_B1.isChecked()){

                Intent intent_B1 = new Intent( Specific_area.this, Bali_One.class );
                startActivity( intent_B1 );
            }

            else if(radioButton_B2.isChecked()){

                Intent intent_B2 = new Intent( Specific_area.this, Bali_Two.class );
                startActivity( intent_B2 );

            }

            if(( radioButton_B1.isChecked()==false ) &&( radioButton_B2.isChecked()==false )){

                Toast toast_B = Toast.makeText( Specific_area.this, "請選擇您要搜尋的醫院", Toast.LENGTH_LONG);
                toast_B.show();
            }

        }
    };
}
