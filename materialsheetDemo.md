 **FAB to material sheet**

  Create XML layout
```xml
   <!-- set parent id (compulsorily) -->
<adik.fabtransitions.MorphFrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/hide"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

      <FrameLayout
          android:visibility="invisible"
          android:background="@drawable/card"
          android:id="@+id/reveal"
          android:layout_width="250dp"
          android:layout_height="300dp"
         android:clickable="true">

          <!--Add your views here-->
      </FrameLayout>
   </adik.fabtransitions.MorphFrameLayout>   
```
 In your activity:
```java
       boolean revl_sts = false;   //animation status flag
		
        //Initialize revealview
        final View myView = findViewById(R.id.reveal);

       //create instance of MaterialSheet
    final MaterialSheet materialSheet = new MaterialSheet(myView);// REVEAL VIEW
                       
       //create and floating action button
        FloatingActionButton fab;
       materialSheet.Fab(this,getResources().getDrawable(your_drawable),Color.parseColor("#FFFF00"),72); 
       fab = materialSheet.Create();  
       
  ```
  * **Now you can use other FAB libraries. To do that create an instance of your FAB button and pass it to MaterialSheet constructor.**
  ```
final MaterialSheet materialsheet = new MaterialSheet( Activity activity ,final View RevealView,final View FAB);
  ```
  Then attach Event listener
  ```

//set onClicklistener on FAB to start reveal animation
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reveal_st = materialSheet.Reveal(myView);  //pass reveal view

            }
        });
```
Reveal animation will inflate the material sheet on top of the it's **Parent View** ,
making background activity dim & disabled.

![Example ](https://github.com/Adirockzz95/FABtransitions/blob/master/art/sample1.jpg?raw=true)

 **Material sheet to FAB**

  To reverse the animation you have to set setOnTouchListener on its parent view.
  In other words, touch event outside the Reveal view will act as a trigger.
  
  In your activity
  
  ```java
  //Initialize parent view (Can be any view)
  final View outside = findViewById(R.id.hide);
  
  
  outside.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //check if view is revealed or not
                if(materialsheet.isRevealed()){
                    materialsheet.HideReveal(myView);  //hide vieew
                    revl_sts = false;    //set flag to false
                }
                return true;
            }
        });
      
  ```
  
##Public Constructors
 
   * **MaterialSheet(View RevealView)**
   * **MaterialSheet(View RevealView, View FAB)**
   
   ##Public Methods
   * **Reveal(View)**  
     Returns true after succesfull execution.
   * **HideReveal(View)**  
     Returns true after succesfull execution.
   * **showFab(View v)**  
     Show fab with animation.
   * **hideFab(View v)**  
     Hide fab with animation
   * **isRevealed()**  
     Returns true if View is revealed else false.
   * **isFabHidden()**  
     Returns true if fab is hidden
   * **setChangeX(int x)**  
     Set X coordinate for reveal animation.
   * **setChangeY(int y)**  
     Set Y coordinate for reveal animation
     **Default values of (x,y) coordinates are Center(x,y+200) of View.**

   * **setMargins(int left,int top, int right, int bottom)**  
     **Default values are (0,0,450,30,30)**

    
  Output:
  
  ![ ](https://github.com/Adirockzz95/FABtransitions/blob/master/art/sample2.gif?raw=true);
  
  
 
  
  
