package com.app.appointment_app.commons.domain.components;
import java.util.List;

public class ListPaginator<T> implements Paginator<T> {
    private List<T> items;
    private int itemsPerPage;
    private int currentPage;

    public ListPaginator(List<T> items, int itemsPerPage) {
        this.items = items;
        this.itemsPerPage = itemsPerPage;
        this.currentPage = 0;
    }

    @Override
    public List<T> getCurrentPage() {
        int startIndex = currentPage * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, items.size());
        return items.subList(startIndex, endIndex);
    }

    @Override
    public boolean hasNextPage() {
        return (currentPage + 1) * itemsPerPage < items.size();
    }

    @Override
    public boolean hasPreviousPage() {
        return currentPage > 0;
    }

    @Override
    public void nextPage() {
        if (hasNextPage()) {
            currentPage++;
        }
    }

    @Override
    public void previousPage() {
        if (hasPreviousPage()) {
            currentPage--;
        }
    }

    @Override
    public int getCurrentPageNumber() {
        return currentPage + 1;
    }

    @Override
    public int getTotalPages() {
        return (int) Math.ceil((double) items.size() / itemsPerPage);
    }
}
