package com.app.appointment_app.commons.domain.components;

import java.util.List;

public interface Paginator<T> {
    List<T> getCurrentPage();
    boolean hasNextPage();
    boolean hasPreviousPage();
    void nextPage();
    void previousPage();
    int getCurrentPageNumber();
    int getTotalPages();
}