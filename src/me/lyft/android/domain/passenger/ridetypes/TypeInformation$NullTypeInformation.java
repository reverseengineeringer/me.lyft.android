package me.lyft.android.domain.passenger.ridetypes;

class TypeInformation$NullTypeInformation
  extends TypeInformation
{
  private static final TypeInformation INSTANCE = new NullTypeInformation();
  
  private TypeInformation$NullTypeInformation()
  {
    super("", "", "", "", "", "", "");
  }
  
  static TypeInformation getInstance()
  {
    return INSTANCE;
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ridetypes.TypeInformation.NullTypeInformation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */