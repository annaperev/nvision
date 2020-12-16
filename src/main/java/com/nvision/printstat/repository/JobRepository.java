package com.nvision.printstat.repository;

import com.nvision.printstat.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>, JobRepositoryCustom {
}
