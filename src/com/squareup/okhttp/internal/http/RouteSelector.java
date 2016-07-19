package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Dns;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.RouteDatabase;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class RouteSelector
{
  private final Address address;
  private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
  private InetSocketAddress lastInetSocketAddress;
  private Proxy lastProxy;
  private int nextInetSocketAddressIndex;
  private int nextProxyIndex;
  private final List<Route> postponedRoutes = new ArrayList();
  private List<Proxy> proxies = Collections.emptyList();
  private final RouteDatabase routeDatabase;
  
  public RouteSelector(Address paramAddress, RouteDatabase paramRouteDatabase)
  {
    address = paramAddress;
    routeDatabase = paramRouteDatabase;
    resetNextProxy(paramAddress.url(), paramAddress.getProxy());
  }
  
  static String getHostString(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null) {
      return paramInetSocketAddress.getHostName();
    }
    return localInetAddress.getHostAddress();
  }
  
  private boolean hasNextInetSocketAddress()
  {
    return nextInetSocketAddressIndex < inetSocketAddresses.size();
  }
  
  private boolean hasNextPostponed()
  {
    return !postponedRoutes.isEmpty();
  }
  
  private boolean hasNextProxy()
  {
    return nextProxyIndex < proxies.size();
  }
  
  private InetSocketAddress nextInetSocketAddress()
    throws IOException
  {
    if (!hasNextInetSocketAddress()) {
      throw new SocketException("No route to " + address.getUriHost() + "; exhausted inet socket addresses: " + inetSocketAddresses);
    }
    List localList = inetSocketAddresses;
    int i = nextInetSocketAddressIndex;
    nextInetSocketAddressIndex = (i + 1);
    return (InetSocketAddress)localList.get(i);
  }
  
  private Route nextPostponed()
  {
    return (Route)postponedRoutes.remove(0);
  }
  
  private Proxy nextProxy()
    throws IOException
  {
    if (!hasNextProxy()) {
      throw new SocketException("No route to " + address.getUriHost() + "; exhausted proxy configurations: " + proxies);
    }
    Object localObject = proxies;
    int i = nextProxyIndex;
    nextProxyIndex = (i + 1);
    localObject = (Proxy)((List)localObject).get(i);
    resetNextInetSocketAddress((Proxy)localObject);
    return (Proxy)localObject;
  }
  
  private void resetNextInetSocketAddress(Proxy paramProxy)
    throws IOException
  {
    inetSocketAddresses = new ArrayList();
    Object localObject;
    if ((paramProxy.type() == Proxy.Type.DIRECT) || (paramProxy.type() == Proxy.Type.SOCKS)) {
      localObject = address.getUriHost();
    }
    InetSocketAddress localInetSocketAddress;
    for (int i = address.getUriPort(); (i < 1) || (i > 65535); i = localInetSocketAddress.getPort())
    {
      throw new SocketException("No route to " + (String)localObject + ":" + i + "; port is out of range");
      localObject = paramProxy.address();
      if (!(localObject instanceof InetSocketAddress)) {
        throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + localObject.getClass());
      }
      localInetSocketAddress = (InetSocketAddress)localObject;
      localObject = getHostString(localInetSocketAddress);
    }
    if (paramProxy.type() == Proxy.Type.SOCKS) {
      inetSocketAddresses.add(InetSocketAddress.createUnresolved((String)localObject, i));
    }
    for (;;)
    {
      nextInetSocketAddressIndex = 0;
      return;
      paramProxy = address.getDns().lookup((String)localObject);
      int j = 0;
      int k = paramProxy.size();
      while (j < k)
      {
        localObject = (InetAddress)paramProxy.get(j);
        inetSocketAddresses.add(new InetSocketAddress((InetAddress)localObject, i));
        j += 1;
      }
    }
  }
  
  private void resetNextProxy(HttpUrl paramHttpUrl, Proxy paramProxy)
  {
    if (paramProxy != null) {
      proxies = Collections.singletonList(paramProxy);
    }
    for (;;)
    {
      nextProxyIndex = 0;
      return;
      proxies = new ArrayList();
      paramHttpUrl = address.getProxySelector().select(paramHttpUrl.uri());
      if (paramHttpUrl != null) {
        proxies.addAll(paramHttpUrl);
      }
      proxies.removeAll(Collections.singleton(Proxy.NO_PROXY));
      proxies.add(Proxy.NO_PROXY);
    }
  }
  
  public void connectFailed(Route paramRoute, IOException paramIOException)
  {
    if ((paramRoute.getProxy().type() != Proxy.Type.DIRECT) && (address.getProxySelector() != null)) {
      address.getProxySelector().connectFailed(address.url().uri(), paramRoute.getProxy().address(), paramIOException);
    }
    routeDatabase.failed(paramRoute);
  }
  
  public boolean hasNext()
  {
    return (hasNextInetSocketAddress()) || (hasNextProxy()) || (hasNextPostponed());
  }
  
  public Route next()
    throws IOException
  {
    Object localObject;
    if (!hasNextInetSocketAddress()) {
      if (!hasNextProxy())
      {
        if (!hasNextPostponed()) {
          throw new NoSuchElementException();
        }
        localObject = nextPostponed();
      }
    }
    Route localRoute;
    do
    {
      return (Route)localObject;
      lastProxy = nextProxy();
      lastInetSocketAddress = nextInetSocketAddress();
      localRoute = new Route(address, lastProxy, lastInetSocketAddress);
      localObject = localRoute;
    } while (!routeDatabase.shouldPostpone(localRoute));
    postponedRoutes.add(localRoute);
    return next();
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.http.RouteSelector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */