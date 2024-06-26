package com.example.puzzle_computer.utils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ItemDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key로 사용할 필드
    
    private String title;
    private String link;
    private String image;
    private int lprice;
    private String brand;
    private String category;
    private String productId;

    public ItemDto(org.json.JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.link = itemJson.getString("link");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
        this.brand = itemJson.getString("brand");
        this.category = itemJson.getString("category3");
        this.productId = itemJson.getString("productId");
    }

    public ItemDto(String title, String link, String image, int lprice, String brand, String category, String productId) {
        this.title = title;
        this.link = link;
        this.image = image;
        this.lprice = lprice;
        this.brand = brand;
        this.category = category;
        this.productId = productId;
    }
}