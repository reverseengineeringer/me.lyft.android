package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class FramedConnection$Builder
{
  private boolean client;
  private String hostName;
  private FramedConnection.Listener listener = FramedConnection.Listener.REFUSE_INCOMING_STREAMS;
  private Protocol protocol = Protocol.SPDY_3;
  private PushObserver pushObserver = PushObserver.CANCEL;
  private BufferedSink sink;
  private Socket socket;
  private BufferedSource source;
  
  public FramedConnection$Builder(boolean paramBoolean)
    throws IOException
  {
    client = paramBoolean;
  }
  
  public FramedConnection build()
    throws IOException
  {
    return new FramedConnection(this, null);
  }
  
  public Builder listener(FramedConnection.Listener paramListener)
  {
    listener = paramListener;
    return this;
  }
  
  public Builder protocol(Protocol paramProtocol)
  {
    protocol = paramProtocol;
    return this;
  }
  
  public Builder pushObserver(PushObserver paramPushObserver)
  {
    pushObserver = paramPushObserver;
    return this;
  }
  
  public Builder socket(Socket paramSocket)
    throws IOException
  {
    return socket(paramSocket, ((InetSocketAddress)paramSocket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(paramSocket)), Okio.buffer(Okio.sink(paramSocket)));
  }
  
  public Builder socket(Socket paramSocket, String paramString, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
  {
    socket = paramSocket;
    hostName = paramString;
    source = paramBufferedSource;
    sink = paramBufferedSink;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.FramedConnection.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */