package com.stripe.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.Random;

public class MultipartProcessor
{
  private static final String LINE_BREAK = "\r\n";
  private final String boundary;
  private String charset;
  private HttpURLConnection conn;
  private OutputStream outputStream;
  private PrintWriter writer;
  
  public MultipartProcessor(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2)
    throws IOException
  {
    boundary = paramString1;
    charset = paramString2;
    conn = paramHttpURLConnection;
    outputStream = paramHttpURLConnection.getOutputStream();
    writer = new PrintWriter(new OutputStreamWriter(outputStream, paramString2), true);
  }
  
  public static String getBoundary()
  {
    return String.valueOf(Long.valueOf(Math.abs(new Random().nextLong())));
  }
  
  public void addFileField(String paramString, File paramFile)
    throws IOException
  {
    String str = paramFile.getName();
    writer.append("--" + boundary).append("\r\n");
    writer.append("Content-Disposition: form-data; name=\"" + paramString + "\"; filename=\"" + str + "\"").append("\r\n");
    paramString = URLConnection.guessContentTypeFromName(str);
    writer.append("Content-Type: " + paramString).append("\r\n");
    writer.append("Content-Transfer-Encoding: binary").append("\r\n");
    writer.append("\r\n");
    writer.flush();
    paramString = new FileInputStream(paramFile);
    try
    {
      paramFile = new byte['က'];
      for (;;)
      {
        int i = paramString.read(paramFile);
        if (i == -1) {
          break;
        }
        outputStream.write(paramFile, 0, i);
      }
      outputStream.flush();
    }
    finally
    {
      paramString.close();
    }
    paramString.close();
    writer.append("\r\n");
    writer.flush();
  }
  
  public void addFormField(String paramString1, String paramString2)
  {
    writer.append("--" + boundary).append("\r\n");
    writer.append("Content-Disposition: form-data; name=\"" + paramString1 + "\"").append("\r\n");
    writer.append("\r\n");
    writer.append(paramString2).append("\r\n");
    writer.flush();
  }
  
  public void finish()
    throws IOException
  {
    writer.append("--" + boundary + "--").append("\r\n");
    writer.flush();
    writer.close();
    outputStream.flush();
    outputStream.close();
  }
}

/* Location:
 * Qualified Name:     com.stripe.net.MultipartProcessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */