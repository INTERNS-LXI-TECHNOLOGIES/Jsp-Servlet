package com.lxisoft.myjhipsterapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lxisoft.myjhipsterapp.domain.Book;
import com.lxisoft.myjhipsterapp.domain.Category;
import com.lxisoft.myjhipsterapp.domain.Publisher;

/**
 * Spring Data repository for the Book entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(value = "select distinct book from Book book left join fetch book.categories", countQuery = "select count(distinct book) from Book book")
	Page<Book> findAllWithEagerRelationships(Pageable pageable);

	@Query(value = "select distinct book from Book book left join fetch book.categories")
	List<Book> findAllWithEagerRelationships();

	@Query("select book from Book book left join fetch book.categories where book.id =:id")
	Optional<Book> findOneWithEagerRelationships(@Param("id") Long id);

	@Query("select book from Book book where book.publisher=:publisher")
	List<Book> findAllNeededPublisherWiseBook(@Param("publisher") Publisher publisher);

	/*
	 * @Query("select book from Book where category in (book.categories)=:category"
	 * ) List<Book> findAllNeededCategoryWiseBook(@Param("category") Category
	 * category);
	 */
	List<Book> findByCategories(Category category);

	Optional<Book> findByBookName(String name);

	Optional<List<Book>> findAllByPrice(Integer price);

	Optional<List<Book>> findByPublisher(Publisher publisher);

	Optional<List<Book>> findByBookNameAndPrice(String bookName, Integer price);

	Optional<List<Book>> findByBookNameOrPrice(String bookName, Integer price);

	Optional<List<Book>> findByPriceLessThan(Integer price);

	Optional<List<Book>> findByPriceLessThanEqual(Integer price);
}
