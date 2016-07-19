package com.leanplum;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;

public class LeanplumInflater
{
  private Context a;
  private LeanplumResources b;
  
  private LeanplumInflater(Context paramContext)
  {
    a = paramContext;
  }
  
  public static LeanplumInflater from(Context paramContext)
  {
    return new LeanplumInflater(paramContext);
  }
  
  public LeanplumResources getLeanplumResources()
  {
    return getLeanplumResources(null);
  }
  
  public LeanplumResources getLeanplumResources(Resources paramResources)
  {
    if (b != null) {
      return b;
    }
    Resources localResources = paramResources;
    if (paramResources == null) {
      localResources = a.getResources();
    }
    if ((localResources instanceof LeanplumResources)) {
      return (LeanplumResources)localResources;
    }
    b = new LeanplumResources(localResources);
    return b;
  }
  
  public View inflate(int paramInt)
  {
    return inflate(paramInt, null, false);
  }
  
  public View inflate(int paramInt, ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null) {}
    for (boolean bool = true;; bool = false) {
      return inflate(paramInt, paramViewGroup, bool);
    }
  }
  
  /* Error */
  public View inflate(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 15	com/leanplum/LeanplumInflater:a	Landroid/content/Context;
    //   5: invokevirtual 33	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   8: invokevirtual 25	com/leanplum/LeanplumInflater:getLeanplumResources	(Landroid/content/res/Resources;)Lcom/leanplum/LeanplumResources;
    //   11: iload_1
    //   12: invokevirtual 49	com/leanplum/LeanplumResources:a	(I)Lcom/leanplum/Var;
    //   15: astore 8
    //   17: aload 8
    //   19: ifnull +19 -> 38
    //   22: aload 8
    //   24: getfield 54	com/leanplum/Var:a	Ljava/lang/String;
    //   27: aload 8
    //   29: invokevirtual 58	com/leanplum/Var:defaultValue	()Ljava/lang/Object;
    //   32: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifeq +17 -> 52
    //   38: aload_0
    //   39: getfield 15	com/leanplum/LeanplumInflater:a	Landroid/content/Context;
    //   42: invokestatic 69	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   45: iload_1
    //   46: aload_2
    //   47: iload_3
    //   48: invokevirtual 70	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   51: areturn
    //   52: aload 8
    //   54: invokevirtual 74	com/leanplum/Var:overrideResId	()I
    //   57: istore 4
    //   59: iload 4
    //   61: ifeq +18 -> 79
    //   64: aload_0
    //   65: getfield 15	com/leanplum/LeanplumInflater:a	Landroid/content/Context;
    //   68: invokestatic 69	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   71: iload 4
    //   73: aload_2
    //   74: iload_3
    //   75: invokevirtual 70	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   78: areturn
    //   79: new 76	java/io/ByteArrayOutputStream
    //   82: dup
    //   83: invokespecial 77	java/io/ByteArrayOutputStream:<init>	()V
    //   86: astore 5
    //   88: aload 8
    //   90: invokevirtual 81	com/leanplum/Var:stream	()Ljava/io/InputStream;
    //   93: astore 6
    //   95: sipush 8192
    //   98: newarray <illegal type>
    //   100: astore 7
    //   102: aload 6
    //   104: aload 7
    //   106: invokevirtual 87	java/io/InputStream:read	([B)I
    //   109: istore 4
    //   111: iload 4
    //   113: ifge +107 -> 220
    //   116: aload 6
    //   118: invokevirtual 90	java/io/InputStream:close	()V
    //   121: ldc 92
    //   123: invokestatic 98	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   126: iconst_1
    //   127: anewarray 94	java/lang/Class
    //   130: dup
    //   131: iconst_0
    //   132: ldc 100
    //   134: aastore
    //   135: invokevirtual 104	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   138: iconst_1
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload 5
    //   146: invokevirtual 108	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   149: aastore
    //   150: invokevirtual 114	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   153: astore 6
    //   155: aconst_null
    //   156: astore 5
    //   158: aconst_null
    //   159: astore 7
    //   161: aload 6
    //   163: invokevirtual 118	java/lang/Object:getClass	()Ljava/lang/Class;
    //   166: ldc 120
    //   168: iconst_0
    //   169: anewarray 94	java/lang/Class
    //   172: invokevirtual 124	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   175: aload 6
    //   177: iconst_0
    //   178: anewarray 4	java/lang/Object
    //   181: invokevirtual 130	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   184: checkcast 132	android/content/res/XmlResourceParser
    //   187: astore 6
    //   189: aload_0
    //   190: getfield 15	com/leanplum/LeanplumInflater:a	Landroid/content/Context;
    //   193: invokestatic 69	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   196: aload 6
    //   198: aload_2
    //   199: iload_3
    //   200: invokevirtual 135	android/view/LayoutInflater:inflate	(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/ViewGroup;Z)Landroid/view/View;
    //   203: astore 5
    //   205: aload 6
    //   207: ifnull +138 -> 345
    //   210: aload 6
    //   212: invokeinterface 136 1 0
    //   217: goto +128 -> 345
    //   220: aload 5
    //   222: aload 7
    //   224: iconst_0
    //   225: iload 4
    //   227: invokevirtual 140	java/io/ByteArrayOutputStream:write	([BII)V
    //   230: goto -128 -> 102
    //   233: astore 5
    //   235: ldc -114
    //   237: new 144	java/lang/StringBuilder
    //   240: dup
    //   241: ldc -110
    //   243: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: iload_1
    //   247: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: ldc -101
    //   252: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload 8
    //   257: invokevirtual 162	com/leanplum/Var:stringValue	()Ljava/lang/String;
    //   260: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: aload 5
    //   268: invokestatic 171	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   271: pop
    //   272: aload_0
    //   273: getfield 15	com/leanplum/LeanplumInflater:a	Landroid/content/Context;
    //   276: invokestatic 69	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   279: iload_1
    //   280: aload_2
    //   281: iload_3
    //   282: invokevirtual 70	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   285: areturn
    //   286: astore 6
    //   288: aload 7
    //   290: astore 5
    //   292: new 173	java/lang/RuntimeException
    //   295: dup
    //   296: aload 6
    //   298: invokespecial 176	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   301: athrow
    //   302: astore 7
    //   304: aload 5
    //   306: astore 6
    //   308: aload 7
    //   310: astore 5
    //   312: aload 6
    //   314: ifnull +10 -> 324
    //   317: aload 6
    //   319: invokeinterface 136 1 0
    //   324: aload 5
    //   326: athrow
    //   327: astore 5
    //   329: goto -17 -> 312
    //   332: astore 7
    //   334: aload 6
    //   336: astore 5
    //   338: aload 7
    //   340: astore 6
    //   342: goto -50 -> 292
    //   345: aload 5
    //   347: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	this	LeanplumInflater
    //   0	348	1	paramInt	int
    //   0	348	2	paramViewGroup	ViewGroup
    //   0	348	3	paramBoolean	boolean
    //   57	169	4	i	int
    //   86	135	5	localObject1	Object
    //   233	34	5	localException1	Exception
    //   290	35	5	localObject2	Object
    //   327	1	5	localObject3	Object
    //   336	10	5	localObject4	Object
    //   93	118	6	localObject5	Object
    //   286	11	6	localException2	Exception
    //   306	35	6	localObject6	Object
    //   100	189	7	arrayOfByte	byte[]
    //   302	7	7	localObject7	Object
    //   332	7	7	localException3	Exception
    //   15	241	8	localVar	Var
    // Exception table:
    //   from	to	target	type
    //   79	102	233	java/lang/Exception
    //   102	111	233	java/lang/Exception
    //   116	155	233	java/lang/Exception
    //   210	217	233	java/lang/Exception
    //   220	230	233	java/lang/Exception
    //   317	324	233	java/lang/Exception
    //   324	327	233	java/lang/Exception
    //   161	189	286	java/lang/Exception
    //   161	189	302	finally
    //   292	302	302	finally
    //   189	205	327	finally
    //   189	205	332	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     com.leanplum.LeanplumInflater
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */