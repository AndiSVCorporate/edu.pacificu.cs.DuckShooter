package edu.pacificu.cs.GameObjects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.Display;
import android.widget.ImageView;

public class FixedSprite extends ImageView
{
  protected Bitmap mBitmapImage;
  protected Display mDisplay;
  private int mResID;
  protected int mTopCoordinate;
  protected int mLeftCoordinate;
  private int mWidth;
  private int mHeight;
  private static int mCount = 0;

  public FixedSprite ( Context context, 
                       Display display, 
                       int drawable, 
                       int topCoord, 
                       int leftCoord)
  {
    super (context);
       
    BitmapFactory.Options opts = new BitmapFactory.Options ();
    opts.inJustDecodeBounds = true;
    mBitmapImage = BitmapFactory.decodeResource (context.getResources (), 
                                                  drawable);

    mDisplay = display;
    mTopCoordinate = topCoord;
    mLeftCoordinate = leftCoord;
    mWidth = mBitmapImage.getWidth();
    mHeight = mBitmapImage.getHeight();
    mResID = drawable;
    ++mCount;
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
  
  public int getDisplayHeight()
  {
    return mDisplay.getHeight ();
  }
  
  public int getDisplayWidth ()
  {
    return mDisplay.getWidth ();
  }
}
