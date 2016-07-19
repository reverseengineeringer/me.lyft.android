package com.lyft.widgets;

public abstract interface ViewWithErrorState
{
  public abstract boolean hasValidationError();
  
  public abstract void showValidationMessage();
}

/* Location:
 * Qualified Name:     com.lyft.widgets.ViewWithErrorState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */