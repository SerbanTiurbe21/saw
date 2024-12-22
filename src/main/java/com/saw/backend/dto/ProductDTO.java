package com.saw.backend.dto;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class ProductDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(nullable = false, length = 255)
    private String productName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryDTO category;

    @Column(nullable = false)
    private Double price;

    private Integer stock;

    @OneToMany(mappedBy = "product")
    private List<ProductDetailDTO> productDetails;

    @OneToMany(mappedBy = "product")
    private List<OrderItemDTO> orderItems;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<ProductDetailDTO> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetailDTO> productDetails) {
        this.productDetails = productDetails;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
