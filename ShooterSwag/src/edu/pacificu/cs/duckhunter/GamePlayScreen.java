package edu.pacificu.cs.duckhunter;

import edu.pacificu.cs.GameObjects.FixedSprite;
import edu.pacificu.cs.GameObjects.MovingSprite;
import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

public class GamePlayScreen extends View
{
  private final int EASY = 0;
  private final int MEDIUM = 1;
  private final int HARD = 2;
  FixedSprite mFixedSprite;
  PigeonBird birdOne;
  PigeonBird birdTwo;
  PigeonBird birdThree;

  int pigeonSpeedX = -5;
  int pigeonSpeedY = -5;
  MediaPlayer mp = MediaPlayer.create (getContext (), R.raw.gunshot2); 

  public GamePlayScreen (Context context, int difficultyLevel, Display display)
  {
    super (context);   
    setFocusable (true);
    setFocusableInTouchMode (true); 
    if (difficultyLevel == EASY)
    {
      birdOne = new PigeonBird (context, display, R.drawable.ball_yellow, 
          75, 50);
      birdTwo = new PigeonBird (context, display, R.drawable.ball_green,
          60, 60);
      birdThree = new PigeonBird (context, display, R.drawable.ball_blue,
          50, 50);   
    }
    else if (difficultyLevel == MEDIUM)
    {
      birdOne = new PigeonBird (context, display, R.drawable.ball_yellow, 
          75, 50);
      birdTwo = new PigeonBird (context, display, R.drawable.ball_green,
          60, 60);
      birdThree = new PigeonBird (context, display, R.drawable.ball_blue,
          50, 50);   
    }
    else if (difficultyLevel == HARD)
    {
      birdOne = new PigeonBird (context, display, R.drawable.ball_yellow, 
          75, 50);
      birdTwo = new PigeonBird (context, display, R.drawable.ball_green,
          60, 60);
      birdThree = new PigeonBird (context, display, R.drawable.ball_blue,
          50, 50);   
    }
    
   
    
    
  }


  
  protected void onSizeChanged (int viewWidth, int viewHeight, int oldViewWidth,
      int oldViewHeight)
  {
    
    
    super.onSizeChanged (viewWidth, viewHeight, oldViewWidth, oldViewHeight);
  } 
  
  
  protected void onDraw (Canvas canvas)
  {
    birdOne.setX (birdOne.getTopCoordinate () + pigeonSpeedX);
    birdOne.setY (birdOne.getLeftCoordinate () + pigeonSpeedY);

    if ((birdOne.getTopCoordinate () + birdOne.getSpriteHeight ()) >= getHeight ())
    {
      pigeonSpeedX *= -1;
    }

    if ((birdOne.getLeftCoordinate () + birdOne.getSpriteWidth ()) >= getWidth ())
    {
      pigeonSpeedY *= -1;
    }

    if (birdOne.getTopCoordinate () <= 0)
    {
      pigeonSpeedX *= -1;
    }

    if (birdOne.getLeftCoordinate () <= 0)
    {
      pigeonSpeedY *= -1;
    }

    birdOne.doDraw (canvas);
    

    super.onDraw (canvas);

    invalidate ();
    
    
  }
  
  public boolean onTouchEvent (MotionEvent event)
  {
   mp.start (); 
    
    
    
    return true; 
  }
  
  
}
