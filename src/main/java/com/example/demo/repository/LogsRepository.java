package com.example.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Logs;

@Repository
public interface LogsRepository extends PagingAndSortingRepository<Logs, Long> {

}
