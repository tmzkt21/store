package org.bit.store.store.entity;

import lombok.*;
import org.bit.store.common.entity.BaseEntity;

import javax.persistence.*;

//store 이름 위도 경도 주소 주메뉴 등록일 수정일
// jdbc 드라이버는 디비버전에맞춰서
@Entity
// 테이블목적 @Entity  pk 를 접으면 index 트리구조 찾는 속도가중요함
@Getter
@Builder
@Table(name = "store")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //IDENTITY 디비정책에맡기겠다
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
