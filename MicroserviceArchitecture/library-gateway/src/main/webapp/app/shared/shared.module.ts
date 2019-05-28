import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';

import { NgbDateMomentAdapter } from './util/datepicker-adapter';
import { LibrarySharedLibsModule, LibrarySharedCommonModule, HasAnyAuthorityDirective } from './';

@NgModule({
    imports: [LibrarySharedLibsModule, LibrarySharedCommonModule],
    declarations: [HasAnyAuthorityDirective],
    providers: [{ provide: NgbDateAdapter, useClass: NgbDateMomentAdapter }],
    exports: [LibrarySharedCommonModule, HasAnyAuthorityDirective],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class LibrarySharedModule {
    static forRoot() {
        return {
            ngModule: LibrarySharedModule
        };
    }
}
