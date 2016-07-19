package me.lyft.android.jobs;

import com.lyft.android.api.dto.ContributorRequestDTO;
import com.lyft.android.api.dto.UniversalDTO;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.splitfare.SplitFareRequest;
import me.lyft.android.persistence.splitfare.ISplitFareRequestRepository;
import rx.functions.Func1;

public class UpdateSplitFareJob
  implements Job
{
  UniversalDTO appState;
  @Inject
  ISplitFareRequestRepository splitFareRequestRepository;
  
  public UpdateSplitFareJob(UniversalDTO paramUniversalDTO)
  {
    appState = paramUniversalDTO;
  }
  
  static SplitFareRequest resolveSplitFareRequest(List<ContributorRequestDTO> paramList)
  {
    paramList = (ContributorRequestDTO)Iterables.firstOrDefault(paramList, new Func1()
    {
      public Boolean call(ContributorRequestDTO paramAnonymousContributorRequestDTO)
      {
        return Boolean.valueOf(Strings.equalsIgnoreCase(status, "pending"));
      }
    }, null);
    if (paramList == null) {
      return SplitFareRequest.empty();
    }
    return new SplitFareRequest(id, initiatorName, initiatorPhoto, Strings.equalsIgnoreCase(status, "pending"));
  }
  
  public void execute()
    throws Throwable
  {
    SplitFareRequest localSplitFareRequest = resolveSplitFareRequest((List)Objects.firstNonNull(appState.contributorRequests, Collections.emptyList()));
    splitFareRequestRepository.update(localSplitFareRequest);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdateSplitFareJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */