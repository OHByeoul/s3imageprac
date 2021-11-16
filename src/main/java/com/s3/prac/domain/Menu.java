package com.s3.prac.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {
    @Id @GeneratedValue
    private Long id;

    private String name;

    private Integer price;

    @OneToOne
    @JoinColumn(name="category_id")
    private Category category;

    public static Menu createMenu(String menuName, Integer price) {
        return Menu.builder()
                .name(menuName)
                .price(price)
                .build();
    }
}
