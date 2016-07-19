package me.lyft.android.domain.payment;

import java.util.HashMap;
import java.util.Map;
import me.lyft.android.common.DateUtils;
import me.lyft.android.common.Strings;

public class Card
  implements ICard
{
  private static Map<String, Integer> localeFormats = ;
  private String addressCity;
  private String addressCountry;
  private String addressLine1;
  private String addressLine2;
  private String addressState;
  private String addressZip;
  private String cvc;
  private Integer expMonth;
  private Integer expYear;
  private String locale;
  private String name;
  private String number;
  private String type;
  
  public static ICard create(String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, String paramString3)
  {
    return create(paramString1, paramInteger1, paramInteger2, paramString2, paramString3, "en_US");
  }
  
  public static ICard create(String paramString1, Integer paramInteger1, Integer paramInteger2, String paramString2, String paramString3, String paramString4)
  {
    Card localCard = new Card();
    number = normalizeCardNumber(paramString1);
    expMonth = paramInteger1;
    if (paramInteger2 == null) {}
    for (paramString1 = null;; paramString1 = Integer.valueOf(DateUtils.normalizeYear(paramInteger2.intValue())))
    {
      expYear = paramString1;
      cvc = paramString2;
      addressZip = paramString3;
      type = localCard.getType();
      locale = paramString4;
      return localCard;
    }
  }
  
  public static ICard createEmpty()
  {
    return create(null, null, null, null, null);
  }
  
  private int getZipLength()
  {
    return Strings.replaceAllWhitespaces(addressZip).length();
  }
  
  private static Map<String, Integer> initFormats()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("en_US", Integer.valueOf(5));
    localHashMap.put("en_CA", Integer.valueOf(6));
    localHashMap.put("en_GB", Integer.valueOf(7));
    return localHashMap;
  }
  
  static boolean isValidLuhnNumber(String paramString)
  {
    boolean bool = true;
    if (Strings.isNullOrBlank(paramString)) {}
    int k;
    int m;
    char c;
    do
    {
      return false;
      i = 1;
      k = 0;
      m = paramString.length() - 1;
      if (m < 0) {
        break;
      }
      c = paramString.charAt(m);
    } while (!Character.isDigit(c));
    int n = Integer.parseInt("" + c);
    if (i == 0) {}
    for (int i = 1;; i = 0)
    {
      int j = n;
      if (i != 0) {
        j = n * 2;
      }
      n = j;
      if (j > 9) {
        n = j - 9;
      }
      k += n;
      m -= 1;
      break;
    }
    if (k % 10 == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  static boolean isWholePositiveNumber(String paramString)
  {
    if (Strings.isNullOrBlank(paramString)) {
      return false;
    }
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label40;
      }
      if (!Character.isDigit(paramString[i])) {
        break;
      }
      i += 1;
    }
    label40:
    return true;
  }
  
  static String normalizeCardNumber(String paramString)
  {
    if (Strings.isNullOrBlank(paramString)) {
      return null;
    }
    return Strings.emptyToNull(paramString.replaceAll("\\s+|-", "").trim());
  }
  
  public String getAddressCountry()
  {
    return addressCountry;
  }
  
  public String getAddressLine1()
  {
    return addressLine1;
  }
  
  public String getAddressLine2()
  {
    return addressLine2;
  }
  
  public String getAddressZip()
  {
    return addressZip;
  }
  
  public String getCity()
  {
    return addressCity;
  }
  
  public String getCvc()
  {
    return cvc;
  }
  
  public Integer getExpMonth()
  {
    return expMonth;
  }
  
  public Integer getExpYear()
  {
    return expYear;
  }
  
  public String getLast4()
  {
    if ((number != null) && (number.length() > 4)) {
      return number.substring(number.length() - 4, number.length());
    }
    return null;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getNumber()
  {
    return number;
  }
  
  public String getState()
  {
    return addressState;
  }
  
  public String getType()
  {
    if ((Strings.isNullOrBlank(type)) && (!Strings.isNullOrBlank(number)))
    {
      if (Strings.hasAnyPrefix(number, PREFIXES_AMERICAN_EXPRESS)) {
        return "American Express";
      }
      if (Strings.hasAnyPrefix(number, PREFIXES_DISCOVER)) {
        return "Discover";
      }
      if (Strings.hasAnyPrefix(number, PREFIXES_JCB)) {
        return "JCB";
      }
      if (Strings.hasAnyPrefix(number, PREFIXES_DINERS_CLUB)) {
        return "Diners Club";
      }
      if (Strings.hasAnyPrefix(number, PREFIXES_VISA)) {
        return "Visa";
      }
      if (Strings.hasAnyPrefix(number, PREFIXES_MASTERCARD)) {
        return "MasterCard";
      }
      return "Unknown";
    }
    return type;
  }
  
  public boolean isEmpty()
  {
    boolean bool1 = Strings.isNullOrEmpty(getNumber());
    if ((getExpMonth() == null) && (getExpYear() == null)) {}
    for (int i = 1;; i = 0)
    {
      boolean bool2 = Strings.isNullOrEmpty(getCvc());
      boolean bool3 = Strings.isNullOrEmpty(getAddressZip());
      if ((!bool1) || (i == 0) || (!bool2) || (!bool3)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void setAddressLine1(String paramString)
  {
    addressLine1 = paramString;
  }
  
  public void setAddressLine2(String paramString)
  {
    addressLine2 = paramString;
  }
  
  public void setCity(String paramString)
  {
    addressCity = paramString;
  }
  
  public void setState(String paramString)
  {
    addressState = paramString;
  }
  
  public boolean validateCVC()
  {
    if (Strings.isNullOrBlank(cvc)) {}
    for (;;)
    {
      return false;
      String str = cvc.trim();
      if (((type == null) && (str.length() >= 3) && (str.length() <= 4)) || (("American Express".equals(type)) && (str.length() == 4)) || ((!"American Express".equals(type)) && (str.length() == 3))) {}
      for (int i = 1; (isWholePositiveNumber(str)) && (i != 0); i = 0) {
        return true;
      }
    }
  }
  
  public boolean validateCard()
  {
    if (cvc == null) {
      if ((!validateNumber()) || (!validateExpiryDate())) {}
    }
    while ((validateNumber()) && (validateExpiryDate()) && (validateCVC()))
    {
      return true;
      return false;
    }
    return false;
  }
  
  boolean validateExpMonth()
  {
    boolean bool = true;
    if (expMonth == null) {
      return false;
    }
    if ((expMonth.intValue() >= 1) && (expMonth.intValue() <= 12)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  boolean validateExpYear()
  {
    if (expYear == null) {}
    while (DateUtils.hasYearPassed(expYear.intValue())) {
      return false;
    }
    return true;
  }
  
  public boolean validateExpiryDate()
  {
    if (!validateExpMonth()) {}
    while ((!validateExpYear()) || (DateUtils.hasMonthPassed(expYear.intValue(), expMonth.intValue()))) {
      return false;
    }
    return true;
  }
  
  public boolean validateNumber()
  {
    boolean bool = true;
    String str = normalizeCardNumber(number);
    if ((Strings.isNullOrBlank(str)) || (!isWholePositiveNumber(str)) || (!isValidLuhnNumber(str))) {
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (!"American Express".equals(type)) {
            break;
          }
        } while (str.length() == 15);
        return false;
        if (!"Diners Club".equals(type)) {
          break;
        }
      } while (str.length() == 14);
      return false;
    } while (str.length() == 16);
    return false;
  }
  
  public boolean validateZip()
  {
    if (localeFormats.containsKey(locale)) {
      return (!Strings.isNullOrEmpty(addressZip)) && (getZipLength() == ((Integer)localeFormats.get(locale)).intValue());
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.Card
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */