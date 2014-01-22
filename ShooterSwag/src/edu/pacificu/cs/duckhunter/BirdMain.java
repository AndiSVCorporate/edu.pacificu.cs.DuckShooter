package edu.pacificu.cs.duckhunter;

import android.content.Context;
import android.view.Display;

/**
* This implements the abstract bird class that all the specific different types
* of birds inherit from. This class inherits from sprite
*
* @author  Troy Zuroske, Pacific University
*/

public abstract class BirdMain extends Sprite
{
  /**
   * This creates a sprite of the general bird
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
  public BirdMain (Context context, Display display, int drawable,
      int topCoord, int leftCoord)
  {
    super (context, display, drawable, topCoord, leftCoord);
    // TODO Auto-generated constructor stub
  }

  /**
   * To be implemented by specific bird classes. Will return current health of
   * a specific bird
   * 
   * @return integer that holds the bird's health
   */
  
  abstract int getStartHealth ();
  
  /**
   * To be implemented by specific bird classes. Will decrease current health of
   * a bird
   */
  abstract void decreaseHealth ();
  
  /**
   * To be implemented by specific bird classes. Will return the value of 
   * killing one bird
   * 
   * @return integer that holds the bird's score if killed
   */
  
  abstract int getScoreValue (); 
  
  /**
   * To be implemented by specific bird classes. Will return the speed that bird 
   * moves
   * 
   * @return integer that holds the bird's speed
   */
  
  abstract int getflightPattern ();  
}
