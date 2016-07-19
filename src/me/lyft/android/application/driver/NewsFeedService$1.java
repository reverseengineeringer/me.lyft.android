package me.lyft.android.application.driver;

import com.lyft.android.api.dto.NewsFeedMessagesDTO;
import me.lyft.android.domain.newsfeed.NewsFeedMessageMapper;
import rx.functions.Func1;

class NewsFeedService$1
  implements Func1<NewsFeedMessagesDTO, NewsFeedService.NewsFeedMessageSplit>
{
  NewsFeedService$1(NewsFeedService paramNewsFeedService) {}
  
  public NewsFeedService.NewsFeedMessageSplit call(NewsFeedMessagesDTO paramNewsFeedMessagesDTO)
  {
    paramNewsFeedMessagesDTO = NewsFeedMessageMapper.fromNewsFeedMessagesDto(paramNewsFeedMessagesDTO);
    return NewsFeedService.access$000(this$0, paramNewsFeedMessagesDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.NewsFeedService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */