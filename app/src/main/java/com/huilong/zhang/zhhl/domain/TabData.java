package com.huilong.zhang.zhhl.domain;

import java.util.ArrayList;

/**
 * Created by Mario on 4/4/16.
 */
public class TabData {
    public  int retcode;
    public  TabDetail data;

    @Override
    public String toString() {
        return "TabData{" +
                "retcode=" + retcode +
                ", data=" + data +
                '}';
    }

    public class TabDetail{
        public String title;
        public String more;
        public ArrayList<TabNewsData> news;
        public ArrayList<TopNewsData> topnews;
        @Override
        public String toString() {
            return "TabDetail{" +
                    "title='" + title + '\'' +
                    ", more='" + more + '\'' +
                    ", news=" + news +
                    ", topnews=" + topnews +
                    '}';
        }
    }
    public class TabNewsData{
        public  String id;
        public  String listimage;
        public  String puddate;
        public  String title;
        public  String type;

        @Override
        public String toString() {
            return "TabNewsData{" +
                    "id='" + id + '\'' +
                    ", listimage='" + listimage + '\'' +
                    ", puddate='" + puddate + '\'' +
                    ", title='" + title + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

    //头条新闻
    public class TopNewsData{
        public String id;
        public String topimage;
        public String puddate;
        public String title;
        public String type;
        public String url;

        @Override
        public String toString() {
            return "TopNewsData{" +
                    "id='" + id + '\'' +
                    ", topimage='" + topimage + '\'' +
                    ", puddate='" + puddate + '\'' +
                    ", title='" + title + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
