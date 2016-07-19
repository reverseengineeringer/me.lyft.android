package com.facebook.share.internal;

import com.facebook.share.model.ShareContent.Builder;

public final class ShareFeedContent$Builder
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

/* Location:
 * Qualified Name:     com.facebook.share.internal.ShareFeedContent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */