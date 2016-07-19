package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsRU
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsRU()
  {
    mDisplay.put(StringKey.CANCEL, "Отмена");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
    mDisplay.put(StringKey.DONE, "Готово");
    mDisplay.put(StringKey.ENTRY_CVV, "Код безопасности");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "Индекс");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "Действительна до");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "ММ/ГГ");
    mDisplay.put(StringKey.SCAN_GUIDE, "Держите карту внутри рамки.\nОна будет считана\nавтоматически.");
    mDisplay.put(StringKey.KEYBOARD, "Клавиатура…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "Номер карты");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "Информация о карте");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "В данном устройстве нет опции считывания номера карты с помощью фотокамеры.");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "Фотокамера устройства недоступна.");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "Возникла незапланированная ошибка при открытии фотокамеры устройства.");
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
    return "ru";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsRU
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */