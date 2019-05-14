import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ISale } from 'app/shared/model/sale.model';
import { SaleService } from './sale.service';

@Component({
  selector: 'jhi-sale-delete-dialog',
  templateUrl: './sale-delete-dialog.component.html'
})
export class SaleDeleteDialogComponent {
  sale: ISale;

  constructor(protected saleService: SaleService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.saleService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'saleListModification',
        content: 'Deleted an sale'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-sale-delete-popup',
  template: ''
})
export class SaleDeletePopupComponent implements OnInit, OnDestroy {
  protected ngbModalRef: NgbModalRef;

  constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ sale }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(SaleDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.sale = sale;
        this.ngbModalRef.result.then(
          result => {
            this.router.navigate(['/sale', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          },
          reason => {
            this.router.navigate(['/sale', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          }
        );
      }, 0);
    });
  }

  ngOnDestroy() {
    this.ngbModalRef = null;
  }
}
