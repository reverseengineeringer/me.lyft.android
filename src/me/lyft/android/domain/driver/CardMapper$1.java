package me.lyft.android.domain.driver;

import com.lyft.android.api.dto.DialDTO;
import rx.functions.Func1;

final class CardMapper$1
  implements Func1<DialDTO, Dial>
{
  public Dial call(DialDTO paramDialDTO)
  {
    return DialMapper.fromDto(paramDialDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.CardMapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */