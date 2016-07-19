package com.paypal.android.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

public final class aj
  extends al
{
  private Context a;
  private String b;
  private Handler c;
  
  public aj(Context paramContext, String paramString, Handler paramHandler)
  {
    a = paramContext;
    b = paramString;
    c = paramHandler;
  }
  
  public final void run()
  {
    if (c == null) {
      return;
    }
    try
    {
      c.sendMessage(Message.obtain(c, 10, b));
      W localW = new W(a, b);
      c.sendMessage(Message.obtain(c, 12, localW));
      return;
    }
    catch (Exception localException)
    {
      c.sendMessage(Message.obtain(c, 11, localException));
      return;
    }
    finally
    {
      an.a().b(this);
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.aj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */