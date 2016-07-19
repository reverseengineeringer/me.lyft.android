package android.support.v7.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

class CardView$1
  implements CardViewDelegate
{
  private Drawable mCardBackground;
  
  CardView$1(CardView paramCardView) {}
  
  public Drawable getCardBackground()
  {
    return mCardBackground;
  }
  
  public View getCardView()
  {
    return this$0;
  }
  
  public boolean getPreventCornerOverlap()
  {
    return this$0.getPreventCornerOverlap();
  }
  
  public boolean getUseCompatPadding()
  {
    return this$0.getUseCompatPadding();
  }
  
  public void setCardBackground(Drawable paramDrawable)
  {
    mCardBackground = paramDrawable;
    this$0.setBackgroundDrawable(paramDrawable);
  }
  
  public void setMinWidthHeightInternal(int paramInt1, int paramInt2)
  {
    if (paramInt1 > CardView.access$300(this$0)) {
      CardView.access$401(this$0, paramInt1);
    }
    if (paramInt2 > CardView.access$500(this$0)) {
      CardView.access$601(this$0, paramInt2);
    }
  }
  
  public void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    CardView.access$000(this$0).set(paramInt1, paramInt2, paramInt3, paramInt4);
    CardView.access$201(this$0, access$100this$0).left + paramInt1, access$100this$0).top + paramInt2, access$100this$0).right + paramInt3, access$100this$0).bottom + paramInt4);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.CardView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */