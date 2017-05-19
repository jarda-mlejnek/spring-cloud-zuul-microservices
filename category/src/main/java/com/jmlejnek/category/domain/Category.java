package com.jmlejnek.category.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Jarda Mlejnek on 07.05.2017.
 */
public class Category {

    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String nameI18N;

    @NotNull
    @Size(min = 1, max = 255)
    private String url;

    @Size(max = 255)
    private String imageUrl;

    private int level;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    @Valid
    private Category parentCategory;

    @Valid
    private List<Category> subCategories;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }
}
