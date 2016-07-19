package io.card.payment.i18n;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class I18nManager<E extends Enum<?>>
{
  private static final Set<String> RIGHT_TO_LEFT_LOCALE_SET;
  private static final Map<String, String> SPECIAL_LOCALE_MAP;
  private static final String TAG;
  private SupportedLocale<E> currentLocale;
  private Class<E> enumClazz;
  private Map<String, SupportedLocale<E>> supportedLocales = new LinkedHashMap();
  
  static
  {
    if (!I18nManager.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      TAG = I18nManager.class.getSimpleName();
      SPECIAL_LOCALE_MAP = new HashMap();
      RIGHT_TO_LEFT_LOCALE_SET = new HashSet();
      SPECIAL_LOCALE_MAP.put("zh_CN", "zh-Hans");
      SPECIAL_LOCALE_MAP.put("zh_TW", "zh-Hant_TW");
      SPECIAL_LOCALE_MAP.put("zh_HK", "zh-Hant");
      SPECIAL_LOCALE_MAP.put("en_UK", "en_GB");
      SPECIAL_LOCALE_MAP.put("en_IE", "en_GB");
      SPECIAL_LOCALE_MAP.put("iw_IL", "he");
      SPECIAL_LOCALE_MAP.put("no", "nb");
      RIGHT_TO_LEFT_LOCALE_SET.add("he");
      RIGHT_TO_LEFT_LOCALE_SET.add("ar");
      return;
    }
  }
  
  public I18nManager(Class<E> paramClass, List<SupportedLocale<E>> paramList)
  {
    enumClazz = paramClass;
    paramClass = paramList.iterator();
    while (paramClass.hasNext()) {
      addLocale((SupportedLocale)paramClass.next());
    }
    setLanguage(null);
  }
  
  private void addLocale(SupportedLocale<E> paramSupportedLocale)
  {
    String str = paramSupportedLocale.getName();
    if (str == null) {
      throw new RuntimeException("Null localeName");
    }
    if (supportedLocales.containsKey(str)) {
      throw new RuntimeException("Locale " + str + " already added");
    }
    supportedLocales.put(str, paramSupportedLocale);
    logMissingLocalizations(str);
  }
  
  private List<String> getMissingLocaleMessages(String paramString)
  {
    SupportedLocale localSupportedLocale = (SupportedLocale)supportedLocales.get(paramString);
    ArrayList localArrayList = new ArrayList();
    Log.i(TAG, "Checking locale " + paramString);
    Enum[] arrayOfEnum = (Enum[])enumClazz.getEnumConstants();
    int j = arrayOfEnum.length;
    int i = 0;
    while (i < j)
    {
      Enum localEnum = arrayOfEnum[i];
      String str = "[" + paramString + "," + localEnum + "]";
      if (localSupportedLocale.getAdaptedDisplay(localEnum, null) == null) {
        localArrayList.add("Missing " + str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void logMissingLocalizations(String paramString)
  {
    paramString = getMissingLocaleMessages(paramString).iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      Log.i(TAG, str);
    }
  }
  
  private SupportedLocale<E> lookupSupportedLocale(String paramString)
  {
    if ((paramString == null) || (paramString.length() < 2))
    {
      localObject1 = null;
      return (SupportedLocale<E>)localObject1;
    }
    Object localObject2 = null;
    if (SPECIAL_LOCALE_MAP.containsKey(paramString))
    {
      localObject1 = (String)SPECIAL_LOCALE_MAP.get(paramString);
      localObject2 = (SupportedLocale)supportedLocales.get(localObject1);
      Log.d(TAG, "Overriding locale specifier " + paramString + " with " + (String)localObject1);
    }
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      if (!paramString.contains("_")) {
        break label170;
      }
    }
    label170:
    for (localObject1 = paramString;; localObject1 = paramString + "_" + Locale.getDefault().getCountry())
    {
      localObject1 = (SupportedLocale)supportedLocales.get(localObject1);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (SupportedLocale)supportedLocales.get(paramString);
      }
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      paramString = paramString.substring(0, 2);
      return (SupportedLocale)supportedLocales.get(paramString);
    }
  }
  
  public SupportedLocale<E> getLocaleFromSpecifier(String paramString)
  {
    SupportedLocale localSupportedLocale = null;
    if (paramString != null) {
      localSupportedLocale = lookupSupportedLocale(paramString);
    }
    Object localObject = localSupportedLocale;
    if (localSupportedLocale == null)
    {
      localObject = Locale.getDefault().toString();
      Log.d(TAG, paramString + " not found.  Attempting to look for " + (String)localObject);
      localObject = lookupSupportedLocale((String)localObject);
    }
    paramString = (String)localObject;
    if (localObject == null)
    {
      Log.d(TAG, "defaulting to english");
      paramString = (SupportedLocale)supportedLocales.get("en");
    }
    assert (paramString != null);
    return paramString;
  }
  
  public String getString(E paramE)
  {
    return getString(paramE, currentLocale);
  }
  
  public String getString(E paramE, SupportedLocale<E> paramSupportedLocale)
  {
    String str = Locale.getDefault().getCountry().toUpperCase(Locale.US);
    Object localObject = paramSupportedLocale.getAdaptedDisplay(paramE, str);
    paramSupportedLocale = (SupportedLocale<E>)localObject;
    if (localObject == null)
    {
      paramSupportedLocale = "Missing localized string for [" + currentLocale.getName() + ",Key." + paramE.toString() + "]";
      Log.i(TAG, paramSupportedLocale);
      paramSupportedLocale = ((SupportedLocale)supportedLocales.get("en")).getAdaptedDisplay(paramE, str);
    }
    localObject = paramSupportedLocale;
    if (paramSupportedLocale == null)
    {
      Log.i(TAG, "Missing localized string for [en,Key." + paramE.toString() + "], so defaulting to keyname");
      localObject = paramE.toString();
    }
    return (String)localObject;
  }
  
  public void setLanguage(String paramString)
  {
    Log.d(TAG, "setLanguage(" + paramString + ")");
    currentLocale = null;
    currentLocale = getLocaleFromSpecifier(paramString);
    assert (currentLocale != null);
    Log.d(TAG, "setting locale to:" + currentLocale.getName());
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.I18nManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */