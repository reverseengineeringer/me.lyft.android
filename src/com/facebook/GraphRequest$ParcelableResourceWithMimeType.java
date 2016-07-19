package com.facebook;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GraphRequest$ParcelableResourceWithMimeType<RESOURCE extends Parcelable>
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableResourceWithMimeType> CREATOR = new Parcelable.Creator()
  {
    public GraphRequest.ParcelableResourceWithMimeType createFromParcel(Parcel paramAnonymousParcel)
    {
      return new GraphRequest.ParcelableResourceWithMimeType(paramAnonymousParcel, null);
    }
    
    public GraphRequest.ParcelableResourceWithMimeType[] newArray(int paramAnonymousInt)
    {
      return new GraphRequest.ParcelableResourceWithMimeType[paramAnonymousInt];
    }
  };
  private final String mimeType;
  private final RESOURCE resource;
  
  private GraphRequest$ParcelableResourceWithMimeType(Parcel paramParcel)
  {
    mimeType = paramParcel.readString();
    resource = paramParcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
  }
  
  public GraphRequest$ParcelableResourceWithMimeType(RESOURCE paramRESOURCE, String paramString)
  {
    mimeType = paramString;
    resource = paramRESOURCE;
  }
  
  public int describeContents()
  {
    return 1;
  }
  
  public String getMimeType()
  {
    return mimeType;
  }
  
  public RESOURCE getResource()
  {
    return resource;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(mimeType);
    paramParcel.writeParcelable(resource, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.facebook.GraphRequest.ParcelableResourceWithMimeType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */