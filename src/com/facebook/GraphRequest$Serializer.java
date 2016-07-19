package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class GraphRequest$Serializer
  implements GraphRequest.KeyValueSerializer
{
  private boolean firstWrite = true;
  private final Logger logger;
  private final OutputStream outputStream;
  private boolean useUrlEncode = false;
  
  public GraphRequest$Serializer(OutputStream paramOutputStream, Logger paramLogger, boolean paramBoolean)
  {
    outputStream = paramOutputStream;
    logger = paramLogger;
    useUrlEncode = paramBoolean;
  }
  
  private RuntimeException getInvalidTypeError()
  {
    return new IllegalArgumentException("value is not a supported type.");
  }
  
  public void write(String paramString, Object... paramVarArgs)
    throws IOException
  {
    if (!useUrlEncode)
    {
      if (firstWrite)
      {
        outputStream.write("--".getBytes());
        outputStream.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
        outputStream.write("\r\n".getBytes());
        firstWrite = false;
      }
      outputStream.write(String.format(paramString, paramVarArgs).getBytes());
      return;
    }
    outputStream.write(URLEncoder.encode(String.format(Locale.US, paramString, paramVarArgs), "UTF-8").getBytes());
  }
  
  public void writeBitmap(String paramString, Bitmap paramBitmap)
    throws IOException
  {
    writeContentDisposition(paramString, paramString, "image/png");
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
    writeLine("", new Object[0]);
    writeRecordBoundary();
    if (logger != null) {
      logger.appendKeyValue("    " + paramString, "<Image>");
    }
  }
  
  public void writeBytes(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    writeContentDisposition(paramString, paramString, "content/unknown");
    outputStream.write(paramArrayOfByte);
    writeLine("", new Object[0]);
    writeRecordBoundary();
    if (logger != null) {
      logger.appendKeyValue("    " + paramString, String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(paramArrayOfByte.length) }));
    }
  }
  
  public void writeContentDisposition(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    if (!useUrlEncode)
    {
      write("Content-Disposition: form-data; name=\"%s\"", new Object[] { paramString1 });
      if (paramString2 != null) {
        write("; filename=\"%s\"", new Object[] { paramString2 });
      }
      writeLine("", new Object[0]);
      if (paramString3 != null) {
        writeLine("%s: %s", new Object[] { "Content-Type", paramString3 });
      }
      writeLine("", new Object[0]);
      return;
    }
    outputStream.write(String.format("%s=", new Object[] { paramString1 }).getBytes());
  }
  
  public void writeContentUri(String paramString1, Uri paramUri, String paramString2)
    throws IOException
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "content/unknown";
    }
    writeContentDisposition(paramString1, paramString1, str);
    int i = 0;
    if ((outputStream instanceof ProgressNoopOutputStream))
    {
      long l = Utility.getContentSize(paramUri);
      ((ProgressNoopOutputStream)outputStream).addProgress(l);
    }
    for (;;)
    {
      writeLine("", new Object[0]);
      writeRecordBoundary();
      if (logger != null) {
        logger.appendKeyValue("    " + paramString1, String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(i) }));
      }
      return;
      i = 0 + Utility.copyAndCloseInputStream(FacebookSdk.getApplicationContext().getContentResolver().openInputStream(paramUri), outputStream);
    }
  }
  
  public void writeFile(String paramString1, ParcelFileDescriptor paramParcelFileDescriptor, String paramString2)
    throws IOException
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "content/unknown";
    }
    writeContentDisposition(paramString1, paramString1, str);
    int i = 0;
    if ((outputStream instanceof ProgressNoopOutputStream)) {
      ((ProgressNoopOutputStream)outputStream).addProgress(paramParcelFileDescriptor.getStatSize());
    }
    for (;;)
    {
      writeLine("", new Object[0]);
      writeRecordBoundary();
      if (logger != null) {
        logger.appendKeyValue("    " + paramString1, String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(i) }));
      }
      return;
      i = 0 + Utility.copyAndCloseInputStream(new ParcelFileDescriptor.AutoCloseInputStream(paramParcelFileDescriptor), outputStream);
    }
  }
  
  public void writeLine(String paramString, Object... paramVarArgs)
    throws IOException
  {
    write(paramString, paramVarArgs);
    if (!useUrlEncode) {
      write("\r\n", new Object[0]);
    }
  }
  
  public void writeObject(String paramString, Object paramObject, GraphRequest paramGraphRequest)
    throws IOException
  {
    if ((outputStream instanceof RequestOutputStream)) {
      ((RequestOutputStream)outputStream).setCurrentRequest(paramGraphRequest);
    }
    if (GraphRequest.access$000(paramObject))
    {
      writeString(paramString, GraphRequest.access$100(paramObject));
      return;
    }
    if ((paramObject instanceof Bitmap))
    {
      writeBitmap(paramString, (Bitmap)paramObject);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      writeBytes(paramString, (byte[])paramObject);
      return;
    }
    if ((paramObject instanceof Uri))
    {
      writeContentUri(paramString, (Uri)paramObject, null);
      return;
    }
    if ((paramObject instanceof ParcelFileDescriptor))
    {
      writeFile(paramString, (ParcelFileDescriptor)paramObject, null);
      return;
    }
    if ((paramObject instanceof GraphRequest.ParcelableResourceWithMimeType))
    {
      paramGraphRequest = (GraphRequest.ParcelableResourceWithMimeType)paramObject;
      paramObject = paramGraphRequest.getResource();
      paramGraphRequest = paramGraphRequest.getMimeType();
      if ((paramObject instanceof ParcelFileDescriptor))
      {
        writeFile(paramString, (ParcelFileDescriptor)paramObject, paramGraphRequest);
        return;
      }
      if ((paramObject instanceof Uri))
      {
        writeContentUri(paramString, (Uri)paramObject, paramGraphRequest);
        return;
      }
      throw getInvalidTypeError();
    }
    throw getInvalidTypeError();
  }
  
  public void writeRecordBoundary()
    throws IOException
  {
    if (!useUrlEncode)
    {
      writeLine("--%s", new Object[] { "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" });
      return;
    }
    outputStream.write("&".getBytes());
  }
  
  public void writeRequestsAsJson(String paramString, JSONArray paramJSONArray, Collection<GraphRequest> paramCollection)
    throws IOException, JSONException
  {
    if (!(outputStream instanceof RequestOutputStream)) {
      writeString(paramString, paramJSONArray.toString());
    }
    do
    {
      return;
      RequestOutputStream localRequestOutputStream = (RequestOutputStream)outputStream;
      writeContentDisposition(paramString, null, null);
      write("[", new Object[0]);
      int i = 0;
      paramCollection = paramCollection.iterator();
      if (paramCollection.hasNext())
      {
        GraphRequest localGraphRequest = (GraphRequest)paramCollection.next();
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        localRequestOutputStream.setCurrentRequest(localGraphRequest);
        if (i > 0) {
          write(",%s", new Object[] { localJSONObject.toString() });
        }
        for (;;)
        {
          i += 1;
          break;
          write("%s", new Object[] { localJSONObject.toString() });
        }
      }
      write("]", new Object[0]);
    } while (logger == null);
    logger.appendKeyValue("    " + paramString, paramJSONArray.toString());
  }
  
  public void writeString(String paramString1, String paramString2)
    throws IOException
  {
    writeContentDisposition(paramString1, null, null);
    writeLine("%s", new Object[] { paramString2 });
    writeRecordBoundary();
    if (logger != null) {
      logger.appendKeyValue("    " + paramString1, paramString2);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.GraphRequest.Serializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */