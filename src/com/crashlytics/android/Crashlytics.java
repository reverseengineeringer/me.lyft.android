package com.crashlytics.android;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.beta.Beta;
import com.crashlytics.android.core.CrashlyticsCore;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitGroup;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Crashlytics
  extends Kit<Void>
  implements KitGroup
{
  public final Answers answers;
  public final Beta beta;
  public final CrashlyticsCore core;
  public final Collection<? extends Kit> kits;
  
  public Crashlytics()
  {
    this(new Answers(), new Beta(), new CrashlyticsCore());
  }
  
  Crashlytics(Answers paramAnswers, Beta paramBeta, CrashlyticsCore paramCrashlyticsCore)
  {
    answers = paramAnswers;
    beta = paramBeta;
    core = paramCrashlyticsCore;
    kits = Collections.unmodifiableCollection(Arrays.asList(new Kit[] { paramAnswers, paramBeta, paramCrashlyticsCore }));
  }
  
  private static void checkInitialized()
  {
    if (getInstance() == null) {
      throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
    }
  }
  
  public static Crashlytics getInstance()
  {
    return (Crashlytics)Fabric.getKit(Crashlytics.class);
  }
  
  public static void log(String paramString)
  {
    checkInitialized();
    getInstancecore.log(paramString);
  }
  
  public static void logException(Throwable paramThrowable)
  {
    checkInitialized();
    getInstancecore.logException(paramThrowable);
  }
  
  public static void setString(String paramString1, String paramString2)
  {
    checkInitialized();
    getInstancecore.setString(paramString1, paramString2);
  }
  
  public static void setUserEmail(String paramString)
  {
    checkInitialized();
    getInstancecore.setUserEmail(paramString);
  }
  
  public static void setUserIdentifier(String paramString)
  {
    checkInitialized();
    getInstancecore.setUserIdentifier(paramString);
  }
  
  public static void setUserName(String paramString)
  {
    checkInitialized();
    getInstancecore.setUserName(paramString);
  }
  
  protected Void doInBackground()
  {
    return null;
  }
  
  public String getIdentifier()
  {
    return "com.crashlytics.sdk.android:crashlytics";
  }
  
  public Collection<? extends Kit> getKits()
  {
    return kits;
  }
  
  public String getVersion()
  {
    return "2.5.5.97";
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.Crashlytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */