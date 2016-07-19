package io.fabric.sdk.android.services.events;

import java.io.File;
import java.util.List;

public abstract interface FilesSender
{
  public abstract boolean send(List<File> paramList);
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.events.FilesSender
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */