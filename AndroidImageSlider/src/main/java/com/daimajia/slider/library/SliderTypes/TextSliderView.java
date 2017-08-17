package com.daimajia.slider.library.SliderTypes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.slider.library.R;

/**
 * This is a slider with a description TextView.
 */
public class TextSliderView extends BaseSliderView {

    private boolean showDes = false;

    public TextSliderView(Context context) {
        super(context);
    }

    public TextSliderView(Context context, boolean showDes) {
        super(context);
        this.showDes = showDes;
    }

    @Override
    public View getView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.render_type_text, null);
        ImageView target = (ImageView) v.findViewById(R.id.daimajia_slider_image);
        LinearLayout ll_des = ((LinearLayout) v.findViewById(R.id.description_layout));
        if (showDes) {
            ll_des.setVisibility(View.VISIBLE);
        } else {
            ll_des.setVisibility(View.GONE);
        }
        TextView description = (TextView) v.findViewById(R.id.description);
        description.setText(getDescription());
        bindEventAndShow(v, target);
        return v;
    }
}
