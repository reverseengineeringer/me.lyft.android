package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;

public abstract interface zzvs
  extends IInterface
{
  public abstract void zza(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
    throws RemoteException;
  
  public abstract void zzdy(Status paramStatus)
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzvs
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.search.internal.ISearchAuthCallbacks");
    }
    
    public static zzvs zzke(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.search.internal.ISearchAuthCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof zzvs))) {
        return (zzvs)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.search.internal.ISearchAuthCallbacks");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.search.internal.ISearchAuthCallbacks");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label113;
          }
        }
        label113:
        for (paramParcel1 = (GoogleNowAuthState)GoogleNowAuthState.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          zza(paramParcel2, paramParcel1);
          return true;
          paramParcel2 = null;
          break;
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.search.internal.ISearchAuthCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zzdy(paramParcel1);
        return true;
      }
    }
    
    private static class zza
      implements zzvs
    {
      private IBinder zzahn;
      
      zza(IBinder paramIBinder)
      {
        zzahn = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return zzahn;
      }
      
      public void zza(Status paramStatus, GoogleNowAuthState paramGoogleNowAuthState)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthCallbacks");
            if (paramStatus != null)
            {
              localParcel.writeInt(1);
              paramStatus.writeToParcel(localParcel, 0);
              if (paramGoogleNowAuthState != null)
              {
                localParcel.writeInt(1);
                paramGoogleNowAuthState.writeToParcel(localParcel, 0);
                zzahn.transact(1, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      /* Error */
      public void zzdy(Status paramStatus)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 32
        //   7: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +33 -> 44
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 46	com/google/android/gms/common/api/Status:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 18	com/google/android/gms/internal/zzvs$zza$zza:zzahn	Landroid/os/IBinder;
        //   29: iconst_2
        //   30: aload_2
        //   31: aconst_null
        //   32: iconst_1
        //   33: invokeinterface 55 5 0
        //   38: pop
        //   39: aload_2
        //   40: invokevirtual 58	android/os/Parcel:recycle	()V
        //   43: return
        //   44: aload_2
        //   45: iconst_0
        //   46: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   49: goto -24 -> 25
        //   52: astore_1
        //   53: aload_2
        //   54: invokevirtual 58	android/os/Parcel:recycle	()V
        //   57: aload_1
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	zza
        //   0	59	1	paramStatus	Status
        //   3	51	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	52	finally
        //   14	25	52	finally
        //   25	39	52	finally
        //   44	49	52	finally
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzvs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */