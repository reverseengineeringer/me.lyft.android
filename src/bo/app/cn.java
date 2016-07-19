package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.configuration.XmlAppConfigurationProvider;

public final class cn
  implements cm
{
  private final XmlAppConfigurationProvider a;
  private final SharedPreferences b;
  
  public cn(Context paramContext, XmlAppConfigurationProvider paramXmlAppConfigurationProvider)
  {
    a = paramXmlAppConfigurationProvider;
    b = paramContext.getSharedPreferences("com.appboy.push_registration", 0);
  }
  
  /* Error */
  public final String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 27	bo/app/cn:b	Landroid/content/SharedPreferences;
    //   8: ldc 31
    //   10: invokeinterface 37 2 0
    //   15: ifeq +34 -> 49
    //   18: aload_0
    //   19: getfield 17	bo/app/cn:a	Lcom/appboy/configuration/XmlAppConfigurationProvider;
    //   22: invokevirtual 43	com/appboy/configuration/XmlAppConfigurationProvider:getVersionCode	()I
    //   25: istore_1
    //   26: aload_0
    //   27: getfield 27	bo/app/cn:b	Landroid/content/SharedPreferences;
    //   30: ldc 31
    //   32: ldc 44
    //   34: invokeinterface 48 3 0
    //   39: istore_2
    //   40: iload_1
    //   41: iload_2
    //   42: if_icmpeq +7 -> 49
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: areturn
    //   49: aload_0
    //   50: getfield 27	bo/app/cn:b	Landroid/content/SharedPreferences;
    //   53: ldc 50
    //   55: aconst_null
    //   56: invokeinterface 54 3 0
    //   61: astore_3
    //   62: goto -17 -> 45
    //   65: astore_3
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_3
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	cn
    //   25	18	1	i	int
    //   39	4	2	j	int
    //   1	61	3	str	String
    //   65	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	40	65	finally
    //   49	62	65	finally
  }
  
  public final void a(String paramString)
  {
    if (paramString == null) {
      try
      {
        throw new NullPointerException();
      }
      finally {}
    }
    SharedPreferences.Editor localEditor = b.edit();
    localEditor.putString("registration_id", paramString);
    localEditor.putInt("version_code", a.getVersionCode());
    localEditor.apply();
  }
  
  public final void b()
  {
    try
    {
      SharedPreferences.Editor localEditor = b.edit();
      localEditor.putString("registration_id", "");
      localEditor.apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.cn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */