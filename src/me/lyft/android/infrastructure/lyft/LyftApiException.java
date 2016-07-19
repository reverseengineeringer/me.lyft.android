package me.lyft.android.infrastructure.lyft;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.IHasReason;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.lyft.LyftError;
import me.lyft.android.domain.lyft.LyftValidationError;

public class LyftApiException
  extends IOException
  implements IHasReason
{
  private LyftError lyftError;
  private int statusCode;
  
  public LyftApiException(LyftError paramLyftError, int paramInt)
  {
    lyftError = paramLyftError;
    statusCode = paramInt;
  }
  
  public LyftError getLyftError()
  {
    LyftError localLyftError = LyftError.empty();
    return (LyftError)Objects.firstNonNull(lyftError, localLyftError);
  }
  
  public String getLyftErrorMessage()
  {
    return getLyftError().getErrorDescription();
  }
  
  public String getMessage()
  {
    Object localObject2 = "Request failed with status:" + getStatusCode() + " error:" + getLyftError().getErrorDescription();
    Object localObject1 = localObject2;
    if (getValidationErrors().size() > 0) {
      localObject1 = (String)localObject2 + " validation errors:";
    }
    localObject2 = getValidationErrors().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      LyftValidationError localLyftValidationError = (LyftValidationError)((Iterator)localObject2).next();
      localObject1 = (String)localObject1 + localLyftValidationError.getField() + "-" + localLyftValidationError.getReason() + "; ";
    }
    return (String)localObject1;
  }
  
  public String getReason()
  {
    Object localObject = getLyftError();
    StringBuilder localStringBuilder = new StringBuilder("lyft_").append(getStatusCode());
    if (!Strings.isNullOrEmpty(((LyftError)localObject).getErrorDescription())) {
      localStringBuilder.append("_").append(((LyftError)localObject).getErrorDescription());
    }
    localObject = ((LyftError)localObject).getErrors().iterator();
    while (((Iterator)localObject).hasNext())
    {
      LyftValidationError localLyftValidationError = (LyftValidationError)((Iterator)localObject).next();
      localStringBuilder.append("_").append(localLyftValidationError.getField()).append("_").append(localLyftValidationError.getReason());
    }
    return localStringBuilder.toString();
  }
  
  public int getStatusCode()
  {
    return statusCode;
  }
  
  public List<LyftValidationError> getValidationErrors()
  {
    return getLyftError().getErrors();
  }
  
  public boolean isServerError()
  {
    return statusCode / 100 == 5;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.LyftApiException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */