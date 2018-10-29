package net.yusufcelik.hackeriq.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import net.yusufcelik.hackeriq.R;


import net.yusufcelik.hackeriq.Models.Category;
import net.yusufcelik.hackeriq.TopicActivity;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private List<Category> categoryList;
    private Context context;
    private LayoutInflater layoutInflater;

    public CategoryAdapter(Activity activity, List<Category> model,Context context) {
        layoutInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.context=context;
        categoryList=model;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Category getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;

        rowView = layoutInflater.inflate(R.layout.custom_category_list,null);

        TextView title=rowView.findViewById(R.id.categoryTitle);
        TextView description=rowView.findViewById(R.id.categoryDescription);
        Button btnTechGo=rowView.findViewById(R.id.btnCategoryGo);

        btnTechGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(context, TopicActivity.class));

            }
        });
        Category model=categoryList.get(position);

        title.setText(model.getTitle());
        description.setText(model.getDescription());


        return rowView;
    }


}
