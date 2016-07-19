package com.google.i18n.phonenumbers;

abstract interface MetadataSource
{
  public abstract Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int paramInt);
  
  public abstract Phonemetadata.PhoneMetadata getMetadataForRegion(String paramString);
}

/* Location:
 * Qualified Name:     com.google.i18n.phonenumbers.MetadataSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */