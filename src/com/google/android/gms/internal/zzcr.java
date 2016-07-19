package com.google.android.gms.internal;

import com.google.android.gms.common.util.zzr;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

@zzir
public class zzcr
{
  private static boolean zza(Character.UnicodeBlock paramUnicodeBlock)
  {
    return (paramUnicodeBlock == Character.UnicodeBlock.BOPOMOFO) || (paramUnicodeBlock == Character.UnicodeBlock.BOPOMOFO_EXTENDED) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) || (paramUnicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B) || (paramUnicodeBlock == Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS) || (paramUnicodeBlock == Character.UnicodeBlock.HANGUL_JAMO) || (paramUnicodeBlock == Character.UnicodeBlock.HANGUL_SYLLABLES) || (paramUnicodeBlock == Character.UnicodeBlock.HIRAGANA) || (paramUnicodeBlock == Character.UnicodeBlock.KATAKANA) || (paramUnicodeBlock == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
  }
  
  public static int zzac(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
    }
    return zzr.zza(paramString, 0, paramString.length, 0);
  }
  
  public static String[] zzad(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    char[] arrayOfChar = paramString.toCharArray();
    int n = paramString.length();
    int j = 0;
    int i = 0;
    int k = 0;
    int m;
    int i1;
    if (k < n)
    {
      m = Character.codePointAt(arrayOfChar, k);
      i1 = Character.charCount(m);
      if (zzm(m))
      {
        if (j != 0) {
          localArrayList.add(new String(arrayOfChar, i, k - i));
        }
        localArrayList.add(new String(arrayOfChar, k, i1));
        m = 0;
        j = i;
        i = m;
      }
    }
    for (;;)
    {
      m = k + i1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      if ((Character.isLetterOrDigit(m)) || (Character.getType(m) == 6) || (Character.getType(m) == 8))
      {
        if (j == 0) {
          i = k;
        }
        j = i;
        i = 1;
      }
      else if (j != 0)
      {
        localArrayList.add(new String(arrayOfChar, i, k - i));
        j = i;
        i = 0;
        continue;
        if (j != 0) {
          localArrayList.add(new String(arrayOfChar, i, k - i));
        }
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
      else
      {
        m = i;
        i = j;
        j = m;
      }
    }
  }
  
  static boolean zzm(int paramInt)
  {
    return (Character.isLetter(paramInt)) && ((zza(Character.UnicodeBlock.of(paramInt))) || (zzo(paramInt)));
  }
  
  public static byte[] zzn(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.putInt(paramInt);
    return localByteBuffer.array();
  }
  
  private static boolean zzo(int paramInt)
  {
    return ((paramInt >= 65382) && (paramInt <= 65437)) || ((paramInt >= 65441) && (paramInt <= 65500));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */