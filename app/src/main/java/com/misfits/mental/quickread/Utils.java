package com.misfits.mental.quickread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mahe on 7/17/2017.
 */

public class Utils {
    public static final List<Topic> topics = new ArrayList<>();

    static {
        topics.add(new Topic(R.drawable.tech, "TECH", R.color.sienna, "AI","Data Science", "Future", "Innovation", "Robotics"));
        topics.add(new Topic(R.drawable.design, "DESIGN", R.color.saffron, "Architecture", "UX", "UI", "Decoration", "Web Design"));
        topics.add(new Topic(R.drawable.culture, "CULTURE", R.color.green, "Music", "Film", "Media", "Pop culture", "Television"));
        topics.add(new Topic(R.drawable.news, "NEWS", R.color.pink, "Local", "World", "Politics", "Environment", "Current Events"));
        topics.add(new Topic(R.drawable.humor, "HUMOR", R.color.orange, "Comedy", "Satire", "Memes", "Cartoons", "Comics"));
        topics.add(new Topic(R.drawable.art, "ART", R.color.saffron, "Museum", "Film", "TV", "Philosophy", "Illustration"));
        topics.add(new Topic(R.drawable.fashion, "FASHION", R.color.green, "Style","Runway","Makeup","Lifestyle","Beauty"));
        topics.add(new Topic(R.drawable.science, "SCIENCE", R.color.purple, "Physics", "Biology", "Health", "Space", "Neuroscience"));
    }
}
