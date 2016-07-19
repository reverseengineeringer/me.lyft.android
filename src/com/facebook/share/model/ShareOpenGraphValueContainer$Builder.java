package com.facebook.share.model;

import android.os.Bundle;
import java.util.ArrayList;

public abstract class ShareOpenGraphValueContainer$Builder<P extends ShareOpenGraphValueContainer, E extends Builder>
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

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphValueContainer.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */