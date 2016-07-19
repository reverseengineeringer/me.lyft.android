package com.appboy.ui;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.appboy.Appboy;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.adapters.AppboyListAdapter;

class AppboyFeedFragment$5$1
  implements Runnable
{
  AppboyFeedFragment$5$1(AppboyFeedFragment.5 param5, FeedUpdatedEvent paramFeedUpdatedEvent) {}
  
  public void run()
  {
    AppboyLogger.d(AppboyFeedFragment.access$700(), "Updating feed views in response to FeedUpdatedEvent: " + val$event);
    AppboyFeedFragment.access$900(this$1.this$0).removeCallbacks(AppboyFeedFragment.access$800(this$1.this$0));
    AppboyFeedFragment.access$100(this$1.this$0).setVisibility(8);
    if (val$event.getCardCount(AppboyFeedFragment.access$1000(this$1.this$0)) == 0)
    {
      this$1.val$listView.setVisibility(8);
      AppboyFeedFragment.access$500(this$1.this$0).clear();
    }
    while ((val$event.isFromOfflineStorage()) && ((val$event.lastUpdatedInSecondsFromEpoch() + 60L) * 1000L < System.currentTimeMillis()))
    {
      AppboyLogger.i(AppboyFeedFragment.access$700(), String.format("Feed received was older than the max time to live of %d seconds, displaying it for now, but requesting an updated view from the server.", new Object[] { Integer.valueOf(60) }));
      AppboyFeedFragment.access$1300(this$1.this$0).requestFeedRefresh();
      if (val$event.getCardCount(AppboyFeedFragment.access$1000(this$1.this$0)) != 0) {
        break;
      }
      AppboyLogger.d(AppboyFeedFragment.access$700(), String.format("Old feed was empty, putting up a network spinner and registering the network error message on a delay of %dms.", new Object[] { Integer.valueOf(5000) }));
      AppboyFeedFragment.access$1100(this$1.this$0).setVisibility(8);
      AppboyFeedFragment.access$000(this$1.this$0).setVisibility(0);
      AppboyFeedFragment.access$1200(this$1.this$0).setVisibility(0);
      AppboyFeedFragment.access$900(this$1.this$0).postDelayed(AppboyFeedFragment.access$800(this$1.this$0), 5000L);
      return;
      AppboyFeedFragment.access$1100(this$1.this$0).setVisibility(8);
      AppboyFeedFragment.access$000(this$1.this$0).setVisibility(8);
      AppboyFeedFragment.access$1200(this$1.this$0).setVisibility(8);
    }
    if (val$event.getCardCount(AppboyFeedFragment.access$1000(this$1.this$0)) == 0)
    {
      AppboyFeedFragment.access$000(this$1.this$0).setVisibility(8);
      AppboyFeedFragment.access$1100(this$1.this$0).setVisibility(0);
      AppboyFeedFragment.access$1200(this$1.this$0).setVisibility(0);
    }
    for (;;)
    {
      AppboyFeedFragment.access$300(this$1.this$0).setRefreshing(false);
      return;
      AppboyFeedFragment.access$500(this$1.this$0).replaceFeed(val$event.getFeedCards(AppboyFeedFragment.access$1000(this$1.this$0)));
      this$1.val$listView.setVisibility(0);
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.AppboyFeedFragment.5.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */