package me.lyft.android.domain.driverdocuments;

import com.lyft.android.api.dto.DriverDocumentDTO;
import me.lyft.android.common.Strings;

public class DriverDocumentsMapper
{
  private static DriverDocument.Status fromDriverDocumentDtoStatus(String paramString)
  {
    if (paramString == null) {
      return DriverDocument.Status.NONE;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return DriverDocument.Status.NONE;
        if (paramString.equals("approved"))
        {
          i = 0;
          continue;
          if (paramString.equals("pending"))
          {
            i = 1;
            continue;
            if (paramString.equals("rejected"))
            {
              i = 2;
              continue;
              if (paramString.equals("expired")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return DriverDocument.Status.APPROVED;
    return DriverDocument.Status.PENDING;
    return DriverDocument.Status.REJECTED;
    return DriverDocument.Status.EXPIRED;
  }
  
  private static String fromDriverDocumentStatus(DriverDocument.Status paramStatus)
  {
    if (paramStatus == null) {
      return null;
    }
    switch (paramStatus)
    {
    default: 
      return null;
    case ???: 
      return "approved";
    case ???: 
      return "pending";
    case ???: 
      return "rejected";
    }
    return "expired";
  }
  
  public static DriverDocumentDTO fromInspection(Inspection paramInspection)
  {
    return new DriverDocumentDTO(null, null, null, null, paramInspection.getPhotoUrl(), paramInspection.getPhotoUploadUrl());
  }
  
  public static Inspection fromInspectionDTO(DriverDocumentDTO paramDriverDocumentDTO)
  {
    if (paramDriverDocumentDTO == null) {
      return Inspection.NullInspection.getInstance();
    }
    return new Inspection(Strings.nullToEmpty(photo), Strings.nullToEmpty(imageUploadUrl), fromDriverDocumentDtoStatus(status));
  }
  
  public static DriverDocumentDTO fromInsurance(Insurance paramInsurance)
  {
    return new DriverDocumentDTO(fromDriverDocumentStatus(paramInsurance.getStatus()), paramInsurance.getState(), paramInsurance.expirationDateToString(), null, paramInsurance.getPhotoUrl(), paramInsurance.getPhotoUploadUrl());
  }
  
  public static Insurance fromInsuranceDTO(DriverDocumentDTO paramDriverDocumentDTO)
  {
    if (paramDriverDocumentDTO == null) {
      return Insurance.NullInsurance.getInstance();
    }
    return new Insurance(Strings.nullToEmpty(photo), Strings.nullToEmpty(imageUploadUrl), fromDriverDocumentDtoStatus(status), Strings.nullToEmpty(state), expirationDate);
  }
  
  public static DriverDocumentDTO fromRegistration(Registration paramRegistration)
  {
    return new DriverDocumentDTO(null, null, null, null, paramRegistration.getPhotoUrl(), paramRegistration.getPhotoUploadUrl());
  }
  
  public static Registration fromRegistrationDTO(DriverDocumentDTO paramDriverDocumentDTO)
  {
    if (paramDriverDocumentDTO == null) {
      return Registration.NullRegistration.getInstance();
    }
    return new Registration(Strings.nullToEmpty(photo), Strings.nullToEmpty(imageUploadUrl), fromDriverDocumentDtoStatus(status));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driverdocuments.DriverDocumentsMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */