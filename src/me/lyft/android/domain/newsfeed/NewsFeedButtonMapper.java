package me.lyft.android.domain.newsfeed;

import com.lyft.android.api.dto.NewsFeedButtonDTO;
import me.lyft.android.common.Objects;

public class NewsFeedButtonMapper
{
  public static NewsFeedButton fromNewsFeedButtonDto(NewsFeedButtonDTO paramNewsFeedButtonDTO)
  {
    if (paramNewsFeedButtonDTO == null) {
      return NewsFeedButton.empty();
    }
    return new NewsFeedButton((String)Objects.firstNonNull(text, ""), (String)Objects.firstNonNull(url, ""));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.newsfeed.NewsFeedButtonMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */