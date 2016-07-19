package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareContent.Builder;

public class ShareFeedContent
  extends ShareContent<ShareFeedContent, Builder>
{
  public static final Parcelable.Creator<ShareFeedContent> CREATOR = new Parcelable.Creator()
  {
    public ShareFeedContent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ShareFeedContent(paramAnonymousParcel);
    }
    
    public ShareFeedContent[] newArray(int paramAnonymousInt)
    {
      return new ShareFeedContent[paramAnonymousInt];
    }
  };
  private final String link;
  private final String linkCaption;
  private final String linkDescription;
  private final String linkName;
  private final String mediaSource;
  private final String picture;
  private final String toId;
  
  ShareFeedContent(Parcel paramParcel)
  {
    super(paramParcel);
    toId = paramParcel.readString();
    link = paramParcel.readString();
    linkName = paramParcel.readString();
    linkCaption = paramParcel.readString();
    linkDescription = paramParcel.readString();
    picture = paramParcel.readString();
    mediaSource = paramParcel.readString();
  }
  
  private ShareFeedContent(Builder paramBuilder)
  {
    super(paramBuilder);
    toId = toId;
    link = link;
    linkName = linkName;
    linkCaption = linkCaption;
    linkDescription = linkDescription;
    picture = picture;
    mediaSource = mediaSource;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getLink()
  {
    return link;
  }
  
  public String getLinkCaption()
  {
    return linkCaption;
  }
  
  public String getLinkDescription()
  {
    return linkDescription;
  }
  
  public String getLinkName()
  {
    return linkName;
  }
  
  public String getMediaSource()
  {
    return mediaSource;
  }
  
  public String getPicture()
  {
    return picture;
  }
  
  public String getToId()
  {
    return toId;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(toId);
    paramParcel.writeString(link);
    paramParcel.writeString(linkName);
    paramParcel.writeString(linkCaption);
    paramParcel.writeString(linkDescription);
    paramParcel.writeString(picture);
    paramParcel.writeString(mediaSource);
  }
  
  public static final class Builder
    extends ShareContent.Builder<ShareFeedContent, Builder>
  {
    private String link;
    private String linkCaption;
    private String linkDescription;
    private String linkName;
    private String mediaSource;
    private String picture;
    private String toId;
    
    public ShareFeedContent build()
    {
      return new ShareFeedContent(this, null);
    }
    
    public Builder readFrom(ShareFeedContent paramShareFeedContent)
    {
      if (paramShareFeedContent == null) {
        return this;
      }
      return ((Builder)super.readFrom(paramShareFeedContent)).setToId(paramShareFeedContent.getToId()).setLink(paramShareFeedContent.getLink()).setLinkName(paramShareFeedContent.getLinkName()).setLinkCaption(paramShareFeedContent.getLinkCaption()).setLinkDescription(paramShareFeedContent.getLinkDescription()).setPicture(paramShareFeedContent.getPicture()).setMediaSource(paramShareFeedContent.getMediaSource());
    }
    
    public Builder setLink(String paramString)
    {
      link = paramString;
      return this;
    }
    
    public Builder setLinkCaption(String paramString)
    {
      linkCaption = paramString;
      return this;
    }
    
    public Builder setLinkDescription(String paramString)
    {
      linkDescription = paramString;
      return this;
    }
    
    public Builder setLinkName(String paramString)
    {
      linkName = paramString;
      return this;
    }
    
    public Builder setMediaSource(String paramString)
    {
      mediaSource = paramString;
      return this;
    }
    
    public Builder setPicture(String paramString)
    {
      picture = paramString;
      return this;
    }
    
    public Builder setToId(String paramString)
    {
      toId = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.internal.ShareFeedContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */