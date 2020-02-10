package com.ingerencia.test.models.service;

import com.ingerencia.test.models.entity.Hit;

import java.util.List;

public interface IHitService {

    public List<Hit> findAll();

    public List<Hit> saveAll(List<Hit> hits);

    public void delete(String id);
}
