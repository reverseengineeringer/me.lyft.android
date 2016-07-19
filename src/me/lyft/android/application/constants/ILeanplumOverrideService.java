package me.lyft.android.application.constants;

import rx.Observable;

public abstract interface ILeanplumOverrideService
{
  public abstract boolean isLeanplumEnabled();
  
  public abstract Observable<Boolean> observeLeanplumOverride();
  
  public abstract void setLeanplumEnabled(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.constants.ILeanplumOverrideService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */