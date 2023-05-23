package com.nexus.drone.notice.repository;


import com.nexus.drone.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

public interface NoticeRepository extends JpaRepository<Notice, UUID>, CrudRepository<Notice, UUID> {
    //List<Notice> findAllById(@Param("uid") Long id);
}