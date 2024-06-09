package com.commerce.backend.model.request.product;

import lombok.Data;

@Data
public class CreateProductRequest {

    public Long productCategoryId;

    public String sku;

    public String name;

    private String url;

    private String longDesc;

}
