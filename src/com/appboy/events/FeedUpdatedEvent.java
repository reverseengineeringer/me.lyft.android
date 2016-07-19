package com.appboy.events;

import com.appboy.Constants;
import com.appboy.enums.CardCategory;
import com.appboy.models.cards.Card;
import com.appboy.support.AppboyLogger;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public final class FeedUpdatedEvent
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, FeedUpdatedEvent.class.getName() });
  private final List<Card> b;
  private final String c;
  private final boolean d;
  private final long e;
  
  public FeedUpdatedEvent(List<Card> paramList, String paramString, boolean paramBoolean, long paramLong)
  {
    c = paramString;
    d = paramBoolean;
    if (paramList == null) {
      throw new NullPointerException();
    }
    b = paramList;
    e = paramLong;
  }
  
  public final int getCardCount()
  {
    return getCardCount(CardCategory.ALL_CATEGORIES);
  }
  
  public final int getCardCount(CardCategory paramCardCategory)
  {
    return getCardCount(EnumSet.of(paramCardCategory));
  }
  
  public final int getCardCount(EnumSet<CardCategory> paramEnumSet)
  {
    if (paramEnumSet == null)
    {
      AppboyLogger.i(a, "The categories passed into getCardCount are null, FeedUpdatedEvent is going to return the count of all the cards in cache.");
      return b.size();
    }
    if (paramEnumSet.isEmpty())
    {
      AppboyLogger.w(a, "The parameters passed into categories are not valid, Appboy is returning 0 in getCardCount().Please pass in a non-empty EnumSet of CardCategory.");
      return 0;
    }
    return getFeedCards(paramEnumSet).size();
  }
  
  public final List<Card> getFeedCards()
  {
    return getFeedCards(CardCategory.ALL_CATEGORIES);
  }
  
  public final List<Card> getFeedCards(CardCategory paramCardCategory)
  {
    return getFeedCards(EnumSet.of(paramCardCategory));
  }
  
  public final List<Card> getFeedCards(EnumSet<CardCategory> paramEnumSet)
  {
    Object localObject2 = paramEnumSet;
    Object localObject1;
    try
    {
      if (b == null)
      {
        localObject2 = paramEnumSet;
        AppboyLogger.i(a, "There are no cards targeted to this user in the Appboy News Feed, you can call Appboy.requestFeedRefresh(),and try to call getFeedCards(categories) again when you receive a new feed updated event, or check your Appboy dashboard and make sure there are cards in the segment.");
        localObject2 = paramEnumSet;
        return new ArrayList();
      }
      localObject1 = paramEnumSet;
      if (paramEnumSet == null)
      {
        localObject2 = paramEnumSet;
        AppboyLogger.i(a, "The categories passed to getFeedCards are null, FeedUpdatedEvent is going to return all the cards in cache.");
        localObject2 = paramEnumSet;
        localObject1 = CardCategory.ALL_CATEGORIES;
      }
      localObject2 = localObject1;
      if (((EnumSet)localObject1).isEmpty())
      {
        localObject2 = localObject1;
        AppboyLogger.w(a, "The parameter passed into categories is not valid, Appboy is returning an empty card list.Please pass in a non-empty EnumSet of CardCategory for getFeedCards().");
        localObject2 = localObject1;
        paramEnumSet = new ArrayList();
        return paramEnumSet;
      }
    }
    catch (Exception paramEnumSet)
    {
      AppboyLogger.w(a, String.format("Unable to get cards with categories[%s]. Ignoring.", new Object[] { localObject2 }), paramEnumSet);
      return null;
    }
    localObject2 = localObject1;
    paramEnumSet = new ArrayList();
    localObject2 = localObject1;
    Iterator localIterator = b.iterator();
    for (;;)
    {
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject2 = localObject1;
      Card localCard = (Card)localIterator.next();
      localObject2 = localObject1;
      if (localCard.isInCategorySet((EnumSet)localObject1))
      {
        localObject2 = localObject1;
        if (!localCard.isExpired())
        {
          localObject2 = localObject1;
          paramEnumSet.add(localCard);
        }
      }
    }
    return paramEnumSet;
  }
  
  public final int getUnreadCardCount()
  {
    return getUnreadCardCount(CardCategory.ALL_CATEGORIES);
  }
  
  public final int getUnreadCardCount(CardCategory paramCardCategory)
  {
    return getUnreadCardCount(EnumSet.of(paramCardCategory));
  }
  
  public final int getUnreadCardCount(EnumSet<CardCategory> paramEnumSet)
  {
    while (paramEnumSet == null)
    {
      AppboyLogger.w(a, "The categories passed to getUnreadCardCount are null, FeedUpdatedEvent is going to return the count of all the unread cards in cache.");
      paramEnumSet = CardCategory.ALL_CATEGORIES;
    }
    if (paramEnumSet.isEmpty())
    {
      AppboyLogger.w(a, "The parameters passed into categories are Empty, Appboy is returning 0 in getUnreadCardCount().Please pass in a non-empty EnumSet of CardCategory.");
      return 0;
    }
    Iterator localIterator = b.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Card localCard = (Card)localIterator.next();
      if ((!localCard.isInCategorySet(paramEnumSet)) || (localCard.getViewed()) || (localCard.isExpired())) {
        break label104;
      }
      i += 1;
    }
    label104:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public final String getUserId()
  {
    return c;
  }
  
  public final boolean isFromOfflineStorage()
  {
    return d;
  }
  
  public final long lastUpdatedInSecondsFromEpoch()
  {
    return e;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FeedUpdatedEvent{");
    localStringBuilder.append("mFeedCards=").append(b);
    localStringBuilder.append(", mUserId='").append(c).append('\'');
    localStringBuilder.append(", mFromOfflineStorage=").append(d);
    localStringBuilder.append(", mTimestamp=").append(e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.appboy.events.FeedUpdatedEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */