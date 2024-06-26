package com.example.puzzle_computer.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SearchRequestController {

    @Autowired
    private NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
    public List<ItemDto> searchItems(@RequestParam String query) {
        // 네이버 API 호출
        String resultString = naverShopSearch.search(query);
        // JSON 결과를 ItemDto 리스트로 변환
        return naverShopSearch.fromJSONtoItems(resultString);
    }
}

