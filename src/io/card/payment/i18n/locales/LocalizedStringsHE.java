package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsHE
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsHE()
  {
    mDisplay.put(StringKey.CANCEL, "ביטול");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "אמריקן אקספרס");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover‏");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB‏");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "מאסטרקארד");
    mDisplay.put(StringKey.CARDTYPE_VISA, "ויזה");
    mDisplay.put(StringKey.DONE, "בוצע");
    mDisplay.put(StringKey.ENTRY_CVV, "קוד אימות כרטיס");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "מיקוד");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "תאריך תפוגה");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM/YY‏");
    mDisplay.put(StringKey.SCAN_GUIDE, "החזק את הכרטיס כאן.\nהסריקה תתבצע באופן אוטומטי.");
    mDisplay.put(StringKey.KEYBOARD, "מקלדת…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "מספר כרטיס");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "פרטי כרטיס");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "המכשיר אינו מסוגל להשתמש במצלמה לקריאת מספרי כרטיס.");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "מצלמת המכשיר אינה זמינה.");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "המכשיר נתקל בשגיאה בלתי צפויה בזמן הפעלת המצלמה.");
  }
  
  public String getAdaptedDisplay(StringKey paramStringKey, String paramString)
  {
    paramString = paramStringKey.toString() + "|" + paramString;
    if (mAdapted.containsKey(paramString)) {
      return (String)mAdapted.get(paramString);
    }
    return (String)mDisplay.get(paramStringKey);
  }
  
  public String getName()
  {
    return "he";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsHE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */