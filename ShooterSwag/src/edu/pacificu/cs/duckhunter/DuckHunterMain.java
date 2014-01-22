package edu.pacificu.cs.duckhunter;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Android activity that implements a main menu screen for the game Bird Hunter
 *
 * @author Brandon Schlack, Pacific University
 */
public class DuckHunterMain extends Activity
{

  @Override
  protected void onCreate (Bundle savedInstanceState)
  {
    super.onCreate (savedInstanceState);

    setContentView (R.layout.activity_duck_hunter_main);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
    {
      toggleUI ();
    }
    
    final Button btnNewGame = (Button) findViewById (R.id.btnNewGame);
    btnNewGame.setOnClickListener (new View.OnClickListener()
    {
      
      @Override
      public void onClick (View v)
      {
        newGameDialog();       
      }
    });
    
    final Button btnSettings = (Button) findViewById (R.id.btnSettings);
    btnSettings.setOnClickListener (new View.OnClickListener()
    {
      
      @Override
      public void onClick (View v)
      {
        startSettings();       
      }
    });
  }
  
  public boolean hasDPad ()
  {
    Configuration c = getResources ().getConfiguration ();
    return (c.navigation == Configuration.NAVIGATION_DPAD);
  }
  
  @TargetApi (Build.VERSION_CODES.HONEYCOMB)
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

  
  private void startGame (int difficultyLevel)
  {
    Intent startGameIntent = new Intent (getApplicationContext (), 
                                         GameActivity.class);
    startGameIntent.putExtra ("DIFFICULTY_LEVEL", difficultyLevel);
    startActivity (startGameIntent);
  }
  
  private void newGameDialog ()
  {
    new AlertDialog.Builder (this)
     .setTitle (R.string.difficulty)
     .setItems (R.array.gameDifficulty,
        new DialogInterface.OnClickListener ()
        {

          @Override
          public void onClick (DialogInterface dialog, int difficultyLevel)
          {
            startGame (difficultyLevel);
          }
         }).show ();
  }
  
  private void startSettings ()
  {
    Intent startSettingsIntent = new Intent ();
    startSettingsIntent.setClassName ("edu.pacificu.cs.duckhunter", 
                                 "edu.pacificu.cs.duckhunter.SettingsActivity");
    startSettingsIntent.setAction ("@strings/sSettings");
    startActivity (startSettingsIntent);    
  }
}
