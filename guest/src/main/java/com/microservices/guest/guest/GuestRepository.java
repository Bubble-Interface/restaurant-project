package com.microservices.guest.guest;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.Optional;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Integer> {

    @Transactional
    @Modifying
    @Query("update Guest set reserved = true where id = :id")
    Integer reserveGuest(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("update Guest set reserved = false where id = :id")
    Integer cancelGuest(@Param("id") Integer id);
}
