package me.lyft.android.jobs;

import javax.inject.Inject;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.Strings;

public class LyftTokenUpdateJob
  implements Job
{
  private final String lyftToken;
  @Inject
  ILyftPreferences preferences;
  
  public LyftTokenUpdateJob(String paramString)
  {
    lyftToken = paramString;
  }
  
  public void execute()
    throws Throwable
  {
    if (!Strings.isNullOrEmpty(lyftToken)) {
      preferences.setLyftToken(lyftToken);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.LyftTokenUpdateJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */