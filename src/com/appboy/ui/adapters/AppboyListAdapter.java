package com.appboy.ui.adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.appboy.Constants;
import com.appboy.models.cards.BannerImageCard;
import com.appboy.models.cards.CaptionedImageCard;
import com.appboy.models.cards.Card;
import com.appboy.models.cards.CrossPromotionSmallCard;
import com.appboy.models.cards.ShortNewsCard;
import com.appboy.models.cards.TextAnnouncementCard;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.configuration.XmlUIConfigurationProvider;
import com.appboy.ui.widget.BannerImageCardView;
import com.appboy.ui.widget.BaseCardView;
import com.appboy.ui.widget.CaptionedImageCardView;
import com.appboy.ui.widget.CrossPromotionSmallCardView;
import com.appboy.ui.widget.DefaultCardView;
import com.appboy.ui.widget.ShortNewsCardView;
import com.appboy.ui.widget.TextAnnouncementCardView;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppboyListAdapter
  extends ArrayAdapter<Card>
{
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyListAdapter.class.getName() });
  private final Set<String> mCardIdImpressions;
  private final Context mContext;
  private final XmlUIConfigurationProvider mUiConfigurationProvider;
  
  public AppboyListAdapter(Context paramContext, int paramInt, List<Card> paramList)
  {
    super(paramContext, paramInt, paramList);
    mContext = paramContext;
    mCardIdImpressions = new HashSet();
    mUiConfigurationProvider = new XmlUIConfigurationProvider(paramContext);
  }
  
  @TargetApi(11)
  private void addAllBatch(Collection<Card> paramCollection)
  {
    try
    {
      super.addAll(paramCollection);
      return;
    }
    finally
    {
      paramCollection = finally;
      throw paramCollection;
    }
  }
  
  private void logCardImpression(Card paramCard)
  {
    String str = paramCard.getId();
    if (!mCardIdImpressions.contains(str))
    {
      mCardIdImpressions.add(str);
      paramCard.logImpression();
      AppboyLogger.d(TAG, String.format("Logged impression for card %s", new Object[] { str }));
    }
    for (;;)
    {
      if (!paramCard.getViewed()) {
        paramCard.setViewed(true);
      }
      return;
      AppboyLogger.d(TAG, String.format("Already counted impression for card %s", new Object[] { str }));
    }
  }
  
  public void add(Card paramCard)
  {
    try
    {
      super.add(paramCard);
      return;
    }
    finally
    {
      paramCard = finally;
      throw paramCard;
    }
  }
  
  public void batchSetCardsToRead(int paramInt1, int paramInt2)
  {
    if (getCount() == 0) {
      AppboyLogger.d(TAG, "mAdapter is empty in setting some cards to viewed.");
    }
    for (;;)
    {
      return;
      paramInt1 = Math.max(0, paramInt1);
      paramInt2 = Math.min(getCount(), paramInt2);
      while (paramInt1 < paramInt2)
      {
        Card localCard = (Card)getItem(paramInt1);
        if (localCard == null)
        {
          AppboyLogger.d(TAG, "Card was null in setting some cards to viewed.");
          return;
        }
        if (!localCard.isRead()) {
          localCard.setIsRead(true);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    Card localCard = (Card)getItem(paramInt);
    if ((localCard instanceof BannerImageCard)) {
      return 1;
    }
    if ((localCard instanceof CaptionedImageCard)) {
      return 2;
    }
    if ((localCard instanceof CrossPromotionSmallCard)) {
      return 3;
    }
    if ((localCard instanceof ShortNewsCard)) {
      return 4;
    }
    if ((localCard instanceof TextAnnouncementCard)) {
      return 5;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (Card)getItem(paramInt);
    if (paramView == null) {
      if ((paramViewGroup instanceof BannerImageCard)) {
        paramView = new BannerImageCardView(mContext);
      }
    }
    for (;;)
    {
      AppboyLogger.d(TAG, String.format("Using view of type: %s for card at position %d: %s", new Object[] { paramView.getClass().getName(), Integer.valueOf(paramInt), paramViewGroup.toString() }));
      paramView.setCard(paramViewGroup);
      logCardImpression(paramViewGroup);
      return paramView;
      if ((paramViewGroup instanceof CaptionedImageCard))
      {
        paramView = new CaptionedImageCardView(mContext);
      }
      else if ((paramViewGroup instanceof CrossPromotionSmallCard))
      {
        paramView = new CrossPromotionSmallCardView(mContext);
      }
      else if ((paramViewGroup instanceof ShortNewsCard))
      {
        paramView = new ShortNewsCardView(mContext);
      }
      else if ((paramViewGroup instanceof TextAnnouncementCard))
      {
        paramView = new TextAnnouncementCardView(mContext);
      }
      else
      {
        paramView = new DefaultCardView(mContext);
        continue;
        AppboyLogger.d(TAG, "Reusing convertView for rendering of item " + paramInt);
        paramView = (BaseCardView)paramView;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 8;
  }
  
  public void replaceFeed(List<Card> paramList)
  {
    for (;;)
    {
      int i;
      int k;
      try
      {
        setNotifyOnChange(false);
        if (paramList == null)
        {
          clear();
          notifyDataSetChanged();
          return;
        }
        AppboyLogger.d(TAG, String.format("Replacing existing feed of %d cards with new feed containing %d cards.", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramList.size()) }));
        int j = 0;
        i = 0;
        k = paramList.size();
        if (j < getCount())
        {
          Card localCard2 = (Card)getItem(j);
          Card localCard1 = null;
          if (i < k) {
            localCard1 = (Card)paramList.get(i);
          }
          if ((localCard1 != null) && (localCard1.isEqualToCard(localCard2)))
          {
            j += 1;
            i += 1;
            continue;
          }
          remove(localCard2);
          continue;
        }
        if (Build.VERSION.SDK_INT >= 11) {}
      }
      finally {}
      while (i < k)
      {
        add((Card)paramList.get(i));
        i += 1;
        continue;
        addAllBatch(paramList.subList(i, k));
      }
      notifyDataSetChanged();
    }
  }
  
  public void resetCardImpressionTracker()
  {
    mCardIdImpressions.clear();
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.adapters.AppboyListAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */