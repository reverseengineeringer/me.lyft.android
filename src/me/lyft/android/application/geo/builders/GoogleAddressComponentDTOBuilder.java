package me.lyft.android.application.geo.builders;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.infrastructure.googlegeo.model.GoogleAddressComponentDTO;

public class GoogleAddressComponentDTOBuilder
{
  private String shortName;
  private final List<String> types;
  
  public GoogleAddressComponentDTOBuilder()
  {
    types = new ArrayList();
  }
  
  private GoogleAddressComponentDTOBuilder(List<String> paramList, String paramString)
  {
    types = paramList;
    shortName = paramString;
  }
  
  public GoogleAddressComponentDTO build()
  {
    return new GoogleAddressComponentDTO(shortName, shortName, types);
  }
  
  public GoogleAddressComponentDTOBuilder withShortName(String paramString)
  {
    return new GoogleAddressComponentDTOBuilder(types, paramString);
  }
  
  public GoogleAddressComponentDTOBuilder withType(String paramString)
  {
    ArrayList localArrayList = new ArrayList(types);
    localArrayList.add(paramString);
    return new GoogleAddressComponentDTOBuilder(localArrayList, shortName);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.builders.GoogleAddressComponentDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */