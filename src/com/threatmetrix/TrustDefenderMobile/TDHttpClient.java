package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import java.util.concurrent.Executor;

abstract interface TDHttpClient
{
  public abstract void finit(Executor paramExecutor);
  
  public abstract TDURLConnection getURLConnection(CancelState paramCancelState);
  
  public abstract void init(Context paramContext, int paramInt, String paramString, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.TDHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */