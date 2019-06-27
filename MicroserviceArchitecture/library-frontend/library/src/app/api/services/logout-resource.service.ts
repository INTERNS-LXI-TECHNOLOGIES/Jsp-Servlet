/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';


/**
 * Logout Resource
 */
@Injectable({
  providedIn: 'root',
})
class LogoutResourceService extends __BaseService {
  static readonly logoutUsingPOSTPath = '/api/logout';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @param params The `LogoutResourceService.LogoutUsingPOSTParams` containing the following parameters:
   *
   * - `principal`:
   *
   * - `details`:
   *
   * - `credentials`:
   *
   * - `authorities[0].authority`:
   *
   * - `authenticated`:
   *
   * @return OK
   */
  logoutUsingPOSTResponse(params: LogoutResourceService.LogoutUsingPOSTParams): __Observable<__StrictHttpResponse<{}>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (params.principal != null) __params = __params.set('principal', params.principal.toString());
    if (params.details != null) __params = __params.set('details', params.details.toString());
    if (params.credentials != null) __params = __params.set('credentials', params.credentials.toString());
    if (params.authorities0Authority != null) __params = __params.set('authorities[0].authority', params.authorities0Authority.toString());
    if (params.authenticated != null) __params = __params.set('authenticated', params.authenticated.toString());
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/logout`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<{}>;
      })
    );
  }
  /**
   * @param params The `LogoutResourceService.LogoutUsingPOSTParams` containing the following parameters:
   *
   * - `principal`:
   *
   * - `details`:
   *
   * - `credentials`:
   *
   * - `authorities[0].authority`:
   *
   * - `authenticated`:
   *
   * @return OK
   */
  logoutUsingPOST(params: LogoutResourceService.LogoutUsingPOSTParams): __Observable<{}> {
    return this.logoutUsingPOSTResponse(params).pipe(
      __map(_r => _r.body as {})
    );
  }
}

module LogoutResourceService {

  /**
   * Parameters for logoutUsingPOST
   */
  export interface LogoutUsingPOSTParams {
    principal?: {};
    details?: {};
    credentials?: {};
    authorities0Authority?: string;
    authenticated?: boolean;
  }
}

export { LogoutResourceService }
