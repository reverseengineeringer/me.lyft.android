package me.lyft.android.domain.driver;

import me.lyft.android.common.INullable;

public class UiState
  implements INullable
{
  private boolean isDriverUi;
  
  public UiState(boolean paramBoolean)
  {
    isDriverUi = paramBoolean;
  }
  
  public static UiState empty()
  {
    return NullUiState.getInstance();
  }
  
  public boolean isDriverUi()
  {
    return isDriverUi;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  static class NullUiState
    extends UiState
  {
    private static UiState INSTANCE = new NullUiState();
    
    private NullUiState()
    {
      super();
    }
    
    public static UiState getInstance()
    {
      return INSTANCE;
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.UiState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */