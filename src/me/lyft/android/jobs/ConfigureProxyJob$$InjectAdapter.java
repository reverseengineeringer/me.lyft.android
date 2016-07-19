package me.lyft.android.jobs;

import com.squareup.okhttp.OkHttpClient;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.ILyftPreferences;

public final class ConfigureProxyJob$$InjectAdapter
  extends Binding<ConfigureProxyJob>
{
  private Binding<ILyftPreferences> lyftPreferences;
  private Binding<OkHttpClient> okHttpClient;
  
  public ConfigureProxyJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.ConfigureProxyJob", false, ConfigureProxyJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ConfigureProxyJob.class, getClass().getClassLoader());
    okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", ConfigureProxyJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(lyftPreferences);
    paramSet2.add(okHttpClient);
  }
  
  public void injectMembers(ConfigureProxyJob paramConfigureProxyJob)
  {
    lyftPreferences = ((ILyftPreferences)lyftPreferences.get());
    okHttpClient = ((OkHttpClient)okHttpClient.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.ConfigureProxyJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */