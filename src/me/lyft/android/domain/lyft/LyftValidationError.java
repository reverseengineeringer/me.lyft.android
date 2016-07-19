package me.lyft.android.domain.lyft;

public class LyftValidationError
{
  private String field;
  private String message;
  private String reason;
  
  public LyftValidationError(String paramString1, String paramString2, String paramString3)
  {
    field = paramString1;
    reason = paramString2;
    message = paramString3;
  }
  
  public String getField()
  {
    return field;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public String getReason()
  {
    return reason;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.lyft.LyftValidationError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */