package me.lyft.android.domain.passenger.ride;

import com.lyft.android.api.dto.TipOptionDTO;
import rx.functions.Func1;

final class PassengerRideReceiptMapper$1
  implements Func1<TipOptionDTO, TipOption>
{
  public TipOption call(TipOptionDTO paramTipOptionDTO)
  {
    return PassengerRideReceiptMapper.access$000(paramTipOptionDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerRideReceiptMapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */