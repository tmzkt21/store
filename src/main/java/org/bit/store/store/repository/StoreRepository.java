package org.bit.store.store.repository;

import org.bit.store.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface StoreRepository extends JpaRepository<Store,Long> {

    @Modifying
    @Query("update Store set name =:name where id =:id")
    void upadateContent(String name , Long id);

}
