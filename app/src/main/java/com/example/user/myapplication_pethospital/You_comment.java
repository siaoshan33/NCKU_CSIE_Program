package com.example.user.myapplication_pethospital;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import static com.example.user.myapplication_pethospital.R.id.ratingBar_Profession;

public class You_comment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_comment);

        final RatingBar ratingBar_Profession = ( RatingBar ) findViewById ( R.id.ratingBar_Profession );
        final RatingBar ratingBar_Equipment = ( RatingBar ) findViewById ( R.id.ratingBar_Equipment);
        final RatingBar ratingBar_Surroundings = ( RatingBar ) findViewById ( R.id.ratingBar_Surroundings);
        final RatingBar ratingBar_Service = ( RatingBar ) findViewById ( R.id.ratingBar_Service);
        final RatingBar ratingBar_Convenience = ( RatingBar ) findViewById ( R.id.ratingBar_Convenience);

        Button Return_All_comment = ( Button ) findViewById ( R.id.Return_All_comment );
        Return_All_comment.setOnClickListener( RETURN_ALL_comment);

        Button Submit_comment = ( Button ) findViewById ( R.id.Submit_comment );
        Submit_comment.setOnClickListener( SUBMIT_comment );
    }

    private View.OnClickListener RETURN_ALL_comment = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_Return_All_comment = new Intent ( You_comment.this , Tamsui_One.class );
            startActivity( intent_Return_All_comment );
        }
    };

    private View.OnClickListener SUBMIT_comment = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent_Submit_comment = new Intent ( You_comment.this , Tamsui_One.class );
            //Bundle bundle_Submit_comment = new Bundle ();




            startActivity( intent_Submit_comment );
        }
    };
}
