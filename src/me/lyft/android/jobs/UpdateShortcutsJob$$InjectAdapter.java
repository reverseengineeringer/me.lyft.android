package me.lyft.android.jobs;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.application.shortcuts.IShortcutService;

public final class UpdateShortcutsJob$$InjectAdapter
  extends Binding<UpdateShortcutsJob>
{
  private Binding<IShortcutService> shortcutService;
  
  public UpdateShortcutsJob$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.jobs.UpdateShortcutsJob", false, UpdateShortcutsJob.class);
  }
  
  public void attach(Linker paramLinker)
  {
    shortcutService = paramLinker.requestBinding("me.lyft.android.application.shortcuts.IShortcutService", UpdateShortcutsJob.class, getClass().getClassLoader());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(shortcutService);
  }
  
  public void injectMembers(UpdateShortcutsJob paramUpdateShortcutsJob)
  {
    shortcutService = ((IShortcutService)shortcutService.get());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdateShortcutsJob..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */