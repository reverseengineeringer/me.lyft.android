package com.appboy.support;

import com.appboy.Constants;

public class PackageUtils
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, PackageUtils.class.getName() });
  private static String b;
  
  /* Error */
  public static String getResourcePackageName(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 44	com/appboy/support/PackageUtils:b	Ljava/lang/String;
    //   3: ifnull +7 -> 10
    //   6: getstatic 44	com/appboy/support/PackageUtils:b	Ljava/lang/String;
    //   9: areturn
    //   10: aload_0
    //   11: invokevirtual 50	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   14: astore_2
    //   15: aload_2
    //   16: getstatic 56	com/appboy/R$string:resource_for_package_identification	I
    //   19: invokevirtual 61	android/content/res/Resources:getResourcePackageName	(I)Ljava/lang/String;
    //   22: astore_3
    //   23: aload_3
    //   24: putstatic 44	com/appboy/support/PackageUtils:b	Ljava/lang/String;
    //   27: aload_3
    //   28: areturn
    //   29: astore_3
    //   30: aload_0
    //   31: invokevirtual 65	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   34: iconst_0
    //   35: invokevirtual 71	android/content/pm/PackageManager:getInstalledPackages	(I)Ljava/util/List;
    //   38: invokeinterface 77 1 0
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface 83 1 0
    //   50: ifeq +70 -> 120
    //   53: aload_2
    //   54: ldc 85
    //   56: aconst_null
    //   57: aload_3
    //   58: invokeinterface 89 1 0
    //   63: checkcast 91	android/content/pm/PackageInfo
    //   66: getfield 94	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   69: invokevirtual 98	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   72: istore_1
    //   73: iload_1
    //   74: ifeq -30 -> 44
    //   77: aload_2
    //   78: iload_1
    //   79: invokevirtual 101	android/content/res/Resources:getResourceName	(I)Ljava/lang/String;
    //   82: ldc 85
    //   84: invokevirtual 105	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   87: ifeq -43 -> 44
    //   90: aload_2
    //   91: iload_1
    //   92: invokevirtual 61	android/content/res/Resources:getResourcePackageName	(I)Ljava/lang/String;
    //   95: astore 4
    //   97: aload 4
    //   99: putstatic 44	com/appboy/support/PackageUtils:b	Ljava/lang/String;
    //   102: aload 4
    //   104: areturn
    //   105: astore 4
    //   107: goto -63 -> 44
    //   110: astore_2
    //   111: getstatic 30	com/appboy/support/PackageUtils:a	Ljava/lang/String;
    //   114: ldc 107
    //   116: invokestatic 113	com/appboy/support/AppboyLogger:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   119: pop
    //   120: aload_0
    //   121: invokevirtual 116	android/content/Context:getPackageName	()Ljava/lang/String;
    //   124: astore_0
    //   125: aload_0
    //   126: putstatic 44	com/appboy/support/PackageUtils:b	Ljava/lang/String;
    //   129: aload_0
    //   130: areturn
    //   131: astore_2
    //   132: getstatic 30	com/appboy/support/PackageUtils:a	Ljava/lang/String;
    //   135: ldc 118
    //   137: aload_2
    //   138: invokestatic 122	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   141: pop
    //   142: goto -22 -> 120
    //   145: astore_2
    //   146: getstatic 30	com/appboy/support/PackageUtils:a	Ljava/lang/String;
    //   149: ldc 124
    //   151: aload_2
    //   152: invokestatic 122	com/appboy/support/AppboyLogger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   155: pop
    //   156: goto -36 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramContext	android.content.Context
    //   72	20	1	i	int
    //   14	77	2	localResources	android.content.res.Resources
    //   110	1	2	localNotFoundException	android.content.res.Resources.NotFoundException
    //   131	7	2	localNullPointerException	NullPointerException
    //   145	7	2	localException1	Exception
    //   22	6	3	str1	String
    //   29	1	3	localException2	Exception
    //   43	15	3	localIterator	java.util.Iterator
    //   95	8	4	str2	String
    //   105	1	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   15	27	29	java/lang/Exception
    //   77	102	105	java/lang/Exception
    //   10	15	110	android/content/res/Resources$NotFoundException
    //   15	27	110	android/content/res/Resources$NotFoundException
    //   30	44	110	android/content/res/Resources$NotFoundException
    //   44	73	110	android/content/res/Resources$NotFoundException
    //   77	102	110	android/content/res/Resources$NotFoundException
    //   10	15	131	java/lang/NullPointerException
    //   15	27	131	java/lang/NullPointerException
    //   30	44	131	java/lang/NullPointerException
    //   44	73	131	java/lang/NullPointerException
    //   77	102	131	java/lang/NullPointerException
    //   10	15	145	java/lang/Exception
    //   30	44	145	java/lang/Exception
    //   44	73	145	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     com.appboy.support.PackageUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */