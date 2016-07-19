package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkh;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@zzir
@TargetApi(14)
public class zzw
  extends Thread
  implements SurfaceTexture.OnFrameAvailableListener, zzv.zza
{
  private static final float[] zzbuv = { -1.0F, -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F };
  private int zzaie;
  private int zzaif;
  private final float[] zzbur;
  private final zzv zzbuw;
  private final float[] zzbux;
  private final float[] zzbuy;
  private final float[] zzbuz;
  private final float[] zzbva;
  private final float[] zzbvb;
  private final float[] zzbvc;
  private float zzbvd;
  private float zzbve;
  private float zzbvf;
  private SurfaceTexture zzbvg;
  private SurfaceTexture zzbvh;
  private int zzbvi;
  private int zzbvj;
  private int zzbvk;
  private FloatBuffer zzbvl = ByteBuffer.allocateDirect(zzbuv.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private final CountDownLatch zzbvm;
  private final Object zzbvn;
  private EGL10 zzbvo;
  private EGLDisplay zzbvp;
  private EGLContext zzbvq;
  private EGLSurface zzbvr;
  private volatile boolean zzbvs;
  private volatile boolean zzbvt;
  
  zzw(Context paramContext)
  {
    super("SphericalVideoProcessor");
    zzbvl.put(zzbuv).position(0);
    zzbur = new float[9];
    zzbux = new float[9];
    zzbuy = new float[9];
    zzbuz = new float[9];
    zzbva = new float[9];
    zzbvb = new float[9];
    zzbvc = new float[9];
    zzbvd = NaN.0F;
    zzbuw = new zzv(paramContext);
    zzbuw.zza(this);
    zzbvm = new CountDownLatch(1);
    zzbvn = new Object();
  }
  
  private void zza(float[] paramArrayOfFloat, float paramFloat)
  {
    paramArrayOfFloat[0] = 1.0F;
    paramArrayOfFloat[1] = 0.0F;
    paramArrayOfFloat[2] = 0.0F;
    paramArrayOfFloat[3] = 0.0F;
    paramArrayOfFloat[4] = ((float)Math.cos(paramFloat));
    paramArrayOfFloat[5] = ((float)-Math.sin(paramFloat));
    paramArrayOfFloat[6] = 0.0F;
    paramArrayOfFloat[7] = ((float)Math.sin(paramFloat));
    paramArrayOfFloat[8] = ((float)Math.cos(paramFloat));
  }
  
  private void zza(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    paramArrayOfFloat1[0] = (paramArrayOfFloat2[0] * paramArrayOfFloat3[0] + paramArrayOfFloat2[1] * paramArrayOfFloat3[3] + paramArrayOfFloat2[2] * paramArrayOfFloat3[6]);
    paramArrayOfFloat1[1] = (paramArrayOfFloat2[0] * paramArrayOfFloat3[1] + paramArrayOfFloat2[1] * paramArrayOfFloat3[4] + paramArrayOfFloat2[2] * paramArrayOfFloat3[7]);
    paramArrayOfFloat1[2] = (paramArrayOfFloat2[0] * paramArrayOfFloat3[2] + paramArrayOfFloat2[1] * paramArrayOfFloat3[5] + paramArrayOfFloat2[2] * paramArrayOfFloat3[8]);
    paramArrayOfFloat1[3] = (paramArrayOfFloat2[3] * paramArrayOfFloat3[0] + paramArrayOfFloat2[4] * paramArrayOfFloat3[3] + paramArrayOfFloat2[5] * paramArrayOfFloat3[6]);
    paramArrayOfFloat1[4] = (paramArrayOfFloat2[3] * paramArrayOfFloat3[1] + paramArrayOfFloat2[4] * paramArrayOfFloat3[4] + paramArrayOfFloat2[5] * paramArrayOfFloat3[7]);
    paramArrayOfFloat1[5] = (paramArrayOfFloat2[3] * paramArrayOfFloat3[2] + paramArrayOfFloat2[4] * paramArrayOfFloat3[5] + paramArrayOfFloat2[5] * paramArrayOfFloat3[8]);
    paramArrayOfFloat1[6] = (paramArrayOfFloat2[6] * paramArrayOfFloat3[0] + paramArrayOfFloat2[7] * paramArrayOfFloat3[3] + paramArrayOfFloat2[8] * paramArrayOfFloat3[6]);
    paramArrayOfFloat1[7] = (paramArrayOfFloat2[6] * paramArrayOfFloat3[1] + paramArrayOfFloat2[7] * paramArrayOfFloat3[4] + paramArrayOfFloat2[8] * paramArrayOfFloat3[7]);
    paramArrayOfFloat1[8] = (paramArrayOfFloat2[6] * paramArrayOfFloat3[2] + paramArrayOfFloat2[7] * paramArrayOfFloat3[5] + paramArrayOfFloat2[8] * paramArrayOfFloat3[8]);
  }
  
  private float[] zza(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return new float[] { paramArrayOfFloat1[0] * paramArrayOfFloat2[0] + paramArrayOfFloat1[1] * paramArrayOfFloat2[1] + paramArrayOfFloat1[2] * paramArrayOfFloat2[2], paramArrayOfFloat1[3] * paramArrayOfFloat2[0] + paramArrayOfFloat1[4] * paramArrayOfFloat2[1] + paramArrayOfFloat1[5] * paramArrayOfFloat2[2], paramArrayOfFloat1[6] * paramArrayOfFloat2[0] + paramArrayOfFloat1[7] * paramArrayOfFloat2[1] + paramArrayOfFloat1[8] * paramArrayOfFloat2[2] };
  }
  
  private void zzb(float[] paramArrayOfFloat, float paramFloat)
  {
    paramArrayOfFloat[0] = ((float)Math.cos(paramFloat));
    paramArrayOfFloat[1] = ((float)-Math.sin(paramFloat));
    paramArrayOfFloat[2] = 0.0F;
    paramArrayOfFloat[3] = ((float)Math.sin(paramFloat));
    paramArrayOfFloat[4] = ((float)Math.cos(paramFloat));
    paramArrayOfFloat[5] = 0.0F;
    paramArrayOfFloat[6] = 0.0F;
    paramArrayOfFloat[7] = 0.0F;
    paramArrayOfFloat[8] = 1.0F;
  }
  
  private void zzby(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      Log.e("SphericalVideoRenderer", String.valueOf(paramString).length() + 21 + paramString + ": glError " + i);
    }
  }
  
  private float zzc(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = zza(paramArrayOfFloat, new float[] { 0.0F, 1.0F, 0.0F });
    return (float)Math.atan2(paramArrayOfFloat[1], paramArrayOfFloat[0]) - 1.5707964F;
  }
  
  private int zzc(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    zzby("createShader");
    if (i != 0)
    {
      GLES20.glShaderSource(i, paramString);
      zzby("shaderSource");
      GLES20.glCompileShader(i);
      zzby("compileShader");
      paramString = new int[1];
      GLES20.glGetShaderiv(i, 35713, paramString, 0);
      zzby("getShaderiv");
      if (paramString[0] == 0)
      {
        Log.e("SphericalVideoRenderer", 37 + "Could not compile shader " + paramInt + ":");
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(i));
        GLES20.glDeleteShader(i);
        zzby("deleteShader");
        return 0;
      }
    }
    return i;
  }
  
  private void zzpb()
  {
    GLES20.glViewport(0, 0, zzaie, zzaif);
    zzby("viewport");
    int i = GLES20.glGetUniformLocation(zzbvi, "uFOVx");
    int j = GLES20.glGetUniformLocation(zzbvi, "uFOVy");
    if (zzaie > zzaif)
    {
      GLES20.glUniform1f(i, 0.87266463F);
      GLES20.glUniform1f(j, zzaif * 0.87266463F / zzaie);
      return;
    }
    GLES20.glUniform1f(i, zzaie * 0.87266463F / zzaif);
    GLES20.glUniform1f(j, 0.87266463F);
  }
  
  private int zzpd()
  {
    int i = zzc(35633, zzpg());
    if (i == 0) {}
    int j;
    do
    {
      return 0;
      j = zzc(35632, zzph());
    } while (j == 0);
    int k = GLES20.glCreateProgram();
    zzby("createProgram");
    if (k != 0)
    {
      GLES20.glAttachShader(k, i);
      zzby("attachShader");
      GLES20.glAttachShader(k, j);
      zzby("attachShader");
      GLES20.glLinkProgram(k);
      zzby("linkProgram");
      int[] arrayOfInt = new int[1];
      GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
      zzby("getProgramiv");
      if (arrayOfInt[0] != 1)
      {
        Log.e("SphericalVideoRenderer", "Could not link program: ");
        Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(k));
        GLES20.glDeleteProgram(k);
        zzby("deleteProgram");
        return 0;
      }
      GLES20.glValidateProgram(k);
      zzby("validateProgram");
    }
    return k;
  }
  
  private EGLConfig zzpf()
  {
    int[] arrayOfInt = new int[1];
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    if (!zzbvo.eglChooseConfig(zzbvp, new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344 }, arrayOfEGLConfig, 1, arrayOfInt)) {
      return null;
    }
    if (arrayOfInt[0] > 0) {
      return arrayOfEGLConfig[0];
    }
    return null;
  }
  
  private String zzpg()
  {
    zzcy localzzcy = zzdc.zzbak;
    if (!((String)localzzcy.get()).equals(localzzcy.zzjw())) {
      return (String)localzzcy.get();
    }
    return "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}";
  }
  
  private String zzph()
  {
    zzcy localzzcy = zzdc.zzbal;
    if (!((String)localzzcy.get()).equals(localzzcy.zzjw())) {
      return (String)localzzcy.get();
    }
    return "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}";
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    zzbvk += 1;
    synchronized (zzbvn)
    {
      zzbvn.notifyAll();
      return;
    }
  }
  
  public void run()
  {
    int i = 0;
    if (zzbvh == null)
    {
      zzkh.e("SphericalVideoProcessor started with no output texture.");
      zzbvm.countDown();
      return;
    }
    boolean bool = zzpe();
    int j = zzpc();
    if (zzbvi != 0) {
      i = 1;
    }
    if ((!bool) || (i == 0))
    {
      ??? = String.valueOf(GLUtils.getEGLErrorString(zzbvo.eglGetError()));
      if (((String)???).length() != 0) {}
      for (??? = "EGL initialization failed: ".concat((String)???);; ??? = new String("EGL initialization failed: "))
      {
        zzkh.e((String)???);
        zzu.zzft().zzb(new Throwable((String)???), true);
        zzpi();
        zzbvm.countDown();
        return;
      }
    }
    zzbvg = new SurfaceTexture(j);
    zzbvg.setOnFrameAvailableListener(this);
    zzbvm.countDown();
    zzbuw.start();
    try
    {
      zzbvs = true;
      for (;;)
      {
        if (!zzbvt)
        {
          zzpa();
          if (zzbvs)
          {
            zzpb();
            zzbvs = false;
          }
          try
          {
            synchronized (zzbvn)
            {
              if ((!zzbvt) && (!zzbvs) && (zzbvk == 0)) {
                zzbvn.wait();
              }
            }
          }
          catch (InterruptedException localInterruptedException) {}
        }
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      zzkh.zzcy("SphericalVideoProcessor halted unexpectedly.");
      return;
    }
    catch (Throwable localThrowable)
    {
      zzkh.zzb("SphericalVideoProcessor died.", localThrowable);
      zzu.zzft().zzb(localThrowable, true);
      return;
    }
    finally
    {
      zzbuw.stop();
      zzbvg.setOnFrameAvailableListener(null);
      zzbvg = null;
      zzpi();
    }
  }
  
  void zza(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    zzaie = paramInt1;
    zzaif = paramInt2;
    zzbvh = paramSurfaceTexture;
  }
  
  void zzb(float paramFloat1, float paramFloat2)
  {
    float f;
    if (zzaie > zzaif)
    {
      paramFloat1 = 1.7453293F * paramFloat1 / zzaie;
      f = 1.7453293F * paramFloat2 / zzaie;
      paramFloat2 = paramFloat1;
      paramFloat1 = f;
    }
    for (;;)
    {
      zzbve -= paramFloat2;
      zzbvf -= paramFloat1;
      if (zzbvf < -1.5707964F) {
        zzbvf = -1.5707964F;
      }
      if (zzbvf > 1.5707964F) {
        zzbvf = 1.5707964F;
      }
      return;
      f = 1.7453293F * paramFloat1 / zzaif;
      paramFloat1 = 1.7453293F * paramFloat2 / zzaif;
      paramFloat2 = f;
    }
  }
  
  void zzg(int paramInt1, int paramInt2)
  {
    synchronized (zzbvn)
    {
      zzaie = paramInt1;
      zzaif = paramInt2;
      zzbvs = true;
      zzbvn.notifyAll();
      return;
    }
  }
  
  public void zzob()
  {
    synchronized (zzbvn)
    {
      zzbvn.notifyAll();
      return;
    }
  }
  
  void zzoy()
  {
    synchronized (zzbvn)
    {
      zzbvt = true;
      zzbvh = null;
      zzbvn.notifyAll();
      return;
    }
  }
  
  public SurfaceTexture zzoz()
  {
    if (zzbvh == null) {
      return null;
    }
    try
    {
      zzbvm.await();
      return zzbvg;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  void zzpa()
  {
    while (zzbvk > 0)
    {
      zzbvg.updateTexImage();
      zzbvk -= 1;
    }
    if (zzbuw.zzb(zzbur))
    {
      if (Float.isNaN(zzbvd)) {
        zzbvd = (-zzc(zzbur));
      }
      zzb(zzbvb, zzbvd + zzbve);
    }
    for (;;)
    {
      zza(zzbux, 1.5707964F);
      zza(zzbuy, zzbvb, zzbux);
      zza(zzbuz, zzbur, zzbuy);
      zza(zzbva, zzbvf);
      zza(zzbvc, zzbva, zzbuz);
      GLES20.glUniformMatrix3fv(zzbvj, 1, false, zzbvc, 0);
      GLES20.glDrawArrays(5, 0, 4);
      zzby("drawArrays");
      GLES20.glFinish();
      zzbvo.eglSwapBuffers(zzbvp, zzbvr);
      return;
      zza(zzbur, -1.5707964F);
      zzb(zzbvb, zzbve);
    }
  }
  
  int zzpc()
  {
    zzbvi = zzpd();
    GLES20.glUseProgram(zzbvi);
    zzby("useProgram");
    int i = GLES20.glGetAttribLocation(zzbvi, "aPosition");
    GLES20.glVertexAttribPointer(i, 3, 5126, false, 12, zzbvl);
    zzby("vertexAttribPointer");
    GLES20.glEnableVertexAttribArray(i);
    zzby("enableVertexAttribArray");
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    zzby("genTextures");
    i = arrayOfInt[0];
    GLES20.glBindTexture(36197, i);
    zzby("bindTextures");
    GLES20.glTexParameteri(36197, 10240, 9729);
    zzby("texParameteri");
    GLES20.glTexParameteri(36197, 10241, 9729);
    zzby("texParameteri");
    GLES20.glTexParameteri(36197, 10242, 33071);
    zzby("texParameteri");
    GLES20.glTexParameteri(36197, 10243, 33071);
    zzby("texParameteri");
    zzbvj = GLES20.glGetUniformLocation(zzbvi, "uVMat");
    GLES20.glUniformMatrix3fv(zzbvj, 1, false, new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F }, 0);
    return i;
  }
  
  boolean zzpe()
  {
    zzbvo = ((EGL10)EGLContext.getEGL());
    zzbvp = zzbvo.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (zzbvp == EGL10.EGL_NO_DISPLAY) {
      return false;
    }
    Object localObject = new int[2];
    if (!zzbvo.eglInitialize(zzbvp, (int[])localObject)) {
      return false;
    }
    localObject = zzpf();
    if (localObject == null) {
      return false;
    }
    zzbvq = zzbvo.eglCreateContext(zzbvp, (EGLConfig)localObject, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
    if ((zzbvq == null) || (zzbvq == EGL10.EGL_NO_CONTEXT)) {
      return false;
    }
    zzbvr = zzbvo.eglCreateWindowSurface(zzbvp, (EGLConfig)localObject, zzbvh, null);
    if ((zzbvr == null) || (zzbvr == EGL10.EGL_NO_SURFACE)) {
      return false;
    }
    return zzbvo.eglMakeCurrent(zzbvp, zzbvr, zzbvr, zzbvq);
  }
  
  boolean zzpi()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (zzbvr != null)
    {
      bool1 = bool2;
      if (zzbvr != EGL10.EGL_NO_SURFACE)
      {
        bool1 = zzbvo.eglMakeCurrent(zzbvp, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | false | zzbvo.eglDestroySurface(zzbvp, zzbvr);
        zzbvr = null;
      }
    }
    bool2 = bool1;
    if (zzbvq != null)
    {
      bool2 = bool1 | zzbvo.eglDestroyContext(zzbvp, zzbvq);
      zzbvq = null;
    }
    bool1 = bool2;
    if (zzbvp != null)
    {
      bool1 = bool2 | zzbvo.eglTerminate(zzbvp);
      zzbvp = null;
    }
    return bool1;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */