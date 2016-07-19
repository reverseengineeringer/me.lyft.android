package com.facebook.share.model;

public final class ShareVideoContent$Builder
  extends ShareContent.Builder<ShareVideoContent, Builder>
{
  private String contentDescription;
  private String contentTitle;
  private SharePhoto previewPhoto;
  private ShareVideo video;
  
  public ShareVideoContent build()
  {
    return new ShareVideoContent(this, null);
  }
  
  public Builder readFrom(ShareVideoContent paramShareVideoContent)
  {
    if (paramShareVideoContent == null) {
      return this;
    }
    return ((Builder)super.readFrom(paramShareVideoContent)).setContentDescription(paramShareVideoContent.getContentDescription()).setContentTitle(paramShareVideoContent.getContentTitle()).setPreviewPhoto(paramShareVideoContent.getPreviewPhoto()).setVideo(paramShareVideoContent.getVideo());
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
  
  public Builder setPreviewPhoto(SharePhoto paramSharePhoto)
  {
    if (paramSharePhoto == null) {}
    for (paramSharePhoto = null;; paramSharePhoto = new SharePhoto.Builder().readFrom(paramSharePhoto).build())
    {
      previewPhoto = paramSharePhoto;
      return this;
    }
  }
  
  public Builder setVideo(ShareVideo paramShareVideo)
  {
    if (paramShareVideo == null) {
      return this;
    }
    video = new ShareVideo.Builder().readFrom(paramShareVideo).build();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareVideoContent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */