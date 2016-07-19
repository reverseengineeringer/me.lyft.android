package me.lyft.android.domain.payment;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;

public class Credit
{
  boolean commuteCredits;
  List<String> creditRestrictions;
  String description;
  String id;
  List<String> invalidRestrictions;
  String invalidTitle;
  String label;
  String title;
  
  public List<String> getCreditRestrictions()
  {
    return (List)Objects.firstNonNull(creditRestrictions, new ArrayList());
  }
  
  public String getDescription()
  {
    return (String)Objects.firstNonNull(description, "");
  }
  
  public String getId()
  {
    return (String)Objects.firstNonNull(id, "");
  }
  
  public List<String> getInvalidRestrictions()
  {
    return (List)Objects.firstNonNull(invalidRestrictions, new ArrayList());
  }
  
  public String getInvalidTitle()
  {
    return (String)Objects.firstNonNull(invalidTitle, "");
  }
  
  public String getLabel()
  {
    return (String)Objects.firstNonNull(label, "");
  }
  
  public String getTitle()
  {
    return (String)Objects.firstNonNull(title, "");
  }
  
  public boolean isCommuteCredits()
  {
    return commuteCredits;
  }
  
  public boolean isValid()
  {
    return Strings.isNullOrEmpty(getInvalidTitle());
  }
  
  public void setCommuteCredits(boolean paramBoolean)
  {
    commuteCredits = paramBoolean;
  }
  
  public void setCreditRestrictions(List<String> paramList)
  {
    creditRestrictions = paramList;
  }
  
  public void setDescription(String paramString)
  {
    description = paramString;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setInvalidRestrictions(List<String> paramList)
  {
    invalidRestrictions = paramList;
  }
  
  public void setInvalidTitle(String paramString)
  {
    invalidTitle = paramString;
  }
  
  public void setLabel(String paramString)
  {
    label = paramString;
  }
  
  public void setTitle(String paramString)
  {
    title = paramString;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.payment.Credit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */