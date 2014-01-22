package edu.pacificu.cs.duckhunter;

import java.util.ArrayList;
import java.util.Random;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
* This implements the game view for when the user is playing a new Bird Hunter
* game. This holds the game logic and displays the board along with the moves
* the user makes. It will tell them when they have won with a dialogue box
*
* @author  Troy Zuroske, Pacific University
*/

@SuppressLint ("ViewConstructor")
public class GamePlayScreen extends LinearLayout
{
  private final int EASY = 0;
  private final int MEDIUM = 1;
  private final int HARD = 2;
  private final int CROSSHAIR_SPEED = 15;
  private final int NUMBER_OF_PIGEONS = 5;
  private final int NUMBER_OF_CROWS = 5;
  private final int NUMBER_OF_FALCONS = 5;
  private final int NUMBER_OF_EAGLES = 5;
  private final int CENTER_X_COORD = 240;
  private final int CENTER_Y_COORD = 427;
  private final int CROSSHAIR_SIZE = 50;
  private final int CENTER_CROSS_LOCATION = 2;
  final String VIEW_BOARD = "Okay"; 
  final String GAME_END = "Game Over";
  private ArrayList<BirdMain> birdSpriteList; 
  private Activity activity;
  int randomXCoord;
  int randomYCoord;
  int xSpeed = -CROSSHAIR_SPEED;
  int ySpeed = -CROSSHAIR_SPEED;
  int gameScore = 0; 
  Sprite mCrosshair;
  MediaPlayer mp = MediaPlayer.create (getContext (), R.raw.gunshot2);
  MediaPlayer mp1 = MediaPlayer.create (getContext (), R.raw.victory);
  TextView scoreView = new TextView(getContext ());
  TextView textTime = new TextView(getContext()); 
  

  /**
  * This creates the view and gets the number birds to be created from the 
  * difficulty level selected by the user. This places the birds randomly on the 
  * screen. It also turns on the Touch Mode
  * 
  * @param context The interface to the application environment
  * 
  * @param difficultyLevel an integer that represents the level of difficulty
  * the user has selected
  * 
  * @param display provides information about the size and density of a 
  * logical display
  */

  public GamePlayScreen (final Context context, int difficultyLevel, 
      Display display)
  {
    super (context);
    setFocusable (true);
    setFocusableInTouchMode (true);
    
    setOrientation(LinearLayout.VERTICAL);
    setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 
        LayoutParams.MATCH_PARENT));
    
    addView(scoreView);  
    addView(textTime); 
    
    mCrosshair = new Sprite (context, display, R.drawable.crosshairs, 
        (CENTER_X_COORD - CROSSHAIR_SIZE), (CENTER_Y_COORD - CROSSHAIR_SIZE));

    if (difficultyLevel == EASY)
    {
      //mp1.start (); 
      birdSpriteList = new ArrayList<BirdMain> ();
      for (int i = 0; i < NUMBER_OF_PIGEONS; i++)
      { 
        generateRandXCoord ();
        generateRandYCoord (); 
        BirdMain tempObj = new PigeonBird (context, display, R.drawable.pigeon, 
            randomXCoord, randomYCoord);
        birdSpriteList.add (tempObj); 
      }
      for (int i = 0; i < NUMBER_OF_CROWS; i++)
      {
        generateRandXCoord ();
        generateRandYCoord ();
        BirdMain tempObj = new CrowBird (context, display, R.drawable.crow, 
            randomXCoord, randomYCoord);
        birdSpriteList.add (tempObj); 
      }
      CountDownTimer timer = new CountDownTimer(62000, 1000) 
      {
        public void onTick(long millisUntilFinished) 
        {
          textTime.setTextSize (20);
          textTime.setText("seconds remaining: " + millisUntilFinished / 1000);
        }

        public void onFinish() 
        {
          new AlertDialog.Builder(context)
          .setTitle(GAME_END)
          .setMessage("Time is up! Your final score was: " + gameScore)
          .setPositiveButton(VIEW_BOARD, new DialogInterface.OnClickListener() 
          {
            public void onClick(DialogInterface dialog, int which) 
            { 
              activity.finish (); 
            }
          })
          .show();
        }
     }.start();
    }
    else if (difficultyLevel == MEDIUM)
    {
      birdSpriteList = new ArrayList<BirdMain> ();
      for (int i = 0; i < NUMBER_OF_PIGEONS; i++)
      { 
        generateRandXCoord ();
        generateRandYCoord (); 
        BirdMain tempObj = new PigeonBird (context , display, R.drawable.pigeon,
            randomXCoord, randomYCoord);
        birdSpriteList.add (tempObj); 
      }
      for (int i = 0; i < NUMBER_OF_CROWS; i++)
      {
        generateRandXCoord ();
        generateRandYCoord ();
        BirdMain tempObj = new CrowBird (context, display, R.drawable.crow, 
            randomXCoord, randomYCoord);
        birdSpriteList.add (tempObj); 
      }
      for (int i = 0; i < NUMBER_OF_FALCONS; i++)
      {
        generateRandXCoord ();
        generateRandYCoord ();
        BirdMain tempObj = new FalconBird (context, display, R.drawable.falcon, 
            randomXCoord, randomYCoord);
        birdSpriteList.add (tempObj); 
      }
      
      CountDownTimer timer = new CountDownTimer(62000, 1000) 
      {
        public void onTick(long millisUntilFinished) 
        {
          textTime.setTextSize (20);
          textTime.setText("seconds remaining: " + millisUntilFinished / 1000);
        }

        public void onFinish() 
        {
          new AlertDialog.Builder(context)
          .setTitle(GAME_END)
          .setMessage("Time is up! Your final score was: " + gameScore)
          .setPositiveButton(VIEW_BOARD, new DialogInterface.OnClickListener() 
          {
            public void onClick(DialogInterface dialog, int which) 
            { 
              activity.finish ();  
            }
          })
          .show();
        }
     }.start();
     
    }
    else if (difficultyLevel == HARD)
    {
      birdSpriteList = new ArrayList<BirdMain> ();
      for (int i = 0; i < NUMBER_OF_PIGEONS; i++)
      { 
        generateRandXCoord ();
        generateRandYCoord (); 
        BirdMain tempObj = new PigeonBird (context, display, R.drawable.pigeon, 
            randomXCoord, randomYCoord);
        birdSpriteList.add (tempObj); 
      }
      for (int i = 0; i < NUMBER_OF_CROWS; i++)
      {
        generateRandXCoord ();
        generateRandYCoord ();
        BirdMain tempObj = new CrowBird (context, display, R.drawable.crow,
            randomXCoord, randomYCoord);
        birdSpriteList.add (tempObj); 
      }
      for (int i = 0; i < NUMBER_OF_FALCONS; i++)
      {
        generateRandXCoord ();
        generateRandYCoord ();
        BirdMain tempObj = new FalconBird (context, display, R.drawable.falcon, 
            randomXCoord, randomYCoord);
        birdSpriteList.add (tempObj); 
      }
      for (int i = 0; i < NUMBER_OF_EAGLES; i++)
      {
        generateRandXCoord ();
        generateRandYCoord ();
        BirdMain tempObj = new EagleBird (context, display, R.drawable.eagle, 
            randomXCoord, randomYCoord);
        birdSpriteList.add (tempObj); 
      }
      CountDownTimer timer = new CountDownTimer(62000, 1000)
      {
        public void onTick(long millisUntilFinished) 
        {
          textTime.setTextSize (20);
          textTime.setText("seconds remaining: " + millisUntilFinished / 1000);
        }

        public void onFinish() 
        {
          new AlertDialog.Builder(context)
          .setTitle(GAME_END)
          .setMessage("Time is up! Your final score was: " + gameScore)
          .setPositiveButton(VIEW_BOARD, new DialogInterface.OnClickListener() 
          {
            public void onClick(DialogInterface dialog, int which) 
            { 
              activity.finish ();  
            }
          })
          .show();
        }
     }.start();
    }
  }

  /**
   * This is to be notified when when values are known or changed in the view
   * 
   * @param viewWidth the new view's width
   * 
   * @param viewHeight the new view's height
   * 
   * @param oldViewWidth the old view's width
   * 
   * @param oldViewHeight the old view's height
   */
  
  protected void onSizeChanged (int viewWidth, int viewHeight,
      int oldViewWidth, int oldViewHeight)
  {
    super.onSizeChanged (viewWidth, viewHeight, oldViewWidth, oldViewHeight);
  }

  /**
   * This draws the game background, the bird sprites, and the cross hair
   * 
   * @param canvas holds the draw calls
   */
  
  protected void onDraw (Canvas canvas)
  {  
    for (int i = 0; i < birdSpriteList.size (); i++)
    {
      if (birdSpriteList.get(i).getLeftCoordinate () + 
          birdSpriteList.get (i).getSpriteWidth () >= getWidth())
      {
        birdSpriteList.get(i).setY (0);
        birdSpriteList.get(i).setX (birdSpriteList.get(i).getTopCoordinate ());
      }     
      birdSpriteList.get(i).setY (birdSpriteList.get(i).getLeftCoordinate () + 
          birdSpriteList.get(i).getflightPattern ());
      birdSpriteList.get(i).doDraw (canvas);
    }
    
    setBackgroundResource(R.drawable.background);
    mCrosshair.doDraw (canvas);
        
    super.onDraw (canvas);
    invalidate ();
  }
  
  /**
   * This reads in the d-pad directions inputed by the user and moves the cross
   * hair accordingly. This also prevents the user from moving the cross hair
   * off the screen
   * 
   * @param keyCode holds the code corresponding to what button on the d-pad
   * the user pressed
   * 
   * @param event that the user pressed
   */
  
  public boolean onKeyDown (int keyCode, KeyEvent event)
  {
    final int rightMax = 854; 
    final int downMax = 480;
    switch (keyCode)
    {
      case KeyEvent.KEYCODE_DPAD_LEFT:
        if (ySpeed == CROSSHAIR_SPEED)
        {
          ySpeed *= -1;
        }
        if (mCrosshair.getLeftCoordinate () > 0)
        {
          mCrosshair.setY (mCrosshair.getLeftCoordinate () + ySpeed);
        }
        else
        {
          mCrosshair.setY (0);
        }
        break;
      case KeyEvent.KEYCODE_DPAD_RIGHT:
        if (ySpeed == -CROSSHAIR_SPEED)
        {
          ySpeed *= -1;
        }
        if (mCrosshair.getLeftCoordinate () < rightMax - 
            (int) mCrosshair.getSpriteWidth ())
        {
          mCrosshair.setY (mCrosshair.getLeftCoordinate () + ySpeed);
        }
        else
        {
          mCrosshair.setY ((rightMax - (int) mCrosshair.getSpriteWidth ()));
        }
        break;
      case KeyEvent.KEYCODE_DPAD_UP:
        if (xSpeed == CROSSHAIR_SPEED)
        {
          xSpeed *= -1;
        }
        if (mCrosshair.getTopCoordinate () > 0)
        {
          mCrosshair.setX (mCrosshair.getTopCoordinate () + xSpeed);
        }
        else
        {
          mCrosshair.setX (0);
        }
        break;
      case KeyEvent.KEYCODE_DPAD_DOWN:
        if (xSpeed == -CROSSHAIR_SPEED)
        {
          xSpeed *= -1;
        }
        if (mCrosshair.getTopCoordinate () < downMax - 
            (int) mCrosshair.getSpriteHeight ())
        {
          mCrosshair.setX (mCrosshair.getTopCoordinate () + xSpeed);
        }
        else
        {
          mCrosshair.setX ((downMax - (int) mCrosshair.getSpriteHeight ()));
        }
        break;
        
      case KeyEvent.KEYCODE_DPAD_CENTER:
        mp.start ();
        checkCollision ();        
    }
    return true;
  }
  
  /**
   * Generates a random x-coordinate used to place a sprite in a random place
   * within the screen
   */
  
  public void generateRandXCoord ()
  {
    final int RANDOM_COORD =  Sprite.getDisplayHeight() - 125;
    
    Random random = new Random ();
    
    randomXCoord = random.nextInt (RANDOM_COORD);
  }
  
  /**
   * Generates a random y-coordinate used to place a sprite in a random place
   * within the screen
   */
  
  public void generateRandYCoord ()
  {
    final int RANDOM_COORD = Sprite.getDisplayWidth();
    
    Random random = new Random ();
    
    randomYCoord = random.nextInt (RANDOM_COORD);
  } 
  
 /**
  * Checks to see if a collision has occurred between the cross hair sprite and
  * one of the many bird sprites. If so the birds health is decreased by one and
  * if it is out of health the bird sprite is removed. This then increments the
  * users score by how many points the bird was worth. If all birds are removed
  * the user has won  
  */
  
  public void checkCollision ()
  {
    final int SCORE_MULTIPLYER = 5;
    final int TEXT_SIZE = 20;
    final String WIN = "Congratulations!!! You win.";
    
    for (int i = 0; i < birdSpriteList.size (); i++)
    {
      int crossHairHitX = (mCrosshair.getLeftCoordinate () + 
          ((int) mCrosshair.getSpriteWidth () / CENTER_CROSS_LOCATION )); 
      int crossHairHitY = (mCrosshair.getTopCoordinate () + 
          ((int) mCrosshair.getSpriteHeight () /CENTER_CROSS_LOCATION )); 
      
      if (crossHairHitX >= birdSpriteList.get(i).getLeftCoordinate() &&
          crossHairHitX <= (birdSpriteList.get(i).getLeftCoordinate() 
              + birdSpriteList.get(i).getSpriteWidth ()) &&
          crossHairHitY >= birdSpriteList.get(i).getTopCoordinate() &&
          crossHairHitY <= (birdSpriteList.get(i).getTopCoordinate() 
                  + birdSpriteList.get(i).getSpriteHeight ()))
      {
        birdSpriteList.get (i).decreaseHealth (); 
        if (birdSpriteList.get (i).getStartHealth () == 0)
        {
          gameScore += (birdSpriteList.get (i).getScoreValue ()  
              * SCORE_MULTIPLYER);
          birdSpriteList.remove (i); 
          String score = Integer.toString(gameScore);
          scoreView.setTextSize (TEXT_SIZE);
          scoreView.setText("Game Score: " + score);
          if (birdSpriteList.size () == 0)
          {
            mp1.start (); 
            new AlertDialog.Builder(this.getContext ())
            .setTitle(GAME_END)
            .setMessage(WIN)
            .setPositiveButton(VIEW_BOARD, new DialogInterface.OnClickListener() 
            {
              public void onClick(DialogInterface dialog, int which) 
              { 
                
                activity.finish (); 
              }
            })
            .show();
          }
        }
      }
    }
  }
  public void setActivity(Activity myActivity)
  {
    activity = myActivity;
}
}
  
  