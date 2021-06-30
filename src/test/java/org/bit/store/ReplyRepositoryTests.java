package org.bit.store;

import lombok.extern.log4j.Log4j2;
import org.bit.store.board.entity.Board;
import org.bit.store.reply.entity.Reply;
import org.bit.store.reply.repository.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
@ActiveProfiles("dev")
public class ReplyRepositoryTests {
    @Autowired
    ReplyRepository replyRepository;

    @Test
    public void testInsult(){
        IntStream.rangeClosed(1,5).forEach(todo ->{
            Board board = Board.builder().bno(1L).build();
            Reply reply = Reply.builder().replyText("쏘굿"+todo).board(board).build();
            replyRepository.save(reply);
        });
    }

}
