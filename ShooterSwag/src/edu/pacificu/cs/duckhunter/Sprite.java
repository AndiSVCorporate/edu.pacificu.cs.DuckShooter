package edu.pacificu.cs.duckhunter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.Display;
import android.widget.ImageView;

/**
 * This is the sprite class where every sprite created in the main game play
 * uses its functionality and methods
 * 
 * @author  Troy Zuroske, Pacific University
 */
@SuppressLint ("ViewConstructor")
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
  
  /**
   * This creates a new sprite for the game play
   * 
   * @param context The interface to the application environment
   * 
   * @param display provides information about the size and density of a 
   * logical display
   * 
   * @param drawable the image for the sprite
   * 
   * @param topCoord the topCoordinate of the sprite created
   * 
   * @param leftCoord the leftCoordiante of the sprite created
   */
  
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
  
  /**
   * Draw the bitmap of the image of the sprite
   * 
   * @param canvas holds the draw calls
   */
  
  public void doDraw (Canvas canvas )
  {
    canvas.drawBitmap (mImage, (this.mLeftCoordinate), 
                                      this.mTopCoordinate, null);
  }
  
  /**
   * Return the image of the sprite
   * 
   * @return mImage the image of the sprite
   */
  
  public Bitmap getBitmap ()
  {
    return mImage;
  }
  
  /**
   * Return the recourse ID
   * 
   * @return integer that holds the recourse ID
   */
  
  public int getResID ()
  {
    return this.mResID;
  }
  
  /**
   * Returns the top coordinate of the sprite
   * 
   * @return integer that holds the top coordinate of the sprite
   */
  
  public int getTopCoordinate ()
  {
    return mTopCoordinate;
  }
  
  /**
   * Returns the left coordinate of the sprite
   * 
   * @return integer that holds the left coordinate of the sprite
   */
  
  public int getLeftCoordinate ()
  {
    return mLeftCoordinate;
  }
  
  /**
   * Returns the number of sprites created
   * 
   * @return integer that holds the number of sprites
   */
  
  public int getCount ()
  {
    return mCount;
  }
  
  /**
   * Returns the width of the sprite
   * 
   * @return integer that holds the width of the sprite
   */
  
  public int getSpriteWidth ()
  {
    return mWidth;
  }
  
  /**
   *Returns the height of the sprite
   * 
   * @return integer that holds the height of the sprite
   */
  
  public int getSpriteHeight ()
  {
    return mHeight;
  }
  
  /**
   * Returns the display height
   * 
   * @return integer that holds the display height
   */
  
  @SuppressWarnings ("deprecation")
  public static int getDisplayHeight()
  {
    return mDisplay.getHeight ();
  }
  
  /**
   * Returns the display width
   * 
   * @return integer that holds the display width
   */
  
  @SuppressWarnings ("deprecation")
  public static int getDisplayWidth ()
  {
    return mDisplay.getWidth ();
  }
  
  /**
   * Sets the new top coordinate of the sprite with the value passed in
   * 
   * @param newX the x coordinate to set the top coordinate too 
   */
  
  public void setX (int newX)
  {
    mTopCoordinate = newX;
  }
  
  /**
   * Sets the new left coordinate of the sprite with the value passed in
   * 
   * @param newY the y coordinate to set the left coordinate too 
   */
  
  public void setY (int newY)
  {
    mLeftCoordinate = newY;
  }  

  
}
