package com.s3.prac.menu;

import com.s3.prac.dto.MenuRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @PostMapping("/menus")
    public ResponseEntity create(@RequestBody MenuRequest request) {
        menuService.create(request);
        return ResponseEntity.ok().body("done");
    }

    @ResponseBody
    @GetMapping("/menu")
    public String find(Model model) {
        return menuService.find();
    }

}
