package com.leanplum;

import android.util.Log;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class a<T>
{
  private String a;
  private String b;
  private T c;
  private boolean d;
  
  public static a<Integer> a(String paramString, int paramInt)
  {
    return a(paramString, Integer.valueOf(paramInt), "color");
  }
  
  public static <T> a<T> a(String paramString, T paramT)
  {
    return a(paramString, paramT, aU.a(paramT));
  }
  
  private static <T> a<T> a(String paramString1, T paramT, String paramString2)
  {
    a locala = new a();
    a = paramString1;
    b = paramString2;
    c = paramT;
    return locala;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Arrays.toString(a(1, paramString1, paramString2.getBytes("UTF-8")));
      if (paramString1 != null) {
        paramString2 = paramString1;
      }
      return paramString2;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      Log.w("Leanplum", "Unable to encrypt " + paramString2, paramString1);
    }
    return paramString2;
  }
  
  public static String a(Map<String, ?> paramMap)
  {
    try
    {
      String str = b(paramMap).toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      Log.e("Leanplum", "Error converting " + paramMap + " to JSON", localJSONException);
    }
    return null;
  }
  
  public static <T> List<T> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList(paramJSONArray.length());
    int i = 0;
    if (i >= paramJSONArray.length()) {
      return localArrayList;
    }
    Object localObject2 = paramJSONArray.opt(i);
    Object localObject1;
    if ((localObject2 == null) || (localObject2 == JSONObject.NULL)) {
      localObject1 = null;
    }
    for (;;)
    {
      localArrayList.add(localObject1);
      i += 1;
      break;
      if ((localObject2 instanceof JSONObject))
      {
        localObject1 = a((JSONObject)localObject2);
      }
      else if ((localObject2 instanceof JSONArray))
      {
        localObject1 = a((JSONArray)localObject2);
      }
      else
      {
        localObject1 = localObject2;
        if (JSONObject.NULL.equals(localObject2)) {
          localObject1 = null;
        }
      }
    }
  }
  
  public static Map<String, Object> a(String paramString)
  {
    try
    {
      Map localMap = a(new JSONObject(paramString));
      return localMap;
    }
    catch (JSONException localJSONException)
    {
      Log.e("Leanplum", "Error converting " + paramString + " from JSON", localJSONException);
    }
    return null;
  }
  
  public static <T> Map<String, T> a(JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    HashMap localHashMap = new HashMap();
    if (!localIterator.hasNext()) {
      return localHashMap;
    }
    String str = (String)localIterator.next();
    Object localObject2 = paramJSONObject.opt(str);
    Object localObject1;
    if ((localObject2 == null) || (localObject2 == JSONObject.NULL)) {
      localObject1 = null;
    }
    for (;;)
    {
      localHashMap.put(str, localObject1);
      break;
      if ((localObject2 instanceof JSONObject))
      {
        localObject1 = a((JSONObject)localObject2);
      }
      else if ((localObject2 instanceof JSONArray))
      {
        localObject1 = a((JSONArray)localObject2);
      }
      else
      {
        localObject1 = localObject2;
        if (JSONObject.NULL.equals(localObject2)) {
          localObject1 = null;
        }
      }
    }
  }
  
  public static JSONArray a(Iterable<?> paramIterable)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext()) {
      return localJSONArray;
    }
    Object localObject = localIterator.next();
    if ((localObject instanceof Map)) {
      paramIterable = b((Map)localObject);
    }
    for (;;)
    {
      localJSONArray.put(paramIterable);
      break;
      if ((localObject instanceof Iterable))
      {
        paramIterable = a((Iterable)localObject);
      }
      else
      {
        paramIterable = (Iterable<?>)localObject;
        if (localObject == null) {
          paramIterable = JSONObject.NULL;
        }
      }
    }
  }
  
  public static boolean a(Number paramNumber1, Number paramNumber2)
  {
    return ((paramNumber1.intValue() == 4) || (paramNumber1.intValue() == 1)) && (paramNumber2.intValue() == 2);
  }
  
  private static byte[] a(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = "L3@nP1Vm".getBytes("UTF-8");
      byte[] arrayOfByte = "__l3anplum__iv__".getBytes("UTF-8");
      paramString = new PBEKeySpec(paramString.toCharArray(), (byte[])localObject, 1000, 256);
      paramString = new SecretKeySpec(SecretKeyFactory.getInstance("PBEWithMD5And128BitAES-CBC-OpenSSL").generateSecret(paramString).getEncoded(), "AES");
      localObject = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ((Cipher)localObject).init(paramInt, paramString, new IvParameterSpec(arrayOfByte));
      paramString = ((Cipher)localObject).doFinal(paramArrayOfByte);
      return paramString;
    }
    catch (InvalidKeyException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (NoSuchPaddingException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (InvalidAlgorithmParameterException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (IllegalBlockSizeException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (BadPaddingException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (InvalidKeySpecException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    str = paramString2;
    try
    {
      paramString2 = paramString2.trim();
      str = paramString2;
      String[] arrayOfString = paramString2.substring(1, paramString2.length() - 1).trim().split("\\s*,\\s*");
      str = paramString2;
      byte[] arrayOfByte = new byte[arrayOfString.length];
      int i = 0;
      for (;;)
      {
        str = paramString2;
        if (i >= arrayOfString.length)
        {
          str = paramString2;
          return new String(a(2, paramString1, arrayOfByte));
        }
        str = paramString2;
        arrayOfByte[i] = Byte.parseByte(arrayOfString[i]);
        i += 1;
      }
      return str;
    }
    catch (NumberFormatException paramString1)
    {
      Log.w("Leanplum", "Invalid ciphertext: " + str, paramString1);
    }
  }
  
  public static JSONObject b(Map<String, ?> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramMap.keySet().iterator();
    if (!localIterator.hasNext()) {
      return localJSONObject;
    }
    String str = (String)localIterator.next();
    Object localObject2 = paramMap.get(str);
    Object localObject1;
    if ((localObject2 instanceof Map)) {
      localObject1 = b((Map)localObject2);
    }
    for (;;)
    {
      localJSONObject.put(str, localObject1);
      break;
      if ((localObject2 instanceof Iterable))
      {
        localObject1 = a((Iterable)localObject2);
      }
      else
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = JSONObject.NULL;
        }
      }
    }
  }
  
  public static boolean b(Number paramNumber1, Number paramNumber2)
  {
    return (paramNumber1.intValue() == 2) && (paramNumber2.intValue() == 4);
  }
  
  public static a<String> c(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString1 = a(paramString1, str, "file");
    aU.a((String)c, (String)c, paramString1.d(), false, null, 0);
    return paramString1;
  }
  
  public static a<String> d(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1, paramString2, "file");
    d = true;
    aU.a((String)c, (String)c, paramString1.d(), false, null, 0);
    return paramString1;
  }
  
  public static a<String> e(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    return a(paramString1, str, "action");
  }
  
  public String a()
  {
    return a;
  }
  
  public String b()
  {
    return b;
  }
  
  public T c()
  {
    return (T)c;
  }
  
  public InputStream d()
  {
    if (!b.equals("file")) {
      return null;
    }
    return FileManager.a(false, Boolean.valueOf(d), Boolean.valueOf(d), (String)c, (String)c, null);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */