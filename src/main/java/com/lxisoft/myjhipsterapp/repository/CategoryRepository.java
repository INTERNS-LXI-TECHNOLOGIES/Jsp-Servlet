package com.lxisoft.myjhipsterapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lxisoft.myjhipsterapp.domain.Category;

/**
 * Spring Data repository for the Category entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("select category from Category category where category.categoryName=:categoryName")
	Category findByCategoryName(@Param("categoryName") String categoryName);

}
