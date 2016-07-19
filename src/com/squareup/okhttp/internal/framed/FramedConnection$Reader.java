package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.BufferedSource;
import okio.ByteString;

class FramedConnection$Reader
  extends NamedRunnable
  implements FrameReader.Handler
{
  final FrameReader frameReader;
  
  private FramedConnection$Reader(FramedConnection paramFramedConnection, FrameReader paramFrameReader)
  {
    super("OkHttp %s", new Object[] { FramedConnection.access$1100(paramFramedConnection) });
    frameReader = paramFrameReader;
  }
  
  private void ackSettingsLater(final Settings paramSettings)
  {
    FramedConnection.access$2100().execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[] { FramedConnection.access$1100(this$0) })
    {
      public void execute()
      {
        try
        {
          this$0.frameWriter.ackSettings(paramSettings);
          return;
        }
        catch (IOException localIOException) {}
      }
    });
  }
  
  public void ackSettings() {}
  
  public void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong) {}
  
  public void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
    throws IOException
  {
    if (FramedConnection.access$1300(this$0, paramInt1)) {
      FramedConnection.access$1400(this$0, paramInt1, paramBufferedSource, paramInt2, paramBoolean);
    }
    FramedStream localFramedStream;
    do
    {
      return;
      localFramedStream = this$0.getStream(paramInt1);
      if (localFramedStream == null)
      {
        this$0.writeSynResetLater(paramInt1, ErrorCode.INVALID_STREAM);
        paramBufferedSource.skip(paramInt2);
        return;
      }
      localFramedStream.receiveData(paramBufferedSource, paramInt2);
    } while (!paramBoolean);
    localFramedStream.receiveFin();
  }
  
  /* Error */
  protected void execute()
  {
    // Byte code:
    //   0: getstatic 106	com/squareup/okhttp/internal/framed/ErrorCode:INTERNAL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   3: astore_3
    //   4: getstatic 106	com/squareup/okhttp/internal/framed/ErrorCode:INTERNAL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   7: astore 4
    //   9: aload_3
    //   10: astore_2
    //   11: aload_3
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 23	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   17: getfield 110	com/squareup/okhttp/internal/framed/FramedConnection:client	Z
    //   20: ifne +16 -> 36
    //   23: aload_3
    //   24: astore_2
    //   25: aload_3
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 36	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
    //   31: invokeinterface 115 1 0
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: astore_1
    //   40: aload_0
    //   41: getfield 36	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
    //   44: aload_0
    //   45: invokeinterface 119 2 0
    //   50: ifne -14 -> 36
    //   53: aload_3
    //   54: astore_2
    //   55: aload_3
    //   56: astore_1
    //   57: getstatic 122	com/squareup/okhttp/internal/framed/ErrorCode:NO_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   60: astore_3
    //   61: aload_3
    //   62: astore_2
    //   63: aload_3
    //   64: astore_1
    //   65: getstatic 125	com/squareup/okhttp/internal/framed/ErrorCode:CANCEL	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   68: astore 5
    //   70: aload_0
    //   71: getfield 23	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   74: aload_3
    //   75: aload 5
    //   77: invokestatic 129	com/squareup/okhttp/internal/framed/FramedConnection:access$1200	(Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   80: aload_0
    //   81: getfield 36	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
    //   84: invokestatic 135	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   87: return
    //   88: astore_1
    //   89: aload_2
    //   90: astore_1
    //   91: getstatic 138	com/squareup/okhttp/internal/framed/ErrorCode:PROTOCOL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   94: astore_2
    //   95: aload_2
    //   96: astore_1
    //   97: getstatic 138	com/squareup/okhttp/internal/framed/ErrorCode:PROTOCOL_ERROR	Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   100: astore_3
    //   101: aload_0
    //   102: getfield 23	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   105: aload_2
    //   106: aload_3
    //   107: invokestatic 129	com/squareup/okhttp/internal/framed/FramedConnection:access$1200	(Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   110: aload_0
    //   111: getfield 36	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
    //   114: invokestatic 135	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   117: return
    //   118: astore_2
    //   119: aload_0
    //   120: getfield 23	com/squareup/okhttp/internal/framed/FramedConnection$Reader:this$0	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   123: aload_1
    //   124: aload 4
    //   126: invokestatic 129	com/squareup/okhttp/internal/framed/FramedConnection:access$1200	(Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   129: aload_0
    //   130: getfield 36	com/squareup/okhttp/internal/framed/FramedConnection$Reader:frameReader	Lcom/squareup/okhttp/internal/framed/FrameReader;
    //   133: invokestatic 135	com/squareup/okhttp/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   136: aload_2
    //   137: athrow
    //   138: astore_1
    //   139: goto -10 -> 129
    //   142: astore_1
    //   143: goto -33 -> 110
    //   146: astore_1
    //   147: goto -67 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	Reader
    //   12	53	1	localErrorCode1	ErrorCode
    //   88	1	1	localIOException1	IOException
    //   90	34	1	localErrorCode2	ErrorCode
    //   138	1	1	localIOException2	IOException
    //   142	1	1	localIOException3	IOException
    //   146	1	1	localIOException4	IOException
    //   10	96	2	localErrorCode3	ErrorCode
    //   118	19	2	localObject	Object
    //   3	104	3	localErrorCode4	ErrorCode
    //   7	118	4	localErrorCode5	ErrorCode
    //   68	8	5	localErrorCode6	ErrorCode
    // Exception table:
    //   from	to	target	type
    //   13	23	88	java/io/IOException
    //   27	36	88	java/io/IOException
    //   40	53	88	java/io/IOException
    //   57	61	88	java/io/IOException
    //   65	70	88	java/io/IOException
    //   13	23	118	finally
    //   27	36	118	finally
    //   40	53	118	finally
    //   57	61	118	finally
    //   65	70	118	finally
    //   91	95	118	finally
    //   97	101	118	finally
    //   119	129	138	java/io/IOException
    //   101	110	142	java/io/IOException
    //   70	80	146	java/io/IOException
  }
  
  public void goAway(int paramInt, ErrorCode arg2, ByteString paramByteString)
  {
    if (paramByteString.size() > 0) {}
    synchronized (this$0)
    {
      paramByteString = (FramedStream[])FramedConnection.access$1900(this$0).values().toArray(new FramedStream[FramedConnection.access$1900(this$0).size()]);
      FramedConnection.access$1602(this$0, true);
      int j = paramByteString.length;
      int i = 0;
      if (i < j)
      {
        ??? = paramByteString[i];
        if ((???.getId() > paramInt) && (???.isLocallyInitiated()))
        {
          ???.receiveRstStream(ErrorCode.REFUSED_STREAM);
          this$0.removeStream(???.getId());
        }
        i += 1;
      }
    }
  }
  
  public void headers(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, final List<Header> paramList, HeadersMode paramHeadersMode)
  {
    if (FramedConnection.access$1300(this$0, paramInt1)) {
      FramedConnection.access$1500(this$0, paramInt1, paramList, paramBoolean2);
    }
    FramedStream localFramedStream;
    do
    {
      return;
      synchronized (this$0)
      {
        if (FramedConnection.access$1600(this$0)) {
          return;
        }
      }
      localFramedStream = this$0.getStream(paramInt1);
      if (localFramedStream == null)
      {
        if (paramHeadersMode.failIfStreamAbsent())
        {
          this$0.writeSynResetLater(paramInt1, ErrorCode.INVALID_STREAM);
          return;
        }
        if (paramInt1 <= FramedConnection.access$1700(this$0)) {
          return;
        }
        if (paramInt1 % 2 == FramedConnection.access$1800(this$0) % 2) {
          return;
        }
        paramList = new FramedStream(paramInt1, this$0, paramBoolean1, paramBoolean2, paramList);
        FramedConnection.access$1702(this$0, paramInt1);
        FramedConnection.access$1900(this$0).put(Integer.valueOf(paramInt1), paramList);
        FramedConnection.access$2100().execute(new NamedRunnable("OkHttp %s stream %d", new Object[] { FramedConnection.access$1100(this$0), Integer.valueOf(paramInt1) })
        {
          public void execute()
          {
            try
            {
              FramedConnection.access$2000(this$0).onStream(paramList);
              return;
            }
            catch (IOException localIOException1)
            {
              Internal.logger.log(Level.INFO, "FramedConnection.Listener failure for " + FramedConnection.access$1100(this$0), localIOException1);
              try
              {
                paramList.close(ErrorCode.PROTOCOL_ERROR);
                return;
              }
              catch (IOException localIOException2) {}
            }
          }
        });
        return;
      }
      if (paramHeadersMode.failIfStreamPresent())
      {
        localFramedStream.closeLater(ErrorCode.PROTOCOL_ERROR);
        this$0.removeStream(paramInt1);
        return;
      }
      localFramedStream.receiveHeaders(paramList, paramHeadersMode);
    } while (!paramBoolean2);
    localFramedStream.receiveFin();
  }
  
  public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      Ping localPing = FramedConnection.access$2400(this$0, paramInt1);
      if (localPing != null) {
        localPing.receive();
      }
      return;
    }
    FramedConnection.access$2500(this$0, true, paramInt1, paramInt2, null);
  }
  
  public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
  {
    FramedConnection.access$2600(this$0, paramInt2, paramList);
  }
  
  public void rstStream(int paramInt, ErrorCode paramErrorCode)
  {
    if (FramedConnection.access$1300(this$0, paramInt)) {
      FramedConnection.access$2200(this$0, paramInt, paramErrorCode);
    }
    FramedStream localFramedStream;
    do
    {
      return;
      localFramedStream = this$0.removeStream(paramInt);
    } while (localFramedStream == null);
    localFramedStream.receiveRstStream(paramErrorCode);
  }
  
  public void settings(boolean paramBoolean, Settings paramSettings)
  {
    long l2 = 0L;
    ??? = null;
    for (;;)
    {
      int i;
      long l1;
      synchronized (this$0)
      {
        i = this$0.peerSettings.getInitialWindowSize(65536);
        if (paramBoolean) {
          this$0.peerSettings.clear();
        }
        this$0.peerSettings.merge(paramSettings);
        if (this$0.getProtocol() == Protocol.HTTP_2) {
          ackSettingsLater(paramSettings);
        }
        int j = this$0.peerSettings.getInitialWindowSize(65536);
        l1 = l2;
        paramSettings = (Settings)???;
        if (j != -1)
        {
          l1 = l2;
          paramSettings = (Settings)???;
          if (j != i)
          {
            l2 = j - i;
            if (!FramedConnection.access$2300(this$0))
            {
              this$0.addBytesToWriteWindow(l2);
              FramedConnection.access$2302(this$0, true);
            }
            l1 = l2;
            paramSettings = (Settings)???;
            if (!FramedConnection.access$1900(this$0).isEmpty())
            {
              paramSettings = (FramedStream[])FramedConnection.access$1900(this$0).values().toArray(new FramedStream[FramedConnection.access$1900(this$0).size()]);
              l1 = l2;
            }
          }
        }
        FramedConnection.access$2100().execute(new NamedRunnable("OkHttp %s settings", new Object[] { FramedConnection.access$1100(this$0) })
        {
          public void execute()
          {
            FramedConnection.access$2000(this$0).onSettings(this$0);
          }
        });
        if ((paramSettings == null) || (l1 == 0L)) {
          break;
        }
        j = paramSettings.length;
        i = 0;
        if (i >= j) {
          break;
        }
      }
      synchronized (paramSettings[i])
      {
        ((FramedStream)???).addBytesToWriteWindow(l1);
        i += 1;
        continue;
        paramSettings = finally;
        throw paramSettings;
      }
    }
  }
  
  public void windowUpdate(int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      synchronized (this$0)
      {
        FramedConnection localFramedConnection = this$0;
        bytesLeftInWriteWindow += paramLong;
        this$0.notifyAll();
        return;
      }
    }
    ??? = this$0.getStream(paramInt);
    if (??? != null) {
      try
      {
        ((FramedStream)???).addBytesToWriteWindow(paramLong);
        return;
      }
      finally {}
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.Reader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */