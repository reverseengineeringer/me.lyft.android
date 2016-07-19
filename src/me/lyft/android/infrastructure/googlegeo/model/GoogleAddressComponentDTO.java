package me.lyft.android.infrastructure.googlegeo.model;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;

public class GoogleAddressComponentDTO
{
  @SerializedName("long_name")
  public final String longName;
  @SerializedName("short_name")
  public final String shortName;
  @SerializedName("types")
  public final List<String> types;
  
  public GoogleAddressComponentDTO(String paramString1, String paramString2, List<String> paramList)
  {
    longName = Strings.nullToEmpty(paramString1);
    shortName = Strings.nullToEmpty(paramString2);
    types = ((List)Objects.firstNonNull(paramList, Collections.emptyList()));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.GoogleAddressComponentDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */