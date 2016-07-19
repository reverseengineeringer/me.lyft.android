package com.tune.crosspromo;

public class TuneAdViewSet
{
  public String placement;
  public boolean showView1;
  public TuneAdView view1;
  public TuneAdView view2;
  
  public TuneAdViewSet(String paramString, TuneAdView paramTuneAdView1, TuneAdView paramTuneAdView2)
  {
    placement = paramString;
    view1 = paramTuneAdView1;
    view2 = paramTuneAdView2;
    showView1 = true;
  }
  
  protected void changeView()
  {
    if (!showView1) {}
    for (boolean bool = true;; bool = false)
    {
      showView1 = bool;
      return;
    }
  }
  
  protected TuneAdView getCurrentView()
  {
    if (showView1) {
      return view1;
    }
    return view2;
  }
  
  protected TuneAdView getPreviousView()
  {
    if (showView1) {
      return view2;
    }
    return view1;
  }
}

/* Location:
 * Qualified Name:     com.tune.crosspromo.TuneAdViewSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */