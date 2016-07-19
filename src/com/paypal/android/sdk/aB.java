package com.paypal.android.sdk;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ab
  extends Handler
{
  ab(aa paramaa) {}
  
  public final void handleMessage(Message paramMessage)
  {
    try
    {
      switch (what)
      {
      case 12: 
        paramMessage = (W)obj;
        if (paramMessage == null) {
          break label423;
        }
        aa.a(a, paramMessage);
        return;
      }
    }
    catch (Exception paramMessage)
    {
      ao.a("RiskComponent", null, paramMessage);
      return;
    }
    paramMessage = (String)obj;
    new StringBuilder("LogRiskMetadataRequest Server returned: ").append(paramMessage);
    paramMessage = Uri.parse("?" + paramMessage);
    try
    {
      paramMessage = paramMessage.getQueryParameter("responseEnvelope.ack");
      Map.Entry localEntry1;
      int i;
      Iterator localIterator2;
      if ("Success".equals(paramMessage))
      {
        paramMessage = new HashMap(aa.a(a));
        Iterator localIterator1 = aa.a(a).entrySet().iterator();
        if (localIterator1.hasNext())
        {
          localEntry1 = (Map.Entry)localIterator1.next();
          i = 0;
          localIterator2 = aa.b(a).entrySet().iterator();
        }
      }
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
          if (!((String)localEntry2.getKey()).equals(localEntry1.getKey())) {
            break label435;
          }
          if (localEntry2.getValue() == null) {
            if (localEntry1.getValue() != null) {
              break label435;
            }
          } else if (!localEntry2.getValue().equals(localEntry1.getValue())) {
            break label435;
          }
        }
        else
        {
          if (i == 0) {
            break;
          }
          paramMessage.remove(localEntry1.getKey());
          break;
          aa.a(a, paramMessage);
          aa.a(a, aa.c(a));
          aa.b(a, null);
          return;
          Log.e("RiskComponent", "LoadConfigurationRequest failed.");
          return;
          Log.e("RiskComponent", "LogRiskMetadataRequest failed.");
          return;
          Log.e("RiskComponent", "BeaconRequest failed.");
          return;
          label423:
          return;
        }
        i = 1;
      }
    }
    catch (UnsupportedOperationException paramMessage)
    {
      label435:
      for (;;)
      {
        paramMessage = null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.ab
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */