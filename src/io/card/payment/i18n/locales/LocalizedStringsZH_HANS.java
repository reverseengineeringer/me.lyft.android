package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsZH_HANS
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsZH_HANS()
  {
    mDisplay.put(StringKey.CANCEL, "取消");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
    mDisplay.put(StringKey.DONE, "完成");
    mDisplay.put(StringKey.ENTRY_CVV, "CVV");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "邮政编码");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "失效日期：");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM/YY");
    mDisplay.put(StringKey.SCAN_GUIDE, "持卡置于此处。\n设备会自动扫描卡。");
    mDisplay.put(StringKey.KEYBOARD, "键盘…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "卡号");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "卡详细信息");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "此设备无法使用摄像头读取卡号。");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "设备摄像头不可用。");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "设备打开摄像头时出现意外错误。");
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
    return "zh-Hans";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsZH_HANS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */