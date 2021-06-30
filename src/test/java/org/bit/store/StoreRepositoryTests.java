package org.bit.store;

import lombok.extern.log4j.Log4j2;
import org.bit.store.store.entity.Store;
import org.bit.store.store.repository.StoreRepository;
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
@ActiveProfiles("dev")
@Log4j2
public class StoreRepositoryTests {
    //CRUD
    @Autowired
    private StoreRepository storeRepository;

    // test
    @Test
    public void test() {
        log.info(storeRepository.getClass().getName() + "로그");
    }

    // create insert
    // 각각의 컬럼에 1~ 300 까지 데이터 추가

    @Test
    public void testCreate() {
        IntStream.rangeClosed(1,300).forEach(todo ->
        {
            Store store = Store.builder()
                    .name("가게이름" + todo)
                    .latitude("위도" + todo)
                    .longitude("경도" + todo)
                    .address("주소" + todo)
                    .mainMenu("주된메뉴" + todo)
                    .build();
            storeRepository.save(store);
        });
    }



    //read select
    // 18 번째 컬럼찾기
    @Test
    public void testRead() {
        Optional<Store> store = storeRepository.findById(150L);
//        log.info(store.get());
        store.ifPresent(todo -> log.info(todo));
    }

    // paging
    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

        Page<Store> result = storeRepository.findAll(pageable);

        log.info(result);

        result.getContent().forEach(todo -> {
            log.info(todo);
        });
    }

    @Test
    public void testUpdate() {
        Optional<Store> result = storeRepository.findById(25L);

        result.ifPresent(todo -> {
            todo.change("이름", "위도", "경도", "주소", "음식~");
            storeRepository.save(todo);
        });

    }

    @Test
    public void testDelete() {
        storeRepository.delete(Store.builder().id(29L).build());
    }

    @Test
    public void testUpdate2() {
        storeRepository.upadateContent("300..", 250L);
    }
    // 실행 x
}
