package io.card.payment.i18n;

public abstract interface SupportedLocale<E extends Enum<?>>
{
  public abstract String getAdaptedDisplay(E paramE, String paramString);
  
  public abstract String getName();
}

/* Location:
 * Qualified Name:     io.card.payment.i18n.SupportedLocale
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */