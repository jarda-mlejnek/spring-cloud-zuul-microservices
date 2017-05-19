package com.jmlejnek.product.domain;

/**
 * Created by Jarda Mlejnek on 08.05.2017.
 */
public class Product {

    private Long id;
    private String nameI18N;
    private String description;
    private String url;
    private String imageUrl;
    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameI18N() {
        return nameI18N;
    }

    public void setNameI18N(String nameI18N) {
        this.nameI18N = nameI18N;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
