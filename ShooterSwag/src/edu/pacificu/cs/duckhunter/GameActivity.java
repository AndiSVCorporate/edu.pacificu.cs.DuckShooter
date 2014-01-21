package edu.pacificu.cs.duckhunter;

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