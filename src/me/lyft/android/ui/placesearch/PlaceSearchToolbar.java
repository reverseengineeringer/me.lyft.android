package me.lyft.android.ui.placesearch;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.lyft.scoop.dagger.DaggerInjector;
import javax.inject.Inject;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.Unit;
import me.lyft.android.utils.Keyboard;
import rx.Observable;
import rx.subjects.PublishSubject;

public class PlaceSearchToolbar
  extends FrameLayout
{
  @Inject
  AppFlow appFlow;
  View backButton;
  final PublishSubject<Unit> backButtonTapSubject = PublishSubject.create();
  View clearButton;
  private TextWatcher onQueryChanged = new PlaceSearchToolbar.3(this);
  final PublishSubject<String> queryChangeSubject = PublishSubject.create();
  EditText queryEditText;
  
  public PlaceSearchToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate(paramContext, 2130903394, this);
    if (isInEditMode()) {
      return;
    }
    ButterKnife.bind(this);
    clearButton.setOnClickListener(new PlaceSearchToolbar.1(this));
    backButton.setOnClickListener(new PlaceSearchToolbar.2(this));
    DaggerInjector.fromView(this).inject(this);
  }
  
  private void clearQuery()
  {
    Keyboard.showKeyboard(queryEditText);
    queryEditText.setText("");
  }
  
  private void goBack()
  {
    appFlow.goBack();
  }
  
  private void invalidateClearButtonVisibility(String paramString)
  {
    if (paramString.length() > 0)
    {
      clearButton.setVisibility(0);
      return;
    }
    clearButton.setVisibility(8);
  }
  
  public Observable<Unit> observeBackButtonTap()
  {
    return backButtonTapSubject.asObservable();
  }
  
  public Observable<String> observeQueryChange()
  {
    return queryChangeSubject.asObservable();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (isInEditMode()) {
      return;
    }
    queryEditText.addTextChangedListener(onQueryChanged);
    invalidateClearButtonVisibility(queryEditText.getText().toString());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    queryEditText.removeTextChangedListener(onQueryChanged);
  }
  
  public void setHintId(int paramInt)
  {
    queryEditText.setHint(paramInt);
  }
  
  public void setQuery(String paramString)
  {
    queryEditText.setText(paramString);
  }
  
  public void showKeyboard()
  {
    Keyboard.showKeyboard(queryEditText);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.placesearch.PlaceSearchToolbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */