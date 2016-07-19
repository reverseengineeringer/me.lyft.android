package com.leanplum;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

final class p
{
  private static final List<Integer> n = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10) });
  private static final List<Integer> o = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2) });
  private aW a;
  private boolean b = true;
  private int c;
  private boolean d;
  private boolean e;
  private int f;
  private int g;
  private int h;
  private int i;
  private byte[] j = new byte[0];
  private byte[] k = new byte[0];
  private boolean l = false;
  private ByteArrayOutputStream m = new ByteArrayOutputStream();
  
  public p(aW paramaW)
  {
    a = paramaW;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  private byte[] a(Object paramObject, int paramInt1, int paramInt2)
  {
    int i2;
    label22:
    int i4;
    int i1;
    label39:
    int i3;
    label49:
    int i5;
    label68:
    byte[] arrayOfByte;
    if ((paramObject instanceof String))
    {
      paramObject = b((String)paramObject);
      if (paramInt2 <= 0) {
        break label249;
      }
      i2 = 2;
      i4 = paramObject.length + i2;
      if (i4 > 125) {
        break label255;
      }
      i1 = 2;
      if (!b) {
        break label275;
      }
      i3 = 4;
      i5 = i1 + i3;
      if (!b) {
        break label281;
      }
      i3 = 128;
      arrayOfByte = new byte[i4 + i5];
      arrayOfByte[0] = ((byte)((byte)paramInt1 | 0xFFFFFF80));
      if (i4 > 125) {
        break label287;
      }
      arrayOfByte[1] = ((byte)(i3 | i4));
    }
    for (;;)
    {
      if (paramInt2 > 0)
      {
        arrayOfByte[i5] = ((byte)(int)Math.floor(paramInt2 / 256));
        arrayOfByte[(i5 + 1)] = ((byte)paramInt2);
      }
      System.arraycopy(paramObject, 0, arrayOfByte, i2 + i5, paramObject.length);
      if (b)
      {
        paramObject = new byte[4];
        paramObject[0] = ((byte)(int)Math.floor(Math.random() * 256.0D));
        paramObject[1] = ((byte)(int)Math.floor(Math.random() * 256.0D));
        paramObject[2] = ((byte)(int)Math.floor(Math.random() * 256.0D));
        paramObject[3] = ((byte)(int)Math.floor(Math.random() * 256.0D));
        System.arraycopy(paramObject, 0, arrayOfByte, i1, paramObject.length);
        a(arrayOfByte, (byte[])paramObject, i5);
      }
      return arrayOfByte;
      paramObject = (byte[])paramObject;
      break;
      label249:
      i2 = 0;
      break label22;
      label255:
      if (i4 <= 65535)
      {
        i1 = 4;
        break label39;
      }
      i1 = 10;
      break label39;
      label275:
      i3 = 0;
      break label49;
      label281:
      i3 = 0;
      break label68;
      label287:
      if (i4 <= 65535)
      {
        arrayOfByte[1] = ((byte)(i3 | 0x7E));
        arrayOfByte[2] = ((byte)(int)Math.floor(i4 / 256));
        arrayOfByte[3] = ((byte)i4);
      }
      else
      {
        arrayOfByte[1] = ((byte)(i3 | 0x7F));
        arrayOfByte[2] = ((byte)(int)Math.floor(i4 / Math.pow(2.0D, 56.0D)));
        arrayOfByte[3] = ((byte)(int)Math.floor(i4 / Math.pow(2.0D, 48.0D)));
        arrayOfByte[4] = ((byte)(int)Math.floor(i4 / Math.pow(2.0D, 40.0D)));
        arrayOfByte[5] = ((byte)(int)Math.floor(i4 / Math.pow(2.0D, 32.0D)));
        arrayOfByte[6] = ((byte)(int)Math.floor(i4 / Math.pow(2.0D, 24.0D)));
        arrayOfByte[7] = ((byte)(int)Math.floor(i4 / Math.pow(2.0D, 16.0D)));
        arrayOfByte[8] = ((byte)(int)Math.floor(i4 / Math.pow(2.0D, 8.0D)));
        arrayOfByte[9] = ((byte)i4);
      }
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if (paramArrayOfByte2.length == 0) {}
    for (;;)
    {
      return paramArrayOfByte1;
      int i1 = 0;
      while (i1 < paramArrayOfByte1.length - paramInt)
      {
        paramArrayOfByte1[(paramInt + i1)] = ((byte)(paramArrayOfByte1[(paramInt + i1)] ^ paramArrayOfByte2[(i1 % 4)]));
        i1 += 1;
      }
    }
  }
  
  private static byte[] b(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public final void a(q paramq)
  {
    while (paramq.available() != -1)
    {
      int i1;
      int i2;
      label81:
      int i3;
      label122:
      label127:
      label133:
      boolean bool;
      label273:
      label326:
      label331:
      Object localObject;
      switch (c)
      {
      default: 
        break;
      case 0: 
        int i4 = paramq.readByte();
        if ((i4 & 0x40) == 64)
        {
          i1 = 1;
          if ((i4 & 0x20) != 32) {
            break label122;
          }
          i2 = 1;
          if ((i4 & 0x10) != 16) {
            break label127;
          }
        }
        for (i3 = 1;; i3 = 0)
        {
          if ((i1 == 0) && (i2 == 0) && (i3 == 0)) {
            break label133;
          }
          throw new r("RSV not zero");
          i1 = 0;
          break;
          i2 = 0;
          break label81;
        }
        if ((i4 & 0x80) == 128) {}
        for (bool = true;; bool = false)
        {
          d = bool;
          f = (i4 & 0xF);
          j = new byte[0];
          k = new byte[0];
          if (n.contains(Integer.valueOf(f))) {
            break;
          }
          throw new r("Bad opcode");
        }
        if ((!o.contains(Integer.valueOf(f))) && (!d)) {
          throw new r("Expected non-final packet");
        }
        c = 1;
        break;
      case 1: 
        i1 = paramq.readByte();
        if ((i1 & 0x80) == 128)
        {
          bool = true;
          e = bool;
          h = (i1 & 0x7F);
          if ((h < 0) || (h > 125)) {
            break label331;
          }
          if (!e) {
            break label326;
          }
        }
        for (i1 = 3;; i1 = 4)
        {
          c = i1;
          break;
          bool = false;
          break label273;
        }
        if (h == 126) {}
        for (i1 = 2;; i1 = 8)
        {
          g = i1;
          c = 2;
          break;
        }
      case 2: 
        localObject = paramq.a(g);
        i2 = localObject.length;
        if (localObject.length < i2) {
          throw new IllegalArgumentException("length must be less than or equal to b.length");
        }
        long l1 = 0L;
        i1 = 0;
        for (;;)
        {
          if (i1 >= i2)
          {
            if ((l1 >= 0L) && (l1 <= 2147483647L)) {
              break;
            }
            throw new r("Bad integer: " + l1);
          }
          l1 += ((localObject[i1] & 0xFF) << (i2 - 1 - i1 << 3));
          i1 += 1;
        }
        h = ((int)l1);
        if (e) {}
        for (i1 = 3;; i1 = 4)
        {
          c = i1;
          break;
        }
      case 3: 
        j = paramq.a(4);
        c = 4;
        break;
      case 4: 
        k = paramq.a(h);
        localObject = a(k, j, 0);
        i1 = f;
        if (i1 == 0)
        {
          if (i == 0) {
            throw new r("Mode was not set.");
          }
          m.write((byte[])localObject);
          if (d)
          {
            localObject = m.toByteArray();
            if (i != 1) {
              break label640;
            }
            a.a().a(a((byte[])localObject));
            label620:
            i = 0;
            m.reset();
          }
        }
        for (;;)
        {
          c = 0;
          break;
          label640:
          a.a().a();
          break label620;
          if (i1 == 1)
          {
            if (d)
            {
              localObject = a((byte[])localObject);
              a.a().a((String)localObject);
            }
            else
            {
              i = 1;
              m.write((byte[])localObject);
            }
          }
          else if (i1 == 2)
          {
            if (d)
            {
              a.a().a();
            }
            else
            {
              i = 2;
              m.write((byte[])localObject);
            }
          }
          else
          {
            if (i1 == 8)
            {
              if (localObject.length >= 2) {
                i1 = localObject[0] * 256 + localObject[1];
              }
              byte[] arrayOfByte;
              while (localObject.length > 2)
              {
                i3 = localObject.length;
                if (2 > i3)
                {
                  throw new IllegalArgumentException();
                  i1 = 0;
                }
                else
                {
                  i2 = localObject.length;
                  if (2 > i2) {
                    throw new ArrayIndexOutOfBoundsException();
                  }
                  i3 -= 2;
                  i2 = Math.min(i3, i2 - 2);
                  arrayOfByte = new byte[i3];
                  System.arraycopy(localObject, 2, arrayOfByte, 0, i2);
                }
              }
              for (localObject = a(arrayOfByte);; localObject = null)
              {
                a.a().a(i1, (String)localObject);
                break;
              }
            }
            if (i1 == 9)
            {
              if (localObject.length > 125) {
                throw new r("Ping payload too large");
              }
              a.a(a(localObject, 10, -1));
            }
          }
        }
      }
    }
    a.a().a(0, "EOF");
  }
  
  public final byte[] a(String paramString)
  {
    return a(paramString, 1, -1);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */