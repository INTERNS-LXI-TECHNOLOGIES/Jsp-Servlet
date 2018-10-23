package com.lxisoft.myjhipsterapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lxisoft.myjhipsterapp.domain.Publisher;

/**
 * Spring Data repository for the Publisher entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

	@Query("select publisher from Publisher publisher where publisher.publisherName=:publisherName")
	Publisher findByPublisherName(@Param("publisherName") String publisherName);

}
