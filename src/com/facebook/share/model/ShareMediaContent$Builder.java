package com.facebook.share.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareMediaContent$Builder
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

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareMediaContent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */