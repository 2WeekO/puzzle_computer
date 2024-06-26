package com.example.puzzle_computer.utils;




import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class NaverShopService {

    @Autowired
    private ItemDtoRepository itemDtoRepository;

    // 네이버 API에서 가져온 결과를 데이터베이스에 저장하는 메서드
    public List<ItemDto> saveItems(List<ItemDto> items) {
        return itemDtoRepository.saveAll(items);
    }

    // 네이버 API의 JSON 응답을 ItemDto 목록으로 변환하여 저장
    public List<ItemDto> saveItemsFromJson(String jsonResult) {
        // JSON 문자열을 ItemDto 객체로 변환하는 로직을 추가
        List<ItemDto> items = fromJSONtoItems(jsonResult);
        return itemDtoRepository.saveAll(items);
    }

    // JSON을 ItemDto 객체 리스트로 변환
    private List<ItemDto> fromJSONtoItems(String jsonResult) {
        JSONObject rjson = new JSONObject(jsonResult);
        JSONArray items  = rjson.getJSONArray("items");
        List<ItemDto> ret = new ArrayList<>();
        for (int i = 0; i < items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            ItemDto itemDto = new ItemDto(itemJson);
            ret.add(itemDto);
        }
        return ret;
    }
}
