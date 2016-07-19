package me.lyft.android.domain.driver;

import java.util.Collections;

class Card$NullCard
  extends Card
{
  private static final Card INSTANCE = new NullCard();
  
  private Card$NullCard()
  {
    super(Card.Style.LIGHT, "", "", "", Collections.emptyList(), "");
  }
  
  static Card getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.Card.NullCard
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */