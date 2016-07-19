package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.Sink;

public final class StreamAllocation
{
  public final Address address;
  private boolean canceled;
  private RealConnection connection;
  private final ConnectionPool connectionPool;
  private boolean released;
  private RouteSelector routeSelector;
  private HttpStream stream;
  
  public StreamAllocation(ConnectionPool paramConnectionPool, Address paramAddress)
  {
    connectionPool = paramConnectionPool;
    address = paramAddress;
  }
  
  private void connectionFailed(IOException paramIOException)
  {
    synchronized (connectionPool)
    {
      if (routeSelector != null)
      {
        if (connection.streamCount == 0)
        {
          Route localRoute = connection.getRoute();
          routeSelector.connectFailed(localRoute, paramIOException);
        }
      }
      else
      {
        connectionFailed();
        return;
      }
      routeSelector = null;
    }
  }
  
  private void deallocate(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    ConnectionPool localConnectionPool = connectionPool;
    if (paramBoolean3) {}
    try
    {
      stream = null;
      if (paramBoolean2) {
        released = true;
      }
      Object localObject1 = localObject4;
      if (connection != null)
      {
        if (paramBoolean1) {
          connection.noNewStreams = true;
        }
        localObject1 = localObject4;
        if (stream == null) {
          if (!released)
          {
            localObject1 = localObject4;
            if (!connection.noNewStreams) {}
          }
          else
          {
            release(connection);
            if (connection.streamCount > 0) {
              routeSelector = null;
            }
            localObject1 = localObject3;
            if (connection.allocations.isEmpty())
            {
              connection.idleAtNanos = System.nanoTime();
              localObject1 = localObject3;
              if (Internal.instance.connectionBecameIdle(connectionPool, connection)) {
                localObject1 = connection;
              }
            }
            connection = null;
          }
        }
      }
      if (localObject1 != null) {
        Util.closeQuietly(((RealConnection)localObject1).getSocket());
      }
      return;
    }
    finally {}
  }
  
  private RealConnection findConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws IOException, RouteException
  {
    synchronized (connectionPool)
    {
      if (released) {
        throw new IllegalStateException("released");
      }
    }
    if (stream != null) {
      throw new IllegalStateException("stream != null");
    }
    if (canceled) {
      throw new IOException("Canceled");
    }
    RealConnection localRealConnection1 = connection;
    if ((localRealConnection1 != null) && (!noNewStreams)) {
      return localRealConnection1;
    }
    localRealConnection1 = Internal.instance.get(connectionPool, address, this);
    if (localRealConnection1 != null)
    {
      connection = localRealConnection1;
      return localRealConnection1;
    }
    if (routeSelector == null) {
      routeSelector = new RouteSelector(address, routeDatabase());
    }
    localRealConnection1 = new RealConnection(routeSelector.next());
    acquire(localRealConnection1);
    synchronized (connectionPool)
    {
      Internal.instance.put(connectionPool, localRealConnection1);
      connection = localRealConnection1;
      if (canceled) {
        throw new IOException("Canceled");
      }
    }
    localRealConnection2.connect(paramInt1, paramInt2, paramInt3, address.getConnectionSpecs(), paramBoolean);
    routeDatabase().connected(localRealConnection2.getRoute());
    return localRealConnection2;
  }
  
  private RealConnection findHealthyConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException, RouteException
  {
    for (;;)
    {
      RealConnection localRealConnection1 = findConnection(paramInt1, paramInt2, paramInt3, paramBoolean1);
      synchronized (connectionPool)
      {
        if (streamCount == 0) {
          return localRealConnection1;
        }
        if (!localRealConnection1.isHealthy(paramBoolean2)) {
          connectionFailed();
        }
      }
    }
    return localRealConnection2;
  }
  
  private boolean isRecoverable(RouteException paramRouteException)
  {
    paramRouteException = paramRouteException.getLastConnectException();
    if ((paramRouteException instanceof ProtocolException)) {}
    do
    {
      return false;
      if ((paramRouteException instanceof InterruptedIOException)) {
        return paramRouteException instanceof SocketTimeoutException;
      }
    } while ((((paramRouteException instanceof SSLHandshakeException)) && ((paramRouteException.getCause() instanceof CertificateException))) || ((paramRouteException instanceof SSLPeerUnverifiedException)));
    return true;
  }
  
  private boolean isRecoverable(IOException paramIOException)
  {
    if ((paramIOException instanceof ProtocolException)) {}
    while ((paramIOException instanceof InterruptedIOException)) {
      return false;
    }
    return true;
  }
  
  private void release(RealConnection paramRealConnection)
  {
    int i = 0;
    int j = allocations.size();
    while (i < j)
    {
      if (((Reference)allocations.get(i)).get() == this)
      {
        allocations.remove(i);
        return;
      }
      i += 1;
    }
    throw new IllegalStateException();
  }
  
  private RouteDatabase routeDatabase()
  {
    return Internal.instance.routeDatabase(connectionPool);
  }
  
  public void acquire(RealConnection paramRealConnection)
  {
    allocations.add(new WeakReference(this));
  }
  
  public void cancel()
  {
    RealConnection localRealConnection;
    do
    {
      synchronized (connectionPool)
      {
        canceled = true;
        HttpStream localHttpStream = stream;
        localRealConnection = connection;
        if (localHttpStream != null)
        {
          localHttpStream.cancel();
          return;
        }
      }
    } while (localRealConnection == null);
    localRealConnection.cancel();
  }
  
  public RealConnection connection()
  {
    try
    {
      RealConnection localRealConnection = connection;
      return localRealConnection;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void connectionFailed()
  {
    deallocate(true, false, true);
  }
  
  /* Error */
  public HttpStream newStream(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
    throws RouteException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: iload_3
    //   4: iload 4
    //   6: iload 5
    //   8: invokespecial 235	com/squareup/okhttp/internal/http/StreamAllocation:findHealthyConnection	(IIIZZ)Lcom/squareup/okhttp/internal/io/RealConnection;
    //   11: astore 7
    //   13: aload 7
    //   15: getfield 239	com/squareup/okhttp/internal/io/RealConnection:framedConnection	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   18: ifnull +51 -> 69
    //   21: new 241	com/squareup/okhttp/internal/http/Http2xStream
    //   24: dup
    //   25: aload_0
    //   26: aload 7
    //   28: getfield 239	com/squareup/okhttp/internal/io/RealConnection:framedConnection	Lcom/squareup/okhttp/internal/framed/FramedConnection;
    //   31: invokespecial 244	com/squareup/okhttp/internal/http/Http2xStream:<init>	(Lcom/squareup/okhttp/internal/http/StreamAllocation;Lcom/squareup/okhttp/internal/framed/FramedConnection;)V
    //   34: astore 6
    //   36: aload_0
    //   37: getfield 24	com/squareup/okhttp/internal/http/StreamAllocation:connectionPool	Lcom/squareup/okhttp/ConnectionPool;
    //   40: astore 8
    //   42: aload 8
    //   44: monitorenter
    //   45: aload 7
    //   47: aload 7
    //   49: getfield 39	com/squareup/okhttp/internal/io/RealConnection:streamCount	I
    //   52: iconst_1
    //   53: iadd
    //   54: putfield 39	com/squareup/okhttp/internal/io/RealConnection:streamCount	I
    //   57: aload_0
    //   58: aload 6
    //   60: putfield 55	com/squareup/okhttp/internal/http/StreamAllocation:stream	Lcom/squareup/okhttp/internal/http/HttpStream;
    //   63: aload 8
    //   65: monitorexit
    //   66: aload 6
    //   68: areturn
    //   69: aload 7
    //   71: invokevirtual 98	com/squareup/okhttp/internal/io/RealConnection:getSocket	()Ljava/net/Socket;
    //   74: iload_2
    //   75: invokevirtual 250	java/net/Socket:setSoTimeout	(I)V
    //   78: aload 7
    //   80: getfield 254	com/squareup/okhttp/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   83: invokeinterface 260 1 0
    //   88: iload_2
    //   89: i2l
    //   90: getstatic 266	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   93: invokevirtual 271	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
    //   96: pop
    //   97: aload 7
    //   99: getfield 275	com/squareup/okhttp/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   102: invokeinterface 278 1 0
    //   107: iload_3
    //   108: i2l
    //   109: getstatic 266	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   112: invokevirtual 271	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
    //   115: pop
    //   116: new 280	com/squareup/okhttp/internal/http/Http1xStream
    //   119: dup
    //   120: aload_0
    //   121: aload 7
    //   123: getfield 254	com/squareup/okhttp/internal/io/RealConnection:source	Lokio/BufferedSource;
    //   126: aload 7
    //   128: getfield 275	com/squareup/okhttp/internal/io/RealConnection:sink	Lokio/BufferedSink;
    //   131: invokespecial 283	com/squareup/okhttp/internal/http/Http1xStream:<init>	(Lcom/squareup/okhttp/internal/http/StreamAllocation;Lokio/BufferedSource;Lokio/BufferedSink;)V
    //   134: astore 6
    //   136: goto -100 -> 36
    //   139: astore 6
    //   141: aload 8
    //   143: monitorexit
    //   144: aload 6
    //   146: athrow
    //   147: astore 6
    //   149: new 110	com/squareup/okhttp/internal/http/RouteException
    //   152: dup
    //   153: aload 6
    //   155: invokespecial 285	com/squareup/okhttp/internal/http/RouteException:<init>	(Ljava/io/IOException;)V
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	StreamAllocation
    //   0	159	1	paramInt1	int
    //   0	159	2	paramInt2	int
    //   0	159	3	paramInt3	int
    //   0	159	4	paramBoolean1	boolean
    //   0	159	5	paramBoolean2	boolean
    //   34	101	6	localObject1	Object
    //   139	6	6	localObject2	Object
    //   147	7	6	localIOException	IOException
    //   11	116	7	localRealConnection	RealConnection
    // Exception table:
    //   from	to	target	type
    //   45	66	139	finally
    //   141	144	139	finally
    //   0	36	147	java/io/IOException
    //   36	45	147	java/io/IOException
    //   69	136	147	java/io/IOException
    //   144	147	147	java/io/IOException
  }
  
  public void noNewStreams()
  {
    deallocate(true, false, false);
  }
  
  public boolean recover(RouteException paramRouteException)
  {
    if (connection != null) {
      connectionFailed(paramRouteException.getLastConnectException());
    }
    return ((routeSelector == null) || (routeSelector.hasNext())) && (isRecoverable(paramRouteException));
  }
  
  public boolean recover(IOException paramIOException, Sink paramSink)
  {
    int i;
    if (connection != null)
    {
      i = connection.streamCount;
      connectionFailed(paramIOException);
      if (i != 1) {}
    }
    for (;;)
    {
      return false;
      if ((paramSink == null) || ((paramSink instanceof RetryableSink))) {}
      for (i = 1; ((routeSelector == null) || (routeSelector.hasNext())) && (isRecoverable(paramIOException)) && (i != 0); i = 0) {
        return true;
      }
    }
  }
  
  public void release()
  {
    deallocate(false, true, false);
  }
  
  public HttpStream stream()
  {
    synchronized (connectionPool)
    {
      HttpStream localHttpStream = stream;
      return localHttpStream;
    }
  }
  
  public void streamFinished(HttpStream paramHttpStream)
  {
    ConnectionPool localConnectionPool = connectionPool;
    if (paramHttpStream != null) {}
    try
    {
      if (paramHttpStream != stream) {
        throw new IllegalStateException("expected " + stream + " but was " + paramHttpStream);
      }
    }
    finally
    {
      throw paramHttpStream;
    }
  }
  
  public String toString()
  {
    return address.toString();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.StreamAllocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */