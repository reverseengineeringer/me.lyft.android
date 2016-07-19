package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzir;

@zzir
public final class SearchAdRequestParcel
  extends AbstractSafeParcelable
{
  public static final zzao CREATOR = new zzao();
  public final int backgroundColor;
  public final int versionCode;
  public final int zzawx;
  public final int zzawy;
  public final int zzawz;
  public final int zzaxa;
  public final int zzaxb;
  public final int zzaxc;
  public final int zzaxd;
  public final String zzaxe;
  public final int zzaxf;
  public final String zzaxg;
  public final int zzaxh;
  public final int zzaxi;
  public final String zzaxj;
  
  SearchAdRequestParcel(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3)
  {
    versionCode = paramInt1;
    zzawx = paramInt2;
    backgroundColor = paramInt3;
    zzawy = paramInt4;
    zzawz = paramInt5;
    zzaxa = paramInt6;
    zzaxb = paramInt7;
    zzaxc = paramInt8;
    zzaxd = paramInt9;
    zzaxe = paramString1;
    zzaxf = paramInt10;
    zzaxg = paramString2;
    zzaxh = paramInt11;
    zzaxi = paramInt12;
    zzaxj = paramString3;
  }
  
  public SearchAdRequestParcel(SearchAdRequest paramSearchAdRequest)
  {
    versionCode = 1;
    zzawx = paramSearchAdRequest.getAnchorTextColor();
    backgroundColor = paramSearchAdRequest.getBackgroundColor();
    zzawy = paramSearchAdRequest.getBackgroundGradientBottom();
    zzawz = paramSearchAdRequest.getBackgroundGradientTop();
    zzaxa = paramSearchAdRequest.getBorderColor();
    zzaxb = paramSearchAdRequest.getBorderThickness();
    zzaxc = paramSearchAdRequest.getBorderType();
    zzaxd = paramSearchAdRequest.getCallButtonColor();
    zzaxe = paramSearchAdRequest.getCustomChannels();
    zzaxf = paramSearchAdRequest.getDescriptionTextColor();
    zzaxg = paramSearchAdRequest.getFontFace();
    zzaxh = paramSearchAdRequest.getHeaderTextColor();
    zzaxi = paramSearchAdRequest.getHeaderTextSize();
    zzaxj = paramSearchAdRequest.getQuery();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzao.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.SearchAdRequestParcel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */