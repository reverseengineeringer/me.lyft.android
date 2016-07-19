package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R.string;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzaee;
import com.google.android.gms.internal.zzaem;

class SupportWalletFragment$zzc
  extends zza<SupportWalletFragment.zzb>
  implements View.OnClickListener
{
  private SupportWalletFragment$zzc(SupportWalletFragment paramSupportWalletFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = SupportWalletFragment.zza(aIi).getActivity();
    GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramView), paramView, -1);
  }
  
  protected void zza(FrameLayout paramFrameLayout)
  {
    int k = -1;
    int m = -2;
    Button localButton = new Button(SupportWalletFragment.zza(aIi).getActivity());
    localButton.setText(R.string.wallet_buy_button_place_holder);
    int j = m;
    int i = k;
    if (SupportWalletFragment.zze(aIi) != null)
    {
      WalletFragmentStyle localWalletFragmentStyle = SupportWalletFragment.zze(aIi).getFragmentStyle();
      j = m;
      i = k;
      if (localWalletFragmentStyle != null)
      {
        DisplayMetrics localDisplayMetrics = SupportWalletFragment.zza(aIi).getResources().getDisplayMetrics();
        i = localWalletFragmentStyle.zza("buyButtonWidth", localDisplayMetrics, -1);
        j = localWalletFragmentStyle.zza("buyButtonHeight", localDisplayMetrics, -2);
      }
    }
    localButton.setLayoutParams(new ViewGroup.LayoutParams(i, j));
    localButton.setOnClickListener(this);
    paramFrameLayout.addView(localButton);
  }
  
  protected void zza(zzf<SupportWalletFragment.zzb> paramzzf)
  {
    Object localObject = SupportWalletFragment.zza(aIi).getActivity();
    if ((SupportWalletFragment.zzb(aIi) == null) && (SupportWalletFragment.zzc(aIi)) && (localObject != null)) {}
    try
    {
      localObject = zzaem.zza((Activity)localObject, SupportWalletFragment.zzd(aIi), SupportWalletFragment.zze(aIi), SupportWalletFragment.zzf(aIi));
      SupportWalletFragment.zza(aIi, new SupportWalletFragment.zzb((zzaee)localObject, null));
      SupportWalletFragment.zza(aIi, null);
      paramzzf.zza(SupportWalletFragment.zzb(aIi));
      if (SupportWalletFragment.zzg(aIi) != null)
      {
        SupportWalletFragment.zzb.zza(SupportWalletFragment.zzb(aIi), SupportWalletFragment.zzg(aIi));
        SupportWalletFragment.zza(aIi, null);
      }
      if (SupportWalletFragment.zzh(aIi) != null)
      {
        SupportWalletFragment.zzb.zza(SupportWalletFragment.zzb(aIi), SupportWalletFragment.zzh(aIi));
        SupportWalletFragment.zza(aIi, null);
      }
      if (SupportWalletFragment.zzi(aIi) != null)
      {
        SupportWalletFragment.zzb.zza(SupportWalletFragment.zzb(aIi), SupportWalletFragment.zzi(aIi));
        SupportWalletFragment.zza(aIi, null);
      }
      if (SupportWalletFragment.zzj(aIi) != null)
      {
        SupportWalletFragment.zzb.zza(SupportWalletFragment.zzb(aIi), SupportWalletFragment.zzj(aIi).booleanValue());
        SupportWalletFragment.zza(aIi, null);
      }
      return;
    }
    catch (GooglePlayServicesNotAvailableException paramzzf) {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.fragment.SupportWalletFragment.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */