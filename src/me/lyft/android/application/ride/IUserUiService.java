package me.lyft.android.application.ride;

import me.lyft.android.domain.driver.UiState;
import rx.Observable;

public abstract interface IUserUiService
{
  public abstract UiState getUiState();
  
  public abstract Observable<UiState> observeUiState();
  
  public abstract void updateUiState(UiState paramUiState);
  
  public abstract void validateUiState();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.IUserUiService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */