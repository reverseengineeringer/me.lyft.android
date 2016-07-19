package com.facebook.share;

import com.facebook.internal.CollectionMapper.OnMapValueCompleteListener;
import com.facebook.internal.CollectionMapper.ValueMapper;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;

class ShareApi$7
  implements CollectionMapper.ValueMapper
{
  ShareApi$7(ShareApi paramShareApi) {}
  
  public void mapValue(Object paramObject, CollectionMapper.OnMapValueCompleteListener paramOnMapValueCompleteListener)
  {
    if ((paramObject instanceof ArrayList))
    {
      ShareApi.access$200(this$0, (ArrayList)paramObject, paramOnMapValueCompleteListener);
      return;
    }
    if ((paramObject instanceof ShareOpenGraphObject))
    {
      ShareApi.access$300(this$0, (ShareOpenGraphObject)paramObject, paramOnMapValueCompleteListener);
      return;
    }
    if ((paramObject instanceof SharePhoto))
    {
      ShareApi.access$400(this$0, (SharePhoto)paramObject, paramOnMapValueCompleteListener);
      return;
    }
    paramOnMapValueCompleteListener.onComplete(paramObject);
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.ShareApi.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */