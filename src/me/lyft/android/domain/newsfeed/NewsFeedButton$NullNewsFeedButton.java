package me.lyft.android.domain.newsfeed;

class NewsFeedButton$NullNewsFeedButton
  extends NewsFeedButton
{
  private static NewsFeedButton INSTANCE = new NullNewsFeedButton();
  
  private NewsFeedButton$NullNewsFeedButton()
  {
    super("", "");
  }
  
  public static NewsFeedButton getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.newsfeed.NewsFeedButton.NullNewsFeedButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */