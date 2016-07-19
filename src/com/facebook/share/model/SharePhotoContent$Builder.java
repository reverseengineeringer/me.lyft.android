package com.facebook.share.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SharePhotoContent$Builder
  extends ShareContent.Builder<SharePhotoContent, Builder>
{
  private final List<SharePhoto> photos = new ArrayList();
  
  public Builder addPhoto(SharePhoto paramSharePhoto)
  {
    if (paramSharePhoto != null) {
      photos.add(new SharePhoto.Builder().readFrom(paramSharePhoto).build());
    }
    return this;
  }
  
  public Builder addPhotos(List<SharePhoto> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        addPhoto((SharePhoto)paramList.next());
      }
    }
    return this;
  }
  
  public SharePhotoContent build()
  {
    return new SharePhotoContent(this, null);
  }
  
  public Builder readFrom(SharePhotoContent paramSharePhotoContent)
  {
    if (paramSharePhotoContent == null) {
      return this;
    }
    return ((Builder)super.readFrom(paramSharePhotoContent)).addPhotos(paramSharePhotoContent.getPhotos());
  }
  
  public Builder setPhotos(List<SharePhoto> paramList)
  {
    photos.clear();
    addPhotos(paramList);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.SharePhotoContent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */