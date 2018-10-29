package net.yusufcelik.hackeriq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.yusufcelik.hackeriq.Adapters.CategoryAdapter;
import net.yusufcelik.hackeriq.Adapters.TopicAdapter;
import net.yusufcelik.hackeriq.Models.Topic;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class TopicActivity extends AppCompatActivity {

    private ListView lstTopic;
    final List<Topic> topicList=new ArrayList<Topic>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);


        AndroidNetworking.get("http://hackeriq.yemrekeskin.com//api/v1/applications")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            List<JsonObject> objects=new ArrayList<JsonObject>();
                            for(int i=0;i<response.length();i++){
                                JsonObject o=new JsonParser().parse(response.get(i).toString()).getAsJsonObject();
                                topicList.add(new Topic(o.get("id").getAsInt(),o.get("name").getAsString(),o.get("description").getAsString()));
                            }
                            lstTopic=(ListView)findViewById(R.id.lwCourse);


                            TopicAdapter adapter=new TopicAdapter(TopicActivity.this,topicList,TopicActivity.this);
                            lstTopic.setAdapter(adapter);
                        }
                        catch (Exception e){

                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }
}
