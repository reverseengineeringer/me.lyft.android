package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException
  extends UserRecoverableException
{
  private final int cs;
  
  GooglePlayServicesRepairableException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    cs = paramInt;
  }
  
  public int getConnectionStatusCode()
  {
    return cs;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesRepairableException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */