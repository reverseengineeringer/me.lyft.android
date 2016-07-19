package me.lyft.android.utils;

import android.content.Intent;

public final class ActivityResult
{
  private Intent data;
  private int requestCode;
  private int resultCode;
  
  private ActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    requestCode = paramInt1;
    resultCode = paramInt2;
    data = paramIntent;
  }
  
  public static ActivityResult create(int paramInt1, int paramInt2, Intent paramIntent)
  {
    return new ActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public Intent getIntent()
  {
    return data;
  }
  
  public int getRequestCode()
  {
    return requestCode;
  }
  
  public int getResultCode()
  {
    return resultCode;
  }
  
  public String toString()
  {
    return "ActivityResult{requestCode=" + requestCode + ", resultCode=" + resultCode + ", data=" + data + '}';
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.utils.ActivityResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */