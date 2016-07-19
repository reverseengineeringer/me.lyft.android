package me.lyft.android.domain.newsfeed;

import me.lyft.android.common.INullable;

public class NewsFeedProgressBar
  implements INullable
{
  private final String label;
  private final int percent;
  
  public NewsFeedProgressBar(int paramInt, String paramString)
  {
    percent = paramInt;
    label = paramString;
  }
  
  public static NewsFeedProgressBar empty()
  {
    return NullNewsFeedProgressBar.getInstance();
  }
  
  public String getLabel()
  {
    return label;
  }
  
  public int getPercent()
  {
    return percent;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  static class NullNewsFeedProgressBar
    extends NewsFeedProgressBar
  {
    private static NewsFeedProgressBar INSTANCE = new NullNewsFeedProgressBar();
    
    private NullNewsFeedProgressBar()
    {
      super("");
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
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.newsfeed.NewsFeedProgressBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */