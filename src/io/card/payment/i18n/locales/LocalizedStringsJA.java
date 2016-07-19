package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsJA
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsJA()
  {
    mDisplay.put(StringKey.CANCEL, "キャンセル");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
    mDisplay.put(StringKey.DONE, "完了");
    mDisplay.put(StringKey.ENTRY_CVV, "カード確認コード");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "郵便番号");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "有効期限");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM/YY");
    mDisplay.put(StringKey.SCAN_GUIDE, "ここでカードをお持ちください。\n自動的にスキャンされます。");
    mDisplay.put(StringKey.KEYBOARD, "キーボード…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "カード番号");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "カードの詳細");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "この端末ではカード番号の読込にカメラを使えません。");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "端末のカメラを使用できません。");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "カメラを起動中に予期しないエラーが発生しました。");
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
    return "ja";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsJA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */