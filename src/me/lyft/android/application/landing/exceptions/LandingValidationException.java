package me.lyft.android.application.landing.exceptions;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.application.landing.InvalidField;

public class LandingValidationException
  extends LandingServiceException
{
  public static final String EMAIL_FIELD = "email";
  public static final String FIRST_NAME_FIELD = "first_name";
  public static final String LAST_NAME_FIELD = "last_name";
  List<InvalidField> fields = new ArrayList();
  
  public void addField(String paramString)
  {
    fields.add(new InvalidField(paramString));
  }
  
  public List<InvalidField> getFields()
  {
    return fields;
  }
  
  public String getReason()
  {
    return "invalid_profile_info";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.landing.exceptions.LandingValidationException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */