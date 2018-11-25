package com.utdallas.movierental.domain;

public abstract class ItemDecorator implements Item {

    private Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public String getTitle() {
        return item.getTitle();
    }

    @Override
    public void setTitle(String title) {
        item.setTitle(title);
    }

    @Override
    public CategoryType getCategoryType() {
        return item.getCategoryType();
    }

    @Override
    public void setCategoryType(CategoryType categoryType) {
        item.setCategoryType(categoryType);
    }
}
