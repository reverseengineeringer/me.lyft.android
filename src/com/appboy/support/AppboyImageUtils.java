package com.appboy.support;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import com.appboy.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class AppboyImageUtils
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyImageUtils.class.getName() });
  
  private static Bitmap a(Uri paramUri)
  {
    paramUri = paramUri.toString();
    try
    {
      InputStream localInputStream = new URL(paramUri).openStream();
      Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
      if (localInputStream != null) {
        localInputStream.close();
      }
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      AppboyLogger.e(a, String.format("Out of Memory Error in image bitmap download for Uri: %s.", new Object[] { paramUri }), localOutOfMemoryError);
      return null;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;)
      {
        AppboyLogger.e(a, String.format("Unknown Host Exception in image bitmap download for Uri: %s. Device may be offline.", new Object[] { paramUri }), localUnknownHostException);
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        AppboyLogger.e(a, String.format("Malformed URL Exception in image bitmap download for Uri: %s. Image Uri may be corrupted.", new Object[] { paramUri }), localMalformedURLException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AppboyLogger.e(a, String.format("Exception in image bitmap download for Uri: %s", new Object[] { paramUri }), localException);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        AppboyLogger.e(a, String.format("Throwable caught in image bitmap download for Uri: %s", new Object[] { paramUri }), localThrowable);
      }
    }
  }
  
  private static Bitmap b(Uri paramUri)
  {
    try
    {
      Object localObject = new File(paramUri.getPath());
      if (((File)localObject).exists())
      {
        AppboyLogger.i(a, "Retrieving image from path: " + ((File)localObject).getAbsolutePath());
        localObject = BitmapFactory.decodeFile(((File)localObject).getAbsolutePath());
        return (Bitmap)localObject;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      AppboyLogger.e(a, String.format("Out of Memory Error in local bitmap file retrieval for Uri: %s.", new Object[] { paramUri.toString() }), localOutOfMemoryError);
      return null;
    }
    catch (Exception paramUri)
    {
      for (;;)
      {
        AppboyLogger.e(a, "Exception occurred when attempting to retrieve local bitmap.", paramUri);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        AppboyLogger.e(a, String.format("Throwable caught in local bitmap file retrieval for Uri: %s", new Object[] { paramUri.toString() }), localThrowable);
      }
    }
  }
  
  public static Bitmap getBitmap(Uri paramUri)
  {
    if (paramUri == null)
    {
      AppboyLogger.i(a, "Null Uri received. Not getting image.");
      return null;
    }
    if (AppboyFileUtils.isLocalUri(paramUri)) {
      return b(paramUri);
    }
    if (AppboyFileUtils.isRemoteUri(paramUri)) {
      return a(paramUri);
    }
    AppboyLogger.w(a, "Uri with unknown scheme received. Not getting image.");
    return null;
  }
  
  public static int getPixelsFromDensityAndDp(int paramInt1, int paramInt2)
  {
    return Math.abs(paramInt1 * paramInt2 / 160);
  }
  
  public static Uri storePushBitmapInExternalStorage(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      AppboyLogger.w(a, "Received null context. Doing nothing.");
      return null;
    }
    if (paramBitmap == null)
    {
      AppboyLogger.w(a, "Received null bitmap. Doing nothing.");
      return null;
    }
    if (StringUtils.isNullOrBlank(paramString1))
    {
      AppboyLogger.w(a, "Received null or blank image filename base. Doing nothing.");
      return null;
    }
    if (StringUtils.isNullOrBlank(paramString2))
    {
      AppboyLogger.w(a, "Received null or blank image folder name for externally stored image. Doing nothing.");
      return null;
    }
    try
    {
      paramString2 = AppboyFileUtils.getExternalStorage(paramString2);
      if (paramString2 == null)
      {
        AppboyLogger.w(a, "Image storage directory was null. Doing nothing.");
        return null;
      }
    }
    catch (Exception paramContext)
    {
      AppboyLogger.e(a, "Exception occurred when attempting to store image locally.", paramContext);
      return null;
    }
    if (!paramString2.exists()) {
      paramString2.mkdirs();
    }
    paramString1 = new File(paramString2, paramString1 + ".png");
    paramString2 = new FileOutputStream(paramString1);
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 0, paramString2);
    paramString2.flush();
    paramString2.close();
    MediaScannerConnection.scanFile(paramContext, new String[] { paramString1.getAbsolutePath() }, null, null);
    AppboyLogger.i(a, "Stored image locally at " + paramString1.getAbsolutePath());
    paramContext = Uri.fromFile(paramString1);
    return paramContext;
  }
}

/* Location:
 * Qualified Name:     com.appboy.support.AppboyImageUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */