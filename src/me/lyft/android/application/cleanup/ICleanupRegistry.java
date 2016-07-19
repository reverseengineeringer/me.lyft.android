package me.lyft.android.application.cleanup;

public abstract interface ICleanupRegistry
{
  public abstract void add(ICleanable paramICleanable);
  
  public abstract void clearAll();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.cleanup.ICleanupRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */