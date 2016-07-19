package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsTR
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsTR()
  {
    mDisplay.put(StringKey.CANCEL, "İptal");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
    mDisplay.put(StringKey.DONE, "Bitti");
    mDisplay.put(StringKey.ENTRY_CVV, "CVV");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "Posta Kodu");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "Son kullanma tarihi");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "AA/YY");
    mDisplay.put(StringKey.SCAN_GUIDE, "Kartınızı buraya tutun.\nOtomatik olarak taranacaktır.");
    mDisplay.put(StringKey.KEYBOARD, "Klavye…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "Kart Numarası");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "Kart Ayrıntıları");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Bu cihazın kamerası kart rakamlarını okuyamaz.");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Cihaz kamerası kullanılamıyor.");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Cihaz kamerayı açarken beklenmedik bir hata verdi.");
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
    return "tr";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsTR
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */