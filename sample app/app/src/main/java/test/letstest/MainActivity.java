package test.letstest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button grid =  (Button)findViewById(R.id.grid);
        Button sheet = (Button)findViewById(R.id.msheet);

        final Intent intent = new Intent(this,ImageGallery.class);
       final Intent intent1  = new Intent(this,ContactList.class);


        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(intent);
            }
        });

         sheet.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(intent1);
             }
         });



    }


}
