package com.squareup.okhttp;

import java.net.Socket;

public abstract interface Connection
{
  public abstract Handshake getHandshake();
  
  public abstract Protocol getProtocol();
  
  public abstract Route getRoute();
  
  public abstract Socket getSocket();
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.Connection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */