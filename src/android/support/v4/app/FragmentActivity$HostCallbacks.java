package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class FragmentActivity$HostCallbacks
  extends FragmentHostCallback<FragmentActivity>
{
  public FragmentActivity$HostCallbacks(FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
  }
  
  public void onAttachFragment(Fragment paramFragment)
  {
    this$0.onAttachFragment(paramFragment);
  }
  
  public void onDump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this$0.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public View onFindViewById(int paramInt)
  {
    return this$0.findViewById(paramInt);
  }
  
  public FragmentActivity onGetHost()
  {
    return this$0;
  }
  
  public LayoutInflater onGetLayoutInflater()
  {
    return this$0.getLayoutInflater().cloneInContext(this$0);
  }
  
  public int onGetWindowAnimations()
  {
    Window localWindow = this$0.getWindow();
    if (localWindow == null) {
      return 0;
    }
    return getAttributeswindowAnimations;
  }
  
  public boolean onHasView()
  {
    Window localWindow = this$0.getWindow();
    return (localWindow != null) && (localWindow.peekDecorView() != null);
  }
  
  public boolean onHasWindowAnimations()
  {
    return this$0.getWindow() != null;
  }
  
  public void onRequestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt)
  {
    FragmentActivity.access$000(this$0, paramFragment, paramArrayOfString, paramInt);
  }
  
  public boolean onShouldSaveFragmentState(Fragment paramFragment)
  {
    return !this$0.isFinishing();
  }
  
  public boolean onShouldShowRequestPermissionRationale(String paramString)
  {
    return ActivityCompat.shouldShowRequestPermissionRationale(this$0, paramString);
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this$0.startActivityFromFragment(paramFragment, paramIntent, paramInt);
  }
  
  public void onStartActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    this$0.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
  }
  
  public void onSupportInvalidateOptionsMenu()
  {
    this$0.supportInvalidateOptionsMenu();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentActivity.HostCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */