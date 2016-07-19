package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;

@zzir
class zzv
  implements SensorEventListener
{
  private final SensorManager zzbum;
  private final Object zzbun;
  private final Display zzbuo;
  private final float[] zzbup;
  private final float[] zzbuq;
  private float[] zzbur;
  private Handler zzbus;
  private zza zzbut;
  
  zzv(Context paramContext)
  {
    zzbum = ((SensorManager)paramContext.getSystemService("sensor"));
    zzbuo = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    zzbup = new float[9];
    zzbuq = new float[9];
    zzbun = new Object();
  }
  
  private void zzf(int paramInt1, int paramInt2)
  {
    float f = zzbuq[paramInt1];
    zzbuq[paramInt1] = zzbuq[paramInt2];
    zzbuq[paramInt2] = f;
  }
  
  int getRotation()
  {
    return zzbuo.getRotation();
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    zza(values);
  }
  
  void start()
  {
    if (zzbus != null) {}
    Sensor localSensor;
    do
    {
      return;
      localSensor = zzbum.getDefaultSensor(11);
      if (localSensor == null)
      {
        zzkh.e("No Sensor of TYPE_ROTATION_VECTOR");
        return;
      }
      HandlerThread localHandlerThread = new HandlerThread("OrientationMonitor");
      localHandlerThread.start();
      zzbus = new Handler(localHandlerThread.getLooper());
    } while (zzbum.registerListener(this, localSensor, 0, zzbus));
    zzkh.e("SensorManager.registerListener failed.");
    stop();
  }
  
  void stop()
  {
    if (zzbus == null) {
      return;
    }
    zzbum.unregisterListener(this);
    zzbus.post(new Runnable()
    {
      public void run()
      {
        Looper.myLooper().quit();
      }
    });
    zzbus = null;
  }
  
  void zza(zza paramzza)
  {
    zzbut = paramzza;
  }
  
  void zza(float[] arg1)
  {
    if ((???[0] == 0.0F) && (???[1] == 0.0F) && (???[2] == 0.0F)) {}
    for (;;)
    {
      return;
      synchronized (zzbun)
      {
        if (zzbur == null) {
          zzbur = new float[9];
        }
        SensorManager.getRotationMatrixFromVector(zzbup, ???);
        switch (getRotation())
        {
        default: 
          System.arraycopy(zzbup, 0, zzbuq, 0, 9);
          label103:
          zzf(1, 3);
          zzf(2, 6);
          zzf(5, 7);
        }
      }
      synchronized (zzbun)
      {
        System.arraycopy(zzbuq, 0, zzbur, 0, 9);
        if (zzbut == null) {
          continue;
        }
        zzbut.zzob();
        return;
        ??? = finally;
        throw ???;
        SensorManager.remapCoordinateSystem(zzbup, 2, 129, zzbuq);
        break label103;
        SensorManager.remapCoordinateSystem(zzbup, 129, 130, zzbuq);
        break label103;
        SensorManager.remapCoordinateSystem(zzbup, 130, 1, zzbuq);
      }
    }
  }
  
  boolean zzb(float[] paramArrayOfFloat)
  {
    synchronized (zzbun)
    {
      if (zzbur == null) {
        return false;
      }
      System.arraycopy(zzbur, 0, paramArrayOfFloat, 0, zzbur.length);
      return true;
    }
  }
  
  static abstract interface zza
  {
    public abstract void zzob();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */