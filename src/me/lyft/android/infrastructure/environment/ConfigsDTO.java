package me.lyft.android.infrastructure.environment;

import java.util.ArrayList;

public class ConfigsDTO
  extends ArrayList<ConfigDTO>
{
  public CharSequence[] asStringsArray()
  {
    CharSequence[] arrayOfCharSequence = new CharSequence[size()];
    int i = 0;
    while (i < size())
    {
      arrayOfCharSequence[i] = ((ConfigDTO)get(i)).getDisplayName();
      i += 1;
    }
    return arrayOfCharSequence;
  }
  
  public int getIndexForApiRoot(String paramString)
  {
    int i = 0;
    while (i < size())
    {
      if (((ConfigDTO)get(i)).getUrl().equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.environment.ConfigsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */