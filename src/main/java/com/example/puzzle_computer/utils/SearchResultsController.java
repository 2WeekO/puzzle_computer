package com.example.puzzle_computer.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchResultsController {
    @Autowired
    private final NaverShopSearch naverShopSearch;

    public SearchResultsController(NaverShopSearch naverShopSearch) {
        this.naverShopSearch = naverShopSearch;
    }
    
    @Autowired
    private NaverShopService naverShopService;

    @GetMapping("/shop/view/search")
    public String showSearchResults(@RequestParam String query, Model model) {
        // 네이버 API 호출
        String resultString = naverShopSearch.search(query);
        // API에서 가져온 JSON 응답을 데이터베이스에 저장
        List<ItemDto> items = naverShopService.saveItemsFromJson(resultString);
        // 저장된 데이터를 모델에 추가하여 뷰에 전달
        model.addAttribute("items", items);
        return "shop_view"; // HTML 템플릿의 파일명
    }

    @GetMapping("/shop/view/item")
    public String showComputerPart(@RequestParam String query, Model model) {
    
    String resultString = naverShopSearch.search(query);
        List<ItemDto> items = naverShopSearch.fromJSONtoItems(resultString);
        naverShopService.saveItems(items);
        model.addAttribute("items", items);
        return "shop_view";
    }
    
}
