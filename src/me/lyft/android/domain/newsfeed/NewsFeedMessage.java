package me.lyft.android.domain.newsfeed;

import me.lyft.android.common.INullable;
import me.lyft.android.common.Objects;

public class NewsFeedMessage
  implements INullable
{
  private final NewsFeedButton button;
  private final String description;
  private final String id;
  private final String imageUrl;
  private boolean isRead = false;
  private final NewsFeedProgressBar progress;
  private final String style;
  private final String title;
  
  public NewsFeedMessage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, NewsFeedProgressBar paramNewsFeedProgressBar, NewsFeedButton paramNewsFeedButton)
  {
    id = paramString1;
    style = paramString2;
    title = paramString3;
    description = paramString4;
    imageUrl = paramString5;
    progress = paramNewsFeedProgressBar;
    button = paramNewsFeedButton;
  }
  
  public static NewsFeedMessage empty()
  {
    return NullNewsFeedMessage.getInstance();
  }
  
  public NewsFeedButton getButton()
  {
    return button;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getImageUrl()
  {
    return imageUrl;
  }
  
  public NewsFeedProgressBar getProgress()
  {
    return progress;
  }
  
  public String getStyle()
  {
    return style;
  }
  
  public String getTitle()
  {
    return title;
  }
  
  public boolean isAlert()
  {
    return Objects.equals(style, "alert");
  }
  
  public boolean isEducation()
  {
    return Objects.equals(style, "education");
  }
  
  public boolean isLocal()
  {
    return Objects.equals(style, "local");
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isPromotion()
  {
    return Objects.equals(style, "promotion");
  }
  
  public boolean isRead()
  {
    return isRead;
  }
  
  public void setIsRead(boolean paramBoolean)
  {
    isRead = paramBoolean;
  }
  
  static class NullNewsFeedMessage
    extends NewsFeedMessage
  {
    private static NewsFeedMessage INSTANCE = new NullNewsFeedMessage();
    
    private NullNewsFeedMessage()
    {
      super("", "", "", "", NewsFeedProgressBar.empty(), NewsFeedButton.empty());
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
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.newsfeed.NewsFeedMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */