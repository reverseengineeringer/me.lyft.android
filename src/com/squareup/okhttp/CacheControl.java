package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HeaderParser;
import java.util.concurrent.TimeUnit;

public final class CacheControl
{
  public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
  public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
  String headerValue;
  private final boolean isPrivate;
  private final boolean isPublic;
  private final int maxAgeSeconds;
  private final int maxStaleSeconds;
  private final int minFreshSeconds;
  private final boolean mustRevalidate;
  private final boolean noCache;
  private final boolean noStore;
  private final boolean noTransform;
  private final boolean onlyIfCached;
  private final int sMaxAgeSeconds;
  
  private CacheControl(Builder paramBuilder)
  {
    noCache = noCache;
    noStore = noStore;
    maxAgeSeconds = maxAgeSeconds;
    sMaxAgeSeconds = -1;
    isPrivate = false;
    isPublic = false;
    mustRevalidate = false;
    maxStaleSeconds = maxStaleSeconds;
    minFreshSeconds = minFreshSeconds;
    onlyIfCached = onlyIfCached;
    noTransform = noTransform;
  }
  
  private CacheControl(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, String paramString)
  {
    noCache = paramBoolean1;
    noStore = paramBoolean2;
    maxAgeSeconds = paramInt1;
    sMaxAgeSeconds = paramInt2;
    isPrivate = paramBoolean3;
    isPublic = paramBoolean4;
    mustRevalidate = paramBoolean5;
    maxStaleSeconds = paramInt3;
    minFreshSeconds = paramInt4;
    onlyIfCached = paramBoolean6;
    noTransform = paramBoolean7;
    headerValue = paramString;
  }
  
  private String headerValue()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (noCache) {
      localStringBuilder.append("no-cache, ");
    }
    if (noStore) {
      localStringBuilder.append("no-store, ");
    }
    if (maxAgeSeconds != -1) {
      localStringBuilder.append("max-age=").append(maxAgeSeconds).append(", ");
    }
    if (sMaxAgeSeconds != -1) {
      localStringBuilder.append("s-maxage=").append(sMaxAgeSeconds).append(", ");
    }
    if (isPrivate) {
      localStringBuilder.append("private, ");
    }
    if (isPublic) {
      localStringBuilder.append("public, ");
    }
    if (mustRevalidate) {
      localStringBuilder.append("must-revalidate, ");
    }
    if (maxStaleSeconds != -1) {
      localStringBuilder.append("max-stale=").append(maxStaleSeconds).append(", ");
    }
    if (minFreshSeconds != -1) {
      localStringBuilder.append("min-fresh=").append(minFreshSeconds).append(", ");
    }
    if (onlyIfCached) {
      localStringBuilder.append("only-if-cached, ");
    }
    if (noTransform) {
      localStringBuilder.append("no-transform, ");
    }
    if (localStringBuilder.length() == 0) {
      return "";
    }
    localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
    return localStringBuilder.toString();
  }
  
  public static CacheControl parse(Headers paramHeaders)
  {
    boolean bool7 = false;
    boolean bool6 = false;
    int i1 = -1;
    int n = -1;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    int m = -1;
    int k = -1;
    boolean bool2 = false;
    boolean bool1 = false;
    int i = 1;
    Object localObject1 = null;
    int i2 = 0;
    int i8 = paramHeaders.size();
    while (i2 < i8)
    {
      String str2 = paramHeaders.name(i2);
      String str1 = paramHeaders.value(i2);
      int i3;
      if (str2.equalsIgnoreCase("Cache-Control")) {
        if (localObject1 != null)
        {
          i = 0;
          i3 = 0;
        }
      }
      label89:
      boolean bool8;
      boolean bool9;
      int j;
      int i4;
      boolean bool10;
      boolean bool11;
      boolean bool12;
      int i5;
      int i6;
      boolean bool13;
      boolean bool14;
      Object localObject2;
      int i7;
      for (;;)
      {
        bool8 = bool7;
        bool9 = bool6;
        j = i1;
        i4 = n;
        bool10 = bool5;
        bool11 = bool4;
        bool12 = bool3;
        i5 = m;
        i6 = k;
        bool13 = bool2;
        bool14 = bool1;
        localObject2 = localObject1;
        i7 = i;
        if (i3 >= str1.length()) {
          break label603;
        }
        j = HeaderParser.skipUntil(str1, i3, "=,;");
        str2 = str1.substring(i3, j).trim();
        if ((j == str1.length()) || (str1.charAt(j) == ',') || (str1.charAt(j) == ';'))
        {
          j += 1;
          localObject2 = null;
        }
        for (;;)
        {
          if (!"no-cache".equalsIgnoreCase(str2)) {
            break label390;
          }
          bool7 = true;
          i3 = j;
          break label89;
          localObject1 = str1;
          break;
          bool8 = bool7;
          bool9 = bool6;
          j = i1;
          i4 = n;
          bool10 = bool5;
          bool11 = bool4;
          bool12 = bool3;
          i5 = m;
          i6 = k;
          bool13 = bool2;
          bool14 = bool1;
          localObject2 = localObject1;
          i7 = i;
          if (!str2.equalsIgnoreCase("Pragma")) {
            break label603;
          }
          i = 0;
          break;
          i3 = HeaderParser.skipWhitespace(str1, j + 1);
          if ((i3 < str1.length()) && (str1.charAt(i3) == '"'))
          {
            j = i3 + 1;
            i3 = HeaderParser.skipUntil(str1, j, "\"");
            localObject2 = str1.substring(j, i3);
            j = i3 + 1;
          }
          else
          {
            j = HeaderParser.skipUntil(str1, i3, ",;");
            localObject2 = str1.substring(i3, j).trim();
          }
        }
        label390:
        if ("no-store".equalsIgnoreCase(str2))
        {
          bool6 = true;
          i3 = j;
        }
        else if ("max-age".equalsIgnoreCase(str2))
        {
          i1 = HeaderParser.parseSeconds((String)localObject2, -1);
          i3 = j;
        }
        else if ("s-maxage".equalsIgnoreCase(str2))
        {
          n = HeaderParser.parseSeconds((String)localObject2, -1);
          i3 = j;
        }
        else if ("private".equalsIgnoreCase(str2))
        {
          bool5 = true;
          i3 = j;
        }
        else if ("public".equalsIgnoreCase(str2))
        {
          bool4 = true;
          i3 = j;
        }
        else if ("must-revalidate".equalsIgnoreCase(str2))
        {
          bool3 = true;
          i3 = j;
        }
        else if ("max-stale".equalsIgnoreCase(str2))
        {
          m = HeaderParser.parseSeconds((String)localObject2, Integer.MAX_VALUE);
          i3 = j;
        }
        else if ("min-fresh".equalsIgnoreCase(str2))
        {
          k = HeaderParser.parseSeconds((String)localObject2, -1);
          i3 = j;
        }
        else if ("only-if-cached".equalsIgnoreCase(str2))
        {
          bool2 = true;
          i3 = j;
        }
        else
        {
          i3 = j;
          if ("no-transform".equalsIgnoreCase(str2))
          {
            bool1 = true;
            i3 = j;
          }
        }
      }
      label603:
      i2 += 1;
      bool7 = bool8;
      bool6 = bool9;
      i1 = j;
      n = i4;
      bool5 = bool10;
      bool4 = bool11;
      bool3 = bool12;
      m = i5;
      k = i6;
      bool2 = bool13;
      bool1 = bool14;
      localObject1 = localObject2;
      i = i7;
    }
    if (i == 0) {
      localObject1 = null;
    }
    return new CacheControl(bool7, bool6, i1, n, bool5, bool4, bool3, m, k, bool2, bool1, (String)localObject1);
  }
  
  public boolean isPrivate()
  {
    return isPrivate;
  }
  
  public boolean isPublic()
  {
    return isPublic;
  }
  
  public int maxAgeSeconds()
  {
    return maxAgeSeconds;
  }
  
  public int maxStaleSeconds()
  {
    return maxStaleSeconds;
  }
  
  public int minFreshSeconds()
  {
    return minFreshSeconds;
  }
  
  public boolean mustRevalidate()
  {
    return mustRevalidate;
  }
  
  public boolean noCache()
  {
    return noCache;
  }
  
  public boolean noStore()
  {
    return noStore;
  }
  
  public boolean noTransform()
  {
    return noTransform;
  }
  
  public boolean onlyIfCached()
  {
    return onlyIfCached;
  }
  
  public int sMaxAgeSeconds()
  {
    return sMaxAgeSeconds;
  }
  
  public String toString()
  {
    String str = headerValue;
    if (str != null) {
      return str;
    }
    str = headerValue();
    headerValue = str;
    return str;
  }
  
  public static final class Builder
  {
    int maxAgeSeconds = -1;
    int maxStaleSeconds = -1;
    int minFreshSeconds = -1;
    boolean noCache;
    boolean noStore;
    boolean noTransform;
    boolean onlyIfCached;
    
    public CacheControl build()
    {
      return new CacheControl(this, null);
    }
    
    public Builder maxAge(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("maxAge < 0: " + paramInt);
      }
      long l = paramTimeUnit.toSeconds(paramInt);
      if (l > 2147483647L) {}
      for (paramInt = Integer.MAX_VALUE;; paramInt = (int)l)
      {
        maxAgeSeconds = paramInt;
        return this;
      }
    }
    
    public Builder maxStale(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("maxStale < 0: " + paramInt);
      }
      long l = paramTimeUnit.toSeconds(paramInt);
      if (l > 2147483647L) {}
      for (paramInt = Integer.MAX_VALUE;; paramInt = (int)l)
      {
        maxStaleSeconds = paramInt;
        return this;
      }
    }
    
    public Builder minFresh(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt < 0) {
        throw new IllegalArgumentException("minFresh < 0: " + paramInt);
      }
      long l = paramTimeUnit.toSeconds(paramInt);
      if (l > 2147483647L) {}
      for (paramInt = Integer.MAX_VALUE;; paramInt = (int)l)
      {
        minFreshSeconds = paramInt;
        return this;
      }
    }
    
    public Builder noCache()
    {
      noCache = true;
      return this;
    }
    
    public Builder noStore()
    {
      noStore = true;
      return this;
    }
    
    public Builder noTransform()
    {
      noTransform = true;
      return this;
    }
    
    public Builder onlyIfCached()
    {
      onlyIfCached = true;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.CacheControl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */