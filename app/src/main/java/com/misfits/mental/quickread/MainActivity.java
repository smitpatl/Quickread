package com.misfits.mental.quickread;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yalantis.flipviewpager.adapter.BaseFlipAdapter;
import com.yalantis.flipviewpager.utils.FlipSettings;
import com.yalantis.flipviewpager.view.FlipViewPager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        final ListView topics = (ListView) findViewById(R.id.topics_view);
        FlipSettings settings = new FlipSettings.Builder().defaultPage(1).build();
        topics.setAdapter(new TopicsAdapter(this, Utils.topics, settings));
        topics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Topic t = (Topic) topics.getAdapter().getItem(position);
                Toast.makeText(MainActivity.this, t.getTitle(), Toast.LENGTH_LONG).show();
            }
        });
    }
    class TopicsAdapter extends BaseFlipAdapter<Topic>
    {
        private final int PAGES = 3;
        private int[] IDS_TAGS = {R.id.interest_1, R.id.interest_2, R.id.interest_3, R.id.interest_4, R.id.interest_5};
        public TopicsAdapter(Context context, List<Topic> items, FlipSettings settings)
        {
           super(context, items, settings);
        }
        @Override
        public View getPage(int position, View convertView, ViewGroup parent, Topic item1, Topic item2) {
            final TopicsHolder holder;

            if(convertView==null)
            {
                holder = new TopicsHolder();
                convertView = getLayoutInflater().inflate(R.layout.topics_merge_page,parent,false);
                holder.leftImage = (ImageView) convertView.findViewById(R.id.first);
                holder.rightImage = (ImageView) convertView.findViewById(R.id.second);
                holder.infoPage = getLayoutInflater().inflate(R.layout.topics_info, parent, false);
                holder.title = (TextView) holder.infoPage.findViewById(R.id.nickname);
                for (int id : IDS_TAGS)
                    holder.tags2.add((TextView) holder.infoPage.findViewById(id));

                convertView.setTag(holder);
            }
            else
            {
                holder = (TopicsHolder)convertView.getTag();
            }
            switch (position) {
                // Merged page with 2 friends
                case 1:
                    holder.leftImage.setImageResource(((Topic) item1).getImage());
                    if (item2 != null)
                        holder.rightImage.setImageResource(((Topic) item2).getImage());
                    break;
                default:
                    fillHolder(holder, position == 0 ? (Topic) item1 : (Topic) item2);
                    holder.infoPage.setTag(holder);
                    return holder.infoPage;
            }
            return convertView;
        }

        @Override
        public int getPagesCount() {
            return PAGES;
        }
        private void fillHolder(TopicsHolder holder, Topic topic) {
            if (topic == null)
                return;
            Iterator<TextView> iViews = holder.tags2.iterator();
            Iterator<String> iInterests = topic.getTags().iterator();
            while (iViews.hasNext() && iInterests.hasNext())
                iViews.next().setText(iInterests.next());
            holder.infoPage.setBackgroundColor(getResources().getColor(topic.getBackground()));
            holder.title.setText(topic.getTitle());
        }
    }
    class TopicsHolder
    {
        ImageView leftImage;
        ImageView rightImage;
        View infoPage;

        List<TextView> tags2 = new ArrayList<>();
        TextView title;
    }

    public void openDrawer(View view)
    {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
    }
    public void closeDrawer(View view)
    {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }
}
