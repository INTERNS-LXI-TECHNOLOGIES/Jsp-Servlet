import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';

import { NgbDateMomentAdapter } from './util/datepicker-adapter';
import { LibraryGatewaySharedLibsModule, LibraryGatewaySharedCommonModule, HasAnyAuthorityDirective } from './';

@NgModule({
    imports: [LibraryGatewaySharedLibsModule, LibraryGatewaySharedCommonModule],
    declarations: [HasAnyAuthorityDirective],
    providers: [{ provide: NgbDateAdapter, useClass: NgbDateMomentAdapter }],
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
