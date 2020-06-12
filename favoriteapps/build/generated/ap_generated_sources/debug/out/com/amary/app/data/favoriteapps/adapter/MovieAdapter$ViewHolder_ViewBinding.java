// Generated code from Butter Knife. Do not modify!
package com.amary.app.data.favoriteapps.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.amary.app.data.favoriteapps.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MovieAdapter$ViewHolder_ViewBinding implements Unbinder {
  private MovieAdapter.ViewHolder target;

  @UiThread
  public MovieAdapter$ViewHolder_ViewBinding(MovieAdapter.ViewHolder target, View source) {
    this.target = target;

    target.imgPoster = Utils.findRequiredViewAsType(source, R.id.img_poster, "field 'imgPoster'", ImageView.class);
    target.imgBackdrops = Utils.findRequiredViewAsType(source, R.id.img_backdrops, "field 'imgBackdrops'", ImageView.class);
    target.txtJudul = Utils.findRequiredViewAsType(source, R.id.txt_judul, "field 'txtJudul'", TextView.class);
    target.txtTglRilis = Utils.findRequiredViewAsType(source, R.id.txt_tgl_rilis, "field 'txtTglRilis'", TextView.class);
    target.txtRating = Utils.findRequiredViewAsType(source, R.id.txt_rating, "field 'txtRating'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MovieAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgPoster = null;
    target.imgBackdrops = null;
    target.txtJudul = null;
    target.txtTglRilis = null;
    target.txtRating = null;
  }
}
