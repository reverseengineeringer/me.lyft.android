package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsIT
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsIT()
  {
    mDisplay.put(StringKey.CANCEL, "Annulla");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
    mDisplay.put(StringKey.DONE, "Fine");
    mDisplay.put(StringKey.ENTRY_CVV, "CVV");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "Codice postale");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "Scadenza");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM/AA");
    mDisplay.put(StringKey.SCAN_GUIDE, "Inquadra la carta.\nLa scansione è automatica.");
    mDisplay.put(StringKey.KEYBOARD, "Tastiera…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "Numero di carta");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "Dati carta");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "La fotocamera non legge il numero di carta.");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Fotocamera non disponibile.");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Errore inatteso nell’apertura della fotocamera.");
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
    return "it";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsIT
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */