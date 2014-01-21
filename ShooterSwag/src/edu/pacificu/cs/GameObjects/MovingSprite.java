package edu.pacificu.cs.GameObjects;

import android.content.Context;
import android.view.Display;

public class MovingSprite extends FixedSprite
{
  public MovingSprite (Context context, 
                       Display display, 
                       int drawable, 
                       int topCoord, 
                       int leftCoord)
  {
    super (context, display, drawable, topCoord, leftCoord);
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
