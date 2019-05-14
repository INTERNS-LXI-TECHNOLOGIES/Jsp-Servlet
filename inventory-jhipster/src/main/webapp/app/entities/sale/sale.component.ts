import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ISale } from 'app/shared/model/sale.model';
import { AccountService } from 'app/core';
import { SaleService } from './sale.service';

@Component({
  selector: 'jhi-sale',
  templateUrl: './sale.component.html'
})
export class SaleComponent implements OnInit, OnDestroy {
  sales: ISale[];
  currentAccount: any;
  eventSubscriber: Subscription;

  constructor(
    protected saleService: SaleService,
    protected jhiAlertService: JhiAlertService,
    protected eventManager: JhiEventManager,
    protected accountService: AccountService
  ) {}

  loadAll() {
    this.saleService
      .query()
      .pipe(
        filter((res: HttpResponse<ISale[]>) => res.ok),
        map((res: HttpResponse<ISale[]>) => res.body)
      )
      .subscribe(
        (res: ISale[]) => {
          this.sales = res;
        },
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  ngOnInit() {
    this.loadAll();
    this.accountService.identity().then(account => {
      this.currentAccount = account;
    });
    this.registerChangeInSales();
  }

  ngOnDestroy() {
    this.eventManager.destroy(this.eventSubscriber);
  }

  trackId(index: number, item: ISale) {
    return item.id;
  }

  registerChangeInSales() {
    this.eventSubscriber = this.eventManager.subscribe('saleListModification', response => this.loadAll());
  }

  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }
}
