package com.example.puzzle_computer.product;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id; // 상품 코드

    @Column(unique = true)
    private int category_code; // 카테고리 코드

    private String product_name; // 상품 이름

    private String product_infor; // 상품 정보

    private int product_price; // 상품 가격

    private int product_stock; // 상품 갯수

    private LocalDateTime product_date; // 상품 등록 날짜 (최신순으로 정렬 가능)


}
