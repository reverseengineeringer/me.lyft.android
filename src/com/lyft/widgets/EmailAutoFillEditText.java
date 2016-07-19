package com.lyft.widgets;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;

public class EmailAutoFillEditText
  extends AdvancedEditText
{
  public EmailAutoFillEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {}
    for (;;)
    {
      return;
      setThreshold(1);
      paramAttributeSet = new ArrayAdapter(paramContext, 17367050);
      setAdapter(paramAttributeSet);
      paramContext = AccountManager.get(paramContext).getAccountsByType("com.google");
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        paramAttributeSet.add(name);
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.widgets.EmailAutoFillEditText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */