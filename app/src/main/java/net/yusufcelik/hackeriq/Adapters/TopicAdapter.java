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
import net.yusufcelik.hackeriq.Models.Topic;
import java.util.List;

public class TopicAdapter extends BaseAdapter {
    private List<Topic> topicList;
    private Context context;
    private LayoutInflater layoutInflater;

    public TopicAdapter(Activity activity, List<Topic> model, Context context) {
        layoutInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.context=context;
        topicList=model;
    }

    @Override
    public int getCount() {
        return topicList.size();
    }

    @Override
    public Topic getItem(int position) {
        return topicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;

        rowView = layoutInflater.inflate(R.layout.custom_topic_list,null);

        TextView title=rowView.findViewById(R.id.topicTitle);
        TextView description=rowView.findViewById(R.id.topicDescription);
        Button btnCourseGo=rowView.findViewById(R.id.btnTopicGo);

        btnCourseGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v.getContext().startActivity(new Intent(context, LevelActivity.class));

            }
        });
        Topic model=topicList.get(position);

        title.setText(model.getTitle());
        description.setText(model.getDescription());


        return rowView;
    }


}
