package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.internal.zzir;

@zzir
public abstract class NativeAdMapper
{
  protected Bundle mExtras = new Bundle();
  protected boolean mOverrideClickHandling;
  protected boolean mOverrideImpressionRecording;
  
  public final Bundle getExtras()
  {
    return mExtras;
  }
  
  public final boolean getOverrideClickHandling()
  {
    return mOverrideClickHandling;
  }
  
  public final boolean getOverrideImpressionRecording()
  {
    return mOverrideImpressionRecording;
  }
  
  public void handleClick(View paramView) {}
  
  public void recordImpression() {}
  
  public final void setOverrideClickHandling(boolean paramBoolean)
  {
    mOverrideClickHandling = paramBoolean;
  }
  
  public final void setOverrideImpressionRecording(boolean paramBoolean)
  {
    mOverrideImpressionRecording = paramBoolean;
  }
  
  public void trackView(View paramView) {}
  
  public void untrackView(View paramView) {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.mediation.NativeAdMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */