package me.lyft.android.infrastructure.environment;

import java.io.File;
import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface IS3Api
{
  public abstract Observable<ConfigsDTO> getConfigs();
  
  public abstract Observable<Unit> uploadFile(String paramString, File paramFile);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.environment.IS3Api
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */