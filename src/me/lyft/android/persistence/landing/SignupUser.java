package me.lyft.android.persistence.landing;

import com.google.gson.annotations.SerializedName;
import java.util.regex.Pattern;
import me.lyft.android.common.EmailUtils;
import me.lyft.android.common.Strings;

public class SignupUser
{
  private static final String EMAIL_PATTERN = "^[\\w\\.+-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
  private static final Pattern PATTERN = Pattern.compile("^[\\w\\.+-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", 2);
  @SerializedName("agreedToS")
  private final boolean agreedToS;
  @SerializedName("email")
  private final String email;
  @SerializedName("firstName")
  private final String firstName;
  @SerializedName("isoCountryCode")
  private final String isoCountryCode;
  @SerializedName("lastName")
  private final String lastName;
  @SerializedName("phone")
  private final String phoneString;
  
  private SignupUser(SignupUser.Builder paramBuilder)
  {
    firstName = SignupUser.Builder.access$000(paramBuilder);
    lastName = SignupUser.Builder.access$100(paramBuilder);
    email = SignupUser.Builder.access$200(paramBuilder);
    phoneString = SignupUser.Builder.access$300(paramBuilder);
    agreedToS = SignupUser.Builder.access$400(paramBuilder);
    isoCountryCode = SignupUser.Builder.access$500(paramBuilder);
  }
  
  public static SignupUser empty()
  {
    return new SignupUser.Builder().firstName("").lastName("").email("").isoCountryCode("").phone("").hasAgreedTOS(false).build();
  }
  
  public SignupUser.Builder buildUpon()
  {
    return new SignupUser.Builder().lastName(getLastName()).firstName(getFirstName()).email(getEmail()).isoCountryCode(getIsoCountryCode()).phone(getPhoneString()).hasAgreedTOS(hasAgreedToS());
  }
  
  public String getEmail()
  {
    return email;
  }
  
  public String getFirstName()
  {
    return firstName;
  }
  
  public String getIsoCountryCode()
  {
    return isoCountryCode;
  }
  
  public String getLastName()
  {
    return lastName;
  }
  
  public String getPhoneString()
  {
    return phoneString;
  }
  
  public boolean hasAgreedToS()
  {
    return agreedToS;
  }
  
  public boolean isValid()
  {
    return (validateFirstName()) && (validateLastName()) && (validateEmail());
  }
  
  public boolean validateEmail()
  {
    return EmailUtils.validateEmail(email);
  }
  
  public boolean validateFirstName()
  {
    return !Strings.isNullOrBlank(firstName);
  }
  
  public boolean validateLastName()
  {
    return !Strings.isNullOrBlank(lastName);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.persistence.landing.SignupUser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */