package com.google.android.gms.location.places.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.gms.R.id;
import com.google.android.gms.R.layout;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLngBounds;

public class SupportPlaceAutocompleteFragment
  extends Fragment
{
  private View agm;
  private View agn;
  private EditText ago;
  private LatLngBounds agp;
  private AutocompleteFilter agq;
  private PlaceSelectionListener agr;
  
  private void zzbpe()
  {
    int j = 0;
    View localView;
    if (!ago.getText().toString().isEmpty())
    {
      i = 1;
      localView = agn;
      if (i == 0) {
        break label42;
      }
    }
    label42:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  private void zzbpf()
  {
    try
    {
      startActivityForResult(new PlaceAutocomplete.IntentBuilder(2).setBoundsBias(agp).setFilter(agq).zzkv(ago.getText().toString()).zzuk(1).build(getActivity()), 30421);
      i = -1;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      for (;;)
      {
        i = localGooglePlayServicesRepairableException.getConnectionStatusCode();
        Log.e("Places", "Could not open autocomplete activity", localGooglePlayServicesRepairableException);
      }
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      for (;;)
      {
        int i = errorCode;
        Log.e("Places", "Could not open autocomplete activity", localGooglePlayServicesNotAvailableException);
      }
    }
    if (i != -1) {
      GoogleApiAvailability.getInstance().showErrorDialogFragment(getActivity(), i, 30422);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 30421)
    {
      if (paramInt2 != -1) {
        break label64;
      }
      localObject = PlaceAutocomplete.getPlace(getActivity(), paramIntent);
      if (agr != null) {
        agr.onPlaceSelected((Place)localObject);
      }
      setText(((Place)localObject).getName().toString());
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label64:
      if (paramInt2 == 2)
      {
        localObject = PlaceAutocomplete.getStatus(getActivity(), paramIntent);
        if (agr != null) {
          agr.onError((Status)localObject);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.place_autocomplete_fragment, paramViewGroup, false);
    agm = paramLayoutInflater.findViewById(R.id.place_autocomplete_search_button);
    agn = paramLayoutInflater.findViewById(R.id.place_autocomplete_clear_button);
    ago = ((EditText)paramLayoutInflater.findViewById(R.id.place_autocomplete_search_input));
    paramViewGroup = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SupportPlaceAutocompleteFragment.zza(SupportPlaceAutocompleteFragment.this);
      }
    };
    agm.setOnClickListener(paramViewGroup);
    ago.setOnClickListener(paramViewGroup);
    agn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        setText("");
      }
    });
    zzbpe();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    agm = null;
    agn = null;
    ago = null;
    super.onDestroyView();
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    ago.setText(paramCharSequence);
    zzbpe();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */