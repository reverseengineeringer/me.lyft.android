package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public final class AutoClickProtectionConfigurationParcel
  extends AbstractSafeParcelable
{
  public static final zzi CREATOR = new zzi();
  public final int versionCode;
  public final boolean zzccy;
  public final List<String> zzccz;
  
  public AutoClickProtectionConfigurationParcel()
  {
    this(1, false, Collections.emptyList());
  }
  
  public AutoClickProtectionConfigurationParcel(int paramInt, boolean paramBoolean, List<String> paramList)
  {
    versionCode = paramInt;
    zzccy = paramBoolean;
    zzccz = paramList;
  }
  
  public AutoClickProtectionConfigurationParcel(boolean paramBoolean)
  {
    this(1, paramBoolean, Collections.emptyList());
  }
  
  public AutoClickProtectionConfigurationParcel(boolean paramBoolean, List<String> paramList)
  {
    this(1, paramBoolean, paramList);
  }
  
  public static AutoClickProtectionConfigurationParcel zzh(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return new AutoClickProtectionConfigurationParcel();
    }
    JSONArray localJSONArray = paramJSONObject.optJSONArray("reporting_urls");
    ArrayList localArrayList = new ArrayList();
    if (localJSONArray != null)
    {
      int i = 0;
      for (;;)
      {
        if (i < localJSONArray.length()) {
          try
          {
            localArrayList.add(localJSONArray.getString(i));
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              zzkh.zzd("Error grabbing url from json.", localJSONException);
            }
          }
        }
      }
    }
    return new AutoClickProtectionConfigurationParcel(paramJSONObject.optBoolean("enable_protection"), localArrayList);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */