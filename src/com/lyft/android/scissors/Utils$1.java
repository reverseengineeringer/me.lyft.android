package com.lyft.android.scissors;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

final class Utils$1
  implements Runnable
{
  Utils$1(File paramFile, Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt) {}
  
  public void run()
  {
    try
    {
      val$file.getParentFile().mkdirs();
      FileOutputStream localFileOutputStream = new FileOutputStream(val$file);
      val$bitmap.compress(val$format, val$quality, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.scissors.Utils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */