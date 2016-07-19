package com.threatmetrix.TrustDefenderMobile;

class TrustDefenderMobile$1
  extends CompleteProfile
{
  TrustDefenderMobile$1(TrustDefenderMobile paramTrustDefenderMobile1, TrustDefenderMobile paramTrustDefenderMobile2, Config paramConfig)
  {
    super(paramTrustDefenderMobile2);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: invokestatic 31	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$000	()Ljava/lang/String;
    //   5: ldc 33
    //   7: invokestatic 39	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   10: pop
    //   11: aload_0
    //   12: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   15: invokestatic 43	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$100	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Lcom/threatmetrix/TrustDefenderMobile/TDDefaults;
    //   18: ifnull +116 -> 134
    //   21: invokestatic 31	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$000	()Ljava/lang/String;
    //   24: new 45	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   31: ldc 49
    //   33: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   40: invokestatic 43	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$100	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Lcom/threatmetrix/TrustDefenderMobile/TDDefaults;
    //   43: invokevirtual 59	com/threatmetrix/TrustDefenderMobile/TDDefaults:getEnabledOptions	()J
    //   46: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   49: ldc 64
    //   51: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   58: invokestatic 43	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$100	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Lcom/threatmetrix/TrustDefenderMobile/TDDefaults;
    //   61: invokevirtual 67	com/threatmetrix/TrustDefenderMobile/TDDefaults:getDisabledOptions	()J
    //   64: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: ldc 69
    //   69: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_0
    //   73: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   76: invokestatic 73	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$200	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)J
    //   79: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 39	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   88: pop
    //   89: aload_0
    //   90: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   93: aload_0
    //   94: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   97: invokestatic 73	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$200	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)J
    //   100: aload_0
    //   101: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   104: invokestatic 43	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$100	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Lcom/threatmetrix/TrustDefenderMobile/TDDefaults;
    //   107: invokevirtual 67	com/threatmetrix/TrustDefenderMobile/TDDefaults:getDisabledOptions	()J
    //   110: ldc2_w 77
    //   113: land
    //   114: lxor
    //   115: aload_0
    //   116: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   119: invokestatic 43	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$100	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Lcom/threatmetrix/TrustDefenderMobile/TDDefaults;
    //   122: invokevirtual 59	com/threatmetrix/TrustDefenderMobile/TDDefaults:getEnabledOptions	()J
    //   125: ldc2_w 79
    //   128: land
    //   129: lor
    //   130: invokestatic 84	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$202	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;J)J
    //   133: pop2
    //   134: aload_0
    //   135: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   138: getfield 88	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:m_td	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobileCore;
    //   141: aload_0
    //   142: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   145: invokestatic 73	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$200	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)J
    //   148: invokevirtual 94	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobileCore:setProfileOptions	(J)V
    //   151: aload_0
    //   152: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   155: invokestatic 73	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$200	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)J
    //   158: ldc2_w 77
    //   161: land
    //   162: lconst_0
    //   163: lcmp
    //   164: ifeq +322 -> 486
    //   167: aload_0
    //   168: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   171: new 96	com/threatmetrix/TrustDefenderMobile/BrowserInfoGatherer
    //   174: dup
    //   175: invokespecial 97	com/threatmetrix/TrustDefenderMobile/BrowserInfoGatherer:<init>	()V
    //   178: invokestatic 101	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$302	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;Lcom/threatmetrix/TrustDefenderMobile/BrowserInfoGatherer;)Lcom/threatmetrix/TrustDefenderMobile/BrowserInfoGatherer;
    //   181: pop
    //   182: aload_0
    //   183: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   186: invokestatic 105	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$300	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Lcom/threatmetrix/TrustDefenderMobile/BrowserInfoGatherer;
    //   189: aload_0
    //   190: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   193: invokestatic 109	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$400	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Landroid/content/Context;
    //   196: iload_1
    //   197: aload_0
    //   198: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   201: invokestatic 73	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$200	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)J
    //   204: invokevirtual 113	com/threatmetrix/TrustDefenderMobile/BrowserInfoGatherer:initJSExecutor	(Landroid/content/Context;ZJ)Z
    //   207: pop
    //   208: aload_0
    //   209: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   212: invokestatic 117	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$500	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Landroid/util/TimingLogger;
    //   215: ifnull +15 -> 230
    //   218: aload_0
    //   219: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   222: invokestatic 117	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$500	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Landroid/util/TimingLogger;
    //   225: ldc 119
    //   227: invokevirtual 125	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   230: aload_0
    //   231: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   234: invokestatic 105	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$300	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Lcom/threatmetrix/TrustDefenderMobile/BrowserInfoGatherer;
    //   237: invokevirtual 128	com/threatmetrix/TrustDefenderMobile/BrowserInfoGatherer:getBrowserStringFromJS	()Ljava/lang/String;
    //   240: astore_2
    //   241: aload_0
    //   242: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   245: invokestatic 117	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$500	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Landroid/util/TimingLogger;
    //   248: ifnull +15 -> 263
    //   251: aload_0
    //   252: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   255: invokestatic 117	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$500	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Landroid/util/TimingLogger;
    //   258: ldc -126
    //   260: invokevirtual 125	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   263: invokestatic 31	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$000	()Ljava/lang/String;
    //   266: ldc -124
    //   268: invokestatic 39	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   271: pop
    //   272: aload_0
    //   273: getfield 19	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:val$config	Lcom/threatmetrix/TrustDefenderMobile/Config;
    //   276: invokevirtual 138	com/threatmetrix/TrustDefenderMobile/Config:getUseOkHttp	()Z
    //   279: ifeq +212 -> 491
    //   282: aload_0
    //   283: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   286: new 140	com/threatmetrix/TrustDefenderMobile/OkHttpClientImpl
    //   289: dup
    //   290: invokespecial 141	com/threatmetrix/TrustDefenderMobile/OkHttpClientImpl:<init>	()V
    //   293: putfield 145	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:m_httpClient	Lcom/threatmetrix/TrustDefenderMobile/TDHttpClient;
    //   296: aload_0
    //   297: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   300: getfield 145	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:m_httpClient	Lcom/threatmetrix/TrustDefenderMobile/TDHttpClient;
    //   303: aload_0
    //   304: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   307: invokestatic 109	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$400	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Landroid/content/Context;
    //   310: aload_0
    //   311: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   314: invokestatic 149	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$600	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)I
    //   317: aload_2
    //   318: iconst_1
    //   319: invokeinterface 154 5 0
    //   324: aload_0
    //   325: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   328: invokestatic 117	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$500	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Landroid/util/TimingLogger;
    //   331: ifnull +15 -> 346
    //   334: aload_0
    //   335: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   338: invokestatic 117	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$500	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Landroid/util/TimingLogger;
    //   341: ldc -100
    //   343: invokevirtual 125	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   346: invokestatic 31	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$000	()Ljava/lang/String;
    //   349: ldc -98
    //   351: invokestatic 39	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   354: pop
    //   355: aconst_null
    //   356: invokestatic 164	com/threatmetrix/TrustDefenderMobile/StringUtils:MD5	(Ljava/lang/String;)Ljava/lang/String;
    //   359: pop
    //   360: invokestatic 170	com/threatmetrix/TrustDefenderMobile/NativeGatherer:getInstance	()Lcom/threatmetrix/TrustDefenderMobile/NativeGatherer;
    //   363: aload_0
    //   364: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   367: invokestatic 109	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$400	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)Landroid/content/Context;
    //   370: invokevirtual 173	com/threatmetrix/TrustDefenderMobile/NativeGatherer:init	(Landroid/content/Context;)Z
    //   373: pop
    //   374: invokestatic 31	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$000	()Ljava/lang/String;
    //   377: astore_3
    //   378: new 45	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   385: ldc -81
    //   387: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: astore 4
    //   392: invokestatic 170	com/threatmetrix/TrustDefenderMobile/NativeGatherer:getInstance	()Lcom/threatmetrix/TrustDefenderMobile/NativeGatherer;
    //   395: invokevirtual 178	com/threatmetrix/TrustDefenderMobile/NativeGatherer:isAvailable	()Z
    //   398: ifeq +143 -> 541
    //   401: ldc -76
    //   403: astore_2
    //   404: aload_3
    //   405: aload 4
    //   407: aload_2
    //   408: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 39	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   417: pop
    //   418: aload_0
    //   419: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   422: invokevirtual 183	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:readDefaults	()V
    //   425: aload_0
    //   426: getfield 19	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:val$config	Lcom/threatmetrix/TrustDefenderMobile/Config;
    //   429: invokevirtual 186	com/threatmetrix/TrustDefenderMobile/Config:getDisableInitPackageScan	()Z
    //   432: ifne +23 -> 455
    //   435: aload_0
    //   436: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   439: aload_0
    //   440: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   443: invokestatic 189	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$700	(Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;)I
    //   446: iconst_0
    //   447: iconst_0
    //   448: getstatic 194	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$PackageScanCallSource:init	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$PackageScanCallSource;
    //   451: invokevirtual 198	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:doPackageScanInternal	(IZZLcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$PackageScanCallSource;)Z
    //   454: pop
    //   455: aload_0
    //   456: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   459: getfield 202	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:m_state	Lcom/threatmetrix/TrustDefenderMobile/ProfileState;
    //   462: invokevirtual 207	com/threatmetrix/TrustDefenderMobile/ProfileState:waitForScan	()Z
    //   465: pop
    //   466: aload_0
    //   467: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   470: getfield 202	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:m_state	Lcom/threatmetrix/TrustDefenderMobile/ProfileState;
    //   473: invokevirtual 210	com/threatmetrix/TrustDefenderMobile/ProfileState:endInitialising	()V
    //   476: invokestatic 31	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$000	()Ljava/lang/String;
    //   479: ldc -44
    //   481: invokestatic 39	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   484: pop
    //   485: return
    //   486: iconst_0
    //   487: istore_1
    //   488: goto -321 -> 167
    //   491: aload_0
    //   492: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   495: new 214	com/threatmetrix/TrustDefenderMobile/AndroidHttpClientImpl
    //   498: dup
    //   499: invokespecial 215	com/threatmetrix/TrustDefenderMobile/AndroidHttpClientImpl:<init>	()V
    //   502: putfield 145	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:m_httpClient	Lcom/threatmetrix/TrustDefenderMobile/TDHttpClient;
    //   505: goto -209 -> 296
    //   508: astore_2
    //   509: aload_0
    //   510: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   513: getfield 202	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:m_state	Lcom/threatmetrix/TrustDefenderMobile/ProfileState;
    //   516: invokevirtual 207	com/threatmetrix/TrustDefenderMobile/ProfileState:waitForScan	()Z
    //   519: pop
    //   520: aload_0
    //   521: getfield 17	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile$1:this$0	Lcom/threatmetrix/TrustDefenderMobile/TrustDefenderMobile;
    //   524: getfield 202	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:m_state	Lcom/threatmetrix/TrustDefenderMobile/ProfileState;
    //   527: invokevirtual 210	com/threatmetrix/TrustDefenderMobile/ProfileState:endInitialising	()V
    //   530: invokestatic 31	com/threatmetrix/TrustDefenderMobile/TrustDefenderMobile:access$000	()Ljava/lang/String;
    //   533: ldc -44
    //   535: invokestatic 39	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   538: pop
    //   539: aload_2
    //   540: athrow
    //   541: ldc -39
    //   543: astore_2
    //   544: goto -140 -> 404
    //   547: astore_2
    //   548: goto -188 -> 360
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	551	0	this	1
    //   1	487	1	bool	boolean
    //   240	168	2	str1	String
    //   508	32	2	localObject	Object
    //   543	1	2	str2	String
    //   547	1	2	localInterruptedException	InterruptedException
    //   377	28	3	str3	String
    //   390	16	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	134	508	finally
    //   134	167	508	finally
    //   167	230	508	finally
    //   230	263	508	finally
    //   263	296	508	finally
    //   296	346	508	finally
    //   346	355	508	finally
    //   355	360	508	finally
    //   360	401	508	finally
    //   404	455	508	finally
    //   491	505	508	finally
    //   355	360	547	java/lang/InterruptedException
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.TrustDefenderMobile.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */