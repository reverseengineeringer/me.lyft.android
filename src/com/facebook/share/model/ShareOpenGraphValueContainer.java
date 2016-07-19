package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends Builder>
  implements ShareModel
{
  private final Bundle bundle;
  
  ShareOpenGraphValueContainer(Parcel paramParcel)
  {
    bundle = paramParcel.readBundle(Builder.class.getClassLoader());
  }
  
  protected ShareOpenGraphValueContainer(Builder<P, E> paramBuilder)
  {
    bundle = ((Bundle)bundle.clone());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Object get(String paramString)
  {
    return bundle.get(paramString);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return bundle.getBoolean(paramString, paramBoolean);
  }
  
  public boolean[] getBooleanArray(String paramString)
  {
    return bundle.getBooleanArray(paramString);
  }
  
  public Bundle getBundle()
  {
    return (Bundle)bundle.clone();
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    return bundle.getDouble(paramString, paramDouble);
  }
  
  public double[] getDoubleArray(String paramString)
  {
    return bundle.getDoubleArray(paramString);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return bundle.getInt(paramString, paramInt);
  }
  
  public int[] getIntArray(String paramString)
  {
    return bundle.getIntArray(paramString);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return bundle.getLong(paramString, paramLong);
  }
  
  public long[] getLongArray(String paramString)
  {
    return bundle.getLongArray(paramString);
  }
  
  public ShareOpenGraphObject getObject(String paramString)
  {
    paramString = bundle.get(paramString);
    if ((paramString instanceof ShareOpenGraphObject)) {
      return (ShareOpenGraphObject)paramString;
    }
    return null;
  }
  
  public ArrayList<ShareOpenGraphObject> getObjectArrayList(String paramString)
  {
    paramString = bundle.getParcelableArrayList(paramString);
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramString.iterator();
    for (;;)
    {
      paramString = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (Parcelable)localIterator.next();
      if ((paramString instanceof ShareOpenGraphObject)) {
        localArrayList.add((ShareOpenGraphObject)paramString);
      }
    }
  }
  
  public SharePhoto getPhoto(String paramString)
  {
    paramString = bundle.getParcelable(paramString);
    if ((paramString instanceof SharePhoto)) {
      return (SharePhoto)paramString;
    }
    return null;
  }
  
  public ArrayList<SharePhoto> getPhotoArrayList(String paramString)
  {
    paramString = bundle.getParcelableArrayList(paramString);
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramString.iterator();
    for (;;)
    {
      paramString = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (Parcelable)localIterator.next();
      if ((paramString instanceof SharePhoto)) {
        localArrayList.add((SharePhoto)paramString);
      }
    }
  }
  
  public String getString(String paramString)
  {
    return bundle.getString(paramString);
  }
  
  public ArrayList<String> getStringArrayList(String paramString)
  {
    return bundle.getStringArrayList(paramString);
  }
  
  public Set<String> keySet()
  {
    return bundle.keySet();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(bundle);
  }
  
  public static abstract class Builder<P extends ShareOpenGraphValueContainer, E extends Builder>
    implements ShareModelBuilder<P, E>
  {
    private Bundle bundle = new Bundle();
    
    public E putBoolean(String paramString, boolean paramBoolean)
    {
      bundle.putBoolean(paramString, paramBoolean);
      return this;
    }
    
    public E putBooleanArray(String paramString, boolean[] paramArrayOfBoolean)
    {
      bundle.putBooleanArray(paramString, paramArrayOfBoolean);
      return this;
    }
    
    public E putDouble(String paramString, double paramDouble)
    {
      bundle.putDouble(paramString, paramDouble);
      return this;
    }
    
    public E putDoubleArray(String paramString, double[] paramArrayOfDouble)
    {
      bundle.putDoubleArray(paramString, paramArrayOfDouble);
      return this;
    }
    
    public E putInt(String paramString, int paramInt)
    {
      bundle.putInt(paramString, paramInt);
      return this;
    }
    
    public E putIntArray(String paramString, int[] paramArrayOfInt)
    {
      bundle.putIntArray(paramString, paramArrayOfInt);
      return this;
    }
    
    public E putLong(String paramString, long paramLong)
    {
      bundle.putLong(paramString, paramLong);
      return this;
    }
    
    public E putLongArray(String paramString, long[] paramArrayOfLong)
    {
      bundle.putLongArray(paramString, paramArrayOfLong);
      return this;
    }
    
    public E putObject(String paramString, ShareOpenGraphObject paramShareOpenGraphObject)
    {
      bundle.putParcelable(paramString, paramShareOpenGraphObject);
      return this;
    }
    
    public E putObjectArrayList(String paramString, ArrayList<ShareOpenGraphObject> paramArrayList)
    {
      bundle.putParcelableArrayList(paramString, paramArrayList);
      return this;
    }
    
    public E putPhoto(String paramString, SharePhoto paramSharePhoto)
    {
      bundle.putParcelable(paramString, paramSharePhoto);
      return this;
    }
    
    public E putPhotoArrayList(String paramString, ArrayList<SharePhoto> paramArrayList)
    {
      bundle.putParcelableArrayList(paramString, paramArrayList);
      return this;
    }
    
    public E putString(String paramString1, String paramString2)
    {
      bundle.putString(paramString1, paramString2);
      return this;
    }
    
    public E putStringArrayList(String paramString, ArrayList<String> paramArrayList)
    {
      bundle.putStringArrayList(paramString, paramArrayList);
      return this;
    }
    
    public E readFrom(P paramP)
    {
      if (paramP != null) {
        bundle.putAll(paramP.getBundle());
      }
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphValueContainer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */