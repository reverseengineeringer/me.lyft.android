package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsAR
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsAR()
  {
    mDisplay.put(StringKey.CANCEL, "إلغاء");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express‏");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover‏");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB‏");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard‏");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa‏");
    mDisplay.put(StringKey.DONE, "تم");
    mDisplay.put(StringKey.ENTRY_CVV, "CVV‏");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "الرمز البريدي");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "تاريخ انتهاء الصلاحية");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM/YY‏");
    mDisplay.put(StringKey.SCAN_GUIDE, "امسك البطاقة هنا.\n ستمسح تلقائيا.");
    mDisplay.put(StringKey.KEYBOARD, "لوحة المفاتيح…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "رقم البطاقة");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "تفاصيل البطاقة");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "هذا الجهاز لا يمكنه استعمال الكاميرا لقراءة أرقام البطاقة.");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "كاميرا الجهاز غير متاحة.");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "الجهاز حدث به خطا غير متوقع عند فتح الكاميرا.");
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
    return "ar";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsAR
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */