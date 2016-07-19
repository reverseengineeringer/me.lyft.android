package com.facebook.share.model;

import android.os.Parcel;

public class ShareHashtag$Builder
  implements ShareModelBuilder<ShareHashtag, Builder>
{
  private String hashtag;
  
  public ShareHashtag build()
  {
    return new ShareHashtag(this, null);
  }
  
  public String getHashtag()
  {
    return hashtag;
  }
  
  Builder readFrom(Parcel paramParcel)
  {
    return readFrom((ShareHashtag)paramParcel.readParcelable(ShareHashtag.class.getClassLoader()));
  }
  
  public Builder readFrom(ShareHashtag paramShareHashtag)
  {
    if (paramShareHashtag == null) {
      return this;
    }
    return setHashtag(paramShareHashtag.getHashtag());
  }
  
  public Builder setHashtag(String paramString)
  {
    hashtag = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareHashtag.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */