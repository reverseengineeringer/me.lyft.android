package com.lyft.scoop;

import android.content.Context;
import android.content.ContextWrapper;

class Scoop$ScoopContextWrapper
  extends ContextWrapper
  implements Scoop.HaveScoop
{
  private final Scoop scoop;
  
  public Scoop$ScoopContextWrapper(Context paramContext, Scoop paramScoop)
  {
    super(paramContext);
    scoop = paramScoop;
  }
  
  public Scoop getScoop()
  {
    return scoop;
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.Scoop.ScoopContextWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */