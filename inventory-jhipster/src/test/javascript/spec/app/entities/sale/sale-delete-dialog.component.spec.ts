/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { InventoryTestModule } from '../../../test.module';
import { SaleDeleteDialogComponent } from 'app/entities/sale/sale-delete-dialog.component';
import { SaleService } from 'app/entities/sale/sale.service';

describe('Component Tests', () => {
  describe('Sale Management Delete Component', () => {
    let comp: SaleDeleteDialogComponent;
    let fixture: ComponentFixture<SaleDeleteDialogComponent>;
    let service: SaleService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [InventoryTestModule],
        declarations: [SaleDeleteDialogComponent]
      })
        .overrideTemplate(SaleDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(SaleDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(SaleService);
      mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
      mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));
    });
  });
});
