package com.kochava.android.tracker;

import android.content.BroadcastReceiver;

public class ReferralCapture
  extends BroadcastReceiver
{
  public static String params = "";
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  public void onReceive(android.content.Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +9 -> 10
    //   4: ldc 27
    //   6: invokestatic 33	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   9: return
    //   10: ldc 35
    //   12: invokestatic 33	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   15: new 37	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   22: ldc 40
    //   24: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_2
    //   28: invokevirtual 50	android/content/Intent:getPackage	()Ljava/lang/String;
    //   31: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 52
    //   36: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_2
    //   40: invokevirtual 55	android/content/Intent:getAction	()Ljava/lang/String;
    //   43: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 33	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   52: aload_2
    //   53: invokevirtual 62	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   56: astore 5
    //   58: aload 5
    //   60: ifnull +10 -> 70
    //   63: aload 5
    //   65: aconst_null
    //   66: invokevirtual 68	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   69: pop
    //   70: new 70	java/util/HashMap
    //   73: dup
    //   74: invokespecial 71	java/util/HashMap:<init>	()V
    //   77: astore 5
    //   79: aload_2
    //   80: invokevirtual 55	android/content/Intent:getAction	()Ljava/lang/String;
    //   83: ldc 73
    //   85: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifne +11 -> 99
    //   91: ldc 81
    //   93: invokestatic 33	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   96: return
    //   97: astore_1
    //   98: return
    //   99: aload_2
    //   100: ldc 83
    //   102: invokevirtual 87	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +10 -> 117
    //   110: aload_2
    //   111: invokevirtual 91	java/lang/String:length	()I
    //   114: ifne +9 -> 123
    //   117: ldc 93
    //   119: invokestatic 96	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   122: return
    //   123: aload_2
    //   124: ldc 98
    //   126: invokestatic 104	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_2
    //   130: new 37	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   137: ldc 106
    //   139: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_2
    //   143: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 33	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   152: aload_2
    //   153: ldc 108
    //   155: invokevirtual 112	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   158: astore_2
    //   159: aload_2
    //   160: arraylength
    //   161: istore 4
    //   163: iconst_0
    //   164: istore_3
    //   165: iload_3
    //   166: iload 4
    //   168: if_icmpge +113 -> 281
    //   171: aload_2
    //   172: iload_3
    //   173: aaload
    //   174: ldc 114
    //   176: invokevirtual 112	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   179: astore 6
    //   181: aload 6
    //   183: arraylength
    //   184: iconst_1
    //   185: if_icmpne +51 -> 236
    //   188: aload 5
    //   190: aload 6
    //   192: iconst_0
    //   193: aaload
    //   194: ldc 10
    //   196: invokeinterface 120 3 0
    //   201: pop
    //   202: iload_3
    //   203: iconst_1
    //   204: iadd
    //   205: istore_3
    //   206: goto -41 -> 165
    //   209: astore_1
    //   210: new 37	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   217: ldc 122
    //   219: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_1
    //   223: invokevirtual 125	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   226: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 96	com/kochava/android/util/Logging:LogError	(Ljava/lang/String;)V
    //   235: return
    //   236: aload 5
    //   238: aload 6
    //   240: iconst_0
    //   241: aaload
    //   242: aload 6
    //   244: iconst_1
    //   245: aaload
    //   246: invokeinterface 120 3 0
    //   251: pop
    //   252: goto -50 -> 202
    //   255: astore_2
    //   256: new 37	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   263: ldc 122
    //   265: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_2
    //   269: invokevirtual 126	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   272: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 33	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   281: aload 5
    //   283: invokevirtual 129	java/lang/Object:toString	()Ljava/lang/String;
    //   286: astore_2
    //   287: aload_2
    //   288: iconst_1
    //   289: aload_2
    //   290: invokevirtual 91	java/lang/String:length	()I
    //   293: iconst_1
    //   294: isub
    //   295: invokevirtual 133	java/lang/String:substring	(II)Ljava/lang/String;
    //   298: ldc -121
    //   300: ldc 108
    //   302: invokevirtual 139	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   305: ldc 114
    //   307: ldc -115
    //   309: invokevirtual 139	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   312: astore_2
    //   313: aload_1
    //   314: ldc -113
    //   316: iconst_0
    //   317: invokevirtual 149	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   320: invokeinterface 155 1 0
    //   325: ldc -99
    //   327: aload_2
    //   328: invokeinterface 163 3 0
    //   333: invokeinterface 166 1 0
    //   338: new 37	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   345: ldc -88
    //   347: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload_2
    //   351: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 33	com/kochava/android/util/Logging:Log	(Ljava/lang/String;)V
    //   360: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	ReferralCapture
    //   0	361	1	paramContext	android.content.Context
    //   0	361	2	paramIntent	android.content.Intent
    //   164	42	3	i	int
    //   161	8	4	j	int
    //   56	226	5	localObject	Object
    //   179	64	6	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   52	58	97	java/lang/Exception
    //   63	70	97	java/lang/Exception
    //   123	130	209	java/io/UnsupportedEncodingException
    //   152	163	255	java/lang/Exception
    //   171	202	255	java/lang/Exception
    //   236	252	255	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.ReferralCapture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */