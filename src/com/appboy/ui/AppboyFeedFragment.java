package com.appboy.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.appboy.Appboy;
import com.appboy.Constants;
import com.appboy.enums.CardCategory;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.events.IEventSubscriber;
import com.appboy.support.AppboyLogger;
import com.appboy.ui.adapters.AppboyListAdapter;
import java.util.ArrayList;
import java.util.EnumSet;

public class AppboyFeedFragment
  extends ListFragment
  implements SwipeRefreshLayout.OnRefreshListener
{
  private static final long AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS = 2500L;
  private static final int MAX_FEED_TTL_SECONDS = 60;
  private static final int NETWORK_PROBLEM_WARNING_MS = 5000;
  private static final String TAG = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyFeedFragment.class.getName() });
  private int currentCardIndexAtBottomOfScreen;
  private AppboyListAdapter mAdapter;
  private Appboy mAppboy;
  private EnumSet<CardCategory> mCategories;
  private LinearLayout mEmptyFeedLayout;
  private RelativeLayout mFeedRootLayout;
  private SwipeRefreshLayout mFeedSwipeLayout;
  private IEventSubscriber<FeedUpdatedEvent> mFeedUpdatedSubscriber;
  private GestureDetectorCompat mGestureDetector;
  private ProgressBar mLoadingSpinner;
  private final Handler mMainThreadLooper = new Handler(Looper.getMainLooper());
  private LinearLayout mNetworkErrorLayout;
  private final Runnable mShowNetworkError = new Runnable()
  {
    public void run()
    {
      if (mLoadingSpinner != null) {
        mLoadingSpinner.setVisibility(8);
      }
      if (mNetworkErrorLayout != null) {
        mNetworkErrorLayout.setVisibility(0);
      }
    }
  };
  private boolean mSkipCardImpressionsReset;
  private View mTransparentFullBoundsContainerView;
  private int previousVisibleHeadCardIndex;
  
  private void setOnScreenCardsToRead()
  {
    mAdapter.batchSetCardsToRead(previousVisibleHeadCardIndex, currentCardIndexAtBottomOfScreen);
  }
  
  public EnumSet<CardCategory> getCategories()
  {
    return mCategories;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (mSkipCardImpressionsReset) {
      mSkipCardImpressionsReset = false;
    }
    for (;;)
    {
      paramBundle = LayoutInflater.from(getActivity());
      final ListView localListView = getListView();
      localListView.addHeaderView(paramBundle.inflate(R.layout.com_appboy_feed_header, null));
      localListView.addFooterView(paramBundle.inflate(R.layout.com_appboy_feed_footer, null));
      mFeedRootLayout.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
        }
      });
      localListView.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          paramAnonymousAbsListView = mFeedSwipeLayout;
          if (paramAnonymousInt1 == 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousAbsListView.setEnabled(bool);
            if (paramAnonymousInt2 != 0) {
              break;
            }
            return;
          }
          paramAnonymousInt3 = paramAnonymousInt1 - 1;
          if (paramAnonymousInt3 > previousVisibleHeadCardIndex) {
            mAdapter.batchSetCardsToRead(previousVisibleHeadCardIndex, paramAnonymousInt3);
          }
          AppboyFeedFragment.access$402(AppboyFeedFragment.this, paramAnonymousInt3);
          AppboyFeedFragment.access$602(AppboyFeedFragment.this, paramAnonymousInt1 + paramAnonymousInt2);
        }
        
        public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      mTransparentFullBoundsContainerView.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return paramAnonymousView.getVisibility() == 0;
        }
      });
      mAppboy.removeSingleSubscription(mFeedUpdatedSubscriber, FeedUpdatedEvent.class);
      mFeedUpdatedSubscriber = new IEventSubscriber()
      {
        public void trigger(final FeedUpdatedEvent paramAnonymousFeedUpdatedEvent)
        {
          FragmentActivity localFragmentActivity = getActivity();
          if (localFragmentActivity == null) {
            return;
          }
          localFragmentActivity.runOnUiThread(new Runnable()
          {
            public void run()
            {
              AppboyLogger.d(AppboyFeedFragment.TAG, "Updating feed views in response to FeedUpdatedEvent: " + paramAnonymousFeedUpdatedEvent);
              mMainThreadLooper.removeCallbacks(mShowNetworkError);
              mNetworkErrorLayout.setVisibility(8);
              if (paramAnonymousFeedUpdatedEvent.getCardCount(mCategories) == 0)
              {
                val$listView.setVisibility(8);
                mAdapter.clear();
              }
              while ((paramAnonymousFeedUpdatedEvent.isFromOfflineStorage()) && ((paramAnonymousFeedUpdatedEvent.lastUpdatedInSecondsFromEpoch() + 60L) * 1000L < System.currentTimeMillis()))
              {
                AppboyLogger.i(AppboyFeedFragment.TAG, String.format("Feed received was older than the max time to live of %d seconds, displaying it for now, but requesting an updated view from the server.", new Object[] { Integer.valueOf(60) }));
                mAppboy.requestFeedRefresh();
                if (paramAnonymousFeedUpdatedEvent.getCardCount(mCategories) != 0) {
                  break;
                }
                AppboyLogger.d(AppboyFeedFragment.TAG, String.format("Old feed was empty, putting up a network spinner and registering the network error message on a delay of %dms.", new Object[] { Integer.valueOf(5000) }));
                mEmptyFeedLayout.setVisibility(8);
                mLoadingSpinner.setVisibility(0);
                mTransparentFullBoundsContainerView.setVisibility(0);
                mMainThreadLooper.postDelayed(mShowNetworkError, 5000L);
                return;
                mEmptyFeedLayout.setVisibility(8);
                mLoadingSpinner.setVisibility(8);
                mTransparentFullBoundsContainerView.setVisibility(8);
              }
              if (paramAnonymousFeedUpdatedEvent.getCardCount(mCategories) == 0)
              {
                mLoadingSpinner.setVisibility(8);
                mEmptyFeedLayout.setVisibility(0);
                mTransparentFullBoundsContainerView.setVisibility(0);
              }
              for (;;)
              {
                mFeedSwipeLayout.setRefreshing(false);
                return;
                mAdapter.replaceFeed(paramAnonymousFeedUpdatedEvent.getFeedCards(mCategories));
                val$listView.setVisibility(0);
              }
            }
          });
        }
      };
      mAppboy.subscribeToFeedUpdates(mFeedUpdatedSubscriber);
      localListView.setAdapter(mAdapter);
      mAppboy.requestFeedRefreshFromCache();
      return;
      mAdapter.resetCardImpressionTracker();
      AppboyLogger.d(TAG, "Resetting card impressions.");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    mAppboy = Appboy.getInstance(paramActivity);
    if (mAdapter == null)
    {
      mAdapter = new AppboyListAdapter(paramActivity, R.id.tag, new ArrayList());
      mCategories = CardCategory.ALL_CATEGORIES;
    }
    setRetainInstance(true);
    mGestureDetector = new GestureDetectorCompat(paramActivity, new FeedGestureListener());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.com_appboy_feed, paramViewGroup, false);
    mNetworkErrorLayout = ((LinearLayout)paramLayoutInflater.findViewById(R.id.com_appboy_feed_network_error));
    mLoadingSpinner = ((ProgressBar)paramLayoutInflater.findViewById(R.id.com_appboy_feed_loading_spinner));
    mEmptyFeedLayout = ((LinearLayout)paramLayoutInflater.findViewById(R.id.com_appboy_feed_empty_feed));
    mFeedRootLayout = ((RelativeLayout)paramLayoutInflater.findViewById(R.id.com_appboy_feed_root));
    mFeedSwipeLayout = ((SwipeRefreshLayout)paramLayoutInflater.findViewById(R.id.appboy_feed_swipe_container));
    mFeedSwipeLayout.setOnRefreshListener(this);
    mFeedSwipeLayout.setEnabled(false);
    mFeedSwipeLayout.setColorSchemeResources(new int[] { R.color.com_appboy_newsfeed_swipe_refresh_color_1, R.color.com_appboy_newsfeed_swipe_refresh_color_2, R.color.com_appboy_newsfeed_swipe_refresh_color_3, R.color.com_appboy_newsfeed_swipe_refresh_color_4 });
    mTransparentFullBoundsContainerView = paramLayoutInflater.findViewById(R.id.com_appboy_feed_transparent_full_bounds_container_view);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    mAppboy.removeSingleSubscription(mFeedUpdatedSubscriber, FeedUpdatedEvent.class);
    setOnScreenCardsToRead();
  }
  
  public void onDetach()
  {
    super.onDetach();
    setListAdapter(null);
  }
  
  public void onPause()
  {
    super.onPause();
    setOnScreenCardsToRead();
  }
  
  public void onRefresh()
  {
    mAppboy.requestFeedRefresh();
    mMainThreadLooper.postDelayed(new Runnable()
    {
      public void run()
      {
        mFeedSwipeLayout.setRefreshing(false);
      }
    }, 2500L);
  }
  
  public void onResume()
  {
    super.onResume();
    Appboy.getInstance(getActivity()).logFeedDisplayed();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (isVisible()) {
      mSkipCardImpressionsReset = true;
    }
  }
  
  public void setCategories(EnumSet<CardCategory> paramEnumSet)
  {
    if (paramEnumSet == null) {
      AppboyLogger.i(TAG, "The categories passed into setCategories are null, AppboyFeedFragment is going to display all the cards in cache.");
    }
    for (mCategories = CardCategory.ALL_CATEGORIES;; mCategories = paramEnumSet)
    {
      if (mAppboy != null) {
        mAppboy.requestFeedRefreshFromCache();
      }
      do
      {
        return;
        if (paramEnumSet.isEmpty())
        {
          AppboyLogger.w(TAG, "The categories set had no elements and have been ignored. Please pass a valid EnumSet of CardCategory.");
          return;
        }
      } while (paramEnumSet.equals(mCategories));
    }
  }
  
  public void setCategory(CardCategory paramCardCategory)
  {
    setCategories(EnumSet.of(paramCardCategory));
  }
  
  public class FeedGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    public FeedGestureListener() {}
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      long l = (paramMotionEvent2.getEventTime() - paramMotionEvent1.getEventTime()) * 2L;
      int i = (int)((float)l * paramFloat2 / 1000.0F);
      getListView().smoothScrollBy(-i, (int)(l * 2L));
      return true;
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      getListView().smoothScrollBy((int)paramFloat2, 0);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.AppboyFeedFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */