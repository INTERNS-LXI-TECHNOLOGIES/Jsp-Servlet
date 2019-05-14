import { NgModule } from '@angular/core';

import { InventorySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
  imports: [InventorySharedLibsModule],
  declarations: [JhiAlertComponent, JhiAlertErrorComponent],
  exports: [InventorySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class InventorySharedCommonModule {}
