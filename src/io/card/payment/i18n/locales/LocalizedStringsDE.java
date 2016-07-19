package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsDE
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsDE()
  {
    mDisplay.put(StringKey.CANCEL, "Abbrechen");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
    mDisplay.put(StringKey.DONE, "Fertig");
    mDisplay.put(StringKey.ENTRY_CVV, "Kartenprüfnr.");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "PLZ");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "Gültig bis");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM/JJ");
    mDisplay.put(StringKey.SCAN_GUIDE, "Kreditkarte hierhin halten.\nSie wird automatisch gelesen.");
    mDisplay.put(StringKey.KEYBOARD, "Tastatur…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "Kartennummer");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "Kreditkartendetails");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Dieses Gerät kann mit der Kamera keine Kreditkartennummern lesen.");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Die Kamera ist nicht verfügbar.");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Beim Öffnen der Kamera ist ein unerwarteter Fehler aufgetreten.");
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
    return "de";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsDE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */