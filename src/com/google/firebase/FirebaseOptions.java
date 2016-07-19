package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.common.util.zzw;

public final class FirebaseOptions
{
  private final String aMW;
  private final String aMX;
  private final String gs;
  private final String uS;
  private final String uV;
  private final String uW;
  
  private FirebaseOptions(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (!zzw.zzic(paramString1)) {}
    for (boolean bool = true;; bool = false)
    {
      zzab.zza(bool, "ApplicationId must be set.");
      gs = paramString1;
      uS = paramString2;
      aMW = paramString3;
      aMX = paramString4;
      uV = paramString5;
      uW = paramString6;
      return;
    }
  }
  
  public static FirebaseOptions fromResource(Context paramContext)
  {
    paramContext = new zzai(paramContext);
    String str = paramContext.getString("google_app_id");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return new FirebaseOptions(str, paramContext.getString("google_api_key"), paramContext.getString("firebase_database_url"), paramContext.getString("ga_trackingId"), paramContext.getString("gcm_defaultSenderId"), paramContext.getString("google_storage_bucket"));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FirebaseOptions)) {}
    do
    {
      return false;
      paramObject = (FirebaseOptions)paramObject;
    } while ((!zzaa.equal(gs, gs)) || (!zzaa.equal(uS, uS)) || (!zzaa.equal(aMW, aMW)) || (!zzaa.equal(aMX, aMX)) || (!zzaa.equal(uV, uV)) || (!zzaa.equal(uW, uW)));
    return true;
  }
  
  public String getApplicationId()
  {
    return gs;
  }
  
  public String getGcmSenderId()
  {
    return uV;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { gs, uS, aMW, aMX, uV, uW });
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("applicationId", gs).zzg("apiKey", uS).zzg("databaseUrl", aMW).zzg("gcmSenderId", uV).zzg("storageBucket", uW).toString();
  }
}

/* Location:
 * Qualified Name:     com.google.firebase.FirebaseOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */