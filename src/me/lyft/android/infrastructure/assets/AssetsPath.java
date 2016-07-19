package me.lyft.android.infrastructure.assets;

import android.content.Context;
import me.lyft.android.utils.FileUtils;

public class AssetsPath
{
  public static String get(Context paramContext)
  {
    return FileUtils.getTempDirectoryPath(paramContext) + "/assets";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.assets.AssetsPath
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */