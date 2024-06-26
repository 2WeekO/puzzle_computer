package com.example.puzzle_computer.shop;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/shop")
@Controller
public class ShopController {
    @GetMapping("/view")
    public String shopview(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // 현재 사용자 이름 가져오기

        model.addAttribute("username", username); // 사용자 이름을 모델에 추가
        return "shop_view";
    }
    
}
