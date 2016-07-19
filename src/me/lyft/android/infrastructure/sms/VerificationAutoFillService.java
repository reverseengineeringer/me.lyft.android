package me.lyft.android.infrastructure.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import me.lyft.android.analytics.studies.VerificationSmsAnalytics;
import me.lyft.android.logging.L;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

public class VerificationAutoFillService
  implements IVerificationAutoFillService
{
  public static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";
  private String phoneNumber;
  private VerificationSmsAnalytics verificationSmsAnalytics;
  
  public VerificationAutoFillService(VerificationSmsAnalytics paramVerificationSmsAnalytics)
  {
    verificationSmsAnalytics = paramVerificationSmsAnalytics;
  }
  
  public Observable<String> observeCode(final Context paramContext)
  {
    Observable.create(new Observable.OnSubscribe()
    {
      public void call(final Subscriber<? super String> paramAnonymousSubscriber)
      {
        final VerificationAutoFillService.SmsBroadcastReceiver localSmsBroadcastReceiver = new VerificationAutoFillService.SmsBroadcastReceiver(phoneNumber, verificationSmsAnalytics, new Action1()
        {
          public void call(String paramAnonymous2String)
          {
            paramAnonymousSubscriber.onNext(paramAnonymous2String);
          }
        });
        paramAnonymousSubscriber.add(Subscriptions.create(new Action0()
        {
          public void call()
          {
            val$context.unregisterReceiver(localSmsBroadcastReceiver);
          }
        }));
        paramAnonymousSubscriber = new IntentFilter();
        paramAnonymousSubscriber.addAction("android.provider.Telephony.SMS_RECEIVED");
        paramContext.registerReceiver(localSmsBroadcastReceiver, paramAnonymousSubscriber);
      }
    });
  }
  
  public void setPhoneNumber(String paramString)
  {
    phoneNumber = paramString;
  }
  
  private static class SmsBroadcastReceiver
    extends BroadcastReceiver
  {
    private String phoneNumber;
    private Action1<String> smsCallback;
    private final VerificationCodeSmsParser smsParser;
    private VerificationSmsAnalytics verificationSmsAnalytics;
    
    public SmsBroadcastReceiver(String paramString, VerificationSmsAnalytics paramVerificationSmsAnalytics, Action1<String> paramAction1)
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
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.sms.VerificationAutoFillService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */