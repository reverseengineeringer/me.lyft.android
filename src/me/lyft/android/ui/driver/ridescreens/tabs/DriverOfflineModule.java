package me.lyft.android.ui.driver.ridescreens.tabs;

import dagger.Module;
import dagger.Provides;
import java.lang.reflect.Type;
import java.util.Collections;
import javax.inject.Singleton;
import me.lyft.android.application.driver.INewsFeedService;
import me.lyft.android.application.driver.NewsFeedService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.persistence.ISimpleRepositoryFactory;
import me.lyft.android.ui.driver.ridescreens.DriverRideModule;
import me.lyft.android.ui.driver.ridescreens.tabs.newsfeed.NewsFeedItemView;
import me.lyft.android.ui.driver.ridescreens.tabs.newsfeed.NewsFeedView;

@Module(addsTo=DriverRideModule.class, injects={DriverOfflineController.class, NewsFeedItemView.class, NewsFeedView.class})
public class DriverOfflineModule
{
  @Provides
  @Singleton
  INewsFeedService provideNewsFeedService(ILyftApi paramILyftApi, ISimpleRepositoryFactory paramISimpleRepositoryFactory)
  {
    Type localType = new DriverOfflineModule.1(this).getType();
    return new NewsFeedService(paramILyftApi, paramISimpleRepositoryFactory.createRepository("newsFeedCache", Collections.emptyMap(), localType));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.tabs.DriverOfflineModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */