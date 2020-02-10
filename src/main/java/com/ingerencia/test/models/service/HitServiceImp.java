package com.ingerencia.test.models.service;

import com.ingerencia.test.models.dao.IHitDao;
import com.ingerencia.test.models.entity.Hit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class HitServiceImp implements IHitService{
    @Autowired
    IHitDao hitDao;

    @Override
    @Transactional(readOnly = true)
    public List<Hit> findAll() {
        return hitDao.findByDeleted(false);
    }

    @Override
    @Transactional
    public List<Hit> saveAll(List<Hit> hits){
        List<Hit> values=new ArrayList<>();
        for (Hit h: hits){
            if(!hitDao.existsById(h.getObjectID()))
                values.add(hitDao.save(h));
        }

        return values;
    }

    @Override
    @Transactional
    public void delete(String id) {
        hitDao.deletedHit(true,hitDao.findById(id).orElse(null));
    }


}
