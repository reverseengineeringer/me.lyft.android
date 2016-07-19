package me.lyft.android.domain.driver;

import com.lyft.android.api.dto.DialDTO;
import com.lyft.android.api.dto.DriverAchievementCardDTO;
import java.util.Collections;
import java.util.List;
import me.lyft.android.common.Enums;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import rx.functions.Func1;

public class CardMapper
{
  public static Card fromDto(DriverAchievementCardDTO paramDriverAchievementCardDTO)
  {
    List localList = Iterables.map((List)Objects.firstNonNull(dials, Collections.emptyList()), new Func1()
    {
      public Dial call(DialDTO paramAnonymousDialDTO)
      {
        return DialMapper.fromDto(paramAnonymousDialDTO);
      }
    });
    Card.Style localStyle = (Card.Style)Enums.valueOf(Card.Style.class, style, Card.Style.LIGHT);
    if (Card.Style.EXPRESSPAY.equals(localStyle)) {
      return new ExpressPayCard(localStyle, (String)Objects.firstNonNull(title, ""), (String)Objects.firstNonNull(subtitle, ""), (String)Objects.firstNonNull(infoUrl, ""), localList, (String)Objects.firstNonNull(buttonText, ""), (String)Objects.firstNonNull(footer, ""));
    }
    return new Card(localStyle, (String)Objects.firstNonNull(title, ""), (String)Objects.firstNonNull(subtitle, ""), (String)Objects.firstNonNull(infoUrl, ""), localList, (String)Objects.firstNonNull(footer, ""));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.CardMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */