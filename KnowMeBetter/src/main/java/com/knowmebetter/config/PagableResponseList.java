package com.knowmebetter.config;

import twitter4j.CursorSupport;
import twitter4j.ResponseList;

public interface PagableResponseList extends ResponseList, CursorSupport {
    boolean hasPrevious();

    long getPreviousCursor();

    boolean hasNext();

    long getNextCursor();

}
