package com.facebook.share;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper.Collection;
import com.facebook.internal.CollectionMapper.OnErrorListener;
import com.facebook.internal.Mutable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

class ShareApi$5
  implements CollectionMapper.Collection<Integer>
{
  ShareApi$5(ShareApi paramShareApi, ArrayList paramArrayList, JSONArray paramJSONArray) {}
  
  public Object get(Integer paramInteger)
  {
    return val$arrayList.get(paramInteger.intValue());
  }
  
  public Iterator<Integer> keyIterator()
  {
    final int i = val$arrayList.size();
    new Iterator()
    {
      public boolean hasNext()
      {
        return ((Integer)val$current.value).intValue() < i;
      }
      
      public Integer next()
      {
        Integer localInteger = (Integer)val$current.value;
        Mutable localMutable = val$current;
        value = Integer.valueOf(((Integer)value).intValue() + 1);
        return localInteger;
      }
      
      public void remove() {}
    };
  }
  
  public void set(Integer paramInteger, Object paramObject, CollectionMapper.OnErrorListener paramOnErrorListener)
  {
    try
    {
      val$stagedObject.put(paramInteger.intValue(), paramObject);
      return;
    }
    catch (JSONException paramInteger)
    {
      paramObject = paramInteger.getLocalizedMessage();
      paramInteger = (Integer)paramObject;
      if (paramObject == null) {
        paramInteger = "Error staging object.";
      }
      paramOnErrorListener.onError(new FacebookException(paramInteger));
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.ShareApi.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */