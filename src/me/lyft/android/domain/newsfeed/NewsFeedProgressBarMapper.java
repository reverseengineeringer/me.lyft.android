package me.lyft.android.domain.newsfeed;

import com.lyft.android.api.dto.NewsFeedProgressBarDTO;
import me.lyft.android.common.Objects;

public class NewsFeedProgressBarMapper
{
  public static NewsFeedProgressBar fromNewsFeedProgressBarDto(NewsFeedProgressBarDTO paramNewsFeedProgressBarDTO)
  {
    if (paramNewsFeedProgressBarDTO == null) {
      return NewsFeedProgressBar.empty();
    }
    return new NewsFeedProgressBar(((Integer)Objects.firstNonNull(percent, Integer.valueOf(0))).intValue(), (String)Objects.firstNonNull(label, ""));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.newsfeed.NewsFeedProgressBarMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */