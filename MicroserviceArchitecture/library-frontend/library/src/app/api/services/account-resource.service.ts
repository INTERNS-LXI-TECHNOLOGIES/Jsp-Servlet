/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { UserDTO } from '../models/user-dto';

/**
 * Account Resource
 */
@Injectable({
  providedIn: 'root',
})
class AccountResourceService extends __BaseService {
  static readonly getAccountUsingGETPath = '/api/account';
  static readonly isAuthenticatedUsingGETPath = '/api/authenticate';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @param name undefined
   * @return OK
   */
  getAccountUsingGETResponse(name?: string): __Observable<__StrictHttpResponse<UserDTO>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (name != null) __params = __params.set('name', name.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/account`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<UserDTO>;
      })
    );
  }
  /**
   * @param name undefined
   * @return OK
   */
  getAccountUsingGET(name?: string): __Observable<UserDTO> {
    return this.getAccountUsingGETResponse(name).pipe(
      __map(_r => _r.body as UserDTO)
    );
  }

  /**
   * @return OK
   */
  isAuthenticatedUsingGETResponse(): __Observable<__StrictHttpResponse<string>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/authenticate`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'text'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<string>;
      })
    );
  }
  /**
   * @return OK
   */
  isAuthenticatedUsingGET(): __Observable<string> {
    return this.isAuthenticatedUsingGETResponse().pipe(
      __map(_r => _r.body as string)
    );
  }
}

module AccountResourceService {
}

export { AccountResourceService }
