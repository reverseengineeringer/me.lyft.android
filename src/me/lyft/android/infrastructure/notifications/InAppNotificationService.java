package me.lyft.android.infrastructure.notifications;

import com.jakewharton.rxrelay.BehaviorRelay;
import com.lyft.android.api.dto.NotificationDTO;
import com.lyft.android.api.dto.NotificationsDTO;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.User;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.rx.AsyncCall;
import me.lyft.android.ui.Dialogs.InAppNotificationDialog;
import rx.Observable;
import rx.functions.Action1;

public class InAppNotificationService
{
  private static final long NOTIFICATION_UPDATE_TIMEOUT = TimeUnit.HOURS.toMillis(60L);
  private static final int SHOWN_NOTIFICATION_SIZE_LIMIT = 100;
  private final DialogFlow dialogFlow;
  private boolean didShowNotificationForSession = false;
  private long lastTimeUpdated = 0L;
  private final ILyftApi lyftApi;
  private final ILyftPreferences lyftPreferences;
  private final BehaviorRelay<Unit> notificationUpdates = BehaviorRelay.create();
  private Map<String, NotificationDTO> notifications;
  private Set<String> shownNotifications;
  private final IUserProvider userProvider;
  
  public InAppNotificationService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider, ILyftPreferences paramILyftPreferences, DialogFlow paramDialogFlow)
  {
    lyftApi = paramILyftApi;
    userProvider = paramIUserProvider;
    lyftPreferences = paramILyftPreferences;
    dialogFlow = paramDialogFlow;
  }
  
  private NotificationDTO getNotificationByEvent(String paramString)
  {
    NotificationDTO localNotificationDTO = (NotificationDTO)getNotifications().get(paramString);
    paramString = localNotificationDTO;
    if (localNotificationDTO != null)
    {
      paramString = localNotificationDTO;
      if (isNotificationShown(sourceUrl)) {
        paramString = null;
      }
    }
    return paramString;
  }
  
  private Map<String, NotificationDTO> getNotifications()
  {
    if (notifications == null)
    {
      notifications = new HashMap();
      Iterator localIterator = lyftPreferences.getInAppNotifications().iterator();
      while (localIterator.hasNext())
      {
        NotificationDTO localNotificationDTO = (NotificationDTO)localIterator.next();
        notifications.put(event, localNotificationDTO);
      }
    }
    return notifications;
  }
  
  private Set<String> getShownNotifications()
  {
    if (shownNotifications == null) {
      shownNotifications = lyftPreferences.getShownInAppNotifications();
    }
    return shownNotifications;
  }
  
  private boolean isNotificationShown(String paramString)
  {
    return getShownNotifications().contains(paramString);
  }
  
  private void update(NotificationsDTO paramNotificationsDTO)
  {
    paramNotificationsDTO = (List)Objects.firstNonNull(notifications, Collections.emptyList());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramNotificationsDTO.iterator();
    while (localIterator.hasNext())
    {
      NotificationDTO localNotificationDTO = (NotificationDTO)localIterator.next();
      localHashMap.put(event, localNotificationDTO);
    }
    lyftPreferences.setInAppNotifications(paramNotificationsDTO);
    notifications = localHashMap;
  }
  
  public boolean didShowNotificationForSession()
  {
    return didShowNotificationForSession;
  }
  
  public void fetchNotifications()
  {
    if (!userProvider.getUser().isNull())
    {
      long l = System.currentTimeMillis();
      if (l - lastTimeUpdated > NOTIFICATION_UPDATE_TIMEOUT)
      {
        lastTimeUpdated = l;
        lyftApi.getNotifications().subscribe(new AsyncCall()
        {
          public void onSuccess(NotificationsDTO paramAnonymousNotificationsDTO)
          {
            super.onSuccess(paramAnonymousNotificationsDTO);
            InAppNotificationService.this.update(paramAnonymousNotificationsDTO);
            notificationUpdates.call(Unit.create());
          }
        });
      }
    }
  }
  
  public void markNotificationAsShown(String paramString)
  {
    getShownNotifications().add(paramString);
    if (getShownNotifications().size() > 100) {
      getShownNotifications().remove(Iterables.firstOrDefault(getShownNotifications(), null));
    }
    lyftPreferences.setShownInAppNotifications(getShownNotifications());
  }
  
  public void resetDidShowNotificationForSession()
  {
    didShowNotificationForSession = false;
  }
  
  public Observable<Unit> showNotification(final String paramString)
  {
    if (showNotificationIfAvailable(paramString)) {
      return Unit.just();
    }
    fetchNotifications();
    notificationUpdates.doOnNext(new Action1()
    {
      public void call(Unit paramAnonymousUnit)
      {
        showNotificationIfAvailable(paramString);
      }
    });
  }
  
  public boolean showNotificationIfAvailable(String paramString)
  {
    paramString = getNotificationByEvent(paramString);
    if (paramString != null)
    {
      paramString = sourceUrl;
      dialogFlow.show(new Dialogs.InAppNotificationDialog(paramString));
      didShowNotificationForSession = true;
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.notifications.InAppNotificationService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */