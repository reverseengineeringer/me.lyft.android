package me.lyft.android.adapters;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ContactsRecyclerViewAdapter$ViewHolder$$ViewBinder<T extends ContactsRecyclerViewAdapter.ViewHolder>
  implements ButterKnife.ViewBinder<T>
{
  public void bind(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    categoryTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558851, "field 'categoryTextView'"), 2131558851, "field 'categoryTextView'"));
    dividerView = ((View)paramFinder.findRequiredView(paramObject, 2131558852, "field 'dividerView'"));
    checkBox = ((CheckBox)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558853, "field 'checkBox'"), 2131558853, "field 'checkBox'"));
    inviteNameTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558854, "field 'inviteNameTextView'"), 2131558854, "field 'inviteNameTextView'"));
    inviteTextView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131558855, "field 'inviteTextView'"), 2131558855, "field 'inviteTextView'"));
  }
  
  public void unbind(T paramT)
  {
    categoryTextView = null;
    dividerView = null;
    checkBox = null;
    inviteNameTextView = null;
    inviteTextView = null;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.adapters.ContactsRecyclerViewAdapter.ViewHolder..ViewBinder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */