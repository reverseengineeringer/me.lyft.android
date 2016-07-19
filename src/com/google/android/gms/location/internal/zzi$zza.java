package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.internal.zzql;
import com.google.android.gms.internal.zzql.zza;
import com.google.android.gms.location.ActivityRecognitionRequest;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationRequestCreator;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zze;
import com.google.android.gms.location.zze.zza;
import java.util.List;

public abstract class zzi$zza
  extends Binder
  implements zzi
{
  public static zzi zzgw(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
    if ((localIInterface != null) && ((localIInterface instanceof zzi))) {
      return (zzi)localIInterface;
    }
    return new zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    boolean bool = false;
    Object localObject2;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      localObject2 = paramParcel1.createTypedArrayList(ParcelableGeofence.CREATOR);
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        zza((List)localObject2, (PendingIntent)localObject1, zzh.zza.zzgv(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
    case 57: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = (GeofencingRequest)GeofencingRequest.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label432;
        }
      }
      for (localObject2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject2 = null)
      {
        zza((GeofencingRequest)localObject1, (PendingIntent)localObject2, zzh.zza.zzgv(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        zza((PendingIntent)localObject1, zzh.zza.zzgv(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      zza(paramParcel1.createStringArray(), zzh.zza.zzgv(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      zza(zzh.zza.zzgv(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      long l = paramParcel1.readLong();
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        if (paramParcel1.readInt() == 0) {
          break label615;
        }
      }
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza(l, bool, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        bool = false;
        break;
      }
    case 70: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = (ActivityRecognitionRequest)ActivityRecognitionRequest.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label695;
        }
      }
      for (localObject2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject2 = null)
      {
        zza((ActivityRecognitionRequest)localObject1, (PendingIntent)localObject2, zzql.zza.zzdn(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zzb(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 64: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      paramParcel1 = zzkm(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 65: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        zza((PendingIntent)localObject1, zzql.zza.zzdn(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 66: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        zzb((PendingIntent)localObject1, zzql.zza.zzdn(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 60: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = (GestureRequest)GestureRequest.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label963;
        }
      }
      for (localObject2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject2 = null)
      {
        zza((GestureRequest)localObject1, (PendingIntent)localObject2, zzql.zza.zzdn(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 61: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        zzc((PendingIntent)localObject1, zzql.zza.zzdn(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 68: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        zzd((PendingIntent)localObject1, zzql.zza.zzdn(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 69: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        zze((PendingIntent)localObject1, zzql.zza.zzdn(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      paramParcel1 = zzbnk();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (LocationRequest)LocationRequest.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        zza((LocationRequest)localObject1, zze.zza.zzgs(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 20: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (LocationRequest)LocationRequest.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        zza((LocationRequest)localObject1, zze.zza.zzgs(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = (LocationRequest)LocationRequest.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1332;
        }
      }
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza((LocationRequest)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 52: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (LocationRequestInternal)LocationRequestInternal.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        zza((LocationRequestInternal)localObject1, zze.zza.zzgs(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 53: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = (LocationRequestInternal)LocationRequestInternal.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1451;
        }
      }
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza((LocationRequestInternal)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      zza(zze.zza.zzgs(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zzc(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 59: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (LocationRequestUpdateData)LocationRequestUpdateData.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {
        bool = true;
      }
      zzbx(bool);
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Location)Location.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zzc(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 21: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      paramParcel1 = zzkn(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (Location)Location.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        zza((Location)localObject1, paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
    case 67: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      zza(zzg.zza.zzgu(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 34: 
      label432:
      label615:
      label695:
      label963:
      label1332:
      label1451:
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      paramParcel1 = zzko(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
    if (paramParcel1.readInt() != 0) {}
    for (Object localObject1 = (LocationSettingsRequest)LocationSettingsRequest.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
    {
      zza((LocationSettingsRequest)localObject1, zzj.zza.zzgx(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
  }
  
  private static class zza
    implements zzi
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
    public void zza(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
      throws RemoteException
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 5
      //   3: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   6: astore 6
      //   8: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   11: astore 7
      //   13: aload 6
      //   15: ldc 32
      //   17: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   20: aload 6
      //   22: lload_1
      //   23: invokevirtual 40	android/os/Parcel:writeLong	(J)V
      //   26: iload_3
      //   27: ifeq +61 -> 88
      //   30: aload 6
      //   32: iload 5
      //   34: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   37: aload 4
      //   39: ifnull +55 -> 94
      //   42: aload 6
      //   44: iconst_1
      //   45: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   48: aload 4
      //   50: aload 6
      //   52: iconst_0
      //   53: invokevirtual 50	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
      //   56: aload_0
      //   57: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   60: iconst_5
      //   61: aload 6
      //   63: aload 7
      //   65: iconst_0
      //   66: invokeinterface 56 5 0
      //   71: pop
      //   72: aload 7
      //   74: invokevirtual 59	android/os/Parcel:readException	()V
      //   77: aload 7
      //   79: invokevirtual 62	android/os/Parcel:recycle	()V
      //   82: aload 6
      //   84: invokevirtual 62	android/os/Parcel:recycle	()V
      //   87: return
      //   88: iconst_0
      //   89: istore 5
      //   91: goto -61 -> 30
      //   94: aload 6
      //   96: iconst_0
      //   97: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   100: goto -44 -> 56
      //   103: astore 4
      //   105: aload 7
      //   107: invokevirtual 62	android/os/Parcel:recycle	()V
      //   110: aload 6
      //   112: invokevirtual 62	android/os/Parcel:recycle	()V
      //   115: aload 4
      //   117: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	118	0	this	zza
      //   0	118	1	paramLong	long
      //   0	118	3	paramBoolean	boolean
      //   0	118	4	paramPendingIntent	PendingIntent
      //   1	89	5	i	int
      //   6	105	6	localParcel1	Parcel
      //   11	95	7	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   13	26	103	finally
      //   30	37	103	finally
      //   42	56	103	finally
      //   56	77	103	finally
      //   94	100	103	finally
    }
    
    public void zza(PendingIntent paramPendingIntent, zzql paramzzql)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            if (paramzzql != null)
            {
              paramPendingIntent = paramzzql.asBinder();
              localParcel1.writeStrongBinder(paramPendingIntent);
              zzahn.transact(65, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramPendingIntent = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    public void zza(PendingIntent paramPendingIntent, zzh paramzzh, String paramString)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            if (paramzzh != null)
            {
              paramPendingIntent = paramzzh.asBinder();
              localParcel1.writeStrongBinder(paramPendingIntent);
              localParcel1.writeString(paramString);
              zzahn.transact(2, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramPendingIntent = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    /* Error */
    public void zza(Location paramLocation, int paramInt)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_3
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore 4
      //   9: aload_3
      //   10: ldc 32
      //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   15: aload_1
      //   16: ifnull +50 -> 66
      //   19: aload_3
      //   20: iconst_1
      //   21: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   24: aload_1
      //   25: aload_3
      //   26: iconst_0
      //   27: invokevirtual 82	android/location/Location:writeToParcel	(Landroid/os/Parcel;I)V
      //   30: aload_3
      //   31: iload_2
      //   32: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   35: aload_0
      //   36: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   39: bipush 26
      //   41: aload_3
      //   42: aload 4
      //   44: iconst_0
      //   45: invokeinterface 56 5 0
      //   50: pop
      //   51: aload 4
      //   53: invokevirtual 59	android/os/Parcel:readException	()V
      //   56: aload 4
      //   58: invokevirtual 62	android/os/Parcel:recycle	()V
      //   61: aload_3
      //   62: invokevirtual 62	android/os/Parcel:recycle	()V
      //   65: return
      //   66: aload_3
      //   67: iconst_0
      //   68: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   71: goto -41 -> 30
      //   74: astore_1
      //   75: aload 4
      //   77: invokevirtual 62	android/os/Parcel:recycle	()V
      //   80: aload_3
      //   81: invokevirtual 62	android/os/Parcel:recycle	()V
      //   84: aload_1
      //   85: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	86	0	this	zza
      //   0	86	1	paramLocation	Location
      //   0	86	2	paramInt	int
      //   3	78	3	localParcel1	Parcel
      //   7	69	4	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   9	15	74	finally
      //   19	30	74	finally
      //   30	56	74	finally
      //   66	71	74	finally
    }
    
    public void zza(ActivityRecognitionRequest paramActivityRecognitionRequest, PendingIntent paramPendingIntent, zzql paramzzql)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramActivityRecognitionRequest != null)
          {
            localParcel1.writeInt(1);
            paramActivityRecognitionRequest.writeToParcel(localParcel1, 0);
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramzzql == null) {
                break label132;
              }
              paramActivityRecognitionRequest = paramzzql.asBinder();
              localParcel1.writeStrongBinder(paramActivityRecognitionRequest);
              zzahn.transact(70, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          localParcel1.writeInt(0);
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        continue;
        label132:
        paramActivityRecognitionRequest = null;
      }
    }
    
    public void zza(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, zzh paramzzh)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramGeofencingRequest != null)
          {
            localParcel1.writeInt(1);
            paramGeofencingRequest.writeToParcel(localParcel1, 0);
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramzzh == null) {
                break label132;
              }
              paramGeofencingRequest = paramzzh.asBinder();
              localParcel1.writeStrongBinder(paramGeofencingRequest);
              zzahn.transact(57, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          localParcel1.writeInt(0);
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        continue;
        label132:
        paramGeofencingRequest = null;
      }
    }
    
    public void zza(GestureRequest paramGestureRequest, PendingIntent paramPendingIntent, zzql paramzzql)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramGestureRequest != null)
          {
            localParcel1.writeInt(1);
            paramGestureRequest.writeToParcel(localParcel1, 0);
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramzzql == null) {
                break label132;
              }
              paramGestureRequest = paramzzql.asBinder();
              localParcel1.writeStrongBinder(paramGestureRequest);
              zzahn.transact(60, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          localParcel1.writeInt(0);
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
        continue;
        label132:
        paramGestureRequest = null;
      }
    }
    
    public void zza(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramLocationRequest != null)
          {
            localParcel1.writeInt(1);
            paramLocationRequest.writeToParcel(localParcel1, 0);
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              zzahn.transact(9, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          localParcel1.writeInt(0);
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    public void zza(LocationRequest paramLocationRequest, zze paramzze)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramLocationRequest != null)
          {
            localParcel1.writeInt(1);
            paramLocationRequest.writeToParcel(localParcel1, 0);
            if (paramzze != null)
            {
              paramLocationRequest = paramzze.asBinder();
              localParcel1.writeStrongBinder(paramLocationRequest);
              zzahn.transact(8, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramLocationRequest = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    public void zza(LocationRequest paramLocationRequest, zze paramzze, String paramString)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramLocationRequest != null)
          {
            localParcel1.writeInt(1);
            paramLocationRequest.writeToParcel(localParcel1, 0);
            if (paramzze != null)
            {
              paramLocationRequest = paramzze.asBinder();
              localParcel1.writeStrongBinder(paramLocationRequest);
              localParcel1.writeString(paramString);
              zzahn.transact(20, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramLocationRequest = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    public void zza(LocationSettingsRequest paramLocationSettingsRequest, zzj paramzzj, String paramString)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramLocationSettingsRequest != null)
          {
            localParcel1.writeInt(1);
            paramLocationSettingsRequest.writeToParcel(localParcel1, 0);
            if (paramzzj != null)
            {
              paramLocationSettingsRequest = paramzzj.asBinder();
              localParcel1.writeStrongBinder(paramLocationSettingsRequest);
              localParcel1.writeString(paramString);
              zzahn.transact(63, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramLocationSettingsRequest = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    public void zza(LocationRequestInternal paramLocationRequestInternal, PendingIntent paramPendingIntent)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramLocationRequestInternal != null)
          {
            localParcel1.writeInt(1);
            paramLocationRequestInternal.writeToParcel(localParcel1, 0);
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              zzahn.transact(53, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          localParcel1.writeInt(0);
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    public void zza(LocationRequestInternal paramLocationRequestInternal, zze paramzze)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramLocationRequestInternal != null)
          {
            localParcel1.writeInt(1);
            paramLocationRequestInternal.writeToParcel(localParcel1, 0);
            if (paramzze != null)
            {
              paramLocationRequestInternal = paramzze.asBinder();
              localParcel1.writeStrongBinder(paramLocationRequestInternal);
              zzahn.transact(52, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramLocationRequestInternal = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    /* Error */
    public void zza(LocationRequestUpdateData paramLocationRequestUpdateData)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 32
      //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_1
      //   15: ifnull +42 -> 57
      //   18: aload_2
      //   19: iconst_1
      //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   23: aload_1
      //   24: aload_2
      //   25: iconst_0
      //   26: invokevirtual 119	com/google/android/gms/location/internal/LocationRequestUpdateData:writeToParcel	(Landroid/os/Parcel;I)V
      //   29: aload_0
      //   30: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   33: bipush 59
      //   35: aload_2
      //   36: aload_3
      //   37: iconst_0
      //   38: invokeinterface 56 5 0
      //   43: pop
      //   44: aload_3
      //   45: invokevirtual 59	android/os/Parcel:readException	()V
      //   48: aload_3
      //   49: invokevirtual 62	android/os/Parcel:recycle	()V
      //   52: aload_2
      //   53: invokevirtual 62	android/os/Parcel:recycle	()V
      //   56: return
      //   57: aload_2
      //   58: iconst_0
      //   59: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   62: goto -33 -> 29
      //   65: astore_1
      //   66: aload_3
      //   67: invokevirtual 62	android/os/Parcel:recycle	()V
      //   70: aload_2
      //   71: invokevirtual 62	android/os/Parcel:recycle	()V
      //   74: aload_1
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	zza
      //   0	76	1	paramLocationRequestUpdateData	LocationRequestUpdateData
      //   3	68	2	localParcel1	Parcel
      //   7	60	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	14	65	finally
      //   18	29	65	finally
      //   29	48	65	finally
      //   57	62	65	finally
    }
    
    /* Error */
    public void zza(zzg paramzzg)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 32
      //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_1
      //   15: ifnull +43 -> 58
      //   18: aload_1
      //   19: invokeinterface 123 1 0
      //   24: astore_1
      //   25: aload_2
      //   26: aload_1
      //   27: invokevirtual 71	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   30: aload_0
      //   31: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   34: bipush 67
      //   36: aload_2
      //   37: aload_3
      //   38: iconst_0
      //   39: invokeinterface 56 5 0
      //   44: pop
      //   45: aload_3
      //   46: invokevirtual 59	android/os/Parcel:readException	()V
      //   49: aload_3
      //   50: invokevirtual 62	android/os/Parcel:recycle	()V
      //   53: aload_2
      //   54: invokevirtual 62	android/os/Parcel:recycle	()V
      //   57: return
      //   58: aconst_null
      //   59: astore_1
      //   60: goto -35 -> 25
      //   63: astore_1
      //   64: aload_3
      //   65: invokevirtual 62	android/os/Parcel:recycle	()V
      //   68: aload_2
      //   69: invokevirtual 62	android/os/Parcel:recycle	()V
      //   72: aload_1
      //   73: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	zza
      //   0	74	1	paramzzg	zzg
      //   3	66	2	localParcel1	Parcel
      //   7	58	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	14	63	finally
      //   18	25	63	finally
      //   25	49	63	finally
    }
    
    /* Error */
    public void zza(zzh paramzzh, String paramString)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_3
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore 4
      //   9: aload_3
      //   10: ldc 32
      //   12: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   15: aload_1
      //   16: ifnull +50 -> 66
      //   19: aload_1
      //   20: invokeinterface 75 1 0
      //   25: astore_1
      //   26: aload_3
      //   27: aload_1
      //   28: invokevirtual 71	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   31: aload_3
      //   32: aload_2
      //   33: invokevirtual 78	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   36: aload_0
      //   37: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   40: iconst_4
      //   41: aload_3
      //   42: aload 4
      //   44: iconst_0
      //   45: invokeinterface 56 5 0
      //   50: pop
      //   51: aload 4
      //   53: invokevirtual 59	android/os/Parcel:readException	()V
      //   56: aload 4
      //   58: invokevirtual 62	android/os/Parcel:recycle	()V
      //   61: aload_3
      //   62: invokevirtual 62	android/os/Parcel:recycle	()V
      //   65: return
      //   66: aconst_null
      //   67: astore_1
      //   68: goto -42 -> 26
      //   71: astore_1
      //   72: aload 4
      //   74: invokevirtual 62	android/os/Parcel:recycle	()V
      //   77: aload_3
      //   78: invokevirtual 62	android/os/Parcel:recycle	()V
      //   81: aload_1
      //   82: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	zza
      //   0	83	1	paramzzh	zzh
      //   0	83	2	paramString	String
      //   3	75	3	localParcel1	Parcel
      //   7	66	4	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   9	15	71	finally
      //   19	26	71	finally
      //   26	56	71	finally
    }
    
    /* Error */
    public void zza(zze paramzze)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 32
      //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_1
      //   15: ifnull +43 -> 58
      //   18: aload_1
      //   19: invokeinterface 102 1 0
      //   24: astore_1
      //   25: aload_2
      //   26: aload_1
      //   27: invokevirtual 71	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   30: aload_0
      //   31: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   34: bipush 10
      //   36: aload_2
      //   37: aload_3
      //   38: iconst_0
      //   39: invokeinterface 56 5 0
      //   44: pop
      //   45: aload_3
      //   46: invokevirtual 59	android/os/Parcel:readException	()V
      //   49: aload_3
      //   50: invokevirtual 62	android/os/Parcel:recycle	()V
      //   53: aload_2
      //   54: invokevirtual 62	android/os/Parcel:recycle	()V
      //   57: return
      //   58: aconst_null
      //   59: astore_1
      //   60: goto -35 -> 25
      //   63: astore_1
      //   64: aload_3
      //   65: invokevirtual 62	android/os/Parcel:recycle	()V
      //   68: aload_2
      //   69: invokevirtual 62	android/os/Parcel:recycle	()V
      //   72: aload_1
      //   73: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	zza
      //   0	74	1	paramzze	zze
      //   3	66	2	localParcel1	Parcel
      //   7	58	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	14	63	finally
      //   18	25	63	finally
      //   25	49	63	finally
    }
    
    public void zza(List<ParcelableGeofence> paramList, PendingIntent paramPendingIntent, zzh paramzzh, String paramString)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          localParcel1.writeTypedList(paramList);
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            if (paramzzh != null)
            {
              paramList = paramzzh.asBinder();
              localParcel1.writeStrongBinder(paramList);
              localParcel1.writeString(paramString);
              zzahn.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramList = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    /* Error */
    public void zza(String[] paramArrayOfString, zzh paramzzh, String paramString)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore 4
      //   5: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore 5
      //   10: aload 4
      //   12: ldc 32
      //   14: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   17: aload 4
      //   19: aload_1
      //   20: invokevirtual 137	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
      //   23: aload_2
      //   24: ifnull +54 -> 78
      //   27: aload_2
      //   28: invokeinterface 75 1 0
      //   33: astore_1
      //   34: aload 4
      //   36: aload_1
      //   37: invokevirtual 71	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   40: aload 4
      //   42: aload_3
      //   43: invokevirtual 78	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   46: aload_0
      //   47: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   50: iconst_3
      //   51: aload 4
      //   53: aload 5
      //   55: iconst_0
      //   56: invokeinterface 56 5 0
      //   61: pop
      //   62: aload 5
      //   64: invokevirtual 59	android/os/Parcel:readException	()V
      //   67: aload 5
      //   69: invokevirtual 62	android/os/Parcel:recycle	()V
      //   72: aload 4
      //   74: invokevirtual 62	android/os/Parcel:recycle	()V
      //   77: return
      //   78: aconst_null
      //   79: astore_1
      //   80: goto -46 -> 34
      //   83: astore_1
      //   84: aload 5
      //   86: invokevirtual 62	android/os/Parcel:recycle	()V
      //   89: aload 4
      //   91: invokevirtual 62	android/os/Parcel:recycle	()V
      //   94: aload_1
      //   95: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	96	0	this	zza
      //   0	96	1	paramArrayOfString	String[]
      //   0	96	2	paramzzh	zzh
      //   0	96	3	paramString	String
      //   3	87	4	localParcel1	Parcel
      //   8	77	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   10	23	83	finally
      //   27	34	83	finally
      //   34	67	83	finally
    }
    
    /* Error */
    public void zzb(PendingIntent paramPendingIntent)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 32
      //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_1
      //   15: ifnull +42 -> 57
      //   18: aload_2
      //   19: iconst_1
      //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   23: aload_1
      //   24: aload_2
      //   25: iconst_0
      //   26: invokevirtual 50	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
      //   29: aload_0
      //   30: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   33: bipush 6
      //   35: aload_2
      //   36: aload_3
      //   37: iconst_0
      //   38: invokeinterface 56 5 0
      //   43: pop
      //   44: aload_3
      //   45: invokevirtual 59	android/os/Parcel:readException	()V
      //   48: aload_3
      //   49: invokevirtual 62	android/os/Parcel:recycle	()V
      //   52: aload_2
      //   53: invokevirtual 62	android/os/Parcel:recycle	()V
      //   56: return
      //   57: aload_2
      //   58: iconst_0
      //   59: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   62: goto -33 -> 29
      //   65: astore_1
      //   66: aload_3
      //   67: invokevirtual 62	android/os/Parcel:recycle	()V
      //   70: aload_2
      //   71: invokevirtual 62	android/os/Parcel:recycle	()V
      //   74: aload_1
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	zza
      //   0	76	1	paramPendingIntent	PendingIntent
      //   3	68	2	localParcel1	Parcel
      //   7	60	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	14	65	finally
      //   18	29	65	finally
      //   29	48	65	finally
      //   57	62	65	finally
    }
    
    public void zzb(PendingIntent paramPendingIntent, zzql paramzzql)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            if (paramzzql != null)
            {
              paramPendingIntent = paramzzql.asBinder();
              localParcel1.writeStrongBinder(paramPendingIntent);
              zzahn.transact(66, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramPendingIntent = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    /* Error */
    public Location zzbnk()
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 32
      //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_0
      //   15: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   18: bipush 7
      //   20: aload_2
      //   21: aload_3
      //   22: iconst_0
      //   23: invokeinterface 56 5 0
      //   28: pop
      //   29: aload_3
      //   30: invokevirtual 59	android/os/Parcel:readException	()V
      //   33: aload_3
      //   34: invokevirtual 145	android/os/Parcel:readInt	()I
      //   37: ifeq +26 -> 63
      //   40: getstatic 149	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
      //   43: aload_3
      //   44: invokeinterface 155 2 0
      //   49: checkcast 81	android/location/Location
      //   52: astore_1
      //   53: aload_3
      //   54: invokevirtual 62	android/os/Parcel:recycle	()V
      //   57: aload_2
      //   58: invokevirtual 62	android/os/Parcel:recycle	()V
      //   61: aload_1
      //   62: areturn
      //   63: aconst_null
      //   64: astore_1
      //   65: goto -12 -> 53
      //   68: astore_1
      //   69: aload_3
      //   70: invokevirtual 62	android/os/Parcel:recycle	()V
      //   73: aload_2
      //   74: invokevirtual 62	android/os/Parcel:recycle	()V
      //   77: aload_1
      //   78: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	79	0	this	zza
      //   52	13	1	localLocation	Location
      //   68	10	1	localObject	Object
      //   3	71	2	localParcel1	Parcel
      //   7	63	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	53	68	finally
    }
    
    public void zzbx(boolean paramBoolean)
      throws RemoteException
    {
      int i = 0;
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramBoolean) {
          i = 1;
        }
        localParcel1.writeInt(i);
        zzahn.transact(12, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    
    /* Error */
    public void zzc(PendingIntent paramPendingIntent)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 32
      //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_1
      //   15: ifnull +42 -> 57
      //   18: aload_2
      //   19: iconst_1
      //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   23: aload_1
      //   24: aload_2
      //   25: iconst_0
      //   26: invokevirtual 50	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
      //   29: aload_0
      //   30: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   33: bipush 11
      //   35: aload_2
      //   36: aload_3
      //   37: iconst_0
      //   38: invokeinterface 56 5 0
      //   43: pop
      //   44: aload_3
      //   45: invokevirtual 59	android/os/Parcel:readException	()V
      //   48: aload_3
      //   49: invokevirtual 62	android/os/Parcel:recycle	()V
      //   52: aload_2
      //   53: invokevirtual 62	android/os/Parcel:recycle	()V
      //   56: return
      //   57: aload_2
      //   58: iconst_0
      //   59: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   62: goto -33 -> 29
      //   65: astore_1
      //   66: aload_3
      //   67: invokevirtual 62	android/os/Parcel:recycle	()V
      //   70: aload_2
      //   71: invokevirtual 62	android/os/Parcel:recycle	()V
      //   74: aload_1
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	zza
      //   0	76	1	paramPendingIntent	PendingIntent
      //   3	68	2	localParcel1	Parcel
      //   7	60	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	14	65	finally
      //   18	29	65	finally
      //   29	48	65	finally
      //   57	62	65	finally
    }
    
    public void zzc(PendingIntent paramPendingIntent, zzql paramzzql)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            if (paramzzql != null)
            {
              paramPendingIntent = paramzzql.asBinder();
              localParcel1.writeStrongBinder(paramPendingIntent);
              zzahn.transact(61, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramPendingIntent = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    /* Error */
    public void zzc(Location paramLocation)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 32
      //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_1
      //   15: ifnull +42 -> 57
      //   18: aload_2
      //   19: iconst_1
      //   20: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   23: aload_1
      //   24: aload_2
      //   25: iconst_0
      //   26: invokevirtual 82	android/location/Location:writeToParcel	(Landroid/os/Parcel;I)V
      //   29: aload_0
      //   30: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   33: bipush 13
      //   35: aload_2
      //   36: aload_3
      //   37: iconst_0
      //   38: invokeinterface 56 5 0
      //   43: pop
      //   44: aload_3
      //   45: invokevirtual 59	android/os/Parcel:readException	()V
      //   48: aload_3
      //   49: invokevirtual 62	android/os/Parcel:recycle	()V
      //   52: aload_2
      //   53: invokevirtual 62	android/os/Parcel:recycle	()V
      //   56: return
      //   57: aload_2
      //   58: iconst_0
      //   59: invokevirtual 44	android/os/Parcel:writeInt	(I)V
      //   62: goto -33 -> 29
      //   65: astore_1
      //   66: aload_3
      //   67: invokevirtual 62	android/os/Parcel:recycle	()V
      //   70: aload_2
      //   71: invokevirtual 62	android/os/Parcel:recycle	()V
      //   74: aload_1
      //   75: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	zza
      //   0	76	1	paramLocation	Location
      //   3	68	2	localParcel1	Parcel
      //   7	60	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	14	65	finally
      //   18	29	65	finally
      //   29	48	65	finally
      //   57	62	65	finally
    }
    
    public void zzd(PendingIntent paramPendingIntent, zzql paramzzql)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            if (paramzzql != null)
            {
              paramPendingIntent = paramzzql.asBinder();
              localParcel1.writeStrongBinder(paramPendingIntent);
              zzahn.transact(68, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramPendingIntent = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    public void zze(PendingIntent paramPendingIntent, zzql paramzzql)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramPendingIntent != null)
          {
            localParcel1.writeInt(1);
            paramPendingIntent.writeToParcel(localParcel1, 0);
            if (paramzzql != null)
            {
              paramPendingIntent = paramzzql.asBinder();
              localParcel1.writeStrongBinder(paramPendingIntent);
              zzahn.transact(69, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          paramPendingIntent = null;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
    
    /* Error */
    public ActivityRecognitionResult zzkm(String paramString)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 32
      //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_2
      //   15: aload_1
      //   16: invokevirtual 78	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   19: aload_0
      //   20: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   23: bipush 64
      //   25: aload_2
      //   26: aload_3
      //   27: iconst_0
      //   28: invokeinterface 56 5 0
      //   33: pop
      //   34: aload_3
      //   35: invokevirtual 59	android/os/Parcel:readException	()V
      //   38: aload_3
      //   39: invokevirtual 145	android/os/Parcel:readInt	()I
      //   42: ifeq +24 -> 66
      //   45: getstatic 168	com/google/android/gms/location/ActivityRecognitionResult:CREATOR	Lcom/google/android/gms/location/ActivityRecognitionResultCreator;
      //   48: aload_3
      //   49: invokevirtual 171	com/google/android/gms/location/ActivityRecognitionResultCreator:createFromParcel	(Landroid/os/Parcel;)Ljava/lang/Object;
      //   52: checkcast 165	com/google/android/gms/location/ActivityRecognitionResult
      //   55: astore_1
      //   56: aload_3
      //   57: invokevirtual 62	android/os/Parcel:recycle	()V
      //   60: aload_2
      //   61: invokevirtual 62	android/os/Parcel:recycle	()V
      //   64: aload_1
      //   65: areturn
      //   66: aconst_null
      //   67: astore_1
      //   68: goto -12 -> 56
      //   71: astore_1
      //   72: aload_3
      //   73: invokevirtual 62	android/os/Parcel:recycle	()V
      //   76: aload_2
      //   77: invokevirtual 62	android/os/Parcel:recycle	()V
      //   80: aload_1
      //   81: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	82	0	this	zza
      //   0	82	1	paramString	String
      //   3	74	2	localParcel1	Parcel
      //   7	66	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	56	71	finally
    }
    
    /* Error */
    public Location zzkn(String paramString)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 32
      //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_2
      //   15: aload_1
      //   16: invokevirtual 78	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   19: aload_0
      //   20: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   23: bipush 21
      //   25: aload_2
      //   26: aload_3
      //   27: iconst_0
      //   28: invokeinterface 56 5 0
      //   33: pop
      //   34: aload_3
      //   35: invokevirtual 59	android/os/Parcel:readException	()V
      //   38: aload_3
      //   39: invokevirtual 145	android/os/Parcel:readInt	()I
      //   42: ifeq +26 -> 68
      //   45: getstatic 149	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
      //   48: aload_3
      //   49: invokeinterface 155 2 0
      //   54: checkcast 81	android/location/Location
      //   57: astore_1
      //   58: aload_3
      //   59: invokevirtual 62	android/os/Parcel:recycle	()V
      //   62: aload_2
      //   63: invokevirtual 62	android/os/Parcel:recycle	()V
      //   66: aload_1
      //   67: areturn
      //   68: aconst_null
      //   69: astore_1
      //   70: goto -12 -> 58
      //   73: astore_1
      //   74: aload_3
      //   75: invokevirtual 62	android/os/Parcel:recycle	()V
      //   78: aload_2
      //   79: invokevirtual 62	android/os/Parcel:recycle	()V
      //   82: aload_1
      //   83: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	84	0	this	zza
      //   0	84	1	paramString	String
      //   3	76	2	localParcel1	Parcel
      //   7	68	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	58	73	finally
    }
    
    /* Error */
    public LocationAvailability zzko(String paramString)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore_2
      //   4: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 32
      //   11: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   14: aload_2
      //   15: aload_1
      //   16: invokevirtual 78	android/os/Parcel:writeString	(Ljava/lang/String;)V
      //   19: aload_0
      //   20: getfield 18	com/google/android/gms/location/internal/zzi$zza$zza:zzahn	Landroid/os/IBinder;
      //   23: bipush 34
      //   25: aload_2
      //   26: aload_3
      //   27: iconst_0
      //   28: invokeinterface 56 5 0
      //   33: pop
      //   34: aload_3
      //   35: invokevirtual 59	android/os/Parcel:readException	()V
      //   38: aload_3
      //   39: invokevirtual 145	android/os/Parcel:readInt	()I
      //   42: ifeq +24 -> 66
      //   45: getstatic 180	com/google/android/gms/location/LocationAvailability:CREATOR	Lcom/google/android/gms/location/LocationAvailabilityCreator;
      //   48: aload_3
      //   49: invokevirtual 183	com/google/android/gms/location/LocationAvailabilityCreator:createFromParcel	(Landroid/os/Parcel;)Ljava/lang/Object;
      //   52: checkcast 177	com/google/android/gms/location/LocationAvailability
      //   55: astore_1
      //   56: aload_3
      //   57: invokevirtual 62	android/os/Parcel:recycle	()V
      //   60: aload_2
      //   61: invokevirtual 62	android/os/Parcel:recycle	()V
      //   64: aload_1
      //   65: areturn
      //   66: aconst_null
      //   67: astore_1
      //   68: goto -12 -> 56
      //   71: astore_1
      //   72: aload_3
      //   73: invokevirtual 62	android/os/Parcel:recycle	()V
      //   76: aload_2
      //   77: invokevirtual 62	android/os/Parcel:recycle	()V
      //   80: aload_1
      //   81: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	82	0	this	zza
      //   0	82	1	paramString	String
      //   3	74	2	localParcel1	Parcel
      //   7	66	3	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   8	56	71	finally
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzi.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */