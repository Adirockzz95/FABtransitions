package test.letstest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import adik.fabtransitions.*;
import adik.fabtransitions.FloatingActionButton;
import adik.fabtransitions.RevealToolbar;


/**
 * Created by aditockzz on 30-May-15.
 */
public class ImageGallery extends Activity {

  boolean reveal_st = false;
  FloatingActionButton FAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagegallery);

     final   GridView gridView = (GridView)findViewById(R.id.Gridview);
        gridView.setAdapter(new ImageAdapter(this));

        final View myView = findViewById(R.id.reveal);   //REVEAL VIEW
        final View img1 = findViewById(R.id.img1);
        final View img2 = findViewById(R.id.img2);
        final View img3 = findViewById(R.id.img3);
        final View img4 = findViewById(R.id.img4);
        final View img5 = findViewById(R.id.img5);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"click1",Toast.LENGTH_SHORT).show();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"click2",Toast.LENGTH_SHORT).show();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"click3",Toast.LENGTH_SHORT).show();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"click4",Toast.LENGTH_SHORT).show();
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"click5",Toast.LENGTH_SHORT).show();
            }
        });



        final RevealToolbar toolbar = new RevealToolbar(myView);
                          toolbar.toolbarHeight(160);


        toolbar.Fab(this, getResources().getDrawable(R.drawable.ic_edit_white_24dp), Color.parseColor("#03A9F4"), 72);
        FAB = toolbar.Create();


        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reveal_st= toolbar.Reveal(myView);

            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               if(!toolbar.isRevealed()) {
                  reveal_st =toolbar.Reveal(myView);

               }

            }
        });


       gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
           @Override
           public void onScrollStateChanged(AbsListView absListView, int i) {
               if(toolbar.isRevealed()){
                  toolbar.HideReveal(myView);
                   reveal_st = false;
               }
           }

           @Override
           public void onScroll(AbsListView absListView, int i, int i2, int i3) {

           }
       });

    }

}

 class ImageAdapter extends BaseAdapter{

    public Integer[] imgs = {

            R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,
            R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,
            R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12,
            R.drawable.img13,R.drawable.img14,R.drawable.img15,R.drawable.img16,
            R.drawable.img17,R.drawable.img19,R.drawable.img20,R.drawable.img22,
            R.drawable.img23,R.drawable.img21};

    Context mContext;

    public ImageAdapter(Context c){
        mContext =c;

    }


    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int i) {
        return  imgs[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imgs[i]);
        return imageView;
    }


}
