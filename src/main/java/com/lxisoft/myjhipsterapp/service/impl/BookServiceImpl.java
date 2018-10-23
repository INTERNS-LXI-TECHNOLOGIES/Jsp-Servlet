package com.lxisoft.myjhipsterapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lxisoft.myjhipsterapp.domain.Book;
import com.lxisoft.myjhipsterapp.domain.Category;
import com.lxisoft.myjhipsterapp.domain.Publisher;
import com.lxisoft.myjhipsterapp.repository.BookRepository;
import com.lxisoft.myjhipsterapp.repository.CategoryRepository;
import com.lxisoft.myjhipsterapp.repository.PublisherRepository;
import com.lxisoft.myjhipsterapp.service.BookService;
import com.lxisoft.myjhipsterapp.service.dto.BookDTO;
import com.lxisoft.myjhipsterapp.service.mapper.BookMapper;

/**
 * Service Implementation for managing Book.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

	private final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

	private final BookRepository bookRepository;
	@Autowired
	private PublisherRepository publisherRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	private final BookMapper bookMapper;

	public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
		this.bookRepository = bookRepository;
		this.bookMapper = bookMapper;
	}

	/**
	 * Save a book.
	 *
	 * @param bookDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public BookDTO save(BookDTO bookDTO) {
		log.debug("Request to save Book : {}", bookDTO);
		Book book = bookMapper.toEntity(bookDTO);
		book = bookRepository.save(book);
		return bookMapper.toDto(book);
	}

	/**
	 * Get all the books.
	 *
	 * @param pageable
	 *            the pagination information
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public Page<BookDTO> findAll(Pageable pageable) {
		log.debug("Request to get all Books");
		return bookRepository.findAll(pageable).map(bookMapper::toDto);
	}

	/**
	 * Get all the Book with eager load of many-to-many relationships.
	 *
	 * @return the list of entities
	 */
	@Override
	public Page<BookDTO> findAllWithEagerRelationships(Pageable pageable) {
		return bookRepository.findAllWithEagerRelationships(pageable).map(bookMapper::toDto);
	}

	/**
	 * Get one book by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<BookDTO> findOne(Long id) {
		log.debug("Request to get Book : {}", id);
		return bookRepository.findOneWithEagerRelationships(id).map(bookMapper::toDto);
	}

	/**
	 * Delete the book by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Book : {}", id);
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> findAllMyFavorite() {
		return bookRepository.findAllWithEagerRelationships();

	}

	@Override
	public List<Book> findAllByPublisher(String publisherName) {
		// TODO Auto-generated method stub
		Publisher publisher = publisherRepository.findByPublisherName(publisherName);
		return bookRepository.findAllNeededPublisherWiseBook(publisher);
	}

	@Override
	public List<Book> findAllByCategory(String categoryName) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findByCategoryName(categoryName);
		return bookRepository.findByCategories(category);
	}

	@Override
	public Optional<BookDTO> findByBookName(String name) {
		// TODO Auto-generated method stub
		return bookRepository.findByBookName(name).map(bookMapper::toDto);
	}

	@Override
	public Optional<List<BookDTO>> findByPrice(Integer price) {
		// TODO Auto-generated method stub
		return bookRepository.findAllByPrice(price).map(bookMapper::toDto);
	}

	@Override
	public Optional<List<BookDTO>> findByPublisher(String publisherName) {
		Publisher publisher = publisherRepository.findByPublisherName(publisherName);
		return bookRepository.findByPublisher(publisher).map(bookMapper::toDto);
	}

	@Override
	public Optional<List<BookDTO>> findByBookNameAndPrice(String bookName, Integer price) {
		// TODO Auto-generated method stub
		return bookRepository.findByBookNameAndPrice(bookName, price).map(bookMapper::toDto);
	}

	@Override
	public Optional<List<BookDTO>> findByBookNameOrPrice(String bookName, Integer price) {
		// TODO Auto-generated method stub
		return bookRepository.findByBookNameAndPrice(bookName, price).map(bookMapper::toDto);
	}

	@Override
	public Optional<List<BookDTO>> findByPriceLessThan(Integer price) {
		// TODO Auto-generated method stub
		return bookRepository.findByPriceLessThan(price).map(bookMapper::toDto);
	}

	@Override
	public Optional<List<BookDTO>> findByPriceLessThanEqual(Integer price) {
		// TODO Auto-generated method stub
		return bookRepository.findByPriceLessThanEqual(price).map(bookMapper::toDto);
	}

}
