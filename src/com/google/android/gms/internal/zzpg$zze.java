package com.google.android.gms.internal;

final class zzpg$zze
{
  private int mSize = 0;
  
  public void zzamz()
  {
    try
    {
      mSize += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void zzana()
  {
    try
    {
      if (mSize == 0) {
        throw new RuntimeException("too many decrements");
      }
    }
    finally {}
    mSize -= 1;
    if (mSize == 0) {
      notifyAll();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpg.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */