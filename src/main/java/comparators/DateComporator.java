package comparators;

import models.News;

import java.util.Comparator;

public class DateComporator implements Comparator<News> {

    @Override
    public int compare(News o1, News o2) {
        if (o1.getDate().getTime() > o2.getDate().getTime()) {
            return -1;
        } else {
            if (o1.getDate().getTime() < o2.getDate().getTime()) {
                return 1;
            }
        }
        return 0;
    }
}
