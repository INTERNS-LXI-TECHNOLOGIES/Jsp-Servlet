import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { InventoryGatewaySharedLibsModule, InventoryGatewaySharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [InventoryGatewaySharedLibsModule, InventoryGatewaySharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [InventoryGatewaySharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class InventoryGatewaySharedModule {
  static forRoot() {
    return {
      ngModule: InventoryGatewaySharedModule
    };
  }
}
