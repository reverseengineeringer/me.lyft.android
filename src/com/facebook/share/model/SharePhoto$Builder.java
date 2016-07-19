package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SharePhoto$Builder
  extends ShareMedia.Builder<SharePhoto, Builder>
{
  private Bitmap bitmap;
  private String caption;
  private Uri imageUrl;
  private boolean userGenerated;
  
  static List<SharePhoto> readPhotoListFrom(Parcel paramParcel)
  {
    Object localObject = readListFrom(paramParcel);
    paramParcel = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ShareMedia localShareMedia = (ShareMedia)((Iterator)localObject).next();
      if ((localShareMedia instanceof SharePhoto)) {
        paramParcel.add((SharePhoto)localShareMedia);
      }
    }
    return paramParcel;
  }
  
  static void writePhotoListTo(Parcel paramParcel, int paramInt, List<SharePhoto> paramList)
  {
    ShareMedia[] arrayOfShareMedia = new ShareMedia[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfShareMedia[i] = ((ShareMedia)paramList.get(i));
      i += 1;
    }
    paramParcel.writeParcelableArray(arrayOfShareMedia, paramInt);
  }
  
  public SharePhoto build()
  {
    return new SharePhoto(this, null);
  }
  
  Bitmap getBitmap()
  {
    return bitmap;
  }
  
  Uri getImageUrl()
  {
    return imageUrl;
  }
  
  Builder readFrom(Parcel paramParcel)
  {
    return readFrom((SharePhoto)paramParcel.readParcelable(SharePhoto.class.getClassLoader()));
  }
  
  public Builder readFrom(SharePhoto paramSharePhoto)
  {
    if (paramSharePhoto == null) {
      return this;
    }
    return ((Builder)super.readFrom(paramSharePhoto)).setBitmap(paramSharePhoto.getBitmap()).setImageUrl(paramSharePhoto.getImageUrl()).setUserGenerated(paramSharePhoto.getUserGenerated()).setCaption(paramSharePhoto.getCaption());
  }
  
  public Builder setBitmap(Bitmap paramBitmap)
  {
    bitmap = paramBitmap;
    return this;
  }
  
  public Builder setCaption(String paramString)
  {
    caption = paramString;
    return this;
  }
  
  public Builder setImageUrl(Uri paramUri)
  {
    imageUrl = paramUri;
    return this;
  }
  
  public Builder setUserGenerated(boolean paramBoolean)
  {
    userGenerated = paramBoolean;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.SharePhoto.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */