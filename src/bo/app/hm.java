package bo.app;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class hm
  implements hk
{
  private static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      jx.a(paramArrayOfByte);
    }
    return null;
  }
  
  public final String a(String paramString)
  {
    return new BigInteger(a(paramString.getBytes())).abs().toString(36);
  }
}

/* Location:
 * Qualified Name:     bo.app.hm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */