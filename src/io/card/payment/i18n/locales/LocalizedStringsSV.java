package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsSV
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsSV()
  {
    mDisplay.put(StringKey.CANCEL, "Avbryt");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
    mDisplay.put(StringKey.DONE, "Klart");
    mDisplay.put(StringKey.ENTRY_CVV, "CVV");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "Postnummer");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "Går ut");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM/ÅÅ");
    mDisplay.put(StringKey.SCAN_GUIDE, "Håll kortet här.\nDet skannas automatiskt.");
    mDisplay.put(StringKey.KEYBOARD, "Tangentbord …");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "Kortnummer");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "Kortinformation");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Den här enheten kan inte använda kameran till att läsa kortnummer.");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Enhetens kamera är inte tillgänglig.");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Ett oväntat fel uppstod när enheten skulle öppna kameran.");
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
    return "sv";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsSV
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */