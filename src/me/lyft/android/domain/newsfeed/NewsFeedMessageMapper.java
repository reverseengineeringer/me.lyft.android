package me.lyft.android.domain.newsfeed;

import com.lyft.android.api.dto.NewsFeedMessageDTO;
import com.lyft.android.api.dto.NewsFeedMessagesDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Objects;

public class NewsFeedMessageMapper
{
  public static List<NewsFeedMessage> fromNewsFeedMessagesDto(NewsFeedMessagesDTO paramNewsFeedMessagesDTO)
  {
    if ((paramNewsFeedMessagesDTO == null) || (messages == null))
    {
      paramNewsFeedMessagesDTO = Collections.emptyList();
      return paramNewsFeedMessagesDTO;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = messages.iterator();
    for (;;)
    {
      paramNewsFeedMessagesDTO = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramNewsFeedMessagesDTO = (NewsFeedMessageDTO)localIterator.next();
      localArrayList.add(new NewsFeedMessage(id, style, title, description, (String)Objects.firstNonNull(image_url, ""), NewsFeedProgressBarMapper.fromNewsFeedProgressBarDto(progress), NewsFeedButtonMapper.fromNewsFeedButtonDto(button)));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.newsfeed.NewsFeedMessageMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */