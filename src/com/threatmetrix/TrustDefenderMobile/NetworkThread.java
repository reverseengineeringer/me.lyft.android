package com.threatmetrix.TrustDefenderMobile;

class NetworkThread
  extends Thread
{
  private Runnable m_runnable = null;
  
  public NetworkThread(Runnable paramRunnable)
  {
    m_runnable = paramRunnable;
  }
  
  public HttpRunner getHttpRunner()
  {
    if ((m_runnable instanceof HttpRunner)) {
      return (HttpRunner)m_runnable;
    }
    return null;
  }
  
  public void interrupt()
  {
    if ((m_runnable instanceof HttpRunner)) {
      ((HttpRunner)m_runnable).abort();
    }
    super.interrupt();
  }
  
  public void run()
  {
    m_runnable.run();
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.NetworkThread
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */