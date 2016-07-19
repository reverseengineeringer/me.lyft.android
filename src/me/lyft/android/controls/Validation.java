package me.lyft.android.controls;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.lyft.widgets.ViewWithErrorState;

public class Validation
{
  public static void focusErrorField(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    Object localObject;
    ViewWithErrorState localViewWithErrorState;
    if (i < j)
    {
      localObject = paramVarArgs[i];
      localViewWithErrorState = (ViewWithErrorState)localObject;
      if ((!((View)localObject).hasFocus()) || (!localViewWithErrorState.hasValidationError())) {}
    }
    for (;;)
    {
      return;
      i += 1;
      break;
      j = paramVarArgs.length;
      i = 0;
      while (i < j)
      {
        localObject = paramVarArgs[i];
        localViewWithErrorState = (ViewWithErrorState)localObject;
        if (localViewWithErrorState.hasValidationError())
        {
          ((View)localObject).requestFocus();
          localViewWithErrorState.showValidationMessage();
          if ((localObject instanceof EditText))
          {
            localObject = (EditText)localObject;
            ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
          }
        }
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.Validation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */