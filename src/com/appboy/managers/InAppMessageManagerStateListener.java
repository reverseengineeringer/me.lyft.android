package com.appboy.managers;

import android.content.Context;
import bo.app.bd;
import bo.app.ft;
import com.appboy.Appboy;
import com.appboy.AppboyUser;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import java.util.concurrent.atomic.AtomicBoolean;

public class InAppMessageManagerStateListener
{
  private static final String b = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, InAppMessageManagerStateListener.class.getName() });
  private static volatile InAppMessageManagerStateListener c;
  public AtomicBoolean a = new AtomicBoolean(false);
  private bd d;
  private ft e;
  private String f;
  
  public static InAppMessageManagerStateListener getInstance()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new InAppMessageManagerStateListener();
      }
      return c;
    }
    finally {}
  }
  
  public final void a(ft paramft, String paramString, bd parambd)
  {
    try
    {
      e = paramft;
      f = paramString;
      d = parambd;
      return;
    }
    finally
    {
      paramft = finally;
      throw paramft;
    }
  }
  
  public void notifyInAppMessageManagerRegistered(Context paramContext)
  {
    try
    {
      String str = b;
      a.set(true);
      if ((Appboy.getInstance(paramContext).getCurrentUser().getUserId().equals(f)) && (e != null) && (d != null))
      {
        AppboyLogger.i(b, "In-app message manager was registered. Triggering in-app message.");
        e.a(paramContext, d);
      }
      f = null;
      e = null;
      return;
    }
    finally {}
  }
  
  public void notifyInAppMessageManagerUnregistered(Context paramContext)
  {
    paramContext = b;
    a.set(false);
  }
}

/* Location:
 * Qualified Name:     com.appboy.managers.InAppMessageManagerStateListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */