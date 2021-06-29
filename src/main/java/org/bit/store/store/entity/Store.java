package org.bit.store.store.entity;

import lombok.*;
import org.bit.store.common.entity.BaseEntity;

import javax.persistence.*;

//store 이름 위도 경도 주소 주메뉴 등록일 수정일
@Entity
@Getter
@Builder
@Table(name = "store")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    private String latitude;
    private String longitude;
    private String address;
    private String mainMenu;

    public void change(String name,
                       String latitude,
                       String longitude,
                       String address,
                       String mainMenu) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.mainMenu = mainMenu;
    }
}
