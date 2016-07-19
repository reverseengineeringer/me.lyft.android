package com.paypal.android.sdk;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class cj
  extends bg
{
  private static final String a = cj.class.getSimpleName();
  private final au b;
  
  public cj(bh parambh, c paramc, au paramau)
  {
    super(new bl(bm.a), parambh, paramc);
    b = paramau;
  }
  
  private static void a(Map paramMap, StringBuilder paramStringBuilder)
  {
    if (paramMap.isEmpty()) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        if (paramMap.get(str1) == null)
        {
          new StringBuilder("No value for ").append(str1).append(", skipping");
          return;
        }
        String str2 = R.a((String)paramMap.get(str1));
        paramStringBuilder.append("&").append(str1);
        paramStringBuilder.append("=").append(str2);
      }
    }
  }
  
  public final String a(be parambe)
  {
    return "https://paypal.112.2o7.net/b/ss/paypalglobal/0/OIP-2.1.6/";
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = Calendar.getInstance();
    int i = ((Calendar)localObject).get(4);
    long l = -((((Calendar)localObject).get(15) + ((Calendar)localObject).get(16)) / 60000);
    localStringBuilder.append(Integer.toString(((Calendar)localObject).get(5))).append("/").append(Integer.toString(((Calendar)localObject).get(2))).append("/").append(Integer.toString(((Calendar)localObject).get(1))).append(" ").append(Integer.toString(((Calendar)localObject).get(11))).append(":").append(Integer.toString(((Calendar)localObject).get(12))).append(":").append(Integer.toString(((Calendar)localObject).get(13))).append(" ").append(Integer.toString(i)).append(" ").append(Long.toString(l));
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("s").append(b.a).append("?AQB=1").append("&ndh=1").append("&t" + R.a((String)localObject));
    localObject = R.a(t().d().e().replace("-", ""));
    localStringBuilder.append("&ch=" + R.a(b.c)).append("&sv=" + b.d).append("&vid=" + (String)localObject);
    a(b.b, localStringBuilder);
    localStringBuilder.append("&AQE=1");
    return localStringBuilder.toString();
  }
  
  public final void c() {}
  
  public final void d() {}
  
  public final String e()
  {
    return "mockSiteCatalystResponse";
  }
}

/* Location:
 * Qualified Name:     com.paypal.android.sdk.cj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */