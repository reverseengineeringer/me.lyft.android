package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsPL
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsPL()
  {
    mDisplay.put(StringKey.CANCEL, "Anuluj");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
    mDisplay.put(StringKey.DONE, "Gotowe");
    mDisplay.put(StringKey.ENTRY_CVV, "Kod CVV2/CVC2");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "Kod pocztowy");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "Wygasa");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM/RR");
    mDisplay.put(StringKey.SCAN_GUIDE, "Przytrzymaj kartę tutaj.\nZostanie ona zeskanowana automatycznie.");
    mDisplay.put(StringKey.KEYBOARD, "Klawiatura…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "Numer karty");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "Dane karty");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Na tym urządzeniu nie można odczytać numeru karty za pomocą aparatu.");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Aparat na tym urządzeniu jest niedostepny.");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Przy otwieraniu aparatu na tym urządzeniu wystąpił nieoczekiwany błąd.");
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
    return "pl";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsPL
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */