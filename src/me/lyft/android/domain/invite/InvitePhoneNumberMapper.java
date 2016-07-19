package me.lyft.android.domain.invite;

import com.lyft.android.api.dto.InvitePhoneNumberDTO;
import me.lyft.android.common.Objects;

public class InvitePhoneNumberMapper
{
  public static InvitePhoneNumber fromDTO(InvitePhoneNumberDTO paramInvitePhoneNumberDTO)
  {
    return new InvitePhoneNumber((String)Objects.firstNonNull(phone, InvitePhoneNumber.empty().getPhone()), (String)Objects.firstNonNull(label, InvitePhoneNumber.empty().getLabel()));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.invite.InvitePhoneNumberMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */