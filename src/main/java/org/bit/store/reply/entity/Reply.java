package org.bit.store.reply.entity;

import lombok.*;
import org.bit.store.board.entity.Board;

import javax.persistence.*;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    private String replyText;
    @ManyToOne
    private Board board;
}
