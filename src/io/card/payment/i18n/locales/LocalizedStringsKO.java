package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.HashMap;
import java.util.Map;

public class LocalizedStringsKO
  implements SupportedLocale<StringKey>
{
  private static Map<String, String> mAdapted = new HashMap();
  private static Map<StringKey, String> mDisplay = new HashMap();
  
  public LocalizedStringsKO()
  {
    mDisplay.put(StringKey.CANCEL, "취소");
    mDisplay.put(StringKey.CARDTYPE_AMERICANEXPRESS, "American Express");
    mDisplay.put(StringKey.CARDTYPE_DISCOVER, "Discover");
    mDisplay.put(StringKey.CARDTYPE_JCB, "JCB");
    mDisplay.put(StringKey.CARDTYPE_MASTERCARD, "MasterCard");
    mDisplay.put(StringKey.CARDTYPE_VISA, "Visa");
    mDisplay.put(StringKey.DONE, "완료");
    mDisplay.put(StringKey.ENTRY_CVV, "CVV");
    mDisplay.put(StringKey.ENTRY_POSTAL_CODE, "우편번호");
    mDisplay.put(StringKey.ENTRY_EXPIRES, "유효기간");
    mDisplay.put(StringKey.EXPIRES_PLACEHOLDER, "MM / YY");
    mDisplay.put(StringKey.SCAN_GUIDE, "카드를 여기에 갖다 대세요.\n자동으로 스캔됩니다.");
    mDisplay.put(StringKey.KEYBOARD, "키보드…");
    mDisplay.put(StringKey.ENTRY_CARD_NUMBER, "카드 번호");
    mDisplay.put(StringKey.MANUAL_ENTRY_TITLE, "카드 세부정보");
    mDisplay.put(StringKey.ERROR_NO_DEVICE_SUPPORT, "기기가 카메라를 이용한 카드 숫자 판독을 지원하지 않습니다.");
    mDisplay.put(StringKey.ERROR_CAMERA_CONNECT_FAIL, "기기에서 카메라를 사용할 수 없습니다.");
    mDisplay.put(StringKey.ERROR_CAMERA_UNEXPECTED_FAIL, "기기에서 카메라를 여는 동안 예상치 못한 오류가 발생했습니다.");
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
    return "ko";
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsKO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */