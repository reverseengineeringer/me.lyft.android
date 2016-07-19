package me.lyft.android.infrastructure.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import me.lyft.android.analytics.studies.VerificationSmsAnalytics;
import me.lyft.android.logging.L;
import rx.functions.Action1;

class VerificationAutoFillService$SmsBroadcastReceiver
  extends BroadcastReceiver
{
  private String phoneNumber;
  private Action1<String> smsCallback;
  private final VerificationCodeSmsParser smsParser;
  private VerificationSmsAnalytics verificationSmsAnalytics;
  
  public VerificationAutoFillService$SmsBroadcastReceiver(String paramString, VerificationSmsAnalytics paramVerificationSmsAnalytics, Action1<String> paramAction1)
  {
    phoneNumber = paramString;
    verificationSmsAnalytics = paramVerificationSmsAnalytics;
    smsCallback = paramAction1;
    smsParser = new VerificationCodeSmsParser();
  }
  
  private void trackSmsRecieved(String paramString1, String paramString2)
  {
    verificationSmsAnalytics.verifySmsReceived(paramString1, paramString2);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getExtras();
    if (paramContext != null) {}
    try
    {
      paramContext = (Object[])paramContext.get("pdus");
      int j = paramContext.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          paramIntent = SmsMessage.createFromPdu((byte[])paramContext[i]);
          String str = smsParser.extractCode(paramIntent.getDisplayMessageBody());
          if (str == null) {
            break label96;
          }
          if (smsCallback != null)
          {
            trackSmsRecieved(paramIntent.getOriginatingAddress(), phoneNumber);
            smsCallback.call(str);
          }
        }
        return;
        label96:
        i += 1;
      }
      return;
    }
    catch (Exception paramContext)
    {
      L.w(paramContext, "failed to parse verification sms", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.sms.VerificationAutoFillService.SmsBroadcastReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */