package me.lyft.android.common;

import com.lyft.scoop.RouteChange;
import com.lyft.scoop.Screen;
import com.lyft.scoop.ViewController;
import rx.Observable;

public class DialogFlow
{
  private final AppFlow dialogRouter;
  
  public DialogFlow(AppFlow paramAppFlow)
  {
    dialogRouter = paramAppFlow;
  }
  
  public void clear()
  {
    dialogRouter.clear();
  }
  
  public boolean dismiss()
  {
    return dialogRouter.goBack();
  }
  
  public <T extends ViewController> boolean dismiss(T paramT)
  {
    if ((hasActiveDialog()) && (Objects.equals(dialogRouter.peek().getController(), paramT.getClass())))
    {
      dismiss();
      return true;
    }
    return false;
  }
  
  public boolean hasActiveDialog()
  {
    return dialogRouter.hasActiveScreen();
  }
  
  public Observable<RouteChange> observeDialogChange()
  {
    return dialogRouter.observeRouteChange();
  }
  
  public void show(Screen paramScreen)
  {
    dialogRouter.replaceAllWith(new Screen[] { paramScreen });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.DialogFlow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */