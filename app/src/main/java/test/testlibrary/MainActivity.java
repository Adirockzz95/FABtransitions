package test.testlibrary;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import test.library.FloatingActionButton;
import test.library.RevealToolbar;


public class MainActivity extends AppCompatActivity {
    boolean reveal_sts = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View myView = findViewById(R.id.Reveal);

         RevealToolbar.fab(this, getResources().getDrawable(R.drawable.ic_share_white_24dp),Color.parseColor("#03A9F4"),72);
        final FloatingActionButton fab = RevealToolbar.create();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reveal_sts = RevealToolbar.reveal(myView);

            }
        });

        Button b = (Button)findViewById(R.id.Button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(reveal_sts){
                    RevealToolbar.hideReveal(myView);
                    reveal_sts = false;
                }
            }
        });

    }

}
