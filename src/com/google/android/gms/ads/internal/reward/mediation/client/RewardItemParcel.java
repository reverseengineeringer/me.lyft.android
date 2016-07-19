package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzir;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzir
public final class RewardItemParcel
  extends AbstractSafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public final String type;
  public final int versionCode;
  public final int zzcih;
  
  public RewardItemParcel(int paramInt1, String paramString, int paramInt2)
  {
    versionCode = paramInt1;
    type = paramString;
    zzcih = paramInt2;
  }
  
  public RewardItemParcel(RewardItem paramRewardItem)
  {
    this(1, paramRewardItem.getType(), paramRewardItem.getAmount());
  }
  
  public RewardItemParcel(String paramString, int paramInt)
  {
    this(1, paramString, paramInt);
  }
  
  public static RewardItemParcel zza(JSONArray paramJSONArray)
    throws JSONException
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0)) {
      return null;
    }
    return new RewardItemParcel(paramJSONArray.getJSONObject(0).optString("rb_type"), paramJSONArray.getJSONObject(0).optInt("rb_amount"));
  }
  
  public static RewardItemParcel zzci(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = zza(new JSONArray(paramString));
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof RewardItemParcel))) {}
    do
    {
      return false;
      paramObject = (RewardItemParcel)paramObject;
    } while ((!zzaa.equal(type, type)) || (!zzaa.equal(Integer.valueOf(zzcih), Integer.valueOf(zzcih))));
    return true;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { type, Integer.valueOf(zzcih) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public JSONArray zzrx()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("rb_type", type);
    localJSONObject.put("rb_amount", zzcih);
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(localJSONObject);
    return localJSONArray;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */