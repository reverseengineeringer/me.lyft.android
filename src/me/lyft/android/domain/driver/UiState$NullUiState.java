package me.lyft.android.domain.driver;

class UiState$NullUiState
  extends UiState
{
  private static UiState INSTANCE = new NullUiState();
  
  private UiState$NullUiState()
  {
    super(false);
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

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.UiState.NullUiState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */