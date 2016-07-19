package com.google.android.gms.internal;

import java.io.IOException;

public class zzapb
  extends IOException
{
  public zzapb(String paramString)
  {
    super(paramString);
  }
  
  static zzapb ag()
  {
    return new zzapb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static zzapb ah()
  {
    return new zzapb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static zzapb ai()
  {
    return new zzapb("CodedInputStream encountered a malformed varint.");
  }
  
  static zzapb aj()
  {
    return new zzapb("Protocol message contained an invalid tag (zero).");
  }
  
  static zzapb ak()
  {
    return new zzapb("Protocol message end-group tag did not match expected tag.");
  }
  
  static zzapb al()
  {
    return new zzapb("Protocol message tag had invalid wire type.");
  }
  
  static zzapb am()
  {
    return new zzapb("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzapb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */