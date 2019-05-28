import { NgModule } from '@angular/core';

import { LibrarySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [LibrarySharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [LibrarySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class LibrarySharedCommonModule {}
