package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache.Editor;
import com.squareup.okhttp.internal.DiskLruCache.Snapshot;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class Cache$Entry
{
  private final int code;
  private final Handshake handshake;
  private final String message;
  private final Protocol protocol;
  private final String requestMethod;
  private final Headers responseHeaders;
  private final String url;
  private final Headers varyHeaders;
  
  public Cache$Entry(Response paramResponse)
  {
    url = paramResponse.request().urlString();
    varyHeaders = OkHeaders.varyHeaders(paramResponse);
    requestMethod = paramResponse.request().method();
    protocol = paramResponse.protocol();
    code = paramResponse.code();
    message = paramResponse.message();
    responseHeaders = paramResponse.headers();
    handshake = paramResponse.handshake();
  }
  
  public Cache$Entry(Source paramSource)
    throws IOException
  {
    try
    {
      BufferedSource localBufferedSource1 = Okio.buffer(paramSource);
      url = localBufferedSource1.readUtf8LineStrict();
      requestMethod = localBufferedSource1.readUtf8LineStrict();
      Object localObject = new Headers.Builder();
      int j = Cache.access$1000(localBufferedSource1);
      int i = 0;
      while (i < j)
      {
        ((Headers.Builder)localObject).addLenient(localBufferedSource1.readUtf8LineStrict());
        i += 1;
      }
      varyHeaders = ((Headers.Builder)localObject).build();
      localObject = StatusLine.parse(localBufferedSource1.readUtf8LineStrict());
      protocol = protocol;
      code = code;
      message = message;
      localObject = new Headers.Builder();
      j = Cache.access$1000(localBufferedSource1);
      i = 0;
      while (i < j)
      {
        ((Headers.Builder)localObject).addLenient(localBufferedSource1.readUtf8LineStrict());
        i += 1;
      }
      responseHeaders = ((Headers.Builder)localObject).build();
      if (isHttps())
      {
        localObject = localBufferedSource1.readUtf8LineStrict();
        if (((String)localObject).length() > 0) {
          throw new IOException("expected \"\" but was \"" + (String)localObject + "\"");
        }
      }
    }
    finally
    {
      paramSource.close();
    }
    for (handshake = Handshake.get(localBufferedSource2.readUtf8LineStrict(), readCertificateList(localBufferedSource2), readCertificateList(localBufferedSource2));; handshake = null)
    {
      paramSource.close();
      return;
    }
  }
  
  private boolean isHttps()
  {
    return url.startsWith("https://");
  }
  
  /* Error */
  private List<Certificate> readCertificateList(BufferedSource paramBufferedSource)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 98	com/squareup/okhttp/Cache:access$1000	(Lokio/BufferedSource;)I
    //   4: istore_3
    //   5: iload_3
    //   6: iconst_m1
    //   7: if_icmpne +11 -> 18
    //   10: invokestatic 170	java/util/Collections:emptyList	()Ljava/util/List;
    //   13: astore 4
    //   15: aload 4
    //   17: areturn
    //   18: ldc -84
    //   20: invokestatic 178	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   23: astore 6
    //   25: new 180	java/util/ArrayList
    //   28: dup
    //   29: iload_3
    //   30: invokespecial 183	java/util/ArrayList:<init>	(I)V
    //   33: astore 5
    //   35: iconst_0
    //   36: istore_2
    //   37: aload 5
    //   39: astore 4
    //   41: iload_2
    //   42: iload_3
    //   43: if_icmpge -28 -> 15
    //   46: aload_1
    //   47: invokeinterface 91 1 0
    //   52: astore 4
    //   54: new 185	okio/Buffer
    //   57: dup
    //   58: invokespecial 186	okio/Buffer:<init>	()V
    //   61: astore 7
    //   63: aload 7
    //   65: aload 4
    //   67: invokestatic 192	okio/ByteString:decodeBase64	(Ljava/lang/String;)Lokio/ByteString;
    //   70: invokevirtual 196	okio/Buffer:write	(Lokio/ByteString;)Lokio/Buffer;
    //   73: pop
    //   74: aload 5
    //   76: aload 6
    //   78: aload 7
    //   80: invokevirtual 200	okio/Buffer:inputStream	()Ljava/io/InputStream;
    //   83: invokevirtual 204	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   86: invokeinterface 210 2 0
    //   91: pop
    //   92: iload_2
    //   93: iconst_1
    //   94: iadd
    //   95: istore_2
    //   96: goto -59 -> 37
    //   99: astore_1
    //   100: new 80	java/io/IOException
    //   103: dup
    //   104: aload_1
    //   105: invokevirtual 213	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
    //   108: invokespecial 140	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	Entry
    //   0	112	1	paramBufferedSource	BufferedSource
    //   36	60	2	i	int
    //   4	40	3	j	int
    //   13	53	4	localObject	Object
    //   33	42	5	localArrayList	java.util.ArrayList
    //   23	54	6	localCertificateFactory	java.security.cert.CertificateFactory
    //   61	18	7	localBuffer	okio.Buffer
    // Exception table:
    //   from	to	target	type
    //   18	35	99	java/security/cert/CertificateException
    //   46	92	99	java/security/cert/CertificateException
  }
  
  private void writeCertList(BufferedSink paramBufferedSink, List<Certificate> paramList)
    throws IOException
  {
    try
    {
      paramBufferedSink.writeDecimalLong(paramList.size());
      paramBufferedSink.writeByte(10);
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        paramBufferedSink.writeUtf8(ByteString.of(((Certificate)paramList.get(i)).getEncoded()).base64());
        paramBufferedSink.writeByte(10);
        i += 1;
      }
      return;
    }
    catch (CertificateEncodingException paramBufferedSink)
    {
      throw new IOException(paramBufferedSink.getMessage());
    }
  }
  
  public boolean matches(Request paramRequest, Response paramResponse)
  {
    return (url.equals(paramRequest.urlString())) && (requestMethod.equals(paramRequest.method())) && (OkHeaders.varyMatches(paramResponse, varyHeaders, paramRequest));
  }
  
  public Response response(Request paramRequest, DiskLruCache.Snapshot paramSnapshot)
  {
    paramRequest = responseHeaders.get("Content-Type");
    String str = responseHeaders.get("Content-Length");
    Request localRequest = new Request.Builder().url(url).method(requestMethod, null).headers(varyHeaders).build();
    return new Response.Builder().request(localRequest).protocol(protocol).code(code).message(message).headers(responseHeaders).body(new Cache.CacheResponseBody(paramSnapshot, paramRequest, str)).handshake(handshake).build();
  }
  
  public void writeTo(DiskLruCache.Editor paramEditor)
    throws IOException
  {
    paramEditor = Okio.buffer(paramEditor.newSink(0));
    paramEditor.writeUtf8(url);
    paramEditor.writeByte(10);
    paramEditor.writeUtf8(requestMethod);
    paramEditor.writeByte(10);
    paramEditor.writeDecimalLong(varyHeaders.size());
    paramEditor.writeByte(10);
    int i = 0;
    int j = varyHeaders.size();
    while (i < j)
    {
      paramEditor.writeUtf8(varyHeaders.name(i));
      paramEditor.writeUtf8(": ");
      paramEditor.writeUtf8(varyHeaders.value(i));
      paramEditor.writeByte(10);
      i += 1;
    }
    paramEditor.writeUtf8(new StatusLine(protocol, code, message).toString());
    paramEditor.writeByte(10);
    paramEditor.writeDecimalLong(responseHeaders.size());
    paramEditor.writeByte(10);
    i = 0;
    j = responseHeaders.size();
    while (i < j)
    {
      paramEditor.writeUtf8(responseHeaders.name(i));
      paramEditor.writeUtf8(": ");
      paramEditor.writeUtf8(responseHeaders.value(i));
      paramEditor.writeByte(10);
      i += 1;
    }
    if (isHttps())
    {
      paramEditor.writeByte(10);
      paramEditor.writeUtf8(handshake.cipherSuite());
      paramEditor.writeByte(10);
      writeCertList(paramEditor, handshake.peerCertificates());
      writeCertList(paramEditor, handshake.localCertificates());
    }
    paramEditor.close();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Cache.Entry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */