package com.example.charl.charleshellosigns.Tutorials;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.charl.charleshellosigns.R;

/**
 * Created by kialy on 30/05/2018.
 */

public class TimeSwipeAdapter extends PagerAdapter{
    private int [] image_resources = {R.drawable.heure1_2,R.drawable.heure2, R.drawable.heure3};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public TimeSwipeAdapter(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (RelativeLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);
        imageView.setImageResource(image_resources[position]);
        TextView aboutTextView = (TextView) item_view.findViewById(R.id.about_text_view);
        Spanned aboutText = Html.fromHtml("<h1> Tutoriel pour apprendre à donner l'heure en langage des signes "+"</h1>");
        aboutTextView.setText(aboutText);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
