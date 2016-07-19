package me.lyft.android.application.driver;

import java.util.List;
import me.lyft.android.domain.newsfeed.NewsFeedMessage;

public class NewsFeedService$NewsFeedMessageSplit
{
  private boolean hasMessages;
  private final List<NewsFeedMessage> readMessages;
  private final List<NewsFeedMessage> unreadMessages;
  
  public NewsFeedService$NewsFeedMessageSplit(boolean paramBoolean, List<NewsFeedMessage> paramList1, List<NewsFeedMessage> paramList2)
  {
    hasMessages = paramBoolean;
    readMessages = paramList1;
    unreadMessages = paramList2;
  }
  
  public List<NewsFeedMessage> getReadMessages()
  {
    return readMessages;
  }
  
  public List<NewsFeedMessage> getUnreadMessages()
  {
    return unreadMessages;
  }
  
  public boolean hasMessages()
  {
    return hasMessages;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.NewsFeedService.NewsFeedMessageSplit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */