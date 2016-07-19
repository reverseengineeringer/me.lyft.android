package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

class AnswersPreferenceManager
{
  private final PreferenceStore prefStore;
  
  AnswersPreferenceManager(PreferenceStore paramPreferenceStore)
  {
    prefStore = paramPreferenceStore;
  }
  
  public static AnswersPreferenceManager build(Context paramContext)
  {
    return new AnswersPreferenceManager(new PreferenceStoreImpl(paramContext, "settings"));
  }
  
  @SuppressLint({"CommitPrefEdits"})
  public boolean hasAnalyticsLaunched()
  {
    return prefStore.get().getBoolean("analytics_launched", false);
  }
  
  @SuppressLint({"CommitPrefEdits"})
  public void setAnalyticsLaunched()
  {
    prefStore.save(prefStore.edit().putBoolean("analytics_launched", true));
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersPreferenceManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */