package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class GameRequestContent$1
  implements Parcelable.Creator<GameRequestContent>
{
  public GameRequestContent createFromParcel(Parcel paramParcel)
  {
    return new GameRequestContent(paramParcel);
  }
  
  public GameRequestContent[] newArray(int paramInt)
  {
    return new GameRequestContent[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.facebook.share.model.GameRequestContent.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */