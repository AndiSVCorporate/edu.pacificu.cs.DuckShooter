/*package edu.pacificu.cs.duckhunter;

import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity
{
  Sprite mCrosshair;
  
  @Override
  protected void onCreate (Bundle savedInstanceState)
  {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_game);
    
    
  }
}
*/
package edu.pacificu.cs.duckhunter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
* This class starts the game play after receiving a difficulty from the user. 
*
* @author  Troy Zuroske, Pacific University
*/

public class GameActivity extends Activity 
{
 final String difficulty = "DIFFICULTY_LEVEL";
 GamePlayScreen mGamePlay; 
 private Display mDisplay;
 TextView mTextField;
 
 
 /**
  * Gets the difficulty from the user from main activity through intent and
  * then sets up the CustomDrawableView
  * 
  * @param savedInstanceState holds saved data if the activity needs to be
  * recreated
  */
 @Override
 protected void onCreate (Bundle savedInstanceState)
 {
   Bundle extras = getIntent ().getExtras ();
   int difficultyLevel;
   
   difficultyLevel = extras.getInt (difficulty); 
   
   super.onCreate (savedInstanceState); 
     
   requestWindowFeature (Window.FEATURE_NO_TITLE);
   this.getWindow ().setFlags    
        (WindowManager.LayoutParams.FLAG_FULLSCREEN,
         WindowManager.LayoutParams.FLAG_FULLSCREEN);
   
   WindowManager window = getWindowManager ();   
   mDisplay = window.getDefaultDisplay ();
   
   
   mGamePlay = new GamePlayScreen(this, difficultyLevel, mDisplay); 
   mGamePlay.setActivity (this);
   mGamePlay.setBackgroundColor (Color.BLACK);
   setContentView (mGamePlay); 
    
 }

}