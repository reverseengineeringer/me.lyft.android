package me.lyft.android.controls;

import android.text.Editable;
import android.text.TextWatcher;
import rx.subjects.PublishSubject;

class SearchToolbarView$1
  implements TextWatcher
{
  SearchToolbarView$1(SearchToolbarView paramSearchToolbarView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    SearchToolbarView.access$000(this$0, paramEditable);
    this$0.editablePublishSubject.onNext(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.SearchToolbarView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */