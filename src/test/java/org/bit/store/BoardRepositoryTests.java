package org.bit.store;

import lombok.extern.log4j.Log4j2;
import org.bit.store.board.entity.Board;
import org.bit.store.board.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
@ActiveProfiles("dev")
public class BoardRepositoryTests {

    @Autowired
    BoardRepository boardRepository;
    @Test
    public void insertDummies(){
        IntStream.rangeClosed(1,100).forEach(todo->{
           Board board =  Board.builder()
                    .title("제목" + todo)
                    .content("content" + todo)
                    .writer("user" + todo)
                    .build();
            boardRepository.save(board);
        });
    }
}
