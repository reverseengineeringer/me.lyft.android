package me.lyft.android.jobs;

import com.lyft.android.api.dto.UniversalDTO;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.shortcuts.IShortcutService;
import me.lyft.android.domain.shortcuts.ShortcutMapper;

public class UpdateShortcutsJob
  implements Job
{
  private UniversalDTO currentAppState;
  @Inject
  IShortcutService shortcutService;
  
  public UpdateShortcutsJob(UniversalDTO paramUniversalDTO)
  {
    currentAppState = paramUniversalDTO;
  }
  
  public void execute()
    throws Throwable
  {
    List localList = ShortcutMapper.fromUniversal(currentAppState);
    shortcutService.updateShortcuts(localList);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdateShortcutsJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */