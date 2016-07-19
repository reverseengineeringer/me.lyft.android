package me.lyft.android.application.driver;

import me.lyft.android.domain.newsfeed.NewsFeedMessage;
import rx.Observable;

public abstract interface INewsFeedService
{
  public abstract Observable<NewsFeedService.NewsFeedMessageSplit> getNewsFeedMessages();
  
  public abstract void updateReadMessage(NewsFeedMessage paramNewsFeedMessage);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.INewsFeedService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */