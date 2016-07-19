package io.fabric.sdk.android.services.persistence;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract interface PreferenceStore
{
  public abstract SharedPreferences.Editor edit();
  
  public abstract SharedPreferences get();
  
  public abstract boolean save(SharedPreferences.Editor paramEditor);
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.persistence.PreferenceStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */