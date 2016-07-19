package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class DefaultJobValidator
  implements JobValidator
{
  private final Context context;
  
  public DefaultJobValidator(Context paramContext)
  {
    context = paramContext;
  }
  
  private static List<String> addError(List<String> paramList, String paramString)
  {
    if (paramString == null) {
      return paramList;
    }
    if (paramList == null) {
      return getMutableSingletonList(paramString);
    }
    Collections.addAll(paramList, new String[] { paramString });
    return paramList;
  }
  
  private static List<String> addErrorsIf(boolean paramBoolean, List<String> paramList, String paramString)
  {
    Object localObject = paramList;
    if (paramBoolean) {
      localObject = addError(paramList, paramString);
    }
    return (List<String>)localObject;
  }
  
  private static List<String> getMutableSingletonList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  private static int measureBundleSize(Bundle paramBundle)
  {
    Parcel localParcel = Parcel.obtain();
    paramBundle.writeToParcel(localParcel, 0);
    int i = localParcel.dataSize();
    localParcel.recycle();
    return i;
  }
  
  private static List<String> mergeErrorLists(List<String> paramList1, List<String> paramList2)
  {
    List<String> localList;
    if (paramList1 == null) {
      localList = paramList2;
    }
    do
    {
      return localList;
      localList = paramList1;
    } while (paramList2 == null);
    paramList1.addAll(paramList2);
    return paramList1;
  }
  
  private String validateExtrasType(Bundle paramBundle, String paramString)
  {
    Object localObject = null;
    paramBundle = paramBundle.get(paramString);
    if (((paramBundle instanceof Integer)) || ((paramBundle instanceof Long)) || ((paramBundle instanceof Double)) || ((paramBundle instanceof String)) || ((paramBundle instanceof Boolean))) {
      return null;
    }
    Locale localLocale = Locale.US;
    if (paramBundle == null) {}
    for (paramBundle = (Bundle)localObject;; paramBundle = paramBundle.getClass()) {
      return String.format(localLocale, "Received value of type '%s' for key '%s', but only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean", new Object[] { paramString, paramBundle });
    }
  }
  
  private List<String> validateForPersistence(Bundle paramBundle)
  {
    Object localObject = null;
    List localList = null;
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      for (;;)
      {
        localObject = localList;
        if (!localIterator.hasNext()) {
          break;
        }
        localList = addError(localList, validateExtrasType(paramBundle, (String)localIterator.next()));
      }
    }
    return (List<String>)localObject;
  }
  
  private List<String> validateForTransport(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    int i;
    do
    {
      return null;
      i = measureBundleSize(paramBundle);
    } while (i <= 10240);
    return getMutableSingletonList(String.format(Locale.US, "Extras too large: %d bytes is > the max (%d bytes)", new Object[] { Integer.valueOf(i), Integer.valueOf(10240) }));
  }
  
  private List<String> validateService(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return getMutableSingletonList("Service can't be empty");
    }
    if (context == null) {
      return getMutableSingletonList("Context is null, can't query PackageManager");
    }
    Object localObject = context.getPackageManager();
    if (localObject == null) {
      return getMutableSingletonList("PackageManager is null, can't validate service");
    }
    String str = "Couldn't find a registered service with the name " + paramString + ". Is it declared in the manifest with the right intent-filter?";
    Intent localIntent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
    localIntent.setClassName(context, paramString);
    paramString = ((PackageManager)localObject).queryIntentServices(localIntent, 0);
    if ((paramString == null) || (paramString.isEmpty())) {
      return getMutableSingletonList(str);
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject = (ResolveInfo)paramString.next();
      if ((serviceInfo != null) && (serviceInfo.enabled)) {
        return null;
      }
    }
    return getMutableSingletonList(str);
  }
  
  private List<String> validateTag(String paramString)
  {
    if (paramString == null) {
      return getMutableSingletonList("Tag can't be null");
    }
    if (paramString.length() > 100) {
      return getMutableSingletonList("Tag must be shorter than 100");
    }
    return null;
  }
  
  public List<String> validate(JobParameters paramJobParameters)
  {
    List localList2 = mergeErrorLists(mergeErrorLists(null, validate(paramJobParameters.getTrigger())), validate(paramJobParameters.getRetryStrategy()));
    List localList1 = localList2;
    if (paramJobParameters.isRecurring())
    {
      localList1 = localList2;
      if (paramJobParameters.getTrigger() == Trigger.NOW) {
        localList1 = addError(localList2, "ImmediateTriggers can't be used with recurring jobs");
      }
    }
    localList2 = mergeErrorLists(localList1, validateForTransport(paramJobParameters.getExtras()));
    localList1 = localList2;
    if (paramJobParameters.getLifetime() > 1) {
      localList1 = mergeErrorLists(localList2, validateForPersistence(paramJobParameters.getExtras()));
    }
    return mergeErrorLists(mergeErrorLists(localList1, validateTag(paramJobParameters.getTag())), validateService(paramJobParameters.getService()));
  }
  
  public List<String> validate(JobTrigger paramJobTrigger)
  {
    if (paramJobTrigger == Trigger.NOW) {}
    while ((paramJobTrigger instanceof JobTrigger.ExecutionWindowTrigger)) {
      return null;
    }
    return getMutableSingletonList("Unknown trigger provided");
  }
  
  public List<String> validate(RetryStrategy paramRetryStrategy)
  {
    boolean bool2 = true;
    int i = paramRetryStrategy.getPolicy();
    int j = paramRetryStrategy.getInitialBackoff();
    int k = paramRetryStrategy.getMaximumBackoff();
    if ((i != 1) && (i != 2))
    {
      bool1 = true;
      paramRetryStrategy = addErrorsIf(bool1, null, "Unknown retry policy provided");
      if (k >= j) {
        break label108;
      }
      bool1 = true;
      label51:
      paramRetryStrategy = addErrorsIf(bool1, paramRetryStrategy, "Maximum backoff must be greater than or equal to initial backoff");
      if (300 <= k) {
        break label114;
      }
      bool1 = true;
      label72:
      paramRetryStrategy = addErrorsIf(bool1, paramRetryStrategy, "Maximum backoff must be greater than 300s (5 minutes)");
      if (j >= 30) {
        break label120;
      }
    }
    label108:
    label114:
    label120:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return addErrorsIf(bool1, paramRetryStrategy, "Initial backoff must be at least 30s");
      bool1 = false;
      break;
      bool1 = false;
      break label51;
      bool1 = false;
      break label72;
    }
  }
}

/* Location:
 * Qualified Name:     com.firebase.jobdispatcher.DefaultJobValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */