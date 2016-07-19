package com.appboy.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public enum CardCategory
{
  public static final EnumSet<CardCategory> ALL_CATEGORIES;
  private static final Map<String, CardCategory> a;
  
  static
  {
    NO_CATEGORY = new CardCategory("NO_CATEGORY", 4);
    b = new CardCategory[] { ADVERTISING, ANNOUNCEMENTS, NEWS, SOCIAL, NO_CATEGORY };
    a = new HashMap();
    ALL_CATEGORIES = EnumSet.allOf(CardCategory.class);
    Iterator localIterator = EnumSet.allOf(CardCategory.class).iterator();
    while (localIterator.hasNext())
    {
      CardCategory localCardCategory = (CardCategory)localIterator.next();
      a.put(localCardCategory.toString(), localCardCategory);
    }
  }
  
  private CardCategory() {}
  
  public static CardCategory get(String paramString)
  {
    return (CardCategory)a.get(paramString.toUpperCase(Locale.US));
  }
}

/* Location:
 * Qualified Name:     com.appboy.enums.CardCategory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */