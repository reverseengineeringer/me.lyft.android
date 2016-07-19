package me.lyft.android.application.payment;

import com.lyft.android.api.dto.CouponTemplateDTO;
import me.lyft.android.domain.invite.CouponInfo;
import me.lyft.android.domain.invite.CouponInfoMapper;
import rx.functions.Func1;

class CouponService$4
  implements Func1<CouponTemplateDTO, CouponInfo>
{
  CouponService$4(CouponService paramCouponService) {}
  
  public CouponInfo call(CouponTemplateDTO paramCouponTemplateDTO)
  {
    return CouponInfoMapper.fromCouponTemplateDTO(paramCouponTemplateDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.payment.CouponService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */