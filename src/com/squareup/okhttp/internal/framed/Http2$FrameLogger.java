package com.squareup.okhttp.internal.framed;

final class Http2$FrameLogger
{
  private static final String[] BINARY;
  private static final String[] FLAGS;
  private static final String[] TYPES = { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
  
  static
  {
    FLAGS = new String[64];
    BINARY = new String['Ā'];
    int i = 0;
    while (i < BINARY.length)
    {
      BINARY[i] = String.format("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
      i += 1;
    }
    FLAGS[0] = "";
    FLAGS[1] = "END_STREAM";
    int[] arrayOfInt1 = new int[1];
    arrayOfInt1[0] = 1;
    FLAGS[8] = "PADDED";
    int j = arrayOfInt1.length;
    i = 0;
    while (i < j)
    {
      k = arrayOfInt1[i];
      FLAGS[(k | 0x8)] = (FLAGS[k] + "|PADDED");
      i += 1;
    }
    FLAGS[4] = "END_HEADERS";
    FLAGS[32] = "PRIORITY";
    FLAGS[36] = "END_HEADERS|PRIORITY";
    int[] arrayOfInt2 = new int[3];
    int[] tmp240_238 = arrayOfInt2;
    tmp240_238[0] = 4;
    int[] tmp244_240 = tmp240_238;
    tmp244_240[1] = 32;
    int[] tmp249_244 = tmp244_240;
    tmp249_244[2] = 36;
    tmp249_244;
    int k = arrayOfInt2.length;
    i = 0;
    while (i < k)
    {
      int m = arrayOfInt2[i];
      int n = arrayOfInt1.length;
      j = 0;
      while (j < n)
      {
        int i1 = arrayOfInt1[j];
        FLAGS[(i1 | m)] = (FLAGS[i1] + '|' + FLAGS[m]);
        FLAGS[(i1 | m | 0x8)] = (FLAGS[i1] + '|' + FLAGS[m] + "|PADDED");
        j += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < FLAGS.length)
    {
      if (FLAGS[i] == null) {
        FLAGS[i] = BINARY[i];
      }
      i += 1;
    }
  }
  
  static String formatFlags(byte paramByte1, byte paramByte2)
  {
    if (paramByte2 == 0) {
      return "";
    }
    switch (paramByte1)
    {
    case 5: 
    default: 
      if (paramByte2 >= FLAGS.length) {
        break;
      }
    }
    for (String str = FLAGS[paramByte2]; (paramByte1 == 5) && ((paramByte2 & 0x4) != 0); str = BINARY[paramByte2])
    {
      return str.replace("HEADERS", "PUSH_PROMISE");
      if (paramByte2 == 1) {
        return "ACK";
      }
      return BINARY[paramByte2];
      return BINARY[paramByte2];
    }
    if ((paramByte1 == 0) && ((paramByte2 & 0x20) != 0)) {
      return str.replace("PRIORITY", "COMPRESSED");
    }
    return str;
  }
  
  static String formatHeader(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    String str1;
    String str3;
    if (paramByte1 < TYPES.length)
    {
      str1 = TYPES[paramByte1];
      str3 = formatFlags(paramByte1, paramByte2);
      if (!paramBoolean) {
        break label91;
      }
    }
    label91:
    for (String str2 = "<<";; str2 = ">>")
    {
      return String.format("%s 0x%08x %5d %-13s %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, str3 });
      str1 = String.format("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.squareup.okhttp.internal.framed.Http2.FrameLogger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */