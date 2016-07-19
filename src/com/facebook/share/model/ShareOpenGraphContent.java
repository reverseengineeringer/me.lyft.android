package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareOpenGraphContent
  extends ShareContent<ShareOpenGraphContent, Builder>
{
  public static final Parcelable.Creator<ShareOpenGraphContent> CREATOR = new Parcelable.Creator()
  {
    public ShareOpenGraphContent createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ShareOpenGraphContent(paramAnonymousParcel);
    }
    
    public ShareOpenGraphContent[] newArray(int paramAnonymousInt)
    {
      return new ShareOpenGraphContent[paramAnonymousInt];
    }
  };
  private final ShareOpenGraphAction action;
  private final String previewPropertyName;
  
  ShareOpenGraphContent(Parcel paramParcel)
  {
    super(paramParcel);
    action = new ShareOpenGraphAction.Builder().readFrom(paramParcel).build();
    previewPropertyName = paramParcel.readString();
  }
  
  private ShareOpenGraphContent(Builder paramBuilder)
  {
    super(paramBuilder);
    action = action;
    previewPropertyName = previewPropertyName;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ShareOpenGraphAction getAction()
  {
    return action;
  }
  
  public String getPreviewPropertyName()
  {
    return previewPropertyName;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(action, 0);
    paramParcel.writeString(previewPropertyName);
  }
  
  public static final class Builder
    extends ShareContent.Builder<ShareOpenGraphContent, Builder>
  {
    private ShareOpenGraphAction action;
    private String previewPropertyName;
    
    public ShareOpenGraphContent build()
    {
      return new ShareOpenGraphContent(this, null);
    }
    
    public Builder readFrom(ShareOpenGraphContent paramShareOpenGraphContent)
    {
      if (paramShareOpenGraphContent == null) {
        return this;
      }
      return ((Builder)super.readFrom(paramShareOpenGraphContent)).setAction(paramShareOpenGraphContent.getAction()).setPreviewPropertyName(paramShareOpenGraphContent.getPreviewPropertyName());
    }
    
    public Builder setAction(ShareOpenGraphAction paramShareOpenGraphAction)
    {
      if (paramShareOpenGraphAction == null) {}
      for (paramShareOpenGraphAction = null;; paramShareOpenGraphAction = new ShareOpenGraphAction.Builder().readFrom(paramShareOpenGraphAction).build())
      {
        action = paramShareOpenGraphAction;
        return this;
      }
    }
    
    public Builder setPreviewPropertyName(String paramString)
    {
      previewPropertyName = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */