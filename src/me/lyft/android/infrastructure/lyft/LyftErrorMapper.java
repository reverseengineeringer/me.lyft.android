package me.lyft.android.infrastructure.lyft;

import com.lyft.android.api.dto.LyftErrorDTO;
import com.lyft.android.api.dto.ValidationErrorDeprecatedDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.lyft.LyftError;
import me.lyft.android.domain.lyft.LyftValidationError;

public class LyftErrorMapper
{
  public static LyftError fromLyftErrorDTO(LyftErrorDTO paramLyftErrorDTO)
  {
    int i;
    int j;
    label21:
    label31:
    String str1;
    if (!Strings.isNullOrEmpty(error_description))
    {
      i = 1;
      if (error_detail == null) {
        break label94;
      }
      j = 1;
      if ((i == 0) && (j == 0)) {
        break label99;
      }
      i = 1;
      if (i == 0) {
        break label104;
      }
      str1 = error;
      label40:
      if (i == 0) {
        break label109;
      }
    }
    label94:
    label99:
    label104:
    label109:
    for (String str2 = error_description;; str2 = error)
    {
      Double localDouble = primetime_multiplier;
      String str3 = cost_token;
      Map localMap = meta;
      return new LyftError(str2, mapValidatioErrors(paramLyftErrorDTO), str3, localDouble, str1, localMap);
      i = 0;
      break;
      j = 0;
      break label21;
      i = 0;
      break label31;
      str1 = null;
      break label40;
    }
  }
  
  private static List<LyftValidationError> mapValidatioErrors(LyftErrorDTO paramLyftErrorDTO)
  {
    Object localObject = errors;
    ArrayList localArrayList = null;
    paramLyftErrorDTO = localArrayList;
    if (localObject != null)
    {
      paramLyftErrorDTO = localArrayList;
      if (!((List)localObject).isEmpty())
      {
        localArrayList = new ArrayList(((List)localObject).size());
        localObject = ((List)localObject).iterator();
        for (;;)
        {
          paramLyftErrorDTO = localArrayList;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramLyftErrorDTO = (ValidationErrorDeprecatedDTO)((Iterator)localObject).next();
          localArrayList.add(new LyftValidationError(field, reason, message));
        }
      }
    }
    return paramLyftErrorDTO;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.lyft.LyftErrorMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */