package com.lxisoft.myjhipsterapp.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.lxisoft.myjhipsterapp.domain.Book;
import com.lxisoft.myjhipsterapp.service.BookService;
import com.lxisoft.myjhipsterapp.service.dto.BookDTO;
import com.lxisoft.myjhipsterapp.web.rest.errors.BadRequestAlertException;
import com.lxisoft.myjhipsterapp.web.rest.util.HeaderUtil;
import com.lxisoft.myjhipsterapp.web.rest.util.PaginationUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing Book.
 */
@RestController
@RequestMapping("/api")
public class BookResource {

	private final Logger log = LoggerFactory.getLogger(BookResource.class);

	private static final String ENTITY_NAME = "myjhipsterappBook";

	private final BookService bookService;

	public BookResource(BookService bookService) {
		this.bookService = bookService;
	}

	/**
	 * POST /books : Create a new book.
	 *
	 * @param bookDTO
	 *            the bookDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new bookDTO, or with status 400 (Bad Request) if the book has
	 *         already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PostMapping("/books")
	@Timed
	public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) throws URISyntaxException {
		log.debug("REST request to save Book : {}", bookDTO);
		if (bookDTO.getId() != null) {
			throw new BadRequestAlertException("A new book cannot already have an ID", ENTITY_NAME, "idexists");
		}
		BookDTO result = bookService.save(bookDTO);
		return ResponseEntity.created(new URI("/api/books/" + result.getId()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
	}

	/**
	 * PUT /books : Updates an existing book.
	 *
	 * @param bookDTO
	 *            the bookDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         bookDTO, or with status 400 (Bad Request) if the bookDTO is not
	 *         valid, or with status 500 (Internal Server Error) if the bookDTO
	 *         couldn't be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	@PutMapping("/books")
	@Timed
	public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO) throws URISyntaxException {
		log.debug("REST request to update Book : {}", bookDTO);
		if (bookDTO.getId() == null) {
			throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
		}
		BookDTO result = bookService.save(bookDTO);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, bookDTO.getId().toString()))
				.body(result);
	}

	/**
	 * GET /books : get all the books.
	 *
	 * @param pageable
	 *            the pagination information
	 * @param eagerload
	 *            flag to eager load entities from relationships (This is
	 *            applicable for many-to-many)
	 * @return the ResponseEntity with status 200 (OK) and the list of books in
	 *         body
	 */
	@GetMapping("/books")
	@Timed
	public ResponseEntity<List<BookDTO>> getAllBooks(Pageable pageable,
			@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
		log.debug("REST request to get a page of Books");
		Page<BookDTO> page;
		if (eagerload) {
			page = bookService.findAllWithEagerRelationships(pageable);
		} else {
			page = bookService.findAll(pageable);
		}
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page,
				String.format("/api/books?eagerload=%b", eagerload));
		return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}

	/**
	 * GET /books/:id : get the "id" book.
	 *
	 * @param id
	 *            the id of the bookDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         bookDTO, or with status 404 (Not Found)
	 */
	@GetMapping("/books/{id}")
	@Timed
	public ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
		log.debug("REST request to get Book : {}", id);
		Optional<BookDTO> bookDTO = bookService.findOne(id);
		return ResponseUtil.wrapOrNotFound(bookDTO);
	}

	/**
	 * DELETE /books/:id : delete the "id" book.
	 *
	 * @param id
	 *            the id of the bookDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@DeleteMapping("/books/{id}")
	@Timed
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		log.debug("REST request to delete Book : {}", id);
		bookService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}

	@GetMapping("/mybooks")
	@Timed
	public void getAllFavoriteBooks(Pageable pageable,
			@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
		log.debug("REST request to get a page of Books");

		List<Book> booklist = bookService.findAllMyFavorite();
		for (Book book : booklist) {
			System.out.println("################");
			System.out.println(book);
		}

		// return new ResponseEntity<>(page.getContent(), headers,
		// HttpStatus.OK);
	}

	@GetMapping("/mypublisherbooks")
	@Timed
	public void getAllPublisherWiseBooks(Pageable pageable,
			@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
		log.debug("REST request to get a page of Books");

		List<Book> booklist = bookService.findAllByPublisher("DC Books");
		for (Book book : booklist) {
			System.out.println("################");
			System.out.println(book);
		}

		// return new ResponseEntity<>(page.getContent(), headers,
		// HttpStatus.OK);
	}

	@GetMapping("/mycategorybooks")
	@Timed
	public void getAllCategoryWiseBooks(Pageable pageable,
			@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
		log.debug("REST request to get a page of Books");

		List<Book> booklist = bookService.findAllByCategory("programming");
		for (Book book : booklist) {
			System.out.println("################");
			System.out.println(book);
		}

		// return new ResponseEntity<>(page.getContent(), headers,
		// HttpStatus.OK);
	}

	@GetMapping("/bookByName/{name}")
	@Timed
	public ResponseEntity<BookDTO> getBookByName(@PathVariable String name) {
		log.debug("REST request to get a page of Books");

		return ResponseUtil.wrapOrNotFound(bookService.findByBookName("The devil"));

		// return new ResponseEntity<>(page.getContent(), headers,
		// HttpStatus.OK);
	}

	@GetMapping("/bookByPrice/{price}")
	@Timed
	public ResponseEntity<List<BookDTO>> getBookByPrice(@PathVariable Integer price) {
		log.debug("Rest request to get book by price");
		return ResponseUtil.wrapOrNotFound(bookService.findByPrice(price));
	}

	@GetMapping("/bookByPublisher/{name}")
	@Timed
	public ResponseEntity<List<BookDTO>> getBookByPublisher(@PathVariable String name) {
		log.debug("Rest request to ger book by publisher");
		System.out.println("ruhail");
		return ResponseUtil.wrapOrNotFound(bookService.findByPublisher(name));
	}

	@GetMapping("/bookByBookNameAndPrice/{bookName}/{price}")
	@Timed
	public ResponseEntity<List<BookDTO>> getBookByBookNameAndPrice(@PathVariable String bookName,
			@PathVariable Integer price) {
		log.debug("Rest request to get book by book name and price");
		return ResponseUtil.wrapOrNotFound(bookService.findByBookNameAndPrice(bookName, price));
	}

	@GetMapping("/bookByBookNameOrPrice/{bookName}/{price}")
	@Timed
	public ResponseEntity<List<BookDTO>> getBookByBookNameOrPrice(@PathVariable String bookName,
			@PathVariable Integer price) {
		log.debug("Rest request to get book by book name and price");
		return ResponseUtil.wrapOrNotFound(bookService.findByBookNameAndPrice(bookName, price));
	}

	@GetMapping("/bookByPriceLessThan/{price}")
	@Timed
	public ResponseEntity<List<BookDTO>> getBookByPriceLessThan(@PathVariable Integer price) {
		log.debug("Rest request to get book by price less than");
		return ResponseUtil.wrapOrNotFound(bookService.findByPriceLessThan(price));
	}

	@GetMapping("/bookByPriceLessThanEqual/{price}")
	@Timed
	public ResponseEntity<List<BookDTO>> getBookByPriceLessThanEqual(@PathVariable Integer price) {
		log.debug("Rest request to get book by price less than equal");
		return ResponseUtil.wrapOrNotFound(bookService.findByPriceLessThanEqual(price));
	}
}
