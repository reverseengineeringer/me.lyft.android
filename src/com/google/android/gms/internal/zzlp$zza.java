package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

@zzir
public class zzlp$zza
  extends MutableContextWrapper
{
  private Context zzaqj;
  private Activity zzcmz;
  private Context zzcqa;
  
  public zzlp$zza(Context paramContext)
  {
    super(paramContext);
    setBaseContext(paramContext);
  }
  
  public Object getSystemService(String paramString)
  {
    return zzcqa.getSystemService(paramString);
  }
  
  public void setBaseContext(Context paramContext)
  {
    zzaqj = paramContext.getApplicationContext();
    if ((paramContext instanceof Activity)) {}
    for (Activity localActivity = (Activity)paramContext;; localActivity = null)
    {
      zzcmz = localActivity;
      zzcqa = paramContext;
      super.setBaseContext(zzaqj);
      return;
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (zzcmz != null)
    {
      zzcmz.startActivity(paramIntent);
      return;
    }
    paramIntent.setFlags(268435456);
    zzaqj.startActivity(paramIntent);
  }
  
  public Activity zzuf()
  {
    return zzcmz;
  }
  
  public Context zzug()
  {
    return zzcqa;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlp.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */