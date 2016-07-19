package me.lyft.android.domain.payment;

public abstract interface ICard
{
  public static final String AMERICAN_EXPRESS = "American Express";
  public static final String COUNTRY_CANADA = "CA";
  public static final String COUNTRY_DEFAULT = "ZZ";
  public static final String COUNTRY_UK = "GB";
  public static final String COUNTRY_USA = "US";
  public static final String DINERS_CLUB = "Diners Club";
  public static final String DISCOVER = "Discover";
  public static final String JCB = "JCB";
  public static final String LOCALE_CANADA = "en_CA";
  public static final String LOCALE_DEFAULT = "zz_ZZ";
  public static final String LOCALE_UK = "en_GB";
  public static final String LOCALE_USA = "en_US";
  public static final String MASTERCARD = "MasterCard";
  public static final int MAX_LENGTH_AMERICAN_EXPRESS = 15;
  public static final int MAX_LENGTH_CANADA_ZIP = 7;
  public static final int MAX_LENGTH_DEFAULT_ZIP = 10;
  public static final int MAX_LENGTH_DINERS_CLUB = 14;
  public static final int MAX_LENGTH_STANDARD = 16;
  public static final int MAX_LENGTH_UK_ZIP = 8;
  public static final int MAX_LENGTH_USA_ZIP = 5;
  public static final int MIN_LENGTH_CANADA_ZIP = 6;
  public static final int MIN_LENGTH_UK_ZIP = 7;
  public static final int MIN_LENGTH_USA_ZIP = 5;
  public static final String[] PREFIXES_AMERICAN_EXPRESS = { "34", "37" };
  public static final String[] PREFIXES_DINERS_CLUB;
  public static final String[] PREFIXES_DISCOVER = { "60", "62", "64", "65" };
  public static final String[] PREFIXES_JCB = { "35" };
  public static final String[] PREFIXES_MASTERCARD = { "50", "51", "52", "53", "54", "55" };
  public static final String[] PREFIXES_VISA;
  public static final String UNKNOWN = "Unknown";
  public static final String VISA = "Visa";
  
  static
  {
    PREFIXES_DINERS_CLUB = new String[] { "300", "301", "302", "303", "304", "305", "309", "36", "38", "37", "39" };
    PREFIXES_VISA = new String[] { "4" };
  }
  
  public abstract String getAddressCountry();
  
  public abstract String getAddressLine1();
  
  public abstract String getAddressLine2();
  
  public abstract String getAddressZip();
  
  public abstract String getCity();
  
  public abstract String getCvc();
  
  public abstract Integer getExpMonth();
  
  public abstract Integer getExpYear();
  
  public abstract String getLast4();
  
  public abstract String getName();
  
  public abstract String getNumber();
  
  public abstract String getState();
  
  public abstract String getType();
  
  public abstract boolean isEmpty();
  
  public abstract void setAddressLine1(String paramString);
  
  public abstract void setAddressLine2(String paramString);
  
  public abstract void setCity(String paramString);
  
  public abstract void setState(String paramString);
  
  public abstract boolean validateCVC();
  
  public abstract boolean validateCard();
  
  public abstract boolean validateExpiryDate();
  
  public abstract boolean validateNumber();
  
  public abstract boolean validateZip();
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.ICard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */