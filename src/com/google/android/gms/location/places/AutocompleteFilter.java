package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AutocompleteFilter
  extends AbstractSafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final boolean aek;
  final List<Integer> ael;
  final int aem;
  final int mVersionCode;
  
  AutocompleteFilter(int paramInt, boolean paramBoolean, List<Integer> paramList)
  {
    mVersionCode = paramInt;
    ael = paramList;
    aem = zzl(paramList);
    if (mVersionCode < 1)
    {
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        aek = paramBoolean;
        return;
      }
    }
    aek = paramBoolean;
  }
  
  private static int zzl(Collection<Integer> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      return 0;
    }
    return ((Integer)paramCollection.iterator().next()).intValue();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof AutocompleteFilter)) {
        return false;
      }
      paramObject = (AutocompleteFilter)paramObject;
    } while ((aem == aem) && (aek == aek));
    return false;
  }
  
  public int hashCode()
  {
    return zzaa.hashCode(new Object[] { Boolean.valueOf(aek), Integer.valueOf(aem) });
  }
  
  public String toString()
  {
    return zzaa.zzz(this).zzg("includeQueryPredictions", Boolean.valueOf(aek)).zzg("typeFilter", Integer.valueOf(aem)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private boolean aek = false;
    private int aem = 0;
    
    public AutocompleteFilter build()
    {
      return new AutocompleteFilter(1, false, Arrays.asList(new Integer[] { Integer.valueOf(aem) }));
    }
    
    public Builder setTypeFilter(int paramInt)
    {
      aem = paramInt;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.AutocompleteFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */