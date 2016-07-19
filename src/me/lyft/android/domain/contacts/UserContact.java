package me.lyft.android.domain.contacts;

public class UserContact
  implements Comparable<UserContact>
{
  private String email;
  private String name;
  private String phoneNumber;
  private String photoUri;
  
  public UserContact(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    name = paramString1;
    email = paramString2;
    phoneNumber = paramString3;
    photoUri = paramString4;
  }
  
  public int compareTo(UserContact paramUserContact)
  {
    int i = getName().compareToIgnoreCase(paramUserContact.getName());
    if (i != 0) {}
    do
    {
      return i;
      if ((phoneNumber != null) && (phoneNumber != null)) {
        return phoneNumber.compareTo(phoneNumber);
      }
      if (phoneNumber != null) {
        return -1;
      }
      if ((email != null) && (email != null)) {
        return email.compareTo(email);
      }
    } while (email == null);
    return -1;
  }
  
  public String getEmail()
  {
    return email;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getPhoneNumber()
  {
    return phoneNumber;
  }
  
  public String getPhotoUri()
  {
    return photoUri;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.contacts.UserContact
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */