package com.lyft.android.scissors;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Utils
{
  private static final ExecutorService EXECUTOR_SERVICE = ;
  
  public static Bitmap asBitmap(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    Object localObject = new Rect();
    paramDrawable.copyBounds((Rect)localObject);
    if (((Rect)localObject).isEmpty())
    {
      ((Rect)localObject).set(0, 0, Math.max(paramInt1, paramDrawable.getIntrinsicWidth()), Math.max(paramInt2, paramDrawable.getIntrinsicHeight()));
      paramDrawable.setBounds((Rect)localObject);
    }
    localObject = Bitmap.createBitmap(((Rect)localObject).width(), ((Rect)localObject).height(), Bitmap.Config.ARGB_8888);
    paramDrawable.draw(new Canvas((Bitmap)localObject));
    return (Bitmap)localObject;
  }
  
  public static void checkArg(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static void checkNotNull(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new NullPointerException(paramString);
    }
  }
  
  public static Future<Void> flushToFile(final Bitmap paramBitmap, final Bitmap.CompressFormat paramCompressFormat, final int paramInt, File paramFile)
  {
    EXECUTOR_SERVICE.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          val$file.getParentFile().mkdirs();
          FileOutputStream localFileOutputStream = new FileOutputStream(val$file);
          paramBitmap.compress(paramCompressFormat, paramInt, localFileOutputStream);
          localFileOutputStream.flush();
          localFileOutputStream.close();
          return;
        }
        catch (Throwable localThrowable) {}
      }
    }, null);
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.Utils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */