package com.facebook.share;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper.Collection;
import com.facebook.internal.CollectionMapper.OnErrorListener;
import com.facebook.internal.Utility;
import java.util.Iterator;
import java.util.Set;

class ShareApi$8
  implements CollectionMapper.Collection<String>
{
  ShareApi$8(ShareApi paramShareApi, Bundle paramBundle) {}
  
  public Object get(String paramString)
  {
    return val$parameters.get(paramString);
  }
  
  public Iterator<String> keyIterator()
  {
    return val$parameters.keySet().iterator();
  }
  
  public void set(String paramString, Object paramObject, CollectionMapper.OnErrorListener paramOnErrorListener)
  {
    if (!Utility.putJSONValueInBundle(val$parameters, paramString, paramObject)) {
      paramOnErrorListener.onError(new FacebookException("Unexpected value: " + paramObject.toString()));
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.ShareApi.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */