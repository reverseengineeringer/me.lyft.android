package me.lyft.android.domain.lyft;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import me.lyft.android.common.INullable;
import me.lyft.android.common.Objects;

public class LyftError
  implements INullable
{
  private String costToken;
  private String errorCode;
  private String errorDescription;
  private List<LyftValidationError> errors;
  private Map<String, Object> meta;
  private Double primeTimeMultiplier;
  
  public LyftError(String paramString1, List<LyftValidationError> paramList, String paramString2, Double paramDouble, String paramString3, Map<String, Object> paramMap)
  {
    errorDescription = paramString1;
    errors = paramList;
    costToken = paramString2;
    primeTimeMultiplier = paramDouble;
    errorCode = paramString3;
    meta = paramMap;
  }
  
  public static LyftError empty()
  {
    return NullLyftError.INSTANCE;
  }
  
  public String getCostToken()
  {
    return costToken;
  }
  
  public String getErrorCode()
  {
    return errorCode;
  }
  
  public String getErrorDescription()
  {
    return (String)Objects.firstNonNull(errorDescription, "");
  }
  
  public List<LyftValidationError> getErrors()
  {
    return (List)Objects.firstNonNull(errors, Collections.emptyList());
  }
  
  public Map getMeta()
  {
    return (Map)Objects.firstNonNull(meta, Collections.EMPTY_MAP);
  }
  
  public Double getPrimeTimeMultiplier()
  {
    return primeTimeMultiplier;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  private static final class NullLyftError
    extends LyftError
  {
    private static final NullLyftError INSTANCE = new NullLyftError();
    
    public NullLyftError()
    {
      super(Collections.emptyList(), "", Double.valueOf(0.0D), "", Collections.emptyMap());
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.lyft.LyftError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */