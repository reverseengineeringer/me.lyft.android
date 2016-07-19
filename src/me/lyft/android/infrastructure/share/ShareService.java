package me.lyft.android.infrastructure.share;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;

public class ShareService
  implements IShareService
{
  private static final String SMS_SENT_INTENT = "SMS_SENT";
  private static final String TEXT_PLAIN = "text/plain";
  private final Context context;
  
  public ShareService(Context paramContext)
  {
    context = paramContext;
  }
  
  public void openSmsComposer(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.fromParts("sms", paramString, null));
    paramString.addFlags(268435456);
    context.startActivity(paramString);
  }
  
  public void sendSms(String paramString1, String paramString2)
  {
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(context, 0, new Intent("SMS_SENT"), 0);
    SmsManager.getDefault().sendTextMessage(paramString1.replaceAll("\\D+", ""), null, paramString2, localPendingIntent, null);
  }
  
  public void sharePlainText(String paramString1, String paramString2)
  {
    sharePlainText(paramString1, paramString2, null);
  }
  
  public void sharePlainText(String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.TEXT", paramString2);
    localIntent.putExtra("android.intent.extra.SUBJECT", paramString3);
    paramString1 = Intent.createChooser(localIntent, paramString1);
    paramString1.addFlags(268435456);
    context.startActivity(paramString1);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.share.ShareService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */