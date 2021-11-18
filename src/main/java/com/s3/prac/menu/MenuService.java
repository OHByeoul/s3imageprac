package com.s3.prac.menu;

import com.s3.prac.domain.Menu;
import com.s3.prac.dto.MenuRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    @Transactional
    public void create(MenuRequest request) {
        String menuName = request.getMenuName();
        Integer price = request.getPrice();

        Menu createdMenu = Menu.createMenu(menuName, price);
        menuRepository.save(createdMenu);
    }

    public String find() {
        int random = (int)Math.random()*100;
        List<Menu> allMenu = menuRepository.findAll();
        int size = allMenu.size();
        if(size == 0)
            return "없음";
        int index = random%size;
        return allMenu.get(index).getName();
    }
}
