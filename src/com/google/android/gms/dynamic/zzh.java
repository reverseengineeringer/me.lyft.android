package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class zzh
  extends zzc.zza
{
  private Fragment Md;
  
  private zzh(Fragment paramFragment)
  {
    Md = paramFragment;
  }
  
  public static zzh zza(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new zzh(paramFragment);
    }
    return null;
  }
  
  public Bundle getArguments()
  {
    return Md.getArguments();
  }
  
  public int getId()
  {
    return Md.getId();
  }
  
  public boolean getRetainInstance()
  {
    return Md.getRetainInstance();
  }
  
  public String getTag()
  {
    return Md.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return Md.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return Md.getUserVisibleHint();
  }
  
  public zzd getView()
  {
    return zze.zzae(Md.getView());
  }
  
  public boolean isAdded()
  {
    return Md.isAdded();
  }
  
  public boolean isDetached()
  {
    return Md.isDetached();
  }
  
  public boolean isHidden()
  {
    return Md.isHidden();
  }
  
  public boolean isInLayout()
  {
    return Md.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return Md.isRemoving();
  }
  
  public boolean isResumed()
  {
    return Md.isResumed();
  }
  
  public boolean isVisible()
  {
    return Md.isVisible();
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    Md.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    Md.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    Md.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    Md.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    Md.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    Md.startActivityForResult(paramIntent, paramInt);
  }
  
  public void zzab(zzd paramzzd)
  {
    paramzzd = (View)zze.zzad(paramzzd);
    Md.registerForContextMenu(paramzzd);
  }
  
  public void zzac(zzd paramzzd)
  {
    paramzzd = (View)zze.zzad(paramzzd);
    Md.unregisterForContextMenu(paramzzd);
  }
  
  public zzd zzbcs()
  {
    return zze.zzae(Md.getActivity());
  }
  
  public zzc zzbct()
  {
    return zza(Md.getParentFragment());
  }
  
  public zzd zzbcu()
  {
    return zze.zzae(Md.getResources());
  }
  
  public zzc zzbcv()
  {
    return zza(Md.getTargetFragment());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.dynamic.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */