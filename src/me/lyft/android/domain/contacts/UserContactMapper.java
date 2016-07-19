package me.lyft.android.domain.contacts;

import com.lyft.android.api.dto.InviteDTO;
import com.lyft.android.api.dto.InvitePhoneNumberDTO;
import java.util.ArrayList;
import java.util.List;
import me.lyft.android.common.Strings;

public class UserContactMapper
{
  public static InviteDTO emailInviteDTOfromUserContact(UserContact paramUserContact)
  {
    String str1 = getFirstStringMember(paramUserContact.getName());
    String str2 = getSecondStringMember(paramUserContact.getName());
    paramUserContact = paramUserContact.getEmail();
    if (!Strings.isNullOrEmpty(paramUserContact)) {
      return new InviteDTO(str1, str2, paramUserContact, null);
    }
    return null;
  }
  
  private static String getFirstStringMember(String paramString)
  {
    if (!Strings.isNullOrEmpty(paramString)) {
      return paramString.split(" ")[0];
    }
    return null;
  }
  
  private static String getSecondStringMember(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!Strings.isNullOrEmpty(paramString))
    {
      paramString = paramString.split(" ");
      localObject1 = localObject2;
      if (paramString.length > 1) {
        localObject1 = paramString[1];
      }
    }
    return (String)localObject1;
  }
  
  public static InviteDTO phoneInviteDTOfromUserContact(UserContact paramUserContact)
  {
    String str1 = getFirstStringMember(paramUserContact.getName());
    String str2 = getSecondStringMember(paramUserContact.getName());
    paramUserContact = paramUserContact.getPhoneNumber();
    if (!Strings.isNullOrEmpty(paramUserContact))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(new InvitePhoneNumberDTO(paramUserContact, ""));
      return new InviteDTO(str1, str2, null, localArrayList);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.contacts.UserContactMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */