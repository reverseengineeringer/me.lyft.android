package com.leanplum.messagetemplates;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public class MessageTemplates
{
  private static Boolean a = Boolean.valueOf(false);
  
  static String a(Context paramContext)
  {
    int i = getApplicationInfolabelRes;
    if (i == 0) {
      return paramContext.getApplicationInfo().loadLabel(paramContext.getPackageManager()).toString();
    }
    return paramContext.getString(i);
  }
  
  /* Error */
  public static void register(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 16	com/leanplum/messagetemplates/MessageTemplates:a	Ljava/lang/Boolean;
    //   6: invokevirtual 57	java/lang/Boolean:booleanValue	()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +7 -> 18
    //   14: ldc 2
    //   16: monitorexit
    //   17: return
    //   18: iconst_1
    //   19: invokestatic 14	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   22: putstatic 16	com/leanplum/messagetemplates/MessageTemplates:a	Ljava/lang/Boolean;
    //   25: ldc 59
    //   27: getstatic 64	com/leanplum/Leanplum:ACTION_KIND_ACTION	I
    //   30: new 66	com/leanplum/ActionArgs
    //   33: dup
    //   34: invokespecial 67	com/leanplum/ActionArgs:<init>	()V
    //   37: ldc 69
    //   39: ldc 71
    //   41: invokevirtual 75	com/leanplum/ActionArgs:with	(Ljava/lang/String;Ljava/lang/Object;)Lcom/leanplum/ActionArgs;
    //   44: new 77	com/leanplum/messagetemplates/u
    //   47: dup
    //   48: invokespecial 78	com/leanplum/messagetemplates/u:<init>	()V
    //   51: invokestatic 82	com/leanplum/Leanplum:defineAction	(Ljava/lang/String;ILcom/leanplum/ActionArgs;Lcom/leanplum/callbacks/ActionCallback;)V
    //   54: ldc 84
    //   56: getstatic 87	com/leanplum/Leanplum:ACTION_KIND_MESSAGE	I
    //   59: getstatic 64	com/leanplum/Leanplum:ACTION_KIND_ACTION	I
    //   62: ior
    //   63: new 66	com/leanplum/ActionArgs
    //   66: dup
    //   67: invokespecial 67	com/leanplum/ActionArgs:<init>	()V
    //   70: ldc 89
    //   72: aload_0
    //   73: invokestatic 91	com/leanplum/messagetemplates/MessageTemplates:a	(Landroid/content/Context;)Ljava/lang/String;
    //   76: invokevirtual 75	com/leanplum/ActionArgs:with	(Ljava/lang/String;Ljava/lang/Object;)Lcom/leanplum/ActionArgs;
    //   79: ldc 93
    //   81: ldc 95
    //   83: invokevirtual 75	com/leanplum/ActionArgs:with	(Ljava/lang/String;Ljava/lang/Object;)Lcom/leanplum/ActionArgs;
    //   86: ldc 97
    //   88: ldc 99
    //   90: invokevirtual 75	com/leanplum/ActionArgs:with	(Ljava/lang/String;Ljava/lang/Object;)Lcom/leanplum/ActionArgs;
    //   93: ldc 101
    //   95: aconst_null
    //   96: invokevirtual 105	com/leanplum/ActionArgs:withAction	(Ljava/lang/String;Ljava/lang/String;)Lcom/leanplum/ActionArgs;
    //   99: new 107	com/leanplum/messagetemplates/b
    //   102: dup
    //   103: invokespecial 108	com/leanplum/messagetemplates/b:<init>	()V
    //   106: invokestatic 82	com/leanplum/Leanplum:defineAction	(Ljava/lang/String;ILcom/leanplum/ActionArgs;Lcom/leanplum/callbacks/ActionCallback;)V
    //   109: ldc 110
    //   111: getstatic 87	com/leanplum/Leanplum:ACTION_KIND_MESSAGE	I
    //   114: getstatic 64	com/leanplum/Leanplum:ACTION_KIND_ACTION	I
    //   117: ior
    //   118: new 66	com/leanplum/ActionArgs
    //   121: dup
    //   122: invokespecial 67	com/leanplum/ActionArgs:<init>	()V
    //   125: ldc 89
    //   127: aload_0
    //   128: invokestatic 91	com/leanplum/messagetemplates/MessageTemplates:a	(Landroid/content/Context;)Ljava/lang/String;
    //   131: invokevirtual 75	com/leanplum/ActionArgs:with	(Ljava/lang/String;Ljava/lang/Object;)Lcom/leanplum/ActionArgs;
    //   134: ldc 93
    //   136: ldc 112
    //   138: invokevirtual 75	com/leanplum/ActionArgs:with	(Ljava/lang/String;Ljava/lang/Object;)Lcom/leanplum/ActionArgs;
    //   141: ldc 114
    //   143: ldc 116
    //   145: invokevirtual 75	com/leanplum/ActionArgs:with	(Ljava/lang/String;Ljava/lang/Object;)Lcom/leanplum/ActionArgs;
    //   148: ldc 118
    //   150: ldc 120
    //   152: invokevirtual 75	com/leanplum/ActionArgs:with	(Ljava/lang/String;Ljava/lang/Object;)Lcom/leanplum/ActionArgs;
    //   155: ldc 122
    //   157: aconst_null
    //   158: invokevirtual 105	com/leanplum/ActionArgs:withAction	(Ljava/lang/String;Ljava/lang/String;)Lcom/leanplum/ActionArgs;
    //   161: ldc 124
    //   163: aconst_null
    //   164: invokevirtual 105	com/leanplum/ActionArgs:withAction	(Ljava/lang/String;Ljava/lang/String;)Lcom/leanplum/ActionArgs;
    //   167: new 126	com/leanplum/messagetemplates/n
    //   170: dup
    //   171: invokespecial 127	com/leanplum/messagetemplates/n:<init>	()V
    //   174: invokestatic 82	com/leanplum/Leanplum:defineAction	(Ljava/lang/String;ILcom/leanplum/ActionArgs;Lcom/leanplum/callbacks/ActionCallback;)V
    //   177: aload_0
    //   178: invokestatic 131	com/leanplum/messagetemplates/CenterPopup:register	(Landroid/content/Context;)V
    //   181: aload_0
    //   182: invokestatic 134	com/leanplum/messagetemplates/Interstitial:register	(Landroid/content/Context;)V
    //   185: aload_0
    //   186: invokestatic 137	com/leanplum/messagetemplates/WebInterstitial:register	(Landroid/content/Context;)V
    //   189: goto -175 -> 14
    //   192: astore_0
    //   193: ldc 2
    //   195: monitorexit
    //   196: aload_0
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramContext	Context
    //   9	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	10	192	finally
    //   18	189	192	finally
  }
}

/* Location:
 * Qualified Name:     com.leanplum.messagetemplates.MessageTemplates
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */