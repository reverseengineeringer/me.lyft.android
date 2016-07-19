package com.squareup.okhttp;

public final class ConnectionSpec$Builder
{
  private String[] cipherSuites;
  private boolean supportsTlsExtensions;
  private boolean tls;
  private String[] tlsVersions;
  
  public ConnectionSpec$Builder(ConnectionSpec paramConnectionSpec)
  {
    tls = ConnectionSpec.access$400(paramConnectionSpec);
    cipherSuites = ConnectionSpec.access$500(paramConnectionSpec);
    tlsVersions = ConnectionSpec.access$600(paramConnectionSpec);
    supportsTlsExtensions = ConnectionSpec.access$700(paramConnectionSpec);
  }
  
  ConnectionSpec$Builder(boolean paramBoolean)
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

/* Location:
 * Qualified Name:     com.squareup.okhttp.ConnectionSpec.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */