package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsPT
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsPT()
  {
    mDisplay.put(StringKey.CANCEL, "Cancelar");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
    mDisplay.put(StringKey.DONE, "Concluído");
    mDisplay.put(StringKey.ENTRY_CVV, "CSC");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "Código Postal");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "Validade");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM/AA");
    mDisplay.put(StringKey.SCAN_GUIDE, "Segure o cartão aqui.\nSerá lido automaticamente.");
    mDisplay.put(StringKey.KEYBOARD, "Teclado…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "Número do cartão");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "Detalhes do cartão");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Este dispositivo não pode utilizar a câmara para ler números de cartões.");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "A câmara do dispositivo não está disponível.");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Ocorreu um erro inesperado no dispositivo ao abrir a câmara.");
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
    return "pt";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsPT
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */