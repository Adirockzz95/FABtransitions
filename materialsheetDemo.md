 ### **FAB to material sheet**

  Create XML layout
```xml
   <!-- set parent id (compulsorily) -->
<test.library.MorphFrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
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
```
 In your activity:
```java
       boolean revl_sts = false;   //animation status flag
		
        //Initialize revealview
        final View myView = findViewById(R.id.reveal);

        //create instance of materialsheet
        final MaterialSheet cardview = new MaterialSheet(myView);

       //create and floating action button
        FloatingActionButton fab;
       cardview.Fab(this,getResources().getDrawable(your_drawable),Color.parseColor("#FFFF00"),72); 
fab = cardview.Create();  

//set onClicklistener on FAB to start reveal animation
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                revl_sts = cardview.Reveal(myView); //pass reveal view

            }
        });
```
Reveal animation will inflate the material sheet on top of the it's **Parent View** ,
making background activity dim & disabled.

![Example ](https://github.com/Adirockzz95/FABtransitions/blob/master/art/sample1.jpg?raw=true)

 ### **Material sheet to FAB**

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
                if(revl_sts){
                    cardview.HideReveal(myView);  //hide vieew
                    revl_sts = false;    //set flag to false
                }
                return true;
            }
        });
      
  ```    
  Output:
  
  ![ ](https://github.com/Adirockzz95/FABtransitions/blob/master/art/sample2.gif?raw=true);
  
  
  
  
  
