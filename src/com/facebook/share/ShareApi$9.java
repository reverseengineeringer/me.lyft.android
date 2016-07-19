package com.facebook.share;

import com.facebook.FacebookException;
import com.facebook.internal.CollectionMapper.Collection;
import com.facebook.internal.CollectionMapper.OnErrorListener;
import com.facebook.share.model.ShareOpenGraphObject;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class ShareApi$9
  implements CollectionMapper.Collection<String>
{
  ShareApi$9(ShareApi paramShareApi, ShareOpenGraphObject paramShareOpenGraphObject, JSONObject paramJSONObject) {}
  
  public Object get(String paramString)
  {
    return val$object.get(paramString);
  }
  
  public Iterator<String> keyIterator()
  {
    return val$object.keySet().iterator();
  }
  
  public void set(String paramString, Object paramObject, CollectionMapper.OnErrorListener paramOnErrorListener)
  {
    try
    {
      val$stagedObject.put(paramString, paramObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramObject = paramString.getLocalizedMessage();
      paramString = (String)paramObject;
      if (paramObject == null) {
        paramString = "Error staging object.";
      }
      paramOnErrorListener.onError(new FacebookException(paramString));
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.ShareApi.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */