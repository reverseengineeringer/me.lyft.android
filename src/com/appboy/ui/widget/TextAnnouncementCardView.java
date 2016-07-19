package com.appboy.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.appboy.models.cards.TextAnnouncementCard;
import com.appboy.ui.R.drawable;
import com.appboy.ui.R.id;
import com.appboy.ui.R.layout;
import com.appboy.ui.actions.ActionFactory;
import com.appboy.ui.actions.IAction;

public class TextAnnouncementCardView
  extends BaseCardView<TextAnnouncementCard>
{
  private static final String TAG = String.format("%s.%s", new Object[] { "Appboy", TextAnnouncementCardView.class.getName() });
  private IAction mCardAction;
  private final TextView mDescription = (TextView)findViewById(R.id.com_appboy_text_announcement_card_description);
  private final TextView mDomain = (TextView)findViewById(R.id.com_appboy_text_announcement_card_domain);
  private final TextView mTitle = (TextView)findViewById(R.id.com_appboy_text_announcement_card_title);
  
  public TextAnnouncementCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextAnnouncementCardView(Context paramContext, TextAnnouncementCard paramTextAnnouncementCard)
  {
    super(paramContext);
    if (paramTextAnnouncementCard != null) {
      setCard(paramTextAnnouncementCard);
    }
    safeSetBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
  }
  
  protected int getLayoutResource()
  {
    return R.layout.com_appboy_text_announcement_card;
  }
  
  public void onSetCard(final TextAnnouncementCard paramTextAnnouncementCard)
  {
    mTitle.setText(paramTextAnnouncementCard.getTitle());
    mDescription.setText(paramTextAnnouncementCard.getDescription());
    setOptionalTextView(mDomain, paramTextAnnouncementCard.getDomain());
    mCardAction = ActionFactory.createUriAction(getContext(), paramTextAnnouncementCard.getUrl());
    setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        BaseCardView.handleCardClick(mContext, paramTextAnnouncementCard, mCardAction, TextAnnouncementCardView.TAG);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.appboy.ui.widget.TextAnnouncementCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */