package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsFR
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsFR()
  {
    mDisplay.put(StringKey.CANCEL, "Annuler");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
    mDisplay.put(StringKey.DONE, "OK");
    mDisplay.put(StringKey.ENTRY_CVV, "Crypto.");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "Code postal");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "Date d’expiration");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM/AA");
    mDisplay.put(StringKey.SCAN_GUIDE, "Maintenez la carte à cet endroit.\nElle va être automatiquement scannée.");
    mDisplay.put(StringKey.KEYBOARD, "Clavier…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "Nº de carte");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "Carte");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Cet appareil ne peut pas utiliser l’appareil photo pour lire les numéros de carte.");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "L’appareil photo n’est pas disponible.");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Une erreur s’est produite en ouvrant l’appareil photo.");
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
    return "fr";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsFR
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */