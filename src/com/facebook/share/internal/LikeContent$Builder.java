package com.facebook.share.internal;

import com.facebook.share.model.ShareModelBuilder;

public class LikeContent$Builder
  implements ShareModelBuilder<LikeContent, Builder>
{
  private String objectId;
  private String objectType;
  
  public LikeContent build()
  {
    return new LikeContent(this, null);
  }
  
  public Builder readFrom(LikeContent paramLikeContent)
  {
    if (paramLikeContent == null) {
      return this;
    }
    return setObjectId(paramLikeContent.getObjectId()).setObjectType(paramLikeContent.getObjectType());
  }
  
  public Builder setObjectId(String paramString)
  {
    objectId = paramString;
    return this;
  }
  
  public Builder setObjectType(String paramString)
  {
    objectType = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.LikeContent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */