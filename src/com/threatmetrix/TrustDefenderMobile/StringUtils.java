package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

class StringUtils
{
  private static final String TAG = getLogTag(StringUtils.class);
  private static final char[] hexArray = "0123456789abcdef".toCharArray();
  private static final MessageDigest m_md5Digest;
  private static final MessageDigest m_sha1Digest;
  
  static
  {
    Object localObject4 = null;
    Object localObject1 = localObject4;
    if (!NativeGatherer.getInstance().isAvailable()) {
      Log.d(TAG, "Getting SHA1 digest");
    }
    try
    {
      localObject1 = MessageDigest.getInstance("SHA1");
      m_sha1Digest = (MessageDigest)localObject1;
      localObject4 = null;
      localObject1 = localObject4;
      if (!NativeGatherer.getInstance().isAvailable()) {
        Log.d(TAG, "Getting MD5 digest");
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
    {
      try
      {
        localObject1 = MessageDigest.getInstance("MD5");
        m_md5Digest = (MessageDigest)localObject1;
        return;
        localNoSuchAlgorithmException1 = localNoSuchAlgorithmException1;
        Log.v(TAG, "SHA1 digest failed", localNoSuchAlgorithmException1);
        Object localObject2 = localObject4;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
      {
        for (;;)
        {
          Log.v(TAG, "MD5 digest failed", localNoSuchAlgorithmException2);
          Object localObject3 = localObject4;
        }
      }
    }
  }
  
  static String ListToSeparatedString(List<String> paramList, String paramString)
  {
    return ListToSeparatedString(paramList, paramString, false);
  }
  
  static String ListToSeparatedString(List<String> paramList, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!str.isEmpty())
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(paramString);
        }
        localStringBuilder.append(str);
      }
    }
    if ((paramBoolean) && (localStringBuilder.length() > 0)) {
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  static String MD5(String paramString)
    throws InterruptedException
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      paramString = "";
    }
    do
    {
      return paramString;
      if (!NativeGatherer.getInstance().isAvailable()) {
        break;
      }
      ??? = NativeGatherer.getInstance().md5(paramString);
      paramString = (String)???;
    } while (??? != null);
    return "";
    if (m_md5Digest != null) {
      synchronized (m_md5Digest)
      {
        m_md5Digest.update(paramString.getBytes());
        paramString = m_md5Digest.digest();
        m_md5Digest.reset();
        paramString = bytesToHex(paramString);
        return paramString;
      }
    }
    return "";
  }
  
  static String SHA1(String paramString)
    throws InterruptedException
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      paramString = "";
    }
    do
    {
      return paramString;
      if (!NativeGatherer.getInstance().isAvailable()) {
        break;
      }
      ??? = NativeGatherer.getInstance().sha1(paramString);
      paramString = (String)???;
    } while (??? != null);
    return "";
    if (m_sha1Digest != null) {
      synchronized (m_sha1Digest)
      {
        m_sha1Digest.update(paramString.getBytes());
        paramString = m_sha1Digest.digest();
        m_sha1Digest.reset();
        paramString = bytesToHex(paramString);
        return paramString;
      }
    }
    return "";
  }
  
  static String bytesToHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = hexArray[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = hexArray[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  static String getLogTag(Class paramClass)
  {
    String str = "c.t.tdm." + paramClass.getSimpleName();
    paramClass = str;
    if (str.length() > 23) {
      paramClass = str.substring(0, 23);
    }
    return paramClass;
  }
  
  static String new_session_id()
    throws InterruptedException
  {
    Log.d(TAG, "getting UUID");
    if (NativeGatherer.getInstance().isAvailable()) {
      return NativeGatherer.getInstance().getRandomString(32);
    }
    return UUID.randomUUID().toString().toLowerCase(Locale.US).replaceAll("-", "");
  }
  
  static List<String> splitNonRegex(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i = paramString1.indexOf(paramString2);
      if (i == -1)
      {
        if (!paramString1.isEmpty()) {
          localArrayList.add(paramString1);
        }
        return localArrayList;
      }
      if (i > 1) {
        localArrayList.add(paramString1.substring(0, i));
      }
      paramString1 = paramString1.substring(paramString2.length() + i);
    }
  }
  
  static Map<String, String> splitQuery(String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramString = splitNonRegex(paramString, "&").iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      int i = str.indexOf("=");
      try
      {
        localLinkedHashMap.put(URLDecoder.decode(str.substring(0, i), "UTF-8"), URLDecoder.decode(str.substring(i + 1), "UTF-8"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Log.d(TAG, "Unsupported encoding", localUnsupportedEncodingException);
      }
    }
    return localLinkedHashMap;
  }
  
  static String urlEncode(String paramString)
    throws InterruptedException
  {
    if (NativeGatherer.getInstance().isAvailable()) {
      return NativeGatherer.getInstance().urlEncode(paramString);
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Log.e(TAG, "Failed url encoding", paramString);
    }
    return null;
  }
  
  static String xor(String paramString1, String paramString2)
    throws InterruptedException
  {
    if (NativeGatherer.getInstance().isAvailable()) {
      return NativeGatherer.getInstance().xor(paramString1, paramString2);
    }
    String str = paramString1.length() + "&";
    byte[] arrayOfByte = new byte[paramString1.length() + str.length()];
    int n = paramString2.length();
    int j = 0;
    int i = 0;
    int k = 0;
    int i1;
    int m;
    if (k < str.length())
    {
      i1 = (byte)str.charAt(k);
      m = j + 1;
      arrayOfByte[i] = ((byte)(i1 ^ (byte)paramString2.charAt(j) & 0xA));
      if (m < n) {
        break label215;
      }
    }
    label212:
    label215:
    for (j = 0;; j = m)
    {
      k += 1;
      i += 1;
      break;
      k = 0;
      m = j;
      j = i;
      if (k < paramString1.length())
      {
        i1 = (byte)paramString1.charAt(k);
        i = m + 1;
        arrayOfByte[j] = ((byte)(i1 ^ (byte)paramString2.charAt(m) & 0xA));
        if (i < n) {
          break label212;
        }
        i = 0;
      }
      for (;;)
      {
        k += 1;
        j += 1;
        m = i;
        break;
        return bytesToHex(arrayOfByte);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.StringUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */