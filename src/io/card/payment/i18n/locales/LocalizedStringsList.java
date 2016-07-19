package io.card.payment.i18n.locales;

import io.card.payment.i18n.StringKey;
import io.card.payment.i18n.SupportedLocale;
import java.util.ArrayList;
import java.util.List;

public class LocalizedStringsList
{
  public static final List<SupportedLocale<StringKey>> ALL_LOCALES = new ArrayList();
  
  static
  {
    ALL_LOCALES.add(new LocalizedStringsAR());
    ALL_LOCALES.add(new LocalizedStringsDA());
    ALL_LOCALES.add(new LocalizedStringsDE());
    ALL_LOCALES.add(new LocalizedStringsEN());
    ALL_LOCALES.add(new LocalizedStringsEN_AU());
    ALL_LOCALES.add(new LocalizedStringsEN_GB());
    ALL_LOCALES.add(new LocalizedStringsES());
    ALL_LOCALES.add(new LocalizedStringsES_MX());
    ALL_LOCALES.add(new LocalizedStringsFR());
    ALL_LOCALES.add(new LocalizedStringsHE());
    ALL_LOCALES.add(new LocalizedStringsIS());
    ALL_LOCALES.add(new LocalizedStringsIT());
    ALL_LOCALES.add(new LocalizedStringsJA());
    ALL_LOCALES.add(new LocalizedStringsKO());
    ALL_LOCALES.add(new LocalizedStringsMS());
    ALL_LOCALES.add(new LocalizedStringsNB());
    ALL_LOCALES.add(new LocalizedStringsNL());
    ALL_LOCALES.add(new LocalizedStringsPL());
    ALL_LOCALES.add(new LocalizedStringsPT());
    ALL_LOCALES.add(new LocalizedStringsPT_BR());
    ALL_LOCALES.add(new LocalizedStringsRU());
    ALL_LOCALES.add(new LocalizedStringsSV());
    ALL_LOCALES.add(new LocalizedStringsTH());
    ALL_LOCALES.add(new LocalizedStringsTR());
    ALL_LOCALES.add(new LocalizedStringsZH_HANS());
    ALL_LOCALES.add(new LocalizedStringsZH_HANT());
    ALL_LOCALES.add(new LocalizedStringsZH_HANT_TW());
  }
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.locales.LocalizedStringsList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */