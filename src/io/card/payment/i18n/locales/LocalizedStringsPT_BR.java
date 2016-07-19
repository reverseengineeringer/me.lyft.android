package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsPT_BR
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsPT_BR()
  {
    mDisplay.put(StringKey.CANCEL, "Cancelar");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
    mDisplay.put(StringKey.DONE, "Concluído");
    mDisplay.put(StringKey.ENTRY_CVV, "CVV");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "CEP");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "Vencimento");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM/AA");
    mDisplay.put(StringKey.SCAN_GUIDE, "Posicionar cartão aqui.\nEle será digitalizado automaticamente.");
    mDisplay.put(StringKey.KEYBOARD, "Teclado…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "Número do Cartão");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "Dados do cartão");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "Este dispositivo não pode usar a câmera para ler números de cartão.");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "A câmera do dispositivo não está disponível.");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "O dispositivo sofreu um erro inesperado ao abrir a câmera.");
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
    return "pt_BR";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsPT_BR
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */