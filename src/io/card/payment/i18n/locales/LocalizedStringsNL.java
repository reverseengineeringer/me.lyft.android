package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsNL
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsNL()
  {
    mDisplay.put(StringKey.CANCEL, "Annuleren");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
    mDisplay.put(StringKey.DONE, "Gereed");
    mDisplay.put(StringKey.ENTRY_CVV, "CVV");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "Postcode");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "Vervaldatum");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM/JJ");
    mDisplay.put(StringKey.SCAN_GUIDE, "Houd uw kaart hier.\nScannen gaat automatisch.");
    mDisplay.put(StringKey.KEYBOARD, "Toetsenbord…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "Creditcardnummer");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "Kaartgegevens");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Met de camera van dit apparaat kunnen geen kaartnummers worden gelezen.");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Camera apparaat niet beschikbaar.");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Er is een onverwachte fout opgetreden bij het starten van de camera.");
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
    return "nl";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsNL
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */