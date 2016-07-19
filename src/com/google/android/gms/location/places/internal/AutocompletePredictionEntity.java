package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

public class AutocompletePredictionEntity
  extends AbstractSafeParcelable
  implements AutocompletePrediction
{
  public static final Parcelable.Creator<AutocompletePredictionEntity> CREATOR = new zza();
  private static final List<SubstringEntity> afj = Collections.emptyList();
  final String aeL;
  final List<Integer> aeh;
  final String afk;
  final List<SubstringEntity> afl;
  final int afm;
  final String afn;
  final List<SubstringEntity> afo;
  final String afp;
  final List<SubstringEntity> afq;
  final int mVersionCode;
  
  AutocompletePredictionEntity(int paramInt1, String paramString1, List<Integer> paramList, int paramInt2, String paramString2, List<SubstringEntity> paramList1, String paramString3, List<SubstringEntity> paramList2, String paramString4, List<SubstringEntity> paramList3)
  {
    mVersionCode = paramInt1;
    aeL = paramString1;
    aeh = paramList;
    afm = paramInt2;
    afk = paramString2;
    afl = paramList1;
    afn = paramString3;
    afo = paramList2;
    afp = paramString4;
    afq = paramList3;
  }
  
  public static AutocompletePredictionEntity zza(String paramString1, List<Integer> paramList, int paramInt, String paramString2, List<SubstringEntity> paramList1, String paramString3, List<SubstringEntity> paramList2, String paramString4, List<SubstringEntity> paramList3)
  {
    return new AutocompletePredictionEntity(0, paramString1, paramList, paramInt, (String)zzab.zzaa(paramString2), paramList1, paramString3, paramList2, paramString4, paramList3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof AutocompletePredictionEntity)) {
        return false;
      }
      paramObject = (AutocompletePredictionEntity)paramObject;
    } while ((zzaa.equal(aeL, aeL)) && (zzaa.equal(aeh, aeh)) && (zzaa.equal(Integer.valueOf(afm), Integer.valueOf(afm))) && (zzaa.equal(afk, afk)) && (zzaa.equal(afl, afl)) && (zzaa.equal(afn, afn)) && (zzaa.equal(afo, afo)) && (zzaa.equal(afp, afp)) && (zzaa.equal(afq, afq)));
    return false;
  }
  
  public CharSequence getFullText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(afk, afl, paramCharacterStyle);
  }
  
  public String getPlaceId()
  {
    return aeL;
  }
  
  public List<Integer> getPlaceTypes()
  {
    return aeh;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { aeL, aeh, Integer.valueOf(afm), afk, afl, afn, afo, afp, afq });
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("placeId", aeL).zzg("placeTypes", aeh).zzg("fullText", afk).zzg("fullTextMatchedSubstrings", afl).zzg("primaryText", afn).zzg("primaryTextMatchedSubstrings", afo).zzg("secondaryText", afp).zzg("secondaryTextMatchedSubstrings", afq).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public AutocompletePrediction zzboe()
  {
    return this;
  }
  
  public static class SubstringEntity
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<SubstringEntity> CREATOR = new zzu();
    final int mLength;
    final int mOffset;
    final int mVersionCode;
    
    public SubstringEntity(int paramInt1, int paramInt2, int paramInt3)
    {
      mVersionCode = paramInt1;
      mOffset = paramInt2;
      mLength = paramInt3;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof SubstringEntity)) {
          return false;
        }
        paramObject = (SubstringEntity)paramObject;
      } while ((zzaa.equal(Integer.valueOf(mOffset), Integer.valueOf(mOffset))) && (zzaa.equal(Integer.valueOf(mLength), Integer.valueOf(mLength))));
      return false;
    }
    
    public int getLength()
    {
      return mLength;
    }
    
    public int getOffset()
    {
      return mOffset;
    }
    
    public int hashCode()
    {
      return zzaa.hashCode(new Object[] { Integer.valueOf(mOffset), Integer.valueOf(mLength) });
    }
    
    public String toString()
    {
      return zzaa.zzz(this).zzg("offset", Integer.valueOf(mOffset)).zzg("length", Integer.valueOf(mLength)).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzu.zza(this, paramParcel, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.AutocompletePredictionEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */