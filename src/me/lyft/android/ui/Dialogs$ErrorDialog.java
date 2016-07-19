package me.lyft.android.ui;

import com.lyft.scoop.Layout;

@Layout(2130903045)
public class Dialogs$ErrorDialog
  extends Dialogs.AlertDialog
{
  public Dialogs$ErrorDialog(String paramString1, String paramString2, String paramString3)
  {
    super(paramString3);
    setMessage(paramString1);
    addPositiveButton(paramString2);
  }
  
  public Dialogs$ErrorDialog(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString2, paramString3, paramString4);
    setTitle(paramString1);
    setTitleColorResource(2131493111);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.Dialogs.ErrorDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */