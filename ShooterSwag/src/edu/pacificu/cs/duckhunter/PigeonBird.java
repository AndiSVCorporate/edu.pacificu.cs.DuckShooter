package edu.pacificu.cs.duckhunter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.Display;

public class PigeonBird extends BirdMain
{
  private final int startHealth = 1; 
  protected Bitmap mBitmapImage;
  protected Display mDisplay;
  private int mHitCount;
  private int mStartHealth;
  private int mFlightPattern; 
  private int birdImage; 
  protected int mTopCoordinate;
  protected int mLeftCoordinate;
  private int mWidth;
  private int mHeight;
  private static int mCount = 0;
  
  public PigeonBird (Context context, Display display, int drawable, 
      int topCoord, int leftCoord)
  {
    mHitCount = startHealth;
    mStartHealth = startHealth;
  }

  public void setX (int newX)
  {
  mTopCoordinate = newX;
  }
  
  public void setY (int newY)
  {
  mLeftCoordinate = newY;
  }  
  
  @Override
  public void hitCount ()
  {
    mHitCount = startHealth;
  }

  @Override
  public int startHealth ()
  {
    mStartHealth = startHealth;
  }

  @Override
  public void flightPattern ()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  /*public int birdImage ()
  {
    
    
  }*/
  
  public int getmHitCount ()
  {
    return mHitCount;
  }

  public void setmHitCount (int mHitCount)
  {
    this.mHitCount = mHitCount;
  }

  public int getmStartHealth ()
  {
    return mStartHealth;
  }

  public void setmStartHealth (int mStartHealth)
  {
    this.mStartHealth = mStartHealth;
  }

  public int getmFlightPattern ()
  {
    return mFlightPattern;
  }

  public void setmFlightPattern (int mFlightPattern)
  {
    this.mFlightPattern = mFlightPattern;
  }
  
  public  void doDraw (Canvas canvas ) // Draw Bitmap
  {
    canvas.drawBitmap (mBitmapImage, (this.mLeftCoordinate), 
                                      this.mTopCoordinate, null);
  }
  
  public Bitmap getBitmap ()
  {
    return mBitmapImage;
  }
  
  public int getTopCoordinate ()
  {
    return mTopCoordinate;
  }
  
  /*public void setTopCoordinate (int topCoordinate)
  {
    mTopCoordinate = topCoordinate;
  }*/

  public int getLeftCoordinate ()
  {
    return mLeftCoordinate;
  }
  
  /*public void setLeftCoordinate (int leftCoordinate)
  {
    mLeftCoordinate = leftCoordinate;
  }*/
  
  public int getCount ()
  {
    return mCount;
  }
  
  public int getSpriteWidth ()
  {
    return mWidth;
  }
  
  public int getSpriteHeight ()
  {
    return mHeight;
  }
  
  public int getDisplayHeight()
  {
    return mDisplay.getHeight ();
  }
  
  public int getDisplayWidth ()
  {
    return mDisplay.getWidth ();
  }
}

