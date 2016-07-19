package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SharePhoto
  extends ShareMedia
{
  public static final Parcelable.Creator<SharePhoto> CREATOR = new Parcelable.Creator()
  {
    public SharePhoto createFromParcel(Parcel paramAnonymousParcel)
    {
      return new SharePhoto(paramAnonymousParcel);
    }
    
    public SharePhoto[] newArray(int paramAnonymousInt)
    {
      return new SharePhoto[paramAnonymousInt];
    }
  };
  private final Bitmap bitmap;
  private final String caption;
  private final Uri imageUrl;
  private final boolean userGenerated;
  
  SharePhoto(Parcel paramParcel)
  {
    super(paramParcel);
    bitmap = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    imageUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      userGenerated = bool;
      caption = paramParcel.readString();
      return;
    }
  }
  
  private SharePhoto(Builder paramBuilder)
  {
    super(paramBuilder);
    bitmap = bitmap;
    imageUrl = imageUrl;
    userGenerated = userGenerated;
    caption = caption;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bitmap getBitmap()
  {
    return bitmap;
  }
  
  public String getCaption()
  {
    return caption;
  }
  
  public Uri getImageUrl()
  {
    return imageUrl;
  }
  
  public ShareMedia.Type getMediaType()
  {
    return ShareMedia.Type.PHOTO;
  }
  
  public boolean getUserGenerated()
  {
    return userGenerated;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(bitmap, 0);
    paramParcel.writeParcelable(imageUrl, 0);
    paramInt = i;
    if (userGenerated) {
      paramInt = 1;
    }
    paramParcel.writeByte((byte)paramInt);
    paramParcel.writeString(caption);
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.facebook.share.model.SharePhoto
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */