package edu.pacificu.cs.duckhunter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;

public class EagleBird extends BirdMain
{
  private final int START_HEALTH = 2; 
  protected Bitmap mBitmapImage;
  protected Display mDisplay;
  private int mHitCount;
  private int mCurrentHealth;
  private int mFlightPattern; 
  private int birdImage; 
  protected int mTopCoordinate;
  protected int mLeftCoordinate;
  private int mWidth;
  private int mHeight; 
  
  public EagleBird (Context context, Display display, int drawable, 
      int topCoord, int leftCoord)
  {
    mCurrentHealth = START_HEALTH;
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
  void setStartHealth (int startHealth)
  {
    mCurrentHealth = startHealth; 
  }

  /*@Override
  int getflightPattern ()
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  void setFlightPattern ()
  {
    // TODO Auto-generated method stub
    
  }*/

}
