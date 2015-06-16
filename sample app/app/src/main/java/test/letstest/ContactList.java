package test.letstest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import adik.fabtransitions.MaterialSheet;

/**
 * Created by aditockzz on 30-May-15.
 */
public class ContactList extends Activity {

    boolean reveal_st = false;
    adik.fabtransitions.FloatingActionButton FAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactlist);



        String[] InnerList = new String[5];
        String[] OuterList = new String[50];
        for(int i =0;i<5;i++)
            InnerList[i] = "Contact:AdiK "+i;

        for(int i =0;i<50;i++)
            OuterList[i] = "Contact:AdiK "+i;

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,InnerList);
        final ListView listView = (ListView)findViewById(R.id.InnerList);
        listView.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,OuterList);
        final ListView listView1 = (ListView)findViewById(R.id.OuterList);
        listView1.setAdapter(adapter1);

        final View myView = findViewById(R.id.reveal_card);


        final MaterialSheet materialSheet = new MaterialSheet(myView);// REVEAL VIEW
                        materialSheet.setMargins(0,550,30,30);


       materialSheet.Fab(this,getResources().getDrawable(R.drawable.ic_edit_black_24dp), Color.parseColor("#ffffff"),72);
      FAB = materialSheet.Create();


        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               reveal_st = materialSheet.Reveal(myView);

            }


        });

        listView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(reveal_st){
                    materialSheet.HideReveal(myView);
                    reveal_st = false;
                    return  true;
                }

              return  false;
            }

        });


    }


}
