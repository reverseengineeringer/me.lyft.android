package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ShareMediaContent
  extends ShareContent<ShareMediaContent, Builder>
{
  public static final Parcelable.Creator<ShareMediaContent> CREATOR = new Parcelable.Creator()
  {
    public ShareMediaContent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ShareMediaContent(paramAnonymousParcel);
    }
    
    public ShareMediaContent[] newArray(int paramAnonymousInt)
    {
      return new ShareMediaContent[paramAnonymousInt];
    }
  };
  private final List<ShareMedia> media;
  
  ShareMediaContent(Parcel paramParcel)
  {
    super(paramParcel);
    media = Arrays.asList((ShareMedia[])paramParcel.readParcelableArray(ShareMedia.class.getClassLoader()));
  }
  
  private ShareMediaContent(Builder paramBuilder)
  {
    super(paramBuilder);
    media = Collections.unmodifiableList(media);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<ShareMedia> getMedia()
  {
    return media;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelableArray((ShareMedia[])media.toArray(), paramInt);
  }
  
  public static class Builder
    extends ShareContent.Builder<ShareMediaContent, Builder>
  {
    private final List<ShareMedia> media = new ArrayList();
    
    public Builder addMedia(List<ShareMedia> paramList)
    {
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          addMedium((ShareMedia)paramList.next());
        }
      }
      return this;
    }
    
    public Builder addMedium(ShareMedia paramShareMedia)
    {
      if (paramShareMedia != null) {
        if (!(paramShareMedia instanceof SharePhoto)) {
          break label42;
        }
      }
      for (paramShareMedia = new SharePhoto.Builder().readFrom((SharePhoto)paramShareMedia).build();; paramShareMedia = new ShareVideo.Builder().readFrom((ShareVideo)paramShareMedia).build())
      {
        media.add(paramShareMedia);
        return this;
        label42:
        if (!(paramShareMedia instanceof ShareVideo)) {
          break;
        }
      }
      throw new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
    }
    
    public ShareMediaContent build()
    {
      return new ShareMediaContent(this, null);
    }
    
    public Builder readFrom(ShareMediaContent paramShareMediaContent)
    {
      if (paramShareMediaContent == null) {
        return this;
      }
      return ((Builder)super.readFrom(paramShareMediaContent)).addMedia(paramShareMediaContent.getMedia());
    }
    
    public Builder setMedia(List<ShareMedia> paramList)
    {
      media.clear();
      addMedia(paramList);
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareMediaContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */