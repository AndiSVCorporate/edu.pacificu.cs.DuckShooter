package edu.pacificu.cs.duckhunter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.Display;
import android.widget.ImageView;

public class Sprite extends ImageView
{
  protected Bitmap mImage;
  protected static Display mDisplay;
  private int mResID;
  protected int mTopCoordinate;
  protected int mLeftCoordinate;
  private int mWidth;
  private int mHeight;
  private static int mCount = 0;
  
  public Sprite (Context context, Display display, int drawable, int topCoord, 
      int leftCoord)
  {
    super (context);
    
    BitmapFactory.Options opts = new BitmapFactory.Options ();
    opts.inJustDecodeBounds = true;
    mImage = BitmapFactory.decodeResource (context.getResources (), 
                                                  drawable);

    mDisplay = display;
    mTopCoordinate = topCoord;
    mLeftCoordinate = leftCoord;
    mWidth = mImage.getWidth();
    mHeight = mImage.getHeight();
    mResID = drawable;
    ++mCount;
  }
  
  public  void doDraw (Canvas canvas ) // Draw Bitmap
  {
    canvas.drawBitmap (mImage, (this.mLeftCoordinate), 
                                      this.mTopCoordinate, null);
  }
  
  public Bitmap getBitmap ()
  {
    return mImage;
  }
  
  /*public void setBitmap (Bitmap bitmapImage)
  {
    mBitmapImage = bitmapImage;
  }*/
  
  public int getResID ()
  {
    return this.mResID;
  }
  
  /*public void setResID (int resID)
  {
    mResID = resID;
  }*/
  
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
  
  @SuppressWarnings ("deprecation")
  public static int getDisplayHeight()
  {
    return mDisplay.getHeight ();
  }
  
  @SuppressWarnings ("deprecation")
  public static int getDisplayWidth ()
  {
    return mDisplay.getWidth ();
  }
  
  public void setX (int newX)
  {
    mTopCoordinate = newX;
  }
  
  public void setY (int newY)
  {
    mLeftCoordinate = newY;
  }  
}
