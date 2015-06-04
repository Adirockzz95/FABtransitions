package adik.fabtransitions;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.nineoldandroids.animation.Animator;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;
import io.codetail.animation.arcanimator.ArcAnimator;
import io.codetail.animation.arcanimator.Side;

/**
 * Created by aditockzz on 29-May-15.
 */
public class RevealToolbar  {

   static protected   Activity activity;
   static   protected   Drawable drawable;
   static protected   int color = Color.WHITE;
   static  protected    int Size = 72;
   static FloatingActionButton fab;
   static  protected int  fabX,fabY;
   static  float  revealX, revealY;
   static  float revealRadius;
   static SupportAnimator revealAnimator,hideAnimator;
   static ArcAnimator revealArc,hideArc;

    public static void Fab(Activity act,Drawable draw,int clr,int size){
        activity = act;
        drawable = draw;
        color = clr;
        Size = size;

    }

    public static FloatingActionButton Create(){
         fab = new FloatingActionButton.Builder(activity)
                .withDrawable(drawable)
                .withButtonColor(color)
                .withMargins(0,0,16,16)
                .withGravity(Gravity.END | Gravity.BOTTOM)
                .create();
                 fab.setVisibility(View.VISIBLE);
        return fab;

    }

  public static boolean Reveal(final View Myview){

      FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,160);
      params.setMargins(0,0,0,0);
      params.gravity = ( Gravity.END | Gravity.BOTTOM);
      Myview.setLayoutParams(params);
      Myview.setVisibility(View.VISIBLE);
      fabX = (fab.getLeft() +fab.getRight()) / 2;
      fabY = (fab.getTop() + fab.getBottom()) / 2;
      revealX  = (Myview.getLeft() + Myview.getRight()) / 2;
      revealY  = (Myview.getTop() + Myview.getBottom()) / 2;
      revealRadius = Math.max(Myview.getWidth(),Myview.getHeight());

                   revealAnimator = ViewAnimationUtils.createCircularReveal(Myview,fabX-145,fabY, 0, revealRadius);
                   revealAnimator.setDuration(200);
                   revealAnimator.setInterpolator(new AccelerateInterpolator());
                   revealArc = ArcAnimator.createArcAnimator(fab,fabX-145.0f,fabY, +5, Side.LEFT);
                   revealArc.setDuration(120);
                   revealArc.setInterpolator(new AccelerateInterpolator());
                   revealArc.start();
                   revealArc.addListener(new Animator.AnimatorListener() {
                       @Override
                       public void onAnimationStart(Animator animation) {

                       }

                       @Override
                       public void onAnimationEnd(Animator animation) {

                           fab.hideFloatingActionButton();
                          fab.setVisibility(View.INVISIBLE);
                           fab.setEnabled(false);
                           revealAnimator.start();

                           /*
                           hand.postDelayed(hide,0);
                          hand.postDelayed(invi,0);
                           hand.postDelayed(rvl,0);
                           */

                       }

                       @Override
                       public void onAnimationCancel(Animator animation) {

                       }

                       @Override
                       public void onAnimationRepeat(Animator animation) {

                       }
                   });



      return  true;

  }

    public static boolean HideReveal(final View Rootview){

                revealAnimator = ViewAnimationUtils.createCircularReveal(Rootview,fabX-145,fabY,revealRadius,0);
                revealAnimator.setDuration(200);
                revealAnimator.setInterpolator(new AccelerateInterpolator());
                revealArc = ArcAnimator.createArcAnimator(fab,fabX,fabY,-5, Side.RIGHT);
                revealArc.setDuration(120);
                revealArc.setInterpolator(new AccelerateInterpolator());
                revealAnimator.start();
                revealAnimator.addListener(new SupportAnimator.AnimatorListener() {
                    @Override
                    public void onAnimationStart() {

                    }

                    @Override
                    public void onAnimationEnd() {

                        Rootview.setVisibility(View.INVISIBLE);
                        fab.setVisibility(View.VISIBLE);
                        fab.setEnabled(true);
                        fab.showFloatingActionButton();
                          revealArc.start();

                    }

                    @Override
                    public void onAnimationCancel() {

                    }

                    @Override
                    public void onAnimationRepeat() {

                    }
                });


        return true;

    }
   



}
