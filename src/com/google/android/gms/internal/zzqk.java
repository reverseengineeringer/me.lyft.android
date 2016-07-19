package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.R.string;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.common.internal.zzz;

@Deprecated
public final class zzqk
{
  private static zzqk uR;
  private static Object zzamp = new Object();
  private final String uS;
  private final Status uT;
  private final String uU;
  private final String uV;
  private final String uW;
  private final boolean uX;
  private final boolean uY;
  private final String zzcjj;
  
  zzqk(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("google_app_measurement_enable", "integer", ((Resources)localObject).getResourcePackageName(R.string.common_google_play_services_unknown_issue));
    if (i != 0) {
      if (((Resources)localObject).getInteger(i) != 0)
      {
        bool1 = true;
        if (bool1) {
          break label172;
        }
      }
    }
    label52:
    for (uY = bool2;; uY = false)
    {
      uX = bool1;
      zzai localzzai = new zzai(paramContext);
      uU = localzzai.getString("firebase_database_url");
      uW = localzzai.getString("google_storage_bucket");
      uV = localzzai.getString("gcm_defaultSenderId");
      uS = localzzai.getString("google_api_key");
      localObject = zzz.zzcf(paramContext);
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = localzzai.getString("google_app_id");
      }
      if (!TextUtils.isEmpty(paramContext)) {
        break label186;
      }
      uT = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
      zzcjj = null;
      return;
      bool1 = false;
      break;
      label172:
      bool2 = false;
      break label52;
    }
    label186:
    zzcjj = paramContext;
    uT = Status.sg;
  }
  
  zzqk(String paramString, boolean paramBoolean)
  {
    this(paramString, paramBoolean, null, null, null);
  }
  
  zzqk(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    zzcjj = paramString1;
    uS = null;
    uT = Status.sg;
    uX = paramBoolean;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      uY = paramBoolean;
      uU = paramString2;
      uV = paramString4;
      uW = paramString3;
      return;
    }
  }
  
  public static String zzaqk()
  {
    return zzgy"getGoogleAppId"zzcjj;
  }
  
  public static boolean zzaql()
  {
    return zzgy"isMeasurementExplicitlyDisabled"uY;
  }
  
  public static Status zzc(Context arg0, String paramString, boolean paramBoolean)
  {
    zzab.zzb(???, "Context must not be null.");
    zzab.zzh(paramString, "App ID must be nonempty.");
    synchronized (zzamp)
    {
      if (uR != null)
      {
        paramString = uR.zzgx(paramString);
        return paramString;
      }
      uR = new zzqk(paramString, paramBoolean);
      paramString = uRuT;
      return paramString;
    }
  }
  
  public static Status zzcb(Context paramContext)
  {
    zzab.zzb(paramContext, "Context must not be null.");
    synchronized (zzamp)
    {
      if (uR == null) {
        uR = new zzqk(paramContext);
      }
      paramContext = uRuT;
      return paramContext;
    }
  }
  
  private static zzqk zzgy(String paramString)
  {
    synchronized (zzamp)
    {
      if (uR == null) {
        throw new IllegalStateException(String.valueOf(paramString).length() + 34 + "Initialize must be called before " + paramString + ".");
      }
    }
    paramString = uR;
    return paramString;
  }
  
  Status zzgx(String paramString)
  {
    if ((zzcjj != null) && (!zzcjj.equals(paramString)))
    {
      paramString = zzcjj;
      return new Status(10, String.valueOf(paramString).length() + 97 + "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '" + paramString + "'.");
    }
    return Status.sg;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */