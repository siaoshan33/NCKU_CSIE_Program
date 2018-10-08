package com.example.user.myapplication_pethospital;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity_Pet_Hospital extends AppCompatActivity {

    private Context context= this;
    private String  area_position;

    private String [] city = new String [] { "新北市" , " 台北市" };
    private String [] area = new String [] { "八里區" , "五股區" , "淡水區"};
    private String [] time = { "早上(0800-1200)" , "下午(1200-1800)" , "晚上(1800-2400)" , "午夜(0000-0800)"};

    Spinner sp_City , sp_Area , sp_Time;

    ArrayAdapter<String> adapterCity;
    ArrayAdapter<String> adapterArea;
    ArrayAdapter<String> adapterTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main__pet__hospital);

        sp_City = ( Spinner ) findViewById ( R.id.spinner_city);
        adapterCity = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, city);
        adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_City.setAdapter(adapterCity);

        sp_Area = ( Spinner ) findViewById ( R.id.spinner_area);
        adapterArea = new ArrayAdapter< > (this, android.R.layout.simple_spinner_item, area);
        adapterArea.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_Area.setAdapter(adapterArea);
        sp_Area.setOnItemSelectedListener(AREA);

        sp_Time = ( Spinner ) findViewById ( R.id.spinner_time);
        adapterTime = new ArrayAdapter< > (this, android.R.layout.simple_spinner_item, time);
        adapterTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_Time.setAdapter(adapterTime);

        Button button_enter = ( Button ) findViewById ( R.id.button_enter );
        button_enter.setOnClickListener ( ENTER );
    }


    private AdapterView.OnItemSelectedListener AREA = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position_area, long id) {

                area_position = area[position_area];
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private View.OnClickListener ENTER = new View.OnClickListener() {
        @Override
       public void onClick(View v) {

            Intent intent_Main = new Intent();
            Bundle bundle_Main = new Bundle();



            if(area_position=="八里區") {

                bundle_Main.putString ( "city", "新北市");
                bundle_Main.putString ( "area", "八里區");
                intent_Main.putExtras ( bundle_Main );

                intent_Main.setClass(MainActivity_Pet_Hospital.this, Specific_area.class);
            }

            if(area_position=="五股區") {

                bundle_Main.putString ( "city", "新北市");
                bundle_Main.putString ( "area", "五股區");
                intent_Main.putExtras ( bundle_Main );

                intent_Main.setClass(MainActivity_Pet_Hospital.this, WuguActivity.class);
            }

            if(area_position=="淡水區") {

                bundle_Main.putString ( "city", "新北市");
                bundle_Main.putString ( "area", "淡水區");
                intent_Main.putExtras ( bundle_Main );

                intent_Main.setClass(MainActivity_Pet_Hospital.this, TamsuiActivity.class);
            }

            startActivity(intent_Main);
       }
    };
}
