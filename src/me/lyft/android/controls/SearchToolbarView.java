package me.lyft.android.controls;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import butterknife.ButterKnife;
import me.lyft.android.common.Unit;
import me.lyft.android.utils.Keyboard;
import rx.Observable;
import rx.subjects.PublishSubject;

public class SearchToolbarView
  extends FrameLayout
{
  ImageView clearButton;
  EditText editText;
  final PublishSubject<CharSequence> editablePublishSubject = PublishSubject.create();
  final PublishSubject<Unit> homePressedPublishSubject = PublishSubject.create();
  final TextWatcher textWatcher = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      SearchToolbarView.this.updateClearButtonState(paramAnonymousEditable);
      editablePublishSubject.onNext(paramAnonymousEditable);
    }
    
    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  
  public SearchToolbarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130903487, this, true);
  }
  
  private void updateClearButtonState(CharSequence paramCharSequence)
  {
    ImageView localImageView = clearButton;
    if (paramCharSequence.length() <= 0) {}
    for (int i = 4;; i = 0)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void focusFieldAndShowKeyboard()
  {
    Keyboard.showKeyboard(editText);
  }
  
  public void hideKeyboard()
  {
    Keyboard.hideKeyboard(editText);
  }
  
  public Observable<Unit> observeHomeClicked()
  {
    return homePressedPublishSubject.asObservable();
  }
  
  public Observable<CharSequence> observeTextChange()
  {
    return editablePublishSubject.asObservable();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    editText.addTextChangedListener(textWatcher);
    updateClearButtonState(editText.getText().toString());
  }
  
  void onClearClicked()
  {
    editText.setText("");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    editText.removeTextChangedListener(textWatcher);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
  
  void onHomeClicked()
  {
    homePressedPublishSubject.onNext(Unit.create());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.SearchToolbarView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */