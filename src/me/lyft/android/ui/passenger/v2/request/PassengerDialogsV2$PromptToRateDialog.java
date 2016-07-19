package me.lyft.android.ui.passenger.v2.request;

import com.lyft.scoop.Controller;
import me.lyft.android.common.IHasName;

@Controller(PromptToRateDialogController.class)
public class PassengerDialogsV2$PromptToRateDialog
  extends PassengerDialogsV2
  implements IHasName
{
  public String getName()
  {
    return "rate_app_dialog";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.v2.request.PassengerDialogsV2.PromptToRateDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */