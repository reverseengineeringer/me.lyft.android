package me.lyft.android.application.driver;

import com.lyft.android.api.dto.NewsFeedMessagesDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.lyft.android.domain.newsfeed.NewsFeedMessage;
import me.lyft.android.domain.newsfeed.NewsFeedMessageMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.persistence.ISimpleRepository;
import rx.Observable;
import rx.functions.Func1;

public class NewsFeedService
  implements INewsFeedService
{
  private final ILyftApi lyftApi;
  private final ISimpleRepository<Map<String, NewsFeedMessage>> newsFeedMessagesRepository;
  
  public NewsFeedService(ILyftApi paramILyftApi, ISimpleRepository<Map<String, NewsFeedMessage>> paramISimpleRepository)
  {
    lyftApi = paramILyftApi;
    newsFeedMessagesRepository = paramISimpleRepository;
  }
  
  private NewsFeedMessageSplit splitMessages(List<NewsFeedMessage> paramList)
  {
    Map localMap = (Map)newsFeedMessagesRepository.get();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      NewsFeedMessage localNewsFeedMessage = (NewsFeedMessage)localIterator.next();
      String str = localNewsFeedMessage.getId();
      if (localMap.containsKey(str)) {
        localNewsFeedMessage.setIsRead(((NewsFeedMessage)localMap.get(str)).isRead());
      }
      if (localNewsFeedMessage.isRead()) {
        localArrayList1.add(localNewsFeedMessage);
      }
      for (;;)
      {
        localHashMap.put(str, localNewsFeedMessage);
        break;
        localArrayList2.add(localNewsFeedMessage);
      }
    }
    newsFeedMessagesRepository.update(localHashMap);
    if (!paramList.isEmpty()) {}
    for (boolean bool = true;; bool = false) {
      return new NewsFeedMessageSplit(bool, localArrayList1, localArrayList2);
    }
  }
  
  public Observable<NewsFeedMessageSplit> getNewsFeedMessages()
  {
    lyftApi.getNewsFeedMessages().map(new Func1()
    {
      public NewsFeedService.NewsFeedMessageSplit call(NewsFeedMessagesDTO paramAnonymousNewsFeedMessagesDTO)
      {
        paramAnonymousNewsFeedMessagesDTO = NewsFeedMessageMapper.fromNewsFeedMessagesDto(paramAnonymousNewsFeedMessagesDTO);
        return NewsFeedService.this.splitMessages(paramAnonymousNewsFeedMessagesDTO);
      }
    });
  }
  
  public void updateReadMessage(NewsFeedMessage paramNewsFeedMessage)
  {
    Map localMap = (Map)newsFeedMessagesRepository.get();
    paramNewsFeedMessage = paramNewsFeedMessage.getId();
    if (localMap.containsKey(paramNewsFeedMessage))
    {
      ((NewsFeedMessage)localMap.get(paramNewsFeedMessage)).setIsRead(true);
      newsFeedMessagesRepository.update(localMap);
    }
  }
  
  public static class NewsFeedMessageSplit
  {
    private boolean hasMessages;
    private final List<NewsFeedMessage> readMessages;
    private final List<NewsFeedMessage> unreadMessages;
    
    public NewsFeedMessageSplit(boolean paramBoolean, List<NewsFeedMessage> paramList1, List<NewsFeedMessage> paramList2)
    {
      hasMessages = paramBoolean;
      readMessages = paramList1;
      unreadMessages = paramList2;
    }
    
    public List<NewsFeedMessage> getReadMessages()
    {
      return readMessages;
    }
    
    public List<NewsFeedMessage> getUnreadMessages()
    {
      return unreadMessages;
    }
    
    public boolean hasMessages()
    {
      return hasMessages;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driver.NewsFeedService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */