package com.s3.prac.menu;

import com.s3.prac.dto.MenuRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/menus")
    public void create(@RequestBody MenuRequest request) {
        menuService.create(request);
    }

    @GetMapping("/menu")
    public String find() {
        return menuService.find();
    }

}
