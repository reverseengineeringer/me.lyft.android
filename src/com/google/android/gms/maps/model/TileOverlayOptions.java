package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzi;
import com.google.android.gms.maps.model.internal.zzi.zza;

public final class TileOverlayOptions
  implements SafeParcelable
{
  public static final zzo CREATOR = new zzo();
  private zzi aiU;
  private TileProvider aiV;
  private boolean aiW = true;
  private float aim;
  private boolean ain = true;
  private float aiu = 0.0F;
  private final int mVersionCode;
  
  public TileOverlayOptions()
  {
    mVersionCode = 1;
  }
  
  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat1, boolean paramBoolean2, float paramFloat2)
  {
    mVersionCode = paramInt;
    aiU = zzi.zza.zzja(paramIBinder);
    if (aiU == null) {}
    for (paramIBinder = null;; paramIBinder = new TileProvider()
        {
          private final zzi aiX = TileOverlayOptions.zza(TileOverlayOptions.this);
          
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            try
            {
              Tile localTile = aiX.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
              return localTile;
            }
            catch (RemoteException localRemoteException) {}
            return null;
          }
        })
    {
      aiV = paramIBinder;
      ain = paramBoolean1;
      aim = paramFloat1;
      aiW = paramBoolean2;
      aiu = paramFloat2;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public TileOverlayOptions fadeIn(boolean paramBoolean)
  {
    aiW = paramBoolean;
    return this;
  }
  
  public boolean getFadeIn()
  {
    return aiW;
  }
  
  public float getTransparency()
  {
    return aiu;
  }
  
  int getVersionCode()
  {
    return mVersionCode;
  }
  
  public float getZIndex()
  {
    return aim;
  }
  
  public boolean isVisible()
  {
    return ain;
  }
  
  public TileOverlayOptions tileProvider(final TileProvider paramTileProvider)
  {
    aiV = paramTileProvider;
    if (aiV == null) {}
    for (paramTileProvider = null;; paramTileProvider = new zzi.zza()
        {
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            return paramTileProvider.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          }
        })
    {
      aiU = paramTileProvider;
      return this;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
  
  public TileOverlayOptions zIndex(float paramFloat)
  {
    aim = paramFloat;
    return this;
  }
  
  IBinder zzbqj()
  {
    return aiU.asBinder();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.maps.model.TileOverlayOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */