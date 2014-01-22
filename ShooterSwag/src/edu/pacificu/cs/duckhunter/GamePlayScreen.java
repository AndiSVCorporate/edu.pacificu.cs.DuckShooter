package edu.pacificu.cs.duckhunter;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class GamePlayScreen extends View
{
  private final int EASY = 0;
  private final int MEDIUM = 1;
  private final int HARD = 2;
  private final int CROSSHAIR_SPEED = 15;
  private final int NUMBER_OF_PIGEONS = 5;
  private final int NUMBER_OF_CROWS = 5;
  int randomXCoord;
  int randomYCoord;
  
  Sprite mCrosshair;
  BirdMain oneBird;
  
  TextView textic;
  
  //private GameLoopThread gameLoopThread;
  private ArrayList<BirdMain> birdSpriteList; 
  //private List<tempSprite> temps = new ArrayList<tempSprite>();
  

  int xSpeed = -CROSSHAIR_SPEED;
  int ySpeed = -CROSSHAIR_SPEED;
  
  MediaPlayer mp = MediaPlayer.create (getContext (), R.raw.gunshot2);

  public GamePlayScreen (final Context context, int difficultyLevel, Display display)
  {
    super (context);
    setFocusable (true);
    setFocusableInTouchMode (true);
    
    mCrosshair = new Sprite (context, display, R.drawable.crosshairs,
        getHeight () / 2, getWidth () / 2);
    
    generateRandXCoord ();
    generateRandYCoord (); 
    
    oneBird = new EagleBird (context, display, R.drawable.eagle, randomXCoord, 
        randomYCoord);

    if (difficultyLevel == EASY)
    {
      for (int i = 0; i < NUMBER_OF_PIGEONS; i++)
      {
        birdSpriteList = new ArrayList<BirdMain> (); 
        generateRandXCoord ();
        generateRandYCoord (); 
        BirdMain tempObj = new PigeonBird (context, display, R.drawable.eagle, 
            randomXCoord, randomYCoord);
        birdSpriteList.add (tempObj); 
      }
      for (int i = 0; i < NUMBER_OF_CROWS; i++)
      {
        BirdMain tempObj = new PigeonBird (context, display, R.drawable.eagle, 
            randomXCoord, randomYCoord);
        birdSpriteList.add (tempObj); 
      }
      
    }
    else if (difficultyLevel == MEDIUM)
    {

    }
    else if (difficultyLevel == HARD)
    {

    }
  }

  protected void onSizeChanged (int viewWidth, int viewHeight,
      int oldViewWidth, int oldViewHeight)
  {
    super.onSizeChanged (viewWidth, viewHeight, oldViewWidth, oldViewHeight);
  }

  protected void onDraw (Canvas canvas)
  {  
    for (int i = 0; i < birdSpriteList.size (); i++)
    {
      if (birdSpriteList.get(i).getLeftCoordinate () + 
          birdSpriteList.get (i).getSpriteWidth () >= getWidth())
      {
        //oneBird.setY (oneBird.getY ());
        birdSpriteList.get(i).setY (0);
        birdSpriteList.get(i).setX ( birdSpriteList.get(i).getTopCoordinate ());
      }
      
      if (oneBird.getTopCoordinate () + oneBird.getSpriteHeight () <= 0)
      {
        
      }
      //birdSpriteList.get(i).setY (birdSpriteList.get(i).getLeftCoordinate () + birdSpriteList.get(i)).
    }
    setBackgroundResource(R.drawable.background);
    
    mCrosshair.doDraw (canvas);
    
    oneBird.doDraw (canvas);

    super.onDraw (canvas);

    invalidate ();
  }
  
  public boolean onKeyDown (int keyCode, KeyEvent event)
  {
    switch (keyCode)
    {
      case KeyEvent.KEYCODE_DPAD_LEFT:
        if (ySpeed == CROSSHAIR_SPEED)
        {
          ySpeed *= -1;
        }
        mCrosshair.setY (mCrosshair.getLeftCoordinate () + ySpeed);
        break;
      case KeyEvent.KEYCODE_DPAD_RIGHT:
        if (ySpeed == -CROSSHAIR_SPEED)
        {
          ySpeed *= -1;
        }
        mCrosshair.setY (mCrosshair.getLeftCoordinate () + ySpeed);
        break;
      case KeyEvent.KEYCODE_DPAD_UP:
        if (xSpeed == CROSSHAIR_SPEED)
        {
          xSpeed *= -1;
        }
        mCrosshair.setX (mCrosshair.getTopCoordinate () + xSpeed);
        break;
      case KeyEvent.KEYCODE_DPAD_DOWN:
        if (xSpeed == -CROSSHAIR_SPEED)
        {
          xSpeed *= -1;
        }
        mCrosshair.setX (mCrosshair.getTopCoordinate () + xSpeed);
        break;
      case KeyEvent.KEYCODE_DPAD_CENTER:
        mp.start ();

    }
    return true;
  }
  
  public void generateRandXCoord ()
  {
    final int RANDOM_COORD =  Sprite.getDisplayHeight();
    
    Random random = new Random ();
    
    randomXCoord = random.nextInt (RANDOM_COORD);
  }
  
  public void generateRandYCoord ()
  {
    final int RANDOM_COORD = Sprite.getDisplayWidth();;
    
    Random random = new Random ();
    
    randomYCoord = random.nextInt (RANDOM_COORD);
  }
  
}