package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class DrawerLayout$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
  {
    public DrawerLayout.SavedState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new DrawerLayout.SavedState(paramAnonymousParcel);
    }
    
    public DrawerLayout.SavedState[] newArray(int paramAnonymousInt)
    {
      return new DrawerLayout.SavedState[paramAnonymousInt];
    }
  };
  int lockModeEnd;
  int lockModeLeft;
  int lockModeRight;
  int lockModeStart;
  int openDrawerGravity = 0;
  
  public DrawerLayout$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    openDrawerGravity = paramParcel.readInt();
    lockModeLeft = paramParcel.readInt();
    lockModeRight = paramParcel.readInt();
    lockModeStart = paramParcel.readInt();
    lockModeEnd = paramParcel.readInt();
  }
  
  public DrawerLayout$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(openDrawerGravity);
    paramParcel.writeInt(lockModeLeft);
    paramParcel.writeInt(lockModeRight);
    paramParcel.writeInt(lockModeStart);
    paramParcel.writeInt(lockModeEnd);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.DrawerLayout.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */