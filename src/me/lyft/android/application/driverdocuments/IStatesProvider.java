package me.lyft.android.application.driverdocuments;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.domain.driverdocuments.State;

public abstract interface IStatesProvider
{
  public abstract ArrayList<String> getStateLabels();
  
  public abstract List<State> getStates();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driverdocuments.IStatesProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */