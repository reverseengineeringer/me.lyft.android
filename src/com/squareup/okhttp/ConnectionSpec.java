package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpec
{
  private static final CipherSuite[] APPROVED_CIPHER_SUITES = { CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA };
  public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
  public static final ConnectionSpec COMPATIBLE_TLS;
  public static final ConnectionSpec MODERN_TLS = new Builder(true).cipherSuites(APPROVED_CIPHER_SUITES).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
  private final String[] cipherSuites;
  private final boolean supportsTlsExtensions;
  private final boolean tls;
  private final String[] tlsVersions;
  
  static
  {
    COMPATIBLE_TLS = new Builder(MODERN_TLS).tlsVersions(new TlsVersion[] { TlsVersion.TLS_1_0 }).supportsTlsExtensions(true).build();
  }
  
  private ConnectionSpec(Builder paramBuilder)
  {
    tls = tls;
    cipherSuites = cipherSuites;
    tlsVersions = tlsVersions;
    supportsTlsExtensions = supportsTlsExtensions;
  }
  
  private static boolean nonEmptyIntersection(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length == 0) || (paramArrayOfString2.length == 0)) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        if (Util.contains(paramArrayOfString2, paramArrayOfString1[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private ConnectionSpec supportedSpec(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    String[] arrayOfString1;
    if (cipherSuites != null)
    {
      arrayOfString1 = (String[])Util.intersect(String.class, cipherSuites, paramSSLSocket.getEnabledCipherSuites());
      if (tlsVersions == null) {
        break label109;
      }
    }
    label109:
    for (String[] arrayOfString2 = (String[])Util.intersect(String.class, tlsVersions, paramSSLSocket.getEnabledProtocols());; arrayOfString2 = paramSSLSocket.getEnabledProtocols())
    {
      String[] arrayOfString3 = arrayOfString1;
      if (paramBoolean)
      {
        arrayOfString3 = arrayOfString1;
        if (Util.contains(paramSSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
          arrayOfString3 = Util.concat(arrayOfString1, "TLS_FALLBACK_SCSV");
        }
      }
      return new Builder(this).cipherSuites(arrayOfString3).tlsVersions(arrayOfString2).build();
      arrayOfString1 = paramSSLSocket.getEnabledCipherSuites();
      break;
    }
  }
  
  void apply(SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    ConnectionSpec localConnectionSpec = supportedSpec(paramSSLSocket, paramBoolean);
    if (tlsVersions != null) {
      paramSSLSocket.setEnabledProtocols(tlsVersions);
    }
    if (cipherSuites != null) {
      paramSSLSocket.setEnabledCipherSuites(cipherSuites);
    }
  }
  
  public List<CipherSuite> cipherSuites()
  {
    if (cipherSuites == null) {
      return null;
    }
    CipherSuite[] arrayOfCipherSuite = new CipherSuite[cipherSuites.length];
    int i = 0;
    while (i < cipherSuites.length)
    {
      arrayOfCipherSuite[i] = CipherSuite.forJavaName(cipherSuites[i]);
      i += 1;
    }
    return Util.immutableList(arrayOfCipherSuite);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionSpec)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (ConnectionSpec)paramObject;
    } while ((tls != tls) || ((tls) && ((!Arrays.equals(cipherSuites, cipherSuites)) || (!Arrays.equals(tlsVersions, tlsVersions)) || (supportsTlsExtensions != supportsTlsExtensions))));
    return true;
  }
  
  public int hashCode()
  {
    int i = 17;
    int j;
    int k;
    if (tls)
    {
      j = Arrays.hashCode(cipherSuites);
      k = Arrays.hashCode(tlsVersions);
      if (!supportsTlsExtensions) {
        break label53;
      }
    }
    label53:
    for (i = 0;; i = 1)
    {
      i = ((j + 527) * 31 + k) * 31 + i;
      return i;
    }
  }
  
  public boolean isCompatible(SSLSocket paramSSLSocket)
  {
    if (!tls) {}
    while (((tlsVersions != null) && (!nonEmptyIntersection(tlsVersions, paramSSLSocket.getEnabledProtocols()))) || ((cipherSuites != null) && (!nonEmptyIntersection(cipherSuites, paramSSLSocket.getEnabledCipherSuites())))) {
      return false;
    }
    return true;
  }
  
  public boolean isTls()
  {
    return tls;
  }
  
  public boolean supportsTlsExtensions()
  {
    return supportsTlsExtensions;
  }
  
  public List<TlsVersion> tlsVersions()
  {
    if (tlsVersions == null) {
      return null;
    }
    TlsVersion[] arrayOfTlsVersion = new TlsVersion[tlsVersions.length];
    int i = 0;
    while (i < tlsVersions.length)
    {
      arrayOfTlsVersion[i] = TlsVersion.forJavaName(tlsVersions[i]);
      i += 1;
    }
    return Util.immutableList(arrayOfTlsVersion);
  }
  
  public String toString()
  {
    if (!tls) {
      return "ConnectionSpec()";
    }
    String str1;
    if (cipherSuites != null)
    {
      str1 = cipherSuites().toString();
      if (tlsVersions == null) {
        break label92;
      }
    }
    label92:
    for (String str2 = tlsVersions().toString();; str2 = "[all enabled]")
    {
      return "ConnectionSpec(cipherSuites=" + str1 + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + supportsTlsExtensions + ")";
      str1 = "[all enabled]";
      break;
    }
  }
  
  public static final class Builder
  {
    private String[] cipherSuites;
    private boolean supportsTlsExtensions;
    private boolean tls;
    private String[] tlsVersions;
    
    public Builder(ConnectionSpec paramConnectionSpec)
    {
      tls = tls;
      cipherSuites = cipherSuites;
      tlsVersions = tlsVersions;
      supportsTlsExtensions = supportsTlsExtensions;
    }
    
    Builder(boolean paramBoolean)
    {
      tls = paramBoolean;
    }
    
    public Builder allEnabledCipherSuites()
    {
      if (!tls) {
        throw new IllegalStateException("no cipher suites for cleartext connections");
      }
      cipherSuites = null;
      return this;
    }
    
    public Builder allEnabledTlsVersions()
    {
      if (!tls) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      tlsVersions = null;
      return this;
    }
    
    public ConnectionSpec build()
    {
      return new ConnectionSpec(this, null);
    }
    
    public Builder cipherSuites(CipherSuite... paramVarArgs)
    {
      if (!tls) {
        throw new IllegalStateException("no cipher suites for cleartext connections");
      }
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = javaName;
        i += 1;
      }
      return cipherSuites(arrayOfString);
    }
    
    public Builder cipherSuites(String... paramVarArgs)
    {
      if (!tls) {
        throw new IllegalStateException("no cipher suites for cleartext connections");
      }
      if (paramVarArgs.length == 0) {
        throw new IllegalArgumentException("At least one cipher suite is required");
      }
      cipherSuites = ((String[])paramVarArgs.clone());
      return this;
    }
    
    public Builder supportsTlsExtensions(boolean paramBoolean)
    {
      if (!tls) {
        throw new IllegalStateException("no TLS extensions for cleartext connections");
      }
      supportsTlsExtensions = paramBoolean;
      return this;
    }
    
    public Builder tlsVersions(TlsVersion... paramVarArgs)
    {
      if (!tls) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = javaName;
        i += 1;
      }
      return tlsVersions(arrayOfString);
    }
    
    public Builder tlsVersions(String... paramVarArgs)
    {
      if (!tls) {
        throw new IllegalStateException("no TLS versions for cleartext connections");
      }
      if (paramVarArgs.length == 0) {
        throw new IllegalArgumentException("At least one TLS version is required");
      }
      tlsVersions = ((String[])paramVarArgs.clone());
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.ConnectionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */