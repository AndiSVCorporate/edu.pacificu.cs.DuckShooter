package edu.pacificu.cs.duckhunter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;

/**
* This implements the bird class of the Pigeon. The pigeon is the easiest to 
* kill as it has the lowest starting health of all the birds. This class 
* inherits from the abstract class BirdMain
*
* @author  Troy Zuroske, Pacific University
*/

@SuppressLint ("ViewConstructor")
public class PigeonBird extends BirdMain
{
  private final int START_HEALTH = 1; 
  private final int BIRD_SPEED = 2;
  private final int SCORE_VALUE = 2;
  protected Bitmap mBitmapImage;
  protected Display mDisplay;
  private int mCurrentHealth;
  protected int mTopCoordinate;
  protected int mLeftCoordinate;
  private int mBirdSpeed; 

  /**
   * This creates a sprite specifically of the bird type: pigeon which has a 
   * start health of one and and bird speed movement of twp.
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
  
  public PigeonBird (Context context, Display display, int drawable, 
      int topCoord, int leftCoord)
  {
    super (context, display, drawable, topCoord, leftCoord);
    mCurrentHealth = START_HEALTH;
    mBirdSpeed = BIRD_SPEED;
  }

  /**
   * Returns the amount of points this bird is worth when get killed
   * 
   * @return integer that holds the score value of the bird: pigeon
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
   * Returns the flight speed of the bird, for pigeons it is two
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

