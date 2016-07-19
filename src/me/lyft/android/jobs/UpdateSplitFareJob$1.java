package me.lyft.android.jobs;

import com.lyft.android.api.dto.ContributorRequestDTO;
import me.lyft.android.common.Strings;
import rx.functions.Func1;

final class UpdateSplitFareJob$1
  implements Func1<ContributorRequestDTO, Boolean>
{
  public Boolean call(ContributorRequestDTO paramContributorRequestDTO)
  {
    return Boolean.valueOf(Strings.equalsIgnoreCase(status, "pending"));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdateSplitFareJob.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */