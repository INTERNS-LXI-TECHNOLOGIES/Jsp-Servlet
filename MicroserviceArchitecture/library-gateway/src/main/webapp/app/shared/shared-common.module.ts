import { NgModule } from '@angular/core';

import { LibraryGatewaySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
  imports: [LibraryGatewaySharedLibsModule],
  declarations: [JhiAlertComponent, JhiAlertErrorComponent],
  exports: [LibraryGatewaySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class LibraryGatewaySharedCommonModule {}
