package edu.pacificu.cs.duckhunter;

import android.content.Context;
import android.view.Display;

public abstract class BirdMain extends Sprite
{
  public BirdMain (Context context, Display display, int drawable,
      int topCoord, int leftCoord)
  {
    super (context, display, drawable, topCoord, leftCoord);
    // TODO Auto-generated constructor stub
  }

  abstract int getHitCount ();
  
  //abstract void setHitCount ();
  
  abstract int getStartHealth ();
  
  //abstract void setStartHealth (); 
  
  //abstract int getflightPattern ();
  
  //abstract void setFlightPattern ();

  void setHitCount (int hitCount)
  {
    // TODO Auto-generated method stub
    
  }

  void setHealth (int startHealth)
  {
    // TODO Auto-generated method stub
    
  }

  int getflightPattern ()
  {
    // TODO Auto-generated method stub
    return 0;
  } 
   
  
}
