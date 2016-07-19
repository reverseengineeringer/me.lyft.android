package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.R.string;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zzir
public class zzhd
  extends zzhj
{
  private final Context mContext;
  private final Map<String, String> zzbee;
  private String zzbqc;
  private long zzbqd;
  private long zzbqe;
  private String zzbqf;
  private String zzbqg;
  
  public zzhd(zzll paramzzll, Map<String, String> paramMap)
  {
    super(paramzzll, "createCalendarEvent");
    zzbee = paramMap;
    mContext = paramzzll.zzuf();
    zzmv();
  }
  
  private String zzbr(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)zzbee.get(paramString))) {
      return "";
    }
    return (String)zzbee.get(paramString);
  }
  
  private long zzbs(String paramString)
  {
    paramString = (String)zzbee.get(paramString);
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
  
  private void zzmv()
  {
    zzbqc = zzbr("description");
    zzbqf = zzbr("summary");
    zzbqd = zzbs("start_ticks");
    zzbqe = zzbs("end_ticks");
    zzbqg = zzbr("location");
  }
  
  @TargetApi(14)
  Intent createIntent()
  {
    Intent localIntent = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
    localIntent.putExtra("title", zzbqc);
    localIntent.putExtra("eventLocation", zzbqg);
    localIntent.putExtra("description", zzbqf);
    if (zzbqd > -1L) {
      localIntent.putExtra("beginTime", zzbqd);
    }
    if (zzbqe > -1L) {
      localIntent.putExtra("endTime", zzbqe);
    }
    localIntent.setFlags(268435456);
    return localIntent;
  }
  
  public void execute()
  {
    if (mContext == null)
    {
      zzbu("Activity context is not available.");
      return;
    }
    if (!zzu.zzfq().zzag(mContext).zzju())
    {
      zzbu("This feature is not available on the device.");
      return;
    }
    AlertDialog.Builder localBuilder = zzu.zzfq().zzaf(mContext);
    Resources localResources = zzu.zzft().getResources();
    if (localResources != null)
    {
      str = localResources.getString(R.string.create_calendar_title);
      localBuilder.setTitle(str);
      if (localResources == null) {
        break label157;
      }
      str = localResources.getString(R.string.create_calendar_message);
      label85:
      localBuilder.setMessage(str);
      if (localResources == null) {
        break label163;
      }
      str = localResources.getString(R.string.accept);
      label103:
      localBuilder.setPositiveButton(str, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = createIntent();
          zzu.zzfq().zzb(zzhd.zza(zzhd.this), paramAnonymousDialogInterface);
        }
      });
      if (localResources == null) {
        break label169;
      }
    }
    label157:
    label163:
    label169:
    for (String str = localResources.getString(R.string.decline);; str = "Decline")
    {
      localBuilder.setNegativeButton(str, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          zzbu("Operation denied by user.");
        }
      });
      localBuilder.create().show();
      return;
      str = "Create calendar event";
      break;
      str = "Allow Ad to create a calendar event?";
      break label85;
      str = "Accept";
      break label103;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzhd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */