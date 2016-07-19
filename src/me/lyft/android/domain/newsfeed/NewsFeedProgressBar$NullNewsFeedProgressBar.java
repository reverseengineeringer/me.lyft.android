package me.lyft.android.domain.newsfeed;

class NewsFeedProgressBar$NullNewsFeedProgressBar
  extends NewsFeedProgressBar
{
  private static NewsFeedProgressBar INSTANCE = new NullNewsFeedProgressBar();
  
  private NewsFeedProgressBar$NullNewsFeedProgressBar()
  {
    super(0, "");
  }
  
  public static NewsFeedProgressBar getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.newsfeed.NewsFeedProgressBar.NullNewsFeedProgressBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */