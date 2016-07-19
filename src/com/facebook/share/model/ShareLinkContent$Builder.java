package com.facebook.share.model;

import android.net.Uri;

public final class ShareLinkContent$Builder
  extends ShareContent.Builder<ShareLinkContent, Builder>
{
  private String contentDescription;
  private String contentTitle;
  private Uri imageUrl;
  private String quote;
  
  public ShareLinkContent build()
  {
    return new ShareLinkContent(this, null);
  }
  
  public Builder readFrom(ShareLinkContent paramShareLinkContent)
  {
    if (paramShareLinkContent == null) {
      return this;
    }
    return ((Builder)super.readFrom(paramShareLinkContent)).setContentDescription(paramShareLinkContent.getContentDescription()).setImageUrl(paramShareLinkContent.getImageUrl()).setContentTitle(paramShareLinkContent.getContentTitle()).setQuote(paramShareLinkContent.getQuote());
  }
  
  public Builder setContentDescription(String paramString)
  {
    contentDescription = paramString;
    return this;
  }
  
  public Builder setContentTitle(String paramString)
  {
    contentTitle = paramString;
    return this;
  }
  
  public Builder setImageUrl(Uri paramUri)
  {
    imageUrl = paramUri;
    return this;
  }
  
  public Builder setQuote(String paramString)
  {
    quote = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareLinkContent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */