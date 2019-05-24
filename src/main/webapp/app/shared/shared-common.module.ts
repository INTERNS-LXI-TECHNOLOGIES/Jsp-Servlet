import { NgModule } from '@angular/core';

import { InventoryGatewaySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
  imports: [InventoryGatewaySharedLibsModule],
  declarations: [JhiAlertComponent, JhiAlertErrorComponent],
  exports: [InventoryGatewaySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class InventoryGatewaySharedCommonModule {}
