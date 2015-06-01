package test.library;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;

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



    public static void fab(Activity act,Drawable draw,int clr,int size){
        activity = act;
        drawable = draw;
        color = clr;
        Size = size;
    }

    public static FloatingActionButton create(){
         fab = new FloatingActionButton.Builder(activity)
                .withDrawable(drawable)
                .withButtonColor(color)
                .withMargins(0,0,16,16)
                .withGravity(Gravity.END | Gravity.BOTTOM)
                .create();
        return fab;

    }

  public static boolean reveal(final View view){

      FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,160);
      params.setMargins(0,0,0,0);
      params.gravity = ( Gravity.END | Gravity.BOTTOM);
      view.setLayoutParams(params);

      view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
          @Override
          public void onGlobalLayout() {
              fabX = (fab.getLeft() +fab.getRight()) / 2;
              fabY = (fab.getTop() + fab.getBottom()) / 2;
              revealX  = (view.getLeft() + view.getRight()) / 2;
              revealY  = (view.getTop() + view.getBottom()) / 2;

              revealRadius = Math.max(view.getWidth(), view.getHeight());

                   revealAnimator = ViewAnimationUtils.createCircularReveal(view,fabX-145,fabY, 0, revealRadius);
                   revealAnimator.setDuration(210);
                   revealAnimator.setInterpolator(new AccelerateInterpolator());
                   revealArc = ArcAnimator.createArcAnimator(fab,fabX-145.0f,fabY, +10, Side.LEFT);
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
                           view.setVisibility(View.VISIBLE);
                           revealAnimator.start();
                          fab.setVisibility(View.INVISIBLE);

                       }

                       @Override
                       public void onAnimationCancel(Animator animation) {

                       }

                       @Override
                       public void onAnimationRepeat(Animator animation) {

                       }
                   });



          }
      });

      return  true;

  }

    public static boolean hideReveal(final View Rootview) {

        hideAnimator= ViewAnimationUtils.createCircularReveal(Rootview,fabX-145,fabY,revealRadius,0);
        hideAnimator.setDuration(210);
        hideAnimator.setInterpolator(new AccelerateInterpolator());
        hideArc = ArcAnimator.createArcAnimator(fab,fabX,fabY,-5, Side.RIGHT);
        hideArc.setDuration(120);
        hideArc.setInterpolator(new AccelerateInterpolator());
        hideAnimator.start();
        hideAnimator.addListener(new SupportAnimator.AnimatorListener() {
                    @Override
                    public void onAnimationStart() {

                    }

                    @Override
                    public void onAnimationEnd()  {
                                fab.setVisibility(View.VISIBLE);
                                fab.showFloatingActionButton();
                                Rootview.setVisibility(View.INVISIBLE);
                                hideArc.start();

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


/*
    public  static boolean ScrollReveal(final View Rootview){
        revealAnimator = ViewAnimationUtils.createCircularReveal(Rootview,fabX,fabY,revealRadius,0);
        revealAnimator.setDuration(210);
        revealAnimator.setInterpolator(new AccelerateInterpolator());
        revealArc = ArcAnimator.createArcAnimator(fab,fabX,fabY,-10, Side.RIGHT);
        revealArc.setDuration(120);
        revealArc.setInterpolator(new AccelerateInterpolator());
        revealAnimator.start();

        revealAnimator.addListener(new SupportAnimator.AnimatorListener() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {
                fab.setVisibility(View.VISIBLE);
                fab.showFloatingActionButton();
                Rootview.setVisibility(View.INVISIBLE);
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
*/


}
