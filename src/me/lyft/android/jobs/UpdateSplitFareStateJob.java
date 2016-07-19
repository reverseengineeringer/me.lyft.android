package me.lyft.android.jobs;

import com.lyft.android.api.dto.ContributorDTO;
import com.lyft.android.api.dto.RideDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.splitfare.SplitFareState;
import me.lyft.android.infrastructure.splitfare.ISplitFareService;
import me.lyft.android.persistence.splitfare.ISplitFareStateRepository;
import me.lyft.android.ui.splitfare.SearchHelper;

public class UpdateSplitFareStateJob
  implements Job
{
  final RideDTO ride;
  @Inject
  ISplitFareService splitFareService;
  @Inject
  ISplitFareStateRepository splitFareStateRepository;
  
  public UpdateSplitFareStateJob(RideDTO paramRideDTO)
  {
    ride = paramRideDTO;
  }
  
  static int countAccepted(List<ContributorDTO> paramList)
  {
    int i = 0;
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (Strings.equalsIgnoreCase(nextstatus, "accepted")) {
        i += 1;
      }
    }
    return i;
  }
  
  private List<String> normalizeNumbers(List<ContributorDTO> paramList)
  {
    if (paramList.isEmpty())
    {
      paramList = Collections.emptyList();
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (ContributorDTO)localIterator.next();
      if (!Strings.isNullOrEmpty(phone))
      {
        String str = SearchHelper.normalizeNumber(phone);
        localArrayList.add(str);
        if (Strings.isNullOrEmpty(name)) {
          splitFareService.addUnknownPhoneNumber(str);
        }
      }
    }
  }
  
  public void execute()
    throws Throwable
  {
    if (ride == null) {
      return;
    }
    Object localObject = (List)Objects.firstNonNull(ride.contributors, Collections.emptyList());
    localObject = new SplitFareState(countAccepted((List)localObject), normalizeNumbers((List)localObject));
    splitFareStateRepository.update((SplitFareState)localObject);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdateSplitFareStateJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */