package com.nvision.printstat.repository;

import com.nvision.printstat.entity.Job;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JobRepositoryImpl implements JobRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Job> findByUserAndTypeAndDeviceAndTimeAfterAndTimeBefore(String user, String type, String device,
                                                                         LocalDateTime timeFrom, LocalDateTime timeTo) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Job> criteriaQuery = cb.createQuery(Job.class);
        Root<Job> jobRoot = criteriaQuery.from(Job.class);

        List<Predicate> filters = new ArrayList<>();

        if(user != null){
            filters.add(cb.equal(jobRoot.get("user"), user));
        }
        if(type != null){
            filters.add(cb.equal(jobRoot.get("type"), type));
        }
        if(device != null){
            filters.add(cb.equal(jobRoot.get("device"), device));
        }
        if(timeFrom != null){
            filters.add(cb.greaterThanOrEqualTo(jobRoot.get("time"), timeFrom));
        }

        if(timeTo != null){
            filters.add(cb.lessThanOrEqualTo(jobRoot.get("time"), timeTo));
        }

        criteriaQuery.where(cb.and(filters.toArray(new Predicate[]{})));

        TypedQuery<Job> q = em.createQuery(criteriaQuery);

        return q.getResultList();
    }
}
