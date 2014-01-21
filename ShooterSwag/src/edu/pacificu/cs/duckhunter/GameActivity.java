package edu.pacificu.cs.duckhunter;

<<<<<<< HEAD
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

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
    setContentView (mGamePlay); 
      
    requestWindowFeature (Window.FEATURE_NO_TITLE);
    this.getWindow ().setFlags    
         (WindowManager.LayoutParams.FLAG_FULLSCREEN,
          WindowManager.LayoutParams.FLAG_FULLSCREEN);
    
    WindowManager window = getWindowManager ();   
    mDisplay = window.getDefaultDisplay ();
    
    mGamePlay = new GamePlayScreen(this, difficultyLevel); 
    mGamePlay.setBackgroundColor (Color.BLACK);
    setContentView (mGamePlay); 
     
  }

}
=======
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends Activity
{

  @Override
  protected void onCreate (Bundle savedInstanceState)
  {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_game);
    toggleUI ();
  }
  
  @SuppressLint ("InlinedApi")
  public void toggleUI()
  {

    int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
    int newUiOptions = uiOptions;
    
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) 
    {
      newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
      newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
    }
    else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) 
    {
      newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
      newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
    }
    else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) 
    {
      newUiOptions ^= View.SYSTEM_UI_FLAG_LOW_PROFILE;
    }

    getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
  }
}
>>>>>>> refs/remotes/origin/beta
