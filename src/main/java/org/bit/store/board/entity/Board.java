package org.bit.store.board.entity;

import lombok.*;
import org.bit.store.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Builder
@Table(name = "board")
@AllArgsConstructor
@NoArgsConstructor
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    private String title;

    private String content;

    private String writer;


}
