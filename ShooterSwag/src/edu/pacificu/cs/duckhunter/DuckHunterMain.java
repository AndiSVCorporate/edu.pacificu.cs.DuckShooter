package edu.pacificu.cs.duckhunter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;

public class DuckHunterMain extends Activity
{

  @Override
  protected void onCreate (Bundle savedInstanceState)
  {
    super.onCreate (savedInstanceState);

    setContentView (R.layout.activity_duck_hunter_main);
    toggleUI ();
    
    final Button btnNewGame = (Button) findViewById (R.id.btnNewGame);
    btnNewGame.setOnClickListener (new View.OnClickListener()
    {
      
      @Override
      public void onClick (View v)
      {
        startGame();       
      }
    });
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

  
  private void startGame ()
  {
    Intent startGameIntent = new Intent (getApplicationContext (), GameActivity.class);
    startActivity (startGameIntent);
  }
}
