package me.lyft.android.domain.newsfeed;

class NewsFeedMessage$NullNewsFeedMessage
  extends NewsFeedMessage
{
  private static NewsFeedMessage INSTANCE = new NullNewsFeedMessage();
  
  private NewsFeedMessage$NullNewsFeedMessage()
  {
    super("", "", "", "", "", NewsFeedProgressBar.empty(), NewsFeedButton.empty());
  }
  
  public static NewsFeedMessage getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.newsfeed.NewsFeedMessage.NullNewsFeedMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */