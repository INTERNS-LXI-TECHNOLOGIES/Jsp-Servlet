package com.lxisoft.myjhipsterapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.lxisoft.myjhipsterapp.service.PublisherService;
import com.lxisoft.myjhipsterapp.web.rest.errors.BadRequestAlertException;
import com.lxisoft.myjhipsterapp.web.rest.util.HeaderUtil;
import com.lxisoft.myjhipsterapp.web.rest.util.PaginationUtil;
import com.lxisoft.myjhipsterapp.service.dto.PublisherDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Publisher.
 */
@RestController
@RequestMapping("/api")
public class PublisherResource {

    private final Logger log = LoggerFactory.getLogger(PublisherResource.class);

    private static final String ENTITY_NAME = "myjhipsterappPublisher";

    private final PublisherService publisherService;

    public PublisherResource(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    /**
     * POST  /publishers : Create a new publisher.
     *
     * @param publisherDTO the publisherDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new publisherDTO, or with status 400 (Bad Request) if the publisher has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/publishers")
    @Timed
    public ResponseEntity<PublisherDTO> createPublisher(@RequestBody PublisherDTO publisherDTO) throws URISyntaxException {
        log.debug("REST request to save Publisher : {}", publisherDTO);
        if (publisherDTO.getId() != null) {
            throw new BadRequestAlertException("A new publisher cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PublisherDTO result = publisherService.save(publisherDTO);
        return ResponseEntity.created(new URI("/api/publishers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /publishers : Updates an existing publisher.
     *
     * @param publisherDTO the publisherDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated publisherDTO,
     * or with status 400 (Bad Request) if the publisherDTO is not valid,
     * or with status 500 (Internal Server Error) if the publisherDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/publishers")
    @Timed
    public ResponseEntity<PublisherDTO> updatePublisher(@RequestBody PublisherDTO publisherDTO) throws URISyntaxException {
        log.debug("REST request to update Publisher : {}", publisherDTO);
        if (publisherDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PublisherDTO result = publisherService.save(publisherDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, publisherDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /publishers : get all the publishers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of publishers in body
     */
    @GetMapping("/publishers")
    @Timed
    public ResponseEntity<List<PublisherDTO>> getAllPublishers(Pageable pageable) {
        log.debug("REST request to get a page of Publishers");
        Page<PublisherDTO> page = publisherService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/publishers");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /publishers/:id : get the "id" publisher.
     *
     * @param id the id of the publisherDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the publisherDTO, or with status 404 (Not Found)
     */
    @GetMapping("/publishers/{id}")
    @Timed
    public ResponseEntity<PublisherDTO> getPublisher(@PathVariable Long id) {
        log.debug("REST request to get Publisher : {}", id);
        Optional<PublisherDTO> publisherDTO = publisherService.findOne(id);
        return ResponseUtil.wrapOrNotFound(publisherDTO);
    }

    /**
     * DELETE  /publishers/:id : delete the "id" publisher.
     *
     * @param id the id of the publisherDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/publishers/{id}")
    @Timed
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        log.debug("REST request to delete Publisher : {}", id);
        publisherService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
