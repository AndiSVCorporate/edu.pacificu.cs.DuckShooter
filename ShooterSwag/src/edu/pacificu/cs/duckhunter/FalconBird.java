package edu.pacificu.cs.duckhunter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;

/**
* This implements the bird class of the falcon. The falcon is the second hardest 
* to kill as it has starting health of three. This bird is only available when a 
* difficulty of medium or hard is selected by the user. This class inherits from 
* the abstract class BirdMain
*
* @author  Troy Zuroske, Pacific University
*/

@SuppressLint ("ViewConstructor")
public class FalconBird extends BirdMain
{
  private final int START_HEALTH = 3; 
  private final int BIRD_SPEED = 10;
  private final int SCORE_VALUE = 3;
  protected Bitmap mBitmapImage;
  protected Display mDisplay;
  private int mCurrentHealth;
  protected int mTopCoordinate;
  protected int mLeftCoordinate;
  private int mBirdSpeed; 
  
  /**
   * This creates a sprite specifically of the bird type: falcon which has a 
   * start health of three and and bird speed movement of ten.
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
  
  public FalconBird (Context context, Display display, int drawable, 
      int topCoord, int leftCoord)
  {
    super (context, display, drawable, topCoord, leftCoord);
    mCurrentHealth = START_HEALTH;
    mBirdSpeed = BIRD_SPEED;
  }

  /**
   * Returns the amount of points this bird is worth when get killed
   * 
   * @return integer that holds the score value of the bird: falcon
   */
   
   @Override
   int getScoreValue ()
   {
     return SCORE_VALUE; 
   }

   /**
    * Returns the current health of the bird
    * 
    * @return integer that holds the current health of the bird
    */
   
   @Override
   int getStartHealth ()
   {
     return mCurrentHealth; 
   }

   /**
    * Returns the flight speed of the bird, for falcons it is ten
    * 
    * @return integer that holds the bird's speed
    */
   
   @Override
   int getflightPattern ()
   {
     return mBirdSpeed;
   }
   
   /**
    * Decreases the health of the bird that was shot by one point
    */
   
   @Override
   void decreaseHealth ()
   {
     mCurrentHealth--; 
   } 
 }
