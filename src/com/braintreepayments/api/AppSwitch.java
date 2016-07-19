package com.braintreepayments.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.braintreepayments.api.exceptions.AppSwitchNotAvailableException;
import java.util.List;

public abstract class AppSwitch
{
  public static final String EXTRA_MERCHANT_ID = "com.braintreepayments.api.MERCHANT_ID";
  public static final String EXTRA_OFFLINE = "com.braintreepayments.api.OFFLINE";
  public static final String EXTRA_PAYMENT_METHOD_NONCE = "com.braintreepayments.api.EXTRA_PAYMENT_METHOD_NONCE";
  protected static boolean sEnableSignatureVerification = true;
  protected ClientToken mClientToken;
  protected Context mContext;
  
  public AppSwitch(Context paramContext, ClientToken paramClientToken)
  {
    mContext = paramContext;
    mClientToken = paramClientToken;
  }
  
  /* Error */
  private boolean isSignatureValid()
  {
    // Byte code:
    //   0: getstatic 24	com/braintreepayments/api/AppSwitch:sEnableSignatureVerification	Z
    //   3: ifne +5 -> 8
    //   6: iconst_1
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 31	com/braintreepayments/api/AppSwitch:mContext	Landroid/content/Context;
    //   12: invokevirtual 45	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   15: astore 5
    //   17: aload 5
    //   19: aload_0
    //   20: invokevirtual 49	com/braintreepayments/api/AppSwitch:getPackage	()Ljava/lang/String;
    //   23: bipush 64
    //   25: invokevirtual 55	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   28: getfield 61	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   31: astore 5
    //   33: aload 5
    //   35: arraylength
    //   36: istore_2
    //   37: iconst_0
    //   38: istore_1
    //   39: iload_1
    //   40: iload_2
    //   41: if_icmpge +120 -> 161
    //   44: aload 5
    //   46: iload_1
    //   47: aaload
    //   48: astore 6
    //   50: new 63	java/io/ByteArrayInputStream
    //   53: dup
    //   54: aload 6
    //   56: invokevirtual 69	android/content/pm/Signature:toByteArray	()[B
    //   59: invokespecial 72	java/io/ByteArrayInputStream:<init>	([B)V
    //   62: astore 6
    //   64: ldc 74
    //   66: invokestatic 80	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   69: aload 6
    //   71: invokevirtual 84	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   74: checkcast 86	java/security/cert/X509Certificate
    //   77: astore 6
    //   79: aload 6
    //   81: invokevirtual 90	java/security/cert/X509Certificate:getSubjectX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   84: invokevirtual 95	javax/security/auth/x500/X500Principal:getName	()Ljava/lang/String;
    //   87: astore 7
    //   89: aload 6
    //   91: invokevirtual 98	java/security/cert/X509Certificate:getIssuerX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   94: invokevirtual 95	javax/security/auth/x500/X500Principal:getName	()Ljava/lang/String;
    //   97: astore 8
    //   99: aload 6
    //   101: invokevirtual 102	java/security/cert/X509Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   104: invokevirtual 106	java/lang/Object:hashCode	()I
    //   107: istore_3
    //   108: aload_0
    //   109: invokevirtual 109	com/braintreepayments/api/AppSwitch:getCertificateSubject	()Ljava/lang/String;
    //   112: aload 7
    //   114: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   117: ifeq +33 -> 150
    //   120: aload_0
    //   121: invokevirtual 118	com/braintreepayments/api/AppSwitch:getCertificateIssuer	()Ljava/lang/String;
    //   124: aload 8
    //   126: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   129: ifeq +21 -> 150
    //   132: aload_0
    //   133: invokevirtual 121	com/braintreepayments/api/AppSwitch:getPublicKeyHashCode	()I
    //   136: istore 4
    //   138: iload 4
    //   140: iload_3
    //   141: if_icmpne +9 -> 150
    //   144: iconst_1
    //   145: ireturn
    //   146: astore 5
    //   148: iconst_0
    //   149: ireturn
    //   150: iconst_0
    //   151: ireturn
    //   152: astore 6
    //   154: iload_1
    //   155: iconst_1
    //   156: iadd
    //   157: istore_1
    //   158: goto -119 -> 39
    //   161: iconst_0
    //   162: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	AppSwitch
    //   38	120	1	i	int
    //   36	6	2	j	int
    //   107	35	3	k	int
    //   136	6	4	m	int
    //   15	30	5	localObject1	Object
    //   146	1	5	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   48	52	6	localObject2	Object
    //   152	1	6	localCertificateException	java.security.cert.CertificateException
    //   87	26	7	str1	String
    //   97	28	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   17	33	146	android/content/pm/PackageManager$NameNotFoundException
    //   50	138	152	java/security/cert/CertificateException
  }
  
  protected abstract String getAppSwitchActivity();
  
  protected abstract String getCertificateIssuer();
  
  protected abstract String getCertificateSubject();
  
  protected Intent getLaunchIntent()
  {
    return new Intent().setComponent(new ComponentName(getPackage(), getPackage() + "." + getAppSwitchActivity()));
  }
  
  protected abstract String getPackage();
  
  protected abstract int getPublicKeyHashCode();
  
  protected abstract String handleAppSwitchResponse(int paramInt, Intent paramIntent);
  
  protected boolean isAvailable()
  {
    List localList = mContext.getPackageManager().queryIntentActivities(getLaunchIntent(), 0);
    return (localList.size() == 1) && (getPackage().equals(get0activityInfo.packageName)) && (isSignatureValid());
  }
  
  protected void launch(Activity paramActivity, int paramInt)
    throws AppSwitchNotAvailableException
  {
    if (isAvailable())
    {
      paramActivity.startActivityForResult(getLaunchIntent(), paramInt);
      return;
    }
    throw new AppSwitchNotAvailableException();
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.AppSwitch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */