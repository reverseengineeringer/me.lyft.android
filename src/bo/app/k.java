package bo.app;

import com.appboy.Constants;

public final class k
  implements h
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, k.class.getName() });
  private final h b;
  
  public k(h paramh)
  {
    b = paramh;
  }
  
  /* Error */
  public final org.json.JSONObject a(java.net.URI paramURI, java.util.Map<String, String> paramMap)
  {
    // Byte code:
    //   0: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: getfield 40	bo/app/k:b	Lbo/app/h;
    //   8: aload_1
    //   9: aload_2
    //   10: invokeinterface 49 3 0
    //   15: astore_2
    //   16: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   19: lstore 5
    //   21: getstatic 33	bo/app/k:a	Ljava/lang/String;
    //   24: astore 7
    //   26: ldc 51
    //   28: iconst_3
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: lload 5
    //   36: lload_3
    //   37: lsub
    //   38: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: getstatic 62	bo/app/af:a	Lbo/app/af;
    //   47: invokevirtual 65	bo/app/af:toString	()Ljava/lang/String;
    //   50: aastore
    //   51: dup
    //   52: iconst_2
    //   53: aload_1
    //   54: invokevirtual 68	java/net/URI:toString	()Ljava/lang/String;
    //   57: aastore
    //   58: invokestatic 31	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   61: pop
    //   62: aload_2
    //   63: areturn
    //   64: astore_2
    //   65: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   68: lstore 5
    //   70: getstatic 33	bo/app/k:a	Ljava/lang/String;
    //   73: astore 7
    //   75: ldc 51
    //   77: iconst_3
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: lload 5
    //   85: lload_3
    //   86: lsub
    //   87: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: getstatic 62	bo/app/af:a	Lbo/app/af;
    //   96: invokevirtual 65	bo/app/af:toString	()Ljava/lang/String;
    //   99: aastore
    //   100: dup
    //   101: iconst_2
    //   102: aload_1
    //   103: invokevirtual 68	java/net/URI:toString	()Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 31	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   110: pop
    //   111: aload_2
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	k
    //   0	113	1	paramURI	java.net.URI
    //   0	113	2	paramMap	java.util.Map<String, String>
    //   3	83	3	l1	long
    //   19	65	5	l2	long
    //   24	50	7	str	String
    // Exception table:
    //   from	to	target	type
    //   4	16	64	finally
  }
  
  /* Error */
  public final org.json.JSONObject a(java.net.URI paramURI, java.util.Map<String, String> paramMap, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aload_0
    //   6: getfield 40	bo/app/k:b	Lbo/app/h;
    //   9: aload_1
    //   10: aload_2
    //   11: aload_3
    //   12: invokeinterface 73 4 0
    //   17: astore_2
    //   18: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   21: lstore 6
    //   23: getstatic 33	bo/app/k:a	Ljava/lang/String;
    //   26: astore_3
    //   27: ldc 51
    //   29: iconst_3
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: lload 6
    //   37: lload 4
    //   39: lsub
    //   40: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: getstatic 75	bo/app/af:b	Lbo/app/af;
    //   49: invokevirtual 65	bo/app/af:toString	()Ljava/lang/String;
    //   52: aastore
    //   53: dup
    //   54: iconst_2
    //   55: aload_1
    //   56: invokevirtual 68	java/net/URI:toString	()Ljava/lang/String;
    //   59: aastore
    //   60: invokestatic 31	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   63: pop
    //   64: aload_2
    //   65: areturn
    //   66: astore_2
    //   67: invokestatic 47	java/lang/System:currentTimeMillis	()J
    //   70: lstore 6
    //   72: getstatic 33	bo/app/k:a	Ljava/lang/String;
    //   75: astore_3
    //   76: ldc 51
    //   78: iconst_3
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: lload 6
    //   86: lload 4
    //   88: lsub
    //   89: invokestatic 57	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: getstatic 75	bo/app/af:b	Lbo/app/af;
    //   98: invokevirtual 65	bo/app/af:toString	()Ljava/lang/String;
    //   101: aastore
    //   102: dup
    //   103: iconst_2
    //   104: aload_1
    //   105: invokevirtual 68	java/net/URI:toString	()Ljava/lang/String;
    //   108: aastore
    //   109: invokestatic 31	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   112: pop
    //   113: aload_2
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	k
    //   0	115	1	paramURI	java.net.URI
    //   0	115	2	paramMap	java.util.Map<String, String>
    //   0	115	3	paramJSONObject	org.json.JSONObject
    //   3	84	4	l1	long
    //   21	64	6	l2	long
    // Exception table:
    //   from	to	target	type
    //   5	18	66	finally
  }
}

/* Location:
 * Qualified Name:     bo.app.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */