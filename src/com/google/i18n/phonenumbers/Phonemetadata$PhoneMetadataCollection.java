package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class Phonemetadata$PhoneMetadataCollection
  implements Externalizable
{
  private static final long serialVersionUID = 1L;
  private List<Phonemetadata.PhoneMetadata> metadata_ = new ArrayList();
  
  public int getMetadataCount()
  {
    return metadata_.size();
  }
  
  public List<Phonemetadata.PhoneMetadata> getMetadataList()
  {
    return metadata_;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    int j = paramObjectInput.readInt();
    int i = 0;
    while (i < j)
    {
      Phonemetadata.PhoneMetadata localPhoneMetadata = new Phonemetadata.PhoneMetadata();
      localPhoneMetadata.readExternal(paramObjectInput);
      metadata_.add(localPhoneMetadata);
      i += 1;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    int j = getMetadataCount();
    paramObjectOutput.writeInt(j);
    int i = 0;
    while (i < j)
    {
      ((Phonemetadata.PhoneMetadata)metadata_.get(i)).writeExternal(paramObjectOutput);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.i18n.phonenumbers.Phonemetadata.PhoneMetadataCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */