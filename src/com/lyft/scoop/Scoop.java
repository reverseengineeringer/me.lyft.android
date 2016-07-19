package com.lyft.scoop;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Scoop
{
  static ViewBinder viewBinder = new NoOpViewBinder();
  private HashMap<String, Scoop> children = new LinkedHashMap();
  private boolean destroyed;
  private String name;
  private Scoop parent;
  private Map<String, Object> services;
  
  private Scoop(String paramString, Scoop paramScoop, Map<String, Object> paramMap)
  {
    name = paramString;
    parent = paramScoop;
    services = paramMap;
    if (paramScoop != null) {
      children.put(paramString, this);
    }
  }
  
  private <T> T findService(Scoop paramScoop, String paramString)
  {
    Object localObject = services.get(paramString);
    if (localObject != null) {
      return (T)localObject;
    }
    if (parent != null) {
      return (T)findService(parent, paramString);
    }
    return null;
  }
  
  public static Scoop fromContext(Context paramContext)
  {
    if (!(paramContext instanceof HaveScoop)) {
      throw new RuntimeException("View does not implement interface: HaveScoop");
    }
    return ((HaveScoop)paramContext).getScoop();
  }
  
  public static Scoop fromView(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return fromContext(paramView.getContext());
  }
  
  public static void setViewBinder(ViewBinder paramViewBinder)
  {
    viewBinder = paramViewBinder;
  }
  
  public Context createContext(Context paramContext)
  {
    return new ScoopContextWrapper(paramContext, this);
  }
  
  public void destroy()
  {
    Iterator localIterator = new HashSet(children.entrySet()).iterator();
    while (localIterator.hasNext()) {
      ((Scoop)((Map.Entry)localIterator.next()).getValue()).destroy();
    }
    destroyed = true;
    if (parent != null) {
      parent.children.remove(getName());
    }
  }
  
  public <T> T findService(String paramString)
  {
    return (T)findService(this, paramString);
  }
  
  public String getName()
  {
    return name;
  }
  
  public Scoop getParent()
  {
    return parent;
  }
  
  public View inflate(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return inflater(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, paramBoolean);
  }
  
  public LayoutInflater inflater(Context paramContext)
  {
    return LayoutInflater.from(paramContext).cloneInContext(createContext(paramContext));
  }
  
  public static class Builder
  {
    private String name;
    private final Scoop parent;
    private final Map<String, Object> services = new LinkedHashMap();
    
    public Builder(String paramString)
    {
      name = paramString;
      parent = null;
    }
    
    public Builder(String paramString, Scoop paramScoop)
    {
      name = paramString;
      parent = paramScoop;
    }
    
    public Scoop build()
    {
      return new Scoop(name, parent, services, null);
    }
    
    public Builder service(String paramString, Object paramObject)
    {
      services.put(paramString, paramObject);
      return this;
    }
  }
  
  protected static abstract interface HaveScoop
  {
    public abstract Scoop getScoop();
  }
  
  private static class ScoopContextWrapper
    extends ContextWrapper
    implements Scoop.HaveScoop
  {
    private final Scoop scoop;
    
    public ScoopContextWrapper(Context paramContext, Scoop paramScoop)
    {
      super();
      scoop = paramScoop;
    }
    
    public Scoop getScoop()
    {
      return scoop;
    }
  }
}

/* Location:
 * Qualified Name:     com.lyft.scoop.Scoop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */