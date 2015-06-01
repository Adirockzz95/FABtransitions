package adik.fabtransitions;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;

import com.nineoldandroids.animation.Animator;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;
import io.codetail.animation.arcanimator.ArcAnimator;
import io.codetail.animation.arcanimator.Side;


public class RevealMaterialSheet {

    static protected Activity activity;
    static   protected Drawable drawable;
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

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)view.getLayoutParams();
        params.gravity = (Gravity.RIGHT);
        params.setMargins(0,550,30,30);
        view.setLayoutParams(params);


        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                fabX = (fab.getLeft() +fab.getRight()) / 2;
                fabY = (fab.getTop() + fab.getBottom()) / 2;
                revealX  = (view.getLeft() + view.getRight()) / 2;
                revealY  = (view.getTop() + view.getBottom()) / 2;
                revealRadius = Math.max(view.getWidth(), view.getHeight());
                        revealAnimator = ViewAnimationUtils.createCircularReveal(view, (int)revealX, (int)revealY+250, 0, revealRadius);
                        revealAnimator.setDuration(210);
                        revealAnimator.setInterpolator(new AccelerateInterpolator());
                        revealArc = ArcAnimator.createArcAnimator(fab,revealX,revealY+250.0f, +10, Side.LEFT);
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


        return true;

    }

    public static boolean hideReveal( final View Rootview) {

        hideAnimator = ViewAnimationUtils.createCircularReveal(Rootview, (int) revealX, (int) revealY + 250, revealRadius, 0);
        hideAnimator.setDuration(210);
        hideAnimator.setInterpolator(new AccelerateInterpolator());
        hideArc = ArcAnimator.createArcAnimator(fab, fabX, fabY, -10, Side.LEFT);
        hideArc.setDuration(120);
        hideArc.setInterpolator(new AccelerateInterpolator());
        hideAnimator.start();
        hideAnimator.addListener(new SupportAnimator.AnimatorListener() {
                    @Override
                    public void onAnimationStart() {

                    }

                    @Override
                    public void onAnimationEnd() {
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

        return  true;

    }




}
