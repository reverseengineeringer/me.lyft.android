package me.lyft.android.application.driverdocuments;

import android.content.res.Resources;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import me.lyft.android.LyftApplication;
import me.lyft.android.domain.driverdocuments.State;

@Singleton
public class StatesProvider
  implements IStatesProvider
{
  private LyftApplication lyftApplication;
  private List<State> states;
  
  @Inject
  public StatesProvider(LyftApplication paramLyftApplication)
  {
    lyftApplication = paramLyftApplication;
    loadStates();
  }
  
  private void loadStates()
  {
    String[] arrayOfString1 = lyftApplication.getResources().getStringArray(2131361799);
    states = new ArrayList(arrayOfString1.length);
    int j = arrayOfString1.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString2 = arrayOfString1[i].split("\\|", 2);
      states.add(new State(arrayOfString2[0], arrayOfString2[1]));
      i += 1;
    }
  }
  
  public ArrayList<String> getStateLabels()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getStates().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((State)localIterator.next()).getLabel());
    }
    return localArrayList;
  }
  
  public List<State> getStates()
  {
    return states;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.driverdocuments.StatesProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */