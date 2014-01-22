package edu.pacificu.cs.duckhunter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;

public class FalconBird extends BirdMain
{
  private final int START_HEALTH = 3; 
  private final int BIRD_SPEED = 15;
  protected Bitmap mBitmapImage;
  protected Display mDisplay;
  private int mHitCount;
  private int mCurrentHealth;
  protected int mTopCoordinate;
  protected int mLeftCoordinate;
  private int mBirdSpeed; 
  
  public FalconBird (Context context, Display display, int drawable, 
      int topCoord, int leftCoord)
  {
    super (context, display, drawable, topCoord, leftCoord);
    mCurrentHealth = START_HEALTH;
    mBirdSpeed = BIRD_SPEED;
  }

  @Override
  int getHitCount ()
  {
    return mHitCount; 
  }

  @Override
  void setHitCount (int hitCount)
  {
    mHitCount = hitCount;     
  }

  @Override
  int getStartHealth ()
  {
    return mCurrentHealth; 
  }

  @Override
  void setHealth (int startHealth)
  {
    mCurrentHealth = startHealth; 
  }

  @Override
  int getflightPattern ()
  {
    return mBirdSpeed;
  }
  
}
