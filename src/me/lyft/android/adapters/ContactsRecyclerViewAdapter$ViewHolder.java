package me.lyft.android.adapters;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.ButterKnife;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.contacts.UserContact;

public class ContactsRecyclerViewAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  TextView categoryTextView;
  CheckBox checkBox;
  View dividerView;
  TextView inviteNameTextView;
  TextView inviteTextView;
  
  public ContactsRecyclerViewAdapter$ViewHolder(View paramView)
  {
    super(paramView);
    ButterKnife.bind(this, paramView);
  }
  
  private void setItemLabels(UserContact paramUserContact)
  {
    String str = paramUserContact.getName();
    if (paramUserContact.getPhoneNumber() != null) {}
    for (paramUserContact = paramUserContact.getPhoneNumber(); !Strings.isNullOrEmpty(str); paramUserContact = paramUserContact.getEmail())
    {
      inviteTextView.setVisibility(0);
      inviteTextView.setText(paramUserContact);
      inviteNameTextView.setText(str);
      return;
    }
    inviteTextView.setVisibility(8);
    inviteNameTextView.setText(paramUserContact);
  }
  
  public void setCategory(String paramString)
  {
    if (!Strings.isNullOrEmpty(paramString))
    {
      categoryTextView.setText(paramString);
      categoryTextView.setVisibility(0);
      dividerView.setVisibility(8);
      return;
    }
    categoryTextView.setVisibility(8);
    dividerView.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.adapters.ContactsRecyclerViewAdapter.ViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */