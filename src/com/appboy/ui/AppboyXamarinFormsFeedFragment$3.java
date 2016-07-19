package com.appboy.ui;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.appboy.ui.adapters.AppboyListAdapter;

class AppboyXamarinFormsFeedFragment$3
  implements AbsListView.OnScrollListener
{
  AppboyXamarinFormsFeedFragment$3(AppboyXamarinFormsFeedFragment paramAppboyXamarinFormsFeedFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = AppboyXamarinFormsFeedFragment.access$300(this$0);
    if (paramInt1 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramAbsListView.setEnabled(bool);
      if (paramInt2 != 0) {
        break;
      }
      return;
    }
    paramInt3 = paramInt1 - 1;
    if (paramInt3 > AppboyXamarinFormsFeedFragment.access$400(this$0)) {
      AppboyXamarinFormsFeedFragment.access$500(this$0).batchSetCardsToRead(AppboyXamarinFormsFeedFragment.access$400(this$0), paramInt3);
    }
    AppboyXamarinFormsFeedFragment.access$402(this$0, paramInt3);
    AppboyXamarinFormsFeedFragment.access$602(this$0, paramInt1 + paramInt2);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}

/* Location:
 * Qualified Name:     com.appboy.ui.AppboyXamarinFormsFeedFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */