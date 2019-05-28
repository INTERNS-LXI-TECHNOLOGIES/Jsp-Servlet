import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { LibraryGatewaySharedLibsModule, LibraryGatewaySharedCommonModule, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [LibraryGatewaySharedLibsModule, LibraryGatewaySharedCommonModule],
  declarations: [HasAnyAuthorityDirective],
  exports: [LibraryGatewaySharedCommonModule, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class LibraryGatewaySharedModule {
  static forRoot() {
    return {
      ngModule: LibraryGatewaySharedModule
    };
  }
}
