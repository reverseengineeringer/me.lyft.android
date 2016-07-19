package me.lyft.android.ui.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lyft.scoop.Screen;
import com.squareup.picasso.RequestCreator;
import javax.inject.Inject;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.passenger.ridetypes.Pricing;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.infrastructure.assets.IAssetLoadingService;
import me.lyft.android.ui.passenger.PassengerDialogs.RideTypeInfoDialog;

public class RateCardDialogController
  extends StandardDialogContainerController
{
  private final IAssetLoadingService assetLoadingService;
  TextView dialogTitle;
  TextView field1Label;
  TextView field1Value;
  TextView field2Label;
  TextView field2Value;
  TextView field3Label;
  TextView field3Value;
  TextView field4Label;
  TextView field4Value;
  TextView footer;
  TextView rideTypeDescription;
  ImageView rideTypeImage;
  private final IRequestRideTypeService rideTypeProvider;
  
  @Inject
  public RateCardDialogController(DialogFlow paramDialogFlow, IRequestRideTypeService paramIRequestRideTypeService, IAssetLoadingService paramIAssetLoadingService)
  {
    super(paramDialogFlow);
    rideTypeProvider = paramIRequestRideTypeService;
    assetLoadingService = paramIAssetLoadingService;
  }
  
  private Drawable getDrawable(int paramInt)
  {
    Resources.Theme localTheme = getView().getContext().getTheme();
    return ResourcesCompat.getDrawable(getResources(), paramInt, localTheme);
  }
  
  private String getRideTypeId()
  {
    return ((PassengerDialogs.RideTypeInfoDialog)Screen.fromController(this)).getRideTypeId();
  }
  
  protected int layoutId()
  {
    return 2130903435;
  }
  
  public void onAttach()
  {
    super.onAttach();
    Object localObject1 = getRideTypeId();
    localObject1 = rideTypeProvider.findRideTypeById((String)localObject1);
    Object localObject2 = ((RequestRideType)localObject1).getInfoBackgroundColor();
    TextView localTextView;
    if (!Strings.isNullOrEmpty((String)localObject2))
    {
      i = Color.parseColor((String)localObject2);
      dialogTitle.setBackgroundColor(i);
      rideTypeImage.setBackgroundColor(i);
      rideTypeDescription.setBackgroundColor(i);
      localObject2 = ((RequestRideType)localObject1).getLabel();
      dialogTitle.setText((CharSequence)localObject2);
      localTextView = dialogTitle;
      if (!Strings.isNullOrBlank((String)localObject2)) {
        break label255;
      }
    }
    label255:
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      rideTypeDescription.setText(((RequestRideType)localObject1).getLongDescription());
      field1Label.setText(2131166283);
      field2Label.setText(2131166282);
      field3Label.setText(2131166284);
      field4Label.setText(2131166285);
      localObject2 = ((RequestRideType)localObject1).getPricing();
      field1Value.setText(((Pricing)localObject2).getMinimum());
      field2Value.setText(((Pricing)localObject2).getPickup());
      field3Value.setText(((Pricing)localObject2).getPerMile());
      field4Value.setText(((Pricing)localObject2).getPerMinute());
      localObject2 = ((RequestRideType)localObject1).getHeroImage();
      if (!Strings.isNullOrEmpty((String)localObject2)) {
        assetLoadingService.loadImage((String)localObject2).error(getDrawable(2130838333)).into(rideTypeImage);
      }
      footer.setText(((RequestRideType)localObject1).getFooterText());
      return;
      i = getResources().getColor(2131492877);
      break;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.dialogs.RateCardDialogController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */