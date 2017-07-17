package com.misfits.mental.quickread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mahe on 7/17/2017.
 */

public class Topic {
    private int image;
    private String title;
    private int background;
    private List<String> tags = new ArrayList<>();

    public Topic(int image, String title, int background, String... tag)
    {
        this.image = image;
        this.title = title;
        this.background = background;
        tags.addAll(Arrays.asList(tag));
    }

    public int getImage()
    {
        return image;
    }
    public String getTitle()
    {
        return title;
    }
    public int getBackground()
    {
        return background;
    }
    public List<String> getTags()
    {
        return tags;
    }
}
