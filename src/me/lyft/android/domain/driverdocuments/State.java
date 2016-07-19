package me.lyft.android.domain.driverdocuments;

import me.lyft.android.common.Objects;

public class State
{
  String code;
  String label;
  
  public State(String paramString1, String paramString2)
  {
    code = paramString1;
    label = paramString2;
  }
  
  public String getCode()
  {
    return (String)Objects.firstNonNull(code, "");
  }
  
  public String getLabel()
  {
    return (String)Objects.firstNonNull(label, "");
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driverdocuments.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */