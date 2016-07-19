package com.crashlytics.android.core.internal.models;

public class ThreadData
{
  public final FrameData[] frames;
  public final int importance;
  public final String name;
  
  public static final class FrameData
  {
    public final long address;
    public final String file;
    public final int importance;
    public final long offset;
    public final String symbol;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.internal.models.ThreadData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */