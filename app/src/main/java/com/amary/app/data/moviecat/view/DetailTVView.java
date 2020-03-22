package com.amary.app.data.moviecat.view;

import com.amary.app.data.moviecat.model.DetailTv;
import com.amary.app.data.moviecat.model.GetImageTv;

public interface DetailTVView {
    void showLoading();
    void hideLoading();
    void onErrorLoading(String message);
    void onErrorData();
    void setDetailTv(DetailTv detailTv);
    void setImageTv(GetImageTv imageTv);
}
