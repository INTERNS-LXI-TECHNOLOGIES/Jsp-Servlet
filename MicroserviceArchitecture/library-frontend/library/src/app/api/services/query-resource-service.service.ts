/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { Book } from '../models/book';
import { Category } from '../models/category';

/**
 * Query Resource Service
 */
@Injectable({
  providedIn: 'root',
})
class QueryResourceServiceService extends __BaseService {
  static readonly findAllBooksUsingGETPath = '/api/books';
  static readonly createBookUsingPOSTPath = '/api/books';
  static readonly findAllCategoryUsingGETPath = '/api/category';
  static readonly createCategoryUsingPOSTPath = '/api/category';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @return OK
   */
  findAllBooksUsingGETResponse(): __Observable<__StrictHttpResponse<Array<Book>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/books`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<Book>>;
      })
    );
  }
  /**
   * @return OK
   */
  findAllBooksUsingGET(): __Observable<Array<Book>> {
    return this.findAllBooksUsingGETResponse().pipe(
      __map(_r => _r.body as Array<Book>)
    );
  }

  /**
   * @param book book
   * @return OK
   */
  createBookUsingPOSTResponse(book: Book): __Observable<__StrictHttpResponse<Book>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = book;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/books`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Book>;
      })
    );
  }
  /**
   * @param book book
   * @return OK
   */
  createBookUsingPOST(book: Book): __Observable<Book> {
    return this.createBookUsingPOSTResponse(book).pipe(
      __map(_r => _r.body as Book)
    );
  }

  /**
   * @return OK
   */
  findAllCategoryUsingGETResponse(): __Observable<__StrictHttpResponse<Array<Category>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/category`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<Category>>;
      })
    );
  }
  /**
   * @return OK
   */
  findAllCategoryUsingGET(): __Observable<Array<Category>> {
    return this.findAllCategoryUsingGETResponse().pipe(
      __map(_r => _r.body as Array<Category>)
    );
  }

  /**
   * @param category category
   * @return OK
   */
  createCategoryUsingPOSTResponse(category: Category): __Observable<__StrictHttpResponse<Category>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = category;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/category`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Category>;
      })
    );
  }
  /**
   * @param category category
   * @return OK
   */
  createCategoryUsingPOST(category: Category): __Observable<Category> {
    return this.createCategoryUsingPOSTResponse(category).pipe(
      __map(_r => _r.body as Category)
    );
  }
}

module QueryResourceServiceService {
}

export { QueryResourceServiceService }
