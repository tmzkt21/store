package org.bit.store;

import lombok.extern.log4j.Log4j2;
import org.bit.store.board.entity.Board;
import org.bit.store.reply.entity.Reply;
import org.bit.store.reply.repository.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
@ActiveProfiles("dev")
public class ReplyRepositoryTests {
    @Autowired
    ReplyRepository replyRepository;

    @Test
    public void testInsult() {
        IntStream.rangeClosed(1, 20).forEach(todo -> {
//            long bno = (int)(Math.random()*200) + 1;
            Board board = Board.builder().bno(1180L).build();
            Reply reply = Reply.builder().replyText("쏘굿" + todo).board(board).build();
            replyRepository.save(reply);
        });
    }

    @Test
    public void testRead() {
        Optional<Reply> result = replyRepository.findById(1L);
        log.info(result);
        result.ifPresent(todo -> {
            log.info(todo);
        });
    }

    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0,10);
        Page<Reply> result = replyRepository.findAll(pageable);
        log.info(result);
        result.getContent().forEach(todo ->log.info(todo));
    }

}
