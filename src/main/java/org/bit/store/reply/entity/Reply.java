package org.bit.store.reply.entity;

import lombok.*;
import org.bit.store.board.entity.Board;
import org.bit.store.common.entity.BaseEntity;

import javax.persistence.*;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"board"})
// @ManyToOne(fetch = FetchType.LAZY) 레이지사용시 연관관계에있는  exculde  지정한 것에 투스트링을 빼주는것
@Table(name = "reply")
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String replyText;
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
}
