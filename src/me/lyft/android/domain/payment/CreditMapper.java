package me.lyft.android.domain.payment;

import com.lyft.android.api.dto.CreditDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Objects;

public class CreditMapper
{
  public static List<Credit> fromCreditDTO(List<CreditDTO> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = Collections.emptyList();
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      localArrayList.add(fromCreditDTO((CreditDTO)localIterator.next()));
    }
  }
  
  public static Credit fromCreditDTO(CreditDTO paramCreditDTO)
  {
    Credit localCredit = new Credit();
    localCredit.setId((String)Objects.firstNonNull(id, ""));
    localCredit.setLabel((String)Objects.firstNonNull(label, ""));
    localCredit.setTitle((String)Objects.firstNonNull(title, ""));
    localCredit.setCommuteCredits(((Boolean)Objects.firstNonNull(commuteCredits, Boolean.valueOf(false))).booleanValue());
    localCredit.setCreditRestrictions((List)Objects.firstNonNull(creditRestrictions, new ArrayList()));
    localCredit.setInvalidRestrictions((List)Objects.firstNonNull(invalidRestrictions, new ArrayList()));
    localCredit.setDescription((String)Objects.firstNonNull(description, ""));
    localCredit.setInvalidTitle((String)Objects.firstNonNull(invalidTitle, ""));
    return localCredit;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.CreditMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */