package bo.app;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import android.provider.MediaStore.Video.Thumbnails;
import android.webkit.MimeTypeMap;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class ji
  implements jk
{
  protected final Context a;
  protected final int b;
  protected final int c;
  
  public ji(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private ji(Context paramContext, byte paramByte)
  {
    a = paramContext.getApplicationContext();
    b = 5000;
    c = 20000;
  }
  
  private InputStream a(String paramString)
  {
    int j = 0;
    paramString = b(paramString);
    int i = 0;
    while ((paramString.getResponseCode() / 100 == 3) && (i < 5))
    {
      paramString = b(paramString.getHeaderField("Location"));
      i += 1;
    }
    try
    {
      InputStream localInputStream1 = paramString.getInputStream();
      i = j;
      if (paramString.getResponseCode() == 200) {
        i = 1;
      }
      if (i == 0)
      {
        jv.a(localInputStream1);
        throw new IOException("Image request failed with response code " + paramString.getResponseCode());
      }
    }
    catch (IOException localIOException1)
    {
      paramString = paramString.getErrorStream();
      byte[] arrayOfByte = new byte[32768];
      try
      {
        do
        {
          i = paramString.read(arrayOfByte, 0, 32768);
        } while (i != -1);
        jv.a(paramString);
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2 = localIOException2;
          jv.a(paramString);
        }
      }
      finally
      {
        localInputStream2 = finally;
        jv.a(paramString);
        throw localInputStream2;
      }
      throw localIOException1;
      return new ik(new BufferedInputStream(localInputStream2, 32768), paramString.getContentLength());
    }
  }
  
  private HttpURLConnection b(String paramString)
  {
    paramString = (HttpURLConnection)new URL(Uri.encode(paramString, "@#&=*+-_.,:!?()/~'%")).openConnection();
    paramString.setConnectTimeout(b);
    paramString.setReadTimeout(c);
    return paramString;
  }
  
  public final InputStream a(String paramString, Object paramObject)
  {
    paramObject = null;
    int i = 1;
    Object localObject;
    switch (jj.a[jl.a(paramString).ordinal()])
    {
    default: 
      throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[] { paramString }));
    case 1: 
    case 2: 
      paramString = a(paramString);
      return paramString;
    case 3: 
      localObject = jl.c.c(paramString);
      paramString = MimeTypeMap.getFileExtensionFromUrl(paramString);
      paramString = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
      if ((paramString != null) && (paramString.startsWith("video/"))) {}
      for (;;)
      {
        if (i == 0) {
          break label181;
        }
        paramString = (String)paramObject;
        if (Build.VERSION.SDK_INT < 8) {
          break;
        }
        localObject = ThumbnailUtils.createVideoThumbnail((String)localObject, 2);
        paramString = (String)paramObject;
        if (localObject == null) {
          break;
        }
        paramString = new ByteArrayOutputStream();
        ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 0, paramString);
        return new ByteArrayInputStream(paramString.toByteArray());
        i = 0;
      }
      return new ik(new BufferedInputStream(new FileInputStream((String)localObject), 32768), (int)new File((String)localObject).length());
    case 4: 
      localObject = a.getContentResolver();
      paramObject = Uri.parse(paramString);
      String str = a.getContentResolver().getType((Uri)paramObject);
      if ((str != null) && (str.startsWith("video/"))) {}
      for (i = 1; i != 0; i = 0)
      {
        paramString = MediaStore.Video.Thumbnails.getThumbnail((ContentResolver)localObject, Long.valueOf(((Uri)paramObject).getLastPathSegment()).longValue(), 1, null);
        if (paramString == null) {
          break label363;
        }
        paramObject = new ByteArrayOutputStream();
        paramString.compress(Bitmap.CompressFormat.PNG, 0, (OutputStream)paramObject);
        return new ByteArrayInputStream(((ByteArrayOutputStream)paramObject).toByteArray());
      }
      if (paramString.startsWith("content://com.android.contacts/"))
      {
        paramString = a.getContentResolver();
        if (Build.VERSION.SDK_INT >= 14) {
          return ContactsContract.Contacts.openContactPhotoInputStream(paramString, (Uri)paramObject, true);
        }
        return ContactsContract.Contacts.openContactPhotoInputStream(paramString, (Uri)paramObject);
      }
      return ((ContentResolver)localObject).openInputStream((Uri)paramObject);
    case 5: 
      label181:
      label363:
      paramString = jl.e.c(paramString);
      return a.getAssets().open(paramString);
    }
    i = Integer.parseInt(jl.f.c(paramString));
    return a.getResources().openRawResource(i);
  }
}

/* Location:
 * Qualified Name:     bo.app.ji
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */