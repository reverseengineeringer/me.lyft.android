package com.google.android.gms.location.places.personalized;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract class zzc$zza
  extends Binder
  implements zzc
{
  public static zzc zzhe(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.places.personalized.IAliasedPlacesCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof zzc))) {
      return (zzc)localIInterface;
    }
    return new zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.location.places.personalized.IAliasedPlacesCallbacks");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.location.places.personalized.IAliasedPlacesCallbacks");
      paramParcel2 = (Parcel)localObject1;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (AliasedPlacesResult)AliasedPlacesResult.CREATOR.createFromParcel(paramParcel1);
      }
      zza(paramParcel2);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.location.places.personalized.IAliasedPlacesCallbacks");
      paramParcel2 = (Parcel)localObject2;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (AliasedPlacesResult)AliasedPlacesResult.CREATOR.createFromParcel(paramParcel1);
      }
      zzb(paramParcel2);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.location.places.personalized.IAliasedPlacesCallbacks");
    paramParcel2 = (Parcel)localObject3;
    if (paramParcel1.readInt() != 0) {
      paramParcel2 = (AliasedPlacesResult)AliasedPlacesResult.CREATOR.createFromParcel(paramParcel1);
    }
    zzc(paramParcel2);
    return true;
  }
  
  private static class zza
    implements zzc
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
    
    /* Error */
    public void zza(AliasedPlacesResult paramAliasedPlacesResult)
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
      //   22: invokevirtual 46	com/google/android/gms/location/places/personalized/AliasedPlacesResult:writeToParcel	(Landroid/os/Parcel;I)V
      //   25: aload_0
      //   26: getfield 18	com/google/android/gms/location/places/personalized/zzc$zza$zza:zzahn	Landroid/os/IBinder;
      //   29: iconst_2
      //   30: aload_2
      //   31: aconst_null
      //   32: iconst_1
      //   33: invokeinterface 52 5 0
      //   38: pop
      //   39: aload_2
      //   40: invokevirtual 55	android/os/Parcel:recycle	()V
      //   43: return
      //   44: aload_2
      //   45: iconst_0
      //   46: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   49: goto -24 -> 25
      //   52: astore_1
      //   53: aload_2
      //   54: invokevirtual 55	android/os/Parcel:recycle	()V
      //   57: aload_1
      //   58: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	59	0	this	zza
      //   0	59	1	paramAliasedPlacesResult	AliasedPlacesResult
      //   3	51	2	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   4	10	52	finally
      //   14	25	52	finally
      //   25	39	52	finally
      //   44	49	52	finally
    }
    
    /* Error */
    public void zzb(AliasedPlacesResult paramAliasedPlacesResult)
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
      //   22: invokevirtual 46	com/google/android/gms/location/places/personalized/AliasedPlacesResult:writeToParcel	(Landroid/os/Parcel;I)V
      //   25: aload_0
      //   26: getfield 18	com/google/android/gms/location/places/personalized/zzc$zza$zza:zzahn	Landroid/os/IBinder;
      //   29: iconst_3
      //   30: aload_2
      //   31: aconst_null
      //   32: iconst_1
      //   33: invokeinterface 52 5 0
      //   38: pop
      //   39: aload_2
      //   40: invokevirtual 55	android/os/Parcel:recycle	()V
      //   43: return
      //   44: aload_2
      //   45: iconst_0
      //   46: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   49: goto -24 -> 25
      //   52: astore_1
      //   53: aload_2
      //   54: invokevirtual 55	android/os/Parcel:recycle	()V
      //   57: aload_1
      //   58: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	59	0	this	zza
      //   0	59	1	paramAliasedPlacesResult	AliasedPlacesResult
      //   3	51	2	localParcel	Parcel
      // Exception table:
      //   from	to	target	type
      //   4	10	52	finally
      //   14	25	52	finally
      //   25	39	52	finally
      //   44	49	52	finally
    }
    
    /* Error */
    public void zzc(AliasedPlacesResult paramAliasedPlacesResult)
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
      //   22: invokevirtual 46	com/google/android/gms/location/places/personalized/AliasedPlacesResult:writeToParcel	(Landroid/os/Parcel;I)V
      //   25: aload_0
      //   26: getfield 18	com/google/android/gms/location/places/personalized/zzc$zza$zza:zzahn	Landroid/os/IBinder;
      //   29: iconst_4
      //   30: aload_2
      //   31: aconst_null
      //   32: iconst_1
      //   33: invokeinterface 52 5 0
      //   38: pop
      //   39: aload_2
      //   40: invokevirtual 55	android/os/Parcel:recycle	()V
      //   43: return
      //   44: aload_2
      //   45: iconst_0
      //   46: invokevirtual 40	android/os/Parcel:writeInt	(I)V
      //   49: goto -24 -> 25
      //   52: astore_1
      //   53: aload_2
      //   54: invokevirtual 55	android/os/Parcel:recycle	()V
      //   57: aload_1
      //   58: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	59	0	this	zza
      //   0	59	1	paramAliasedPlacesResult	AliasedPlacesResult
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

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.zzc.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */