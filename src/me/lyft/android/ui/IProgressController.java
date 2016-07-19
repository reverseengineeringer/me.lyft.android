package me.lyft.android.ui;

public abstract interface IProgressController
{
  public abstract void disableUI();
  
  public abstract void enableUI();
  
  public abstract void enableUI(boolean paramBoolean);
  
  public abstract void hideProgress();
  
  public abstract boolean isUIEnabled();
  
  public abstract void showProgress();
  
  public abstract void showProgress(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.IProgressController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */