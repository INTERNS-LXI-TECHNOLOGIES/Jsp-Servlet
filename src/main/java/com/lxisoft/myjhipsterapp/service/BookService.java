package com.lxisoft.myjhipsterapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lxisoft.myjhipsterapp.domain.Book;
import com.lxisoft.myjhipsterapp.service.dto.BookDTO;

/**
 * Service Interface for managing Book.
 */
public interface BookService {

	/**
	 * Save a book.
	 *
	 * @param bookDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	BookDTO save(BookDTO bookDTO);

	/**
	 * Get all the books.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	Page<BookDTO> findAll(Pageable pageable);

	/**
	 * Get all the Book with eager load of many-to-many relationships.
	 *
	 * @return the list of entities
	 */
	Page<BookDTO> findAllWithEagerRelationships(Pageable pageable);

	/**
	 * Get the "id" book.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	Optional<BookDTO> findOne(Long id);

	/**
	 * Delete the "id" book.
	 *
	 * @param id
	 *            the id of the entity
	 */
	void delete(Long id);

	List<Book> findAllMyFavorite();

	List<Book> findAllByPublisher(String publisherName);

	List<Book> findAllByCategory(String categoryName);

	Optional<BookDTO> findByBookName(String name);

	Optional<List<BookDTO>> findByPrice(Integer price);

	Optional<List<BookDTO>> findByPublisher(String publisherName);

	Optional<List<BookDTO>> findByBookNameAndPrice(String bookName, Integer price);

	Optional<List<BookDTO>> findByBookNameOrPrice(String bookName, Integer price);

	Optional<List<BookDTO>> findByPriceLessThan(Integer price);

	Optional<List<BookDTO>> findByPriceLessThanEqual(Integer price);
}
