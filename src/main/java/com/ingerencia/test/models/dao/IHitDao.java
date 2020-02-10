package com.ingerencia.test.models.dao;

import com.ingerencia.test.models.entity.Hit;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IHitDao extends CrudRepository<Hit,String> {
    public List<Hit> findByDeletedOrderByCreatedAtIDesc(boolean deleted);

    @Modifying
    @Query("update Hit h set h.deleted = ?1 where h = ?2")
    void deletedHit(boolean deleted,Hit hit);
}
