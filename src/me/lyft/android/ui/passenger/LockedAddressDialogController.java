package me.lyft.android.ui.passenger;

import android.content.res.Resources;
import com.lyft.scoop.Screen;
import javax.inject.Inject;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.Location;
import me.lyft.android.ui.dialogs.StandardDialogController;

public class LockedAddressDialogController
  extends StandardDialogController
{
  @Inject
  public LockedAddressDialogController(DialogFlow paramDialogFlow)
  {
    super(paramDialogFlow);
  }
  
  private static int getPinIcon(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2130838459;
    }
    return 2130838453;
  }
  
  private String getTitle(boolean paramBoolean)
  {
    Resources localResources = getResources();
    if (paramBoolean) {}
    for (int i = 2131165512;; i = 2131165511) {
      return localResources.getString(i);
    }
  }
  
  public String getAddress(Location paramLocation)
  {
    Object localObject = paramLocation.getRoutableAddress();
    if (!Strings.isNullOrEmpty((String)localObject)) {}
    for (paramLocation = (Location)localObject;; paramLocation = paramLocation.getDisplayName())
    {
      localObject = paramLocation;
      if (Strings.isNullOrEmpty(paramLocation)) {
        localObject = getResources().getString(2131165292);
      }
      return (String)localObject;
    }
  }
  
  public void onAttach()
  {
    super.onAttach();
    PassengerDialogs.LockAddressDialog localLockAddressDialog = (PassengerDialogs.LockAddressDialog)Screen.fromController(this);
    boolean bool = localLockAddressDialog.isPickup();
    Location localLocation = localLockAddressDialog.getLocation();
    if ((bool) && (localLockAddressDialog.canPassengerCancel())) {}
    for (int i = 1;; i = 0)
    {
      setContentTitle(getTitle(bool));
      setContentMessage(getAddress(localLocation));
      setContentGraphic(getPinIcon(bool));
      if (i != 0) {
        setContentFooterMessage(getResources().getString(2131165489));
      }
      addPositiveButton(2130903156, getResources().getString(2131165939), getDismissListener());
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.LockedAddressDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */