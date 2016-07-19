package me.lyft.android.analytics.definitions;

public abstract class ParameterStore
{
  private <T> T getValue(Object paramObject, Class<T> paramClass)
    throws ClassCastException
  {
    if (paramObject != null) {
      return (T)paramClass.cast(paramObject);
    }
    return null;
  }
  
  public Boolean getBoolean(Parameter paramParameter)
  {
    return (Boolean)getValue(getParameterInternal(paramParameter), Boolean.class);
  }
  
  public Double getDouble(Parameter paramParameter)
  {
    return (Double)getValue(getParameterInternal(paramParameter), Double.class);
  }
  
  public Float getFloat(Parameter paramParameter)
  {
    return (Float)getValue(getParameterInternal(paramParameter), Float.class);
  }
  
  public Integer getInteger(Parameter paramParameter)
  {
    return (Integer)getValue(getParameterInternal(paramParameter), Integer.class);
  }
  
  public Long getLong(Parameter paramParameter)
  {
    return (Long)getValue(getParameterInternal(paramParameter), Long.class);
  }
  
  protected abstract Object getParameterInternal(Parameter paramParameter)
    throws ClassCastException;
  
  public String getString(Parameter paramParameter)
  {
    return (String)getValue(getParameterInternal(paramParameter), String.class);
  }
  
  public void put(Parameter paramParameter, Boolean paramBoolean)
  {
    putParameterInternal(paramParameter, paramBoolean);
  }
  
  public void put(Parameter paramParameter, Double paramDouble)
  {
    putParameterInternal(paramParameter, paramDouble);
  }
  
  public void put(Parameter paramParameter, Float paramFloat)
  {
    putParameterInternal(paramParameter, paramFloat);
  }
  
  public void put(Parameter paramParameter, Integer paramInteger)
  {
    putParameterInternal(paramParameter, paramInteger);
  }
  
  public void put(Parameter paramParameter, Long paramLong)
  {
    putParameterInternal(paramParameter, paramLong);
  }
  
  public void put(Parameter paramParameter, String paramString)
  {
    putParameterInternal(paramParameter, paramString);
  }
  
  protected abstract void putParameterInternal(Parameter paramParameter, Object paramObject);
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.definitions.ParameterStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */