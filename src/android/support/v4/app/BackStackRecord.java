package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord
  extends FragmentTransaction
  implements FragmentManager.BackStackEntry, Runnable
{
  static final int OP_ADD = 1;
  static final int OP_ATTACH = 7;
  static final int OP_DETACH = 6;
  static final int OP_HIDE = 4;
  static final int OP_NULL = 0;
  static final int OP_REMOVE = 3;
  static final int OP_REPLACE = 2;
  static final int OP_SHOW = 5;
  static final boolean SUPPORTS_TRANSITIONS;
  static final String TAG = "FragmentManager";
  boolean mAddToBackStack;
  boolean mAllowAddToBackStack = true;
  int mBreadCrumbShortTitleRes;
  CharSequence mBreadCrumbShortTitleText;
  int mBreadCrumbTitleRes;
  CharSequence mBreadCrumbTitleText;
  boolean mCommitted;
  int mEnterAnim;
  int mExitAnim;
  Op mHead;
  int mIndex = -1;
  final FragmentManagerImpl mManager;
  String mName;
  int mNumOp;
  int mPopEnterAnim;
  int mPopExitAnim;
  ArrayList<String> mSharedElementSourceNames;
  ArrayList<String> mSharedElementTargetNames;
  Op mTail;
  int mTransition;
  int mTransitionStyle;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      SUPPORTS_TRANSITIONS = bool;
      return;
    }
  }
  
  public BackStackRecord(FragmentManagerImpl paramFragmentManagerImpl)
  {
    mManager = paramFragmentManagerImpl;
  }
  
  private TransitionState beginTransition(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2, boolean paramBoolean)
  {
    TransitionState localTransitionState = new TransitionState();
    nonExistentView = new View(mManager.mHost.getContext());
    int i = 0;
    int j = 0;
    while (j < paramSparseArray1.size())
    {
      if (configureTransitions(paramSparseArray1.keyAt(j), localTransitionState, paramBoolean, paramSparseArray1, paramSparseArray2)) {
        i = 1;
      }
      j += 1;
    }
    j = 0;
    while (j < paramSparseArray2.size())
    {
      int m = paramSparseArray2.keyAt(j);
      int k = i;
      if (paramSparseArray1.get(m) == null)
      {
        k = i;
        if (configureTransitions(m, localTransitionState, paramBoolean, paramSparseArray1, paramSparseArray2)) {
          k = 1;
        }
      }
      j += 1;
      i = k;
    }
    paramSparseArray1 = localTransitionState;
    if (i == 0) {
      paramSparseArray1 = null;
    }
    return paramSparseArray1;
  }
  
  private void calculateFragments(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (!mManager.mContainer.onHasView()) {}
    Op localOp;
    do
    {
      return;
      localOp = mHead;
    } while (localOp == null);
    switch (cmd)
    {
    }
    for (;;)
    {
      localOp = next;
      break;
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      Object localObject1 = fragment;
      if (mManager.mAdded != null)
      {
        int i = 0;
        if (i < mManager.mAdded.size())
        {
          Fragment localFragment = (Fragment)mManager.mAdded.get(i);
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (mContainerId != mContainerId) {}
          }
          else
          {
            if (localFragment != localObject1) {
              break label197;
            }
            localObject2 = null;
            paramSparseArray2.remove(mContainerId);
          }
          for (;;)
          {
            i += 1;
            localObject1 = localObject2;
            break;
            label197:
            setFirstOut(paramSparseArray1, paramSparseArray2, localFragment);
            localObject2 = localObject1;
          }
        }
      }
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
    }
  }
  
  private void callSharedElementEnd(TransitionState paramTransitionState, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, ArrayMap<String, View> paramArrayMap)
  {
    if (paramBoolean) {}
    for (paramTransitionState = mEnterTransitionCallback;; paramTransitionState = mEnterTransitionCallback)
    {
      if (paramTransitionState != null) {
        paramTransitionState.onSharedElementEnd(new ArrayList(paramArrayMap.keySet()), new ArrayList(paramArrayMap.values()), null);
      }
      return;
    }
  }
  
  private static Object captureExitingViews(Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, ArrayMap<String, View> paramArrayMap, View paramView)
  {
    Object localObject = paramObject;
    if (paramObject != null) {
      localObject = FragmentTransitionCompat21.captureExitingViews(paramObject, paramFragment.getView(), paramArrayList, paramArrayMap, paramView);
    }
    return localObject;
  }
  
  private boolean configureTransitions(int paramInt, TransitionState paramTransitionState, boolean paramBoolean, SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    ViewGroup localViewGroup = (ViewGroup)mManager.mContainer.onFindViewById(paramInt);
    if (localViewGroup == null) {
      return false;
    }
    final Object localObject3 = (Fragment)paramSparseArray2.get(paramInt);
    Object localObject5 = (Fragment)paramSparseArray1.get(paramInt);
    Object localObject4 = getEnterTransition((Fragment)localObject3, paramBoolean);
    Object localObject1 = getSharedElementTransition((Fragment)localObject3, (Fragment)localObject5, paramBoolean);
    Object localObject6 = getExitTransition((Fragment)localObject5, paramBoolean);
    paramSparseArray1 = null;
    ArrayList localArrayList = new ArrayList();
    paramSparseArray2 = (SparseArray<Fragment>)localObject1;
    if (localObject1 != null)
    {
      localObject2 = remapSharedElements(paramTransitionState, (Fragment)localObject5, paramBoolean);
      if (((ArrayMap)localObject2).isEmpty())
      {
        paramSparseArray2 = null;
        paramSparseArray1 = null;
      }
    }
    else
    {
      if ((localObject4 != null) || (paramSparseArray2 != null) || (localObject6 != null)) {
        break label216;
      }
      return false;
    }
    if (paramBoolean) {}
    for (paramSparseArray1 = mEnterTransitionCallback;; paramSparseArray1 = mEnterTransitionCallback)
    {
      if (paramSparseArray1 != null) {
        paramSparseArray1.onSharedElementStart(new ArrayList(((ArrayMap)localObject2).keySet()), new ArrayList(((ArrayMap)localObject2).values()), null);
      }
      prepareSharedElementTransition(paramTransitionState, localViewGroup, localObject1, (Fragment)localObject3, (Fragment)localObject5, paramBoolean, localArrayList);
      paramSparseArray2 = (SparseArray<Fragment>)localObject1;
      paramSparseArray1 = (SparseArray<Fragment>)localObject2;
      break;
    }
    label216:
    localObject1 = new ArrayList();
    Object localObject2 = captureExitingViews(localObject6, (Fragment)localObject5, (ArrayList)localObject1, paramSparseArray1, nonExistentView);
    if ((mSharedElementTargetNames != null) && (paramSparseArray1 != null))
    {
      localObject5 = (View)paramSparseArray1.get(mSharedElementTargetNames.get(0));
      if (localObject5 != null)
      {
        if (localObject2 != null) {
          FragmentTransitionCompat21.setEpicenter(localObject2, (View)localObject5);
        }
        if (paramSparseArray2 != null) {
          FragmentTransitionCompat21.setEpicenter(paramSparseArray2, (View)localObject5);
        }
      }
    }
    localObject5 = new FragmentTransitionCompat21.ViewRetriever()
    {
      public View getView()
      {
        return localObject3.getView();
      }
    };
    localObject6 = new ArrayList();
    ArrayMap localArrayMap = new ArrayMap();
    boolean bool = true;
    if (localObject3 != null) {
      if (!paramBoolean) {
        break label470;
      }
    }
    label470:
    for (bool = ((Fragment)localObject3).getAllowReturnTransitionOverlap();; bool = ((Fragment)localObject3).getAllowEnterTransitionOverlap())
    {
      localObject3 = FragmentTransitionCompat21.mergeTransitions(localObject4, localObject2, paramSparseArray2, bool);
      if (localObject3 != null)
      {
        FragmentTransitionCompat21.addTransitionTargets(localObject4, paramSparseArray2, localViewGroup, (FragmentTransitionCompat21.ViewRetriever)localObject5, nonExistentView, enteringEpicenterView, nameOverrides, (ArrayList)localObject6, paramSparseArray1, localArrayMap, localArrayList);
        excludeHiddenFragmentsAfterEnter(localViewGroup, paramTransitionState, paramInt, localObject3);
        FragmentTransitionCompat21.excludeTarget(localObject3, nonExistentView, true);
        excludeHiddenFragments(paramTransitionState, paramInt, localObject3);
        FragmentTransitionCompat21.beginDelayedTransition(localViewGroup, localObject3);
        FragmentTransitionCompat21.cleanupTransitions(localViewGroup, nonExistentView, localObject4, (ArrayList)localObject6, localObject2, (ArrayList)localObject1, paramSparseArray2, localArrayList, localObject3, hiddenFragmentViews, localArrayMap);
      }
      if (localObject3 == null) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void doAddOp(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    mFragmentManager = mManager;
    if (paramString != null)
    {
      if ((mTag != null) && (!paramString.equals(mTag))) {
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + mTag + " now " + paramString);
      }
      mTag = paramString;
    }
    if (paramInt1 != 0)
    {
      if ((mFragmentId != 0) && (mFragmentId != paramInt1)) {
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + mFragmentId + " now " + paramInt1);
      }
      mFragmentId = paramInt1;
      mContainerId = paramInt1;
    }
    paramString = new Op();
    cmd = paramInt2;
    fragment = paramFragment;
    addOp(paramString);
  }
  
  private void excludeHiddenFragments(TransitionState paramTransitionState, int paramInt, Object paramObject)
  {
    if (mManager.mAdded != null)
    {
      int i = 0;
      if (i < mManager.mAdded.size())
      {
        Fragment localFragment = (Fragment)mManager.mAdded.get(i);
        if ((mView != null) && (mContainer != null) && (mContainerId == paramInt))
        {
          if (!mHidden) {
            break label125;
          }
          if (!hiddenFragmentViews.contains(mView))
          {
            FragmentTransitionCompat21.excludeTarget(paramObject, mView, true);
            hiddenFragmentViews.add(mView);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label125:
          FragmentTransitionCompat21.excludeTarget(paramObject, mView, false);
          hiddenFragmentViews.remove(mView);
        }
      }
    }
  }
  
  private void excludeHiddenFragmentsAfterEnter(final View paramView, final TransitionState paramTransitionState, final int paramInt, final Object paramObject)
  {
    paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        paramView.getViewTreeObserver().removeOnPreDrawListener(this);
        BackStackRecord.this.excludeHiddenFragments(paramTransitionState, paramInt, paramObject);
        return true;
      }
    });
  }
  
  private static Object getEnterTransition(Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReenterTransition();; paramFragment = paramFragment.getEnterTransition()) {
      return FragmentTransitionCompat21.cloneTransition(paramFragment);
    }
  }
  
  private static Object getExitTransition(Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment = paramFragment.getReturnTransition();; paramFragment = paramFragment.getExitTransition()) {
      return FragmentTransitionCompat21.cloneTransition(paramFragment);
    }
  }
  
  private static Object getSharedElementTransition(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 == null) || (paramFragment2 == null)) {
      return null;
    }
    if (paramBoolean) {}
    for (paramFragment1 = paramFragment2.getSharedElementReturnTransition();; paramFragment1 = paramFragment1.getSharedElementEnterTransition()) {
      return FragmentTransitionCompat21.wrapSharedElementTransition(paramFragment1);
    }
  }
  
  private ArrayMap<String, View> mapEnteringSharedElements(TransitionState paramTransitionState, Fragment paramFragment, boolean paramBoolean)
  {
    ArrayMap localArrayMap = new ArrayMap();
    paramFragment = paramFragment.getView();
    paramTransitionState = localArrayMap;
    if (paramFragment != null)
    {
      paramTransitionState = localArrayMap;
      if (mSharedElementSourceNames != null)
      {
        FragmentTransitionCompat21.findNamedViews(localArrayMap, paramFragment);
        if (!paramBoolean) {
          break label57;
        }
        paramTransitionState = remapNames(mSharedElementSourceNames, mSharedElementTargetNames, localArrayMap);
      }
    }
    return paramTransitionState;
    label57:
    localArrayMap.retainAll(mSharedElementTargetNames);
    return localArrayMap;
  }
  
  private ArrayMap<String, View> mapSharedElementsIn(TransitionState paramTransitionState, boolean paramBoolean, Fragment paramFragment)
  {
    ArrayMap localArrayMap = mapEnteringSharedElements(paramTransitionState, paramFragment, paramBoolean);
    if (paramBoolean)
    {
      if (mExitTransitionCallback != null) {
        mExitTransitionCallback.onMapSharedElements(mSharedElementTargetNames, localArrayMap);
      }
      setBackNameOverrides(paramTransitionState, localArrayMap, true);
      return localArrayMap;
    }
    if (mEnterTransitionCallback != null) {
      mEnterTransitionCallback.onMapSharedElements(mSharedElementTargetNames, localArrayMap);
    }
    setNameOverrides(paramTransitionState, localArrayMap, true);
    return localArrayMap;
  }
  
  private void prepareSharedElementTransition(final TransitionState paramTransitionState, final View paramView, final Object paramObject, final Fragment paramFragment1, final Fragment paramFragment2, final boolean paramBoolean, final ArrayList<View> paramArrayList)
  {
    paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public boolean onPreDraw()
      {
        paramView.getViewTreeObserver().removeOnPreDrawListener(this);
        if (paramObject != null)
        {
          FragmentTransitionCompat21.removeTargets(paramObject, paramArrayList);
          paramArrayList.clear();
          ArrayMap localArrayMap = BackStackRecord.this.mapSharedElementsIn(paramTransitionState, paramBoolean, paramFragment1);
          FragmentTransitionCompat21.setSharedElementTargets(paramObject, paramTransitionStatenonExistentView, localArrayMap, paramArrayList);
          BackStackRecord.this.setEpicenterIn(localArrayMap, paramTransitionState);
          BackStackRecord.this.callSharedElementEnd(paramTransitionState, paramFragment1, paramFragment2, paramBoolean, localArrayMap);
        }
        return true;
      }
    });
  }
  
  private static ArrayMap<String, View> remapNames(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayMap<String, View> paramArrayMap)
  {
    if (paramArrayMap.isEmpty()) {
      return paramArrayMap;
    }
    ArrayMap localArrayMap = new ArrayMap();
    int j = paramArrayList1.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramArrayMap.get(paramArrayList1.get(i));
      if (localView != null) {
        localArrayMap.put(paramArrayList2.get(i), localView);
      }
      i += 1;
    }
    return localArrayMap;
  }
  
  private ArrayMap<String, View> remapSharedElements(TransitionState paramTransitionState, Fragment paramFragment, boolean paramBoolean)
  {
    ArrayMap localArrayMap2 = new ArrayMap();
    ArrayMap localArrayMap1 = localArrayMap2;
    if (mSharedElementSourceNames != null)
    {
      FragmentTransitionCompat21.findNamedViews(localArrayMap2, paramFragment.getView());
      if (!paramBoolean) {
        break label82;
      }
      localArrayMap2.retainAll(mSharedElementTargetNames);
    }
    label82:
    for (localArrayMap1 = localArrayMap2; paramBoolean; localArrayMap1 = remapNames(mSharedElementSourceNames, mSharedElementTargetNames, localArrayMap2))
    {
      if (mEnterTransitionCallback != null) {
        mEnterTransitionCallback.onMapSharedElements(mSharedElementTargetNames, localArrayMap1);
      }
      setBackNameOverrides(paramTransitionState, localArrayMap1, false);
      return localArrayMap1;
    }
    if (mExitTransitionCallback != null) {
      mExitTransitionCallback.onMapSharedElements(mSharedElementTargetNames, localArrayMap1);
    }
    setNameOverrides(paramTransitionState, localArrayMap1, false);
    return localArrayMap1;
  }
  
  private void setBackNameOverrides(TransitionState paramTransitionState, ArrayMap<String, View> paramArrayMap, boolean paramBoolean)
  {
    int i;
    int j;
    label13:
    String str;
    Object localObject;
    if (mSharedElementTargetNames == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      str = (String)mSharedElementSourceNames.get(j);
      localObject = (View)paramArrayMap.get((String)mSharedElementTargetNames.get(j));
      if (localObject != null)
      {
        localObject = FragmentTransitionCompat21.getTransitionName((View)localObject);
        if (!paramBoolean) {
          break label103;
        }
        setNameOverride(nameOverrides, str, (String)localObject);
      }
    }
    for (;;)
    {
      j += 1;
      break label13;
      i = mSharedElementTargetNames.size();
      break;
      label103:
      setNameOverride(nameOverrides, (String)localObject, str);
    }
  }
  
  private void setEpicenterIn(ArrayMap<String, View> paramArrayMap, TransitionState paramTransitionState)
  {
    if ((mSharedElementTargetNames != null) && (!paramArrayMap.isEmpty()))
    {
      paramArrayMap = (View)paramArrayMap.get(mSharedElementTargetNames.get(0));
      if (paramArrayMap != null) {
        enteringEpicenterView.epicenter = paramArrayMap;
      }
    }
  }
  
  private static void setFirstOut(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i = mContainerId;
      if ((i != 0) && (!paramFragment.isHidden()))
      {
        if ((paramFragment.isAdded()) && (paramFragment.getView() != null) && (paramSparseArray1.get(i) == null)) {
          paramSparseArray1.put(i, paramFragment);
        }
        if (paramSparseArray2.get(i) == paramFragment) {
          paramSparseArray2.remove(i);
        }
      }
    }
  }
  
  private void setLastIn(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i = mContainerId;
      if (i != 0)
      {
        if (!paramFragment.isAdded()) {
          paramSparseArray2.put(i, paramFragment);
        }
        if (paramSparseArray1.get(i) == paramFragment) {
          paramSparseArray1.remove(i);
        }
      }
      if ((mState < 1) && (mManager.mCurState >= 1))
      {
        mManager.makeActive(paramFragment);
        mManager.moveToState(paramFragment, 1, 0, 0, false);
      }
    }
  }
  
  private static void setNameOverride(ArrayMap<String, String> paramArrayMap, String paramString1, String paramString2)
  {
    int i;
    if ((paramString1 != null) && (paramString2 != null)) {
      i = 0;
    }
    while (i < paramArrayMap.size())
    {
      if (paramString1.equals(paramArrayMap.valueAt(i)))
      {
        paramArrayMap.setValueAt(i, paramString2);
        return;
      }
      i += 1;
    }
    paramArrayMap.put(paramString1, paramString2);
  }
  
  private void setNameOverrides(TransitionState paramTransitionState, ArrayMap<String, View> paramArrayMap, boolean paramBoolean)
  {
    int j = paramArrayMap.size();
    int i = 0;
    if (i < j)
    {
      String str1 = (String)paramArrayMap.keyAt(i);
      String str2 = FragmentTransitionCompat21.getTransitionName((View)paramArrayMap.valueAt(i));
      if (paramBoolean) {
        setNameOverride(nameOverrides, str1, str2);
      }
      for (;;)
      {
        i += 1;
        break;
        setNameOverride(nameOverrides, str2, str1);
      }
    }
  }
  
  private static void setNameOverrides(TransitionState paramTransitionState, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if (paramArrayList1 != null)
    {
      int i = 0;
      while (i < paramArrayList1.size())
      {
        String str1 = (String)paramArrayList1.get(i);
        String str2 = (String)paramArrayList2.get(i);
        setNameOverride(nameOverrides, str1, str2);
        i += 1;
      }
    }
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment)
  {
    doAddOp(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public FragmentTransaction add(int paramInt, Fragment paramFragment, String paramString)
  {
    doAddOp(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public FragmentTransaction add(Fragment paramFragment, String paramString)
  {
    doAddOp(0, paramFragment, paramString, 1);
    return this;
  }
  
  void addOp(Op paramOp)
  {
    if (mHead == null)
    {
      mTail = paramOp;
      mHead = paramOp;
    }
    for (;;)
    {
      enterAnim = mEnterAnim;
      exitAnim = mExitAnim;
      popEnterAnim = mPopEnterAnim;
      popExitAnim = mPopExitAnim;
      mNumOp += 1;
      return;
      prev = mTail;
      mTail.next = paramOp;
      mTail = paramOp;
    }
  }
  
  public FragmentTransaction addSharedElement(View paramView, String paramString)
  {
    if (SUPPORTS_TRANSITIONS)
    {
      paramView = FragmentTransitionCompat21.getTransitionName(paramView);
      if (paramView == null) {
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
      }
      if (mSharedElementSourceNames == null)
      {
        mSharedElementSourceNames = new ArrayList();
        mSharedElementTargetNames = new ArrayList();
      }
      mSharedElementSourceNames.add(paramView);
      mSharedElementTargetNames.add(paramString);
    }
    return this;
  }
  
  public FragmentTransaction addToBackStack(String paramString)
  {
    if (!mAllowAddToBackStack) {
      throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }
    mAddToBackStack = true;
    mName = paramString;
    return this;
  }
  
  public FragmentTransaction attach(Fragment paramFragment)
  {
    Op localOp = new Op();
    cmd = 7;
    fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  void bumpBackStackNesting(int paramInt)
  {
    if (!mAddToBackStack) {}
    for (;;)
    {
      return;
      if (FragmentManagerImpl.DEBUG) {
        Log.v("FragmentManager", "Bump nesting in " + this + " by " + paramInt);
      }
      for (Op localOp = mHead; localOp != null; localOp = next)
      {
        Fragment localFragment;
        if (fragment != null)
        {
          localFragment = fragment;
          mBackStackNesting += paramInt;
          if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
          }
        }
        if (removed != null)
        {
          int i = removed.size() - 1;
          while (i >= 0)
          {
            localFragment = (Fragment)removed.get(i);
            mBackStackNesting += paramInt;
            if (FragmentManagerImpl.DEBUG) {
              Log.v("FragmentManager", "Bump nesting of " + localFragment + " to " + mBackStackNesting);
            }
            i -= 1;
          }
        }
      }
    }
  }
  
  public void calculateBackFragments(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (!mManager.mContainer.onHasView()) {}
    Op localOp;
    do
    {
      return;
      localOp = mTail;
    } while (localOp == null);
    switch (cmd)
    {
    }
    for (;;)
    {
      localOp = prev;
      break;
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      if (removed != null)
      {
        int i = removed.size() - 1;
        while (i >= 0)
        {
          setLastIn(paramSparseArray1, paramSparseArray2, (Fragment)removed.get(i));
          i -= 1;
        }
      }
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setLastIn(paramSparseArray1, paramSparseArray2, fragment);
      continue;
      setFirstOut(paramSparseArray1, paramSparseArray2, fragment);
    }
  }
  
  public int commit()
  {
    return commitInternal(false);
  }
  
  public int commitAllowingStateLoss()
  {
    return commitInternal(true);
  }
  
  int commitInternal(boolean paramBoolean)
  {
    if (mCommitted) {
      throw new IllegalStateException("commit already called");
    }
    if (FragmentManagerImpl.DEBUG)
    {
      Log.v("FragmentManager", "Commit: " + this);
      dump("  ", null, new PrintWriter(new LogWriter("FragmentManager")), null);
    }
    mCommitted = true;
    if (mAddToBackStack) {}
    for (mIndex = mManager.allocBackStackIndex(this);; mIndex = -1)
    {
      mManager.enqueueAction(this, paramBoolean);
      return mIndex;
    }
  }
  
  public FragmentTransaction detach(Fragment paramFragment)
  {
    Op localOp = new Op();
    cmd = 6;
    fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public FragmentTransaction disallowAddToBackStack()
  {
    if (mAddToBackStack) {
      throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    mAllowAddToBackStack = false;
    return this;
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    dump(paramString, paramPrintWriter, true);
  }
  
  public void dump(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(mName);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(mIndex);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(mCommitted);
      if (mTransition != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(mTransition));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(mTransitionStyle));
      }
      if ((mEnterAnim != 0) || (mExitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(mEnterAnim));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(mExitAnim));
      }
      if ((mPopEnterAnim != 0) || (mPopExitAnim != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(mPopEnterAnim));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(mPopExitAnim));
      }
      if ((mBreadCrumbTitleRes != 0) || (mBreadCrumbTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(mBreadCrumbTitleRes));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(mBreadCrumbTitleText);
      }
      if ((mBreadCrumbShortTitleRes != 0) || (mBreadCrumbShortTitleText != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(mBreadCrumbShortTitleRes));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(mBreadCrumbShortTitleText);
      }
    }
    if (mHead != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      String str2 = paramString + "    ";
      Op localOp = mHead;
      int i = 0;
      while (localOp != null)
      {
        String str1;
        int j;
        switch (cmd)
        {
        default: 
          str1 = "cmd=" + cmd;
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str1);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(fragment);
          if (paramBoolean)
          {
            if ((enterAnim != 0) || (exitAnim != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(enterAnim));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(exitAnim));
            }
            if ((popEnterAnim != 0) || (popExitAnim != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(popEnterAnim));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(popExitAnim));
            }
          }
          if ((removed == null) || (removed.size() <= 0)) {
            break label807;
          }
          j = 0;
          label641:
          if (j >= removed.size()) {
            break label807;
          }
          paramPrintWriter.print(str2);
          if (removed.size() == 1) {
            paramPrintWriter.print("Removed: ");
          }
          break;
        }
        for (;;)
        {
          paramPrintWriter.println(removed.get(j));
          j += 1;
          break label641;
          str1 = "NULL";
          break;
          str1 = "ADD";
          break;
          str1 = "REPLACE";
          break;
          str1 = "REMOVE";
          break;
          str1 = "HIDE";
          break;
          str1 = "SHOW";
          break;
          str1 = "DETACH";
          break;
          str1 = "ATTACH";
          break;
          if (j == 0) {
            paramPrintWriter.println("Removed:");
          }
          paramPrintWriter.print(str2);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(j);
          paramPrintWriter.print(": ");
        }
        label807:
        localOp = next;
        i += 1;
      }
    }
  }
  
  public CharSequence getBreadCrumbShortTitle()
  {
    if (mBreadCrumbShortTitleRes != 0) {
      return mManager.mHost.getContext().getText(mBreadCrumbShortTitleRes);
    }
    return mBreadCrumbShortTitleText;
  }
  
  public int getBreadCrumbShortTitleRes()
  {
    return mBreadCrumbShortTitleRes;
  }
  
  public CharSequence getBreadCrumbTitle()
  {
    if (mBreadCrumbTitleRes != 0) {
      return mManager.mHost.getContext().getText(mBreadCrumbTitleRes);
    }
    return mBreadCrumbTitleText;
  }
  
  public int getBreadCrumbTitleRes()
  {
    return mBreadCrumbTitleRes;
  }
  
  public int getId()
  {
    return mIndex;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public int getTransition()
  {
    return mTransition;
  }
  
  public int getTransitionStyle()
  {
    return mTransitionStyle;
  }
  
  public FragmentTransaction hide(Fragment paramFragment)
  {
    Op localOp = new Op();
    cmd = 4;
    fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public boolean isAddToBackStackAllowed()
  {
    return mAllowAddToBackStack;
  }
  
  public boolean isEmpty()
  {
    return mNumOp == 0;
  }
  
  public TransitionState popFromBackStack(boolean paramBoolean, TransitionState paramTransitionState, SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (FragmentManagerImpl.DEBUG)
    {
      Log.v("FragmentManager", "popFromBackStack: " + this);
      dump("  ", null, new PrintWriter(new LogWriter("FragmentManager")), null);
    }
    TransitionState localTransitionState = paramTransitionState;
    if (SUPPORTS_TRANSITIONS)
    {
      localTransitionState = paramTransitionState;
      if (mManager.mCurState >= 1)
      {
        if (paramTransitionState != null) {
          break label235;
        }
        if (paramSparseArray1.size() == 0)
        {
          localTransitionState = paramTransitionState;
          if (paramSparseArray2.size() == 0) {}
        }
        else
        {
          localTransitionState = beginTransition(paramSparseArray1, paramSparseArray2, true);
        }
      }
    }
    label112:
    bumpBackStackNesting(-1);
    int i;
    label125:
    int j;
    label133:
    int k;
    if (localTransitionState != null)
    {
      i = 0;
      if (localTransitionState == null) {
        break label269;
      }
      j = 0;
      paramTransitionState = mTail;
      if (paramTransitionState == null) {
        break label558;
      }
      if (localTransitionState == null) {
        break label278;
      }
      k = 0;
      label150:
      if (localTransitionState == null) {
        break label287;
      }
    }
    label235:
    label269:
    label278:
    label287:
    for (int m = 0;; m = popExitAnim) {
      switch (cmd)
      {
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + cmd);
        localTransitionState = paramTransitionState;
        if (paramBoolean) {
          break label112;
        }
        setNameOverrides(paramTransitionState, mSharedElementTargetNames, mSharedElementSourceNames);
        localTransitionState = paramTransitionState;
        break label112;
        i = mTransitionStyle;
        break label125;
        j = mTransition;
        break label133;
        k = popEnterAnim;
        break label150;
      }
    }
    paramSparseArray1 = fragment;
    mNextAnim = m;
    mManager.removeFragment(paramSparseArray1, FragmentManagerImpl.reverseTransit(j), i);
    for (;;)
    {
      paramTransitionState = prev;
      break;
      paramSparseArray1 = fragment;
      if (paramSparseArray1 != null)
      {
        mNextAnim = m;
        mManager.removeFragment(paramSparseArray1, FragmentManagerImpl.reverseTransit(j), i);
      }
      if (removed != null)
      {
        m = 0;
        while (m < removed.size())
        {
          paramSparseArray1 = (Fragment)removed.get(m);
          mNextAnim = k;
          mManager.addFragment(paramSparseArray1, false);
          m += 1;
        }
        paramSparseArray1 = fragment;
        mNextAnim = k;
        mManager.addFragment(paramSparseArray1, false);
        continue;
        paramSparseArray1 = fragment;
        mNextAnim = k;
        mManager.showFragment(paramSparseArray1, FragmentManagerImpl.reverseTransit(j), i);
        continue;
        paramSparseArray1 = fragment;
        mNextAnim = m;
        mManager.hideFragment(paramSparseArray1, FragmentManagerImpl.reverseTransit(j), i);
        continue;
        paramSparseArray1 = fragment;
        mNextAnim = k;
        mManager.attachFragment(paramSparseArray1, FragmentManagerImpl.reverseTransit(j), i);
        continue;
        paramSparseArray1 = fragment;
        mNextAnim = k;
        mManager.detachFragment(paramSparseArray1, FragmentManagerImpl.reverseTransit(j), i);
      }
    }
    label558:
    if (paramBoolean)
    {
      mManager.moveToState(mManager.mCurState, FragmentManagerImpl.reverseTransit(j), i, true);
      localTransitionState = null;
    }
    if (mIndex >= 0)
    {
      mManager.freeBackStackIndex(mIndex);
      mIndex = -1;
    }
    return localTransitionState;
  }
  
  public FragmentTransaction remove(Fragment paramFragment)
  {
    Op localOp = new Op();
    cmd = 3;
    fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment)
  {
    return replace(paramInt, paramFragment, null);
  }
  
  public FragmentTransaction replace(int paramInt, Fragment paramFragment, String paramString)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    doAddOp(paramInt, paramFragment, paramString, 2);
    return this;
  }
  
  public void run()
  {
    if (FragmentManagerImpl.DEBUG) {
      Log.v("FragmentManager", "Run: " + this);
    }
    if ((mAddToBackStack) && (mIndex < 0)) {
      throw new IllegalStateException("addToBackStack() called after commit()");
    }
    bumpBackStackNesting(1);
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (SUPPORTS_TRANSITIONS)
    {
      localObject2 = localObject1;
      if (mManager.mCurState >= 1)
      {
        localObject1 = new SparseArray();
        localObject2 = new SparseArray();
        calculateFragments((SparseArray)localObject1, (SparseArray)localObject2);
        localObject2 = beginTransition((SparseArray)localObject1, (SparseArray)localObject2, false);
      }
    }
    int i;
    label134:
    int j;
    label141:
    Op localOp;
    int k;
    if (localObject2 != null)
    {
      i = 0;
      if (localObject2 == null) {
        break label256;
      }
      j = 0;
      localOp = mHead;
      if (localOp == null) {
        break label755;
      }
      if (localObject2 == null) {
        break label264;
      }
      k = 0;
      label159:
      if (localObject2 == null) {
        break label273;
      }
    }
    label256:
    label264:
    label273:
    for (int m = 0;; m = exitAnim) {
      switch (cmd)
      {
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + cmd);
        i = mTransitionStyle;
        break label134;
        j = mTransition;
        break label141;
        k = enterAnim;
        break label159;
      }
    }
    localObject1 = fragment;
    mNextAnim = k;
    mManager.addFragment((Fragment)localObject1, false);
    for (;;)
    {
      localOp = next;
      break;
      localObject1 = fragment;
      int i1 = mContainerId;
      Object localObject3 = localObject1;
      if (mManager.mAdded != null)
      {
        int n = mManager.mAdded.size() - 1;
        localObject3 = localObject1;
        if (n >= 0)
        {
          Fragment localFragment = (Fragment)mManager.mAdded.get(n);
          if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "OP_REPLACE: adding=" + localObject1 + " old=" + localFragment);
          }
          localObject3 = localObject1;
          if (mContainerId == i1)
          {
            if (localFragment != localObject1) {
              break label471;
            }
            localObject3 = null;
            fragment = null;
          }
          for (;;)
          {
            n -= 1;
            localObject1 = localObject3;
            break;
            label471:
            if (removed == null) {
              removed = new ArrayList();
            }
            removed.add(localFragment);
            mNextAnim = m;
            if (mAddToBackStack)
            {
              mBackStackNesting += 1;
              if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Bump nesting of " + localFragment + " to " + mBackStackNesting);
              }
            }
            mManager.removeFragment(localFragment, j, i);
            localObject3 = localObject1;
          }
        }
      }
      if (localObject3 != null)
      {
        mNextAnim = k;
        mManager.addFragment((Fragment)localObject3, false);
        continue;
        localObject1 = fragment;
        mNextAnim = m;
        mManager.removeFragment((Fragment)localObject1, j, i);
        continue;
        localObject1 = fragment;
        mNextAnim = m;
        mManager.hideFragment((Fragment)localObject1, j, i);
        continue;
        localObject1 = fragment;
        mNextAnim = k;
        mManager.showFragment((Fragment)localObject1, j, i);
        continue;
        localObject1 = fragment;
        mNextAnim = m;
        mManager.detachFragment((Fragment)localObject1, j, i);
        continue;
        localObject1 = fragment;
        mNextAnim = k;
        mManager.attachFragment((Fragment)localObject1, j, i);
      }
    }
    label755:
    mManager.moveToState(mManager.mCurState, j, i, true);
    if (mAddToBackStack) {
      mManager.addBackStackState(this);
    }
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(int paramInt)
  {
    mBreadCrumbShortTitleRes = paramInt;
    mBreadCrumbShortTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbShortTitle(CharSequence paramCharSequence)
  {
    mBreadCrumbShortTitleRes = 0;
    mBreadCrumbShortTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(int paramInt)
  {
    mBreadCrumbTitleRes = paramInt;
    mBreadCrumbTitleText = null;
    return this;
  }
  
  public FragmentTransaction setBreadCrumbTitle(CharSequence paramCharSequence)
  {
    mBreadCrumbTitleRes = 0;
    mBreadCrumbTitleText = paramCharSequence;
    return this;
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2)
  {
    return setCustomAnimations(paramInt1, paramInt2, 0, 0);
  }
  
  public FragmentTransaction setCustomAnimations(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mEnterAnim = paramInt1;
    mExitAnim = paramInt2;
    mPopEnterAnim = paramInt3;
    mPopExitAnim = paramInt4;
    return this;
  }
  
  public FragmentTransaction setTransition(int paramInt)
  {
    mTransition = paramInt;
    return this;
  }
  
  public FragmentTransaction setTransitionStyle(int paramInt)
  {
    mTransitionStyle = paramInt;
    return this;
  }
  
  public FragmentTransaction show(Fragment paramFragment)
  {
    Op localOp = new Op();
    cmd = 5;
    fragment = paramFragment;
    addOp(localOp);
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(mIndex);
    }
    if (mName != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(mName);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Op
  {
    int cmd;
    int enterAnim;
    int exitAnim;
    Fragment fragment;
    Op next;
    int popEnterAnim;
    int popExitAnim;
    Op prev;
    ArrayList<Fragment> removed;
  }
  
  public class TransitionState
  {
    public FragmentTransitionCompat21.EpicenterView enteringEpicenterView = new FragmentTransitionCompat21.EpicenterView();
    public ArrayList<View> hiddenFragmentViews = new ArrayList();
    public ArrayMap<String, String> nameOverrides = new ArrayMap();
    public View nonExistentView;
    
    public TransitionState() {}
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.BackStackRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */