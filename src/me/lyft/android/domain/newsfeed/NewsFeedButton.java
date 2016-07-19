package me.lyft.android.domain.newsfeed;

import me.lyft.android.common.INullable;

public class NewsFeedButton
  implements INullable
{
  private final String text;
  private final String url;
  
  public NewsFeedButton(String paramString1, String paramString2)
  {
    text = paramString1;
    url = paramString2;
  }
  
  public static NewsFeedButton empty()
  {
    return NullNewsFeedButton.getInstance();
  }
  
  public String getText()
  {
    return text;
  }
  
  public String getUrl()
  {
    return url;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  static class NullNewsFeedButton
    extends NewsFeedButton
  {
    private static NewsFeedButton INSTANCE = new NullNewsFeedButton();
    
    private NullNewsFeedButton()
    {
      super("");
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
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.newsfeed.NewsFeedButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */