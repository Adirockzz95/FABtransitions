* **FAB to Toolbar**

Create XML layout. 

```xml
<adik.fabtransitions.MorphFrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
  <FrameLayout
        android:background="#03A9F4"
        android:visibility="invisible"
        android:id="@+id/reveal"        // Reveal view
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        
 			//add views here
        
  </FrameLayout>              
</adik.fabtransitions.MorphFrameLayout>
```
Code:
```java
final boolean reveal_sts = false;  //animation status flag
//Initialize revealview
View myView = findViewById(R.id.reveal) 

// create Floating Action Button
final FloatingActionButton  Fab; RevealToolbar.fab(this,getResources().getDrawable(your_drawable),Color.parseColor("#03A9F4"),72);
fab  = RevealToolbar.create();

//Set onClickListener on FAB to start reveal animation.
Fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) 		             		  
                reveal_st=  RevealToolbar.Reveal(myView); // pass reveal view
                //this will start reveal animation 
            }
        });
```
* **Toolbar to FAB**
 
 There are multiple ways to reverse the animation,you can use Event Listeners
  as triggers.Here we will use a simple Button click to reverse it.
  
  Add Button layout in previously created XML
 ```xml
 <adik.fabtransitions.MorphFrameLayout
   xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    <Button
        android:layout_gravity= "center"
        android:layout_width= "100dp"
        android:layout_height= "70dp"
        android:id= "@+id/button"
        android:text= "Click me"/>
    
  <FrameLayout
        android:background="#03A9F4"
        android:visibility="invisible"
        android:id="@+id/reveal"        // Reveal view
        android:layout_width="match_parent"
        android:layout_height="wrap_content">      
			  <!--Add views here !-->     
  
  </FrameLayout>
  
</adik.fabtransitions.MorphFrameLayout>
```
Code:
```java
//get reference
final Button b = (Button)findViewById(R.id.button);

//Set onClickListener on Button to start hide animation.
 b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //check whether Myview is revealed or not
                if(reveal_sts){
                    //call hideReveal method
                    RevealToolbar.hideReveal(myView); 
                    
                    reveal_sts = false; //set flag to false 
                }
            }
        });
```
Output: