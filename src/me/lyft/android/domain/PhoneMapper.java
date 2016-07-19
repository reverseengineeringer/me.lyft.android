package me.lyft.android.domain;

import com.lyft.android.api.dto.PhoneDTO;
import me.lyft.android.common.Objects;

public class PhoneMapper
{
  public static Phone fromPhoneDTO(PhoneDTO paramPhoneDTO)
  {
    if (paramPhoneDTO == null) {
      return Phone.empty();
    }
    Phone localPhone = new Phone();
    localPhone.setNumber((String)Objects.firstNonNull(number, ""));
    localPhone.setVerificationCode((Integer)Objects.firstNonNull(verificationCode, Integer.valueOf(0)));
    localPhone.setVerificationNeeded(((Boolean)Objects.firstNonNull(verificationNeeded, Boolean.valueOf(true))).booleanValue());
    localPhone.setExistingUsersOnly((Boolean)Objects.firstNonNull(existingUsersOnly, Boolean.valueOf(false)));
    return localPhone;
  }
  
  public static PhoneDTO toPhoneDTO(Phone paramPhone)
  {
    if (paramPhone.isNull()) {
      return new PhoneDTO(null, null, null, null);
    }
    return new PhoneDTO(paramPhone.getNumber(), paramPhone.getVerificationCode(), paramPhone.getVerificationNeeded(), paramPhone.getExistingUsersOnly());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.PhoneMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */