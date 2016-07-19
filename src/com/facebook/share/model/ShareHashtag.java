package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ShareHashtag
  implements ShareModel
{
  public static final Parcelable.Creator<ShareHashtag> CREATOR = new Parcelable.Creator()
  {
    public ShareHashtag createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ShareHashtag(paramAnonymousParcel);
    }
    
    public ShareHashtag[] newArray(int paramAnonymousInt)
    {
      return new ShareHashtag[paramAnonymousInt];
    }
  };
  private final String hashtag;
  
  ShareHashtag(Parcel paramParcel)
  {
    hashtag = paramParcel.readString();
  }
  
  private ShareHashtag(Builder paramBuilder)
  {
    hashtag = hashtag;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getHashtag()
  {
    return hashtag;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(hashtag);
  }
  
  public static class Builder
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
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareHashtag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */