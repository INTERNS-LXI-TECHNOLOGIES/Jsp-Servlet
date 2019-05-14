import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { ISale, Sale } from 'app/shared/model/sale.model';
import { SaleService } from './sale.service';
import { IProduct } from 'app/shared/model/product.model';
import { ProductService } from 'app/entities/product';

@Component({
  selector: 'jhi-sale-update',
  templateUrl: './sale-update.component.html'
})
export class SaleUpdateComponent implements OnInit {
  sale: ISale;
  isSaving: boolean;

  products: IProduct[];

  editForm = this.fb.group({
    id: [],
    quantity: [],
    products: []
  });

  constructor(
    protected jhiAlertService: JhiAlertService,
    protected saleService: SaleService,
    protected productService: ProductService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ sale }) => {
      this.updateForm(sale);
      this.sale = sale;
    });
    this.productService
      .query()
      .pipe(
        filter((mayBeOk: HttpResponse<IProduct[]>) => mayBeOk.ok),
        map((response: HttpResponse<IProduct[]>) => response.body)
      )
      .subscribe((res: IProduct[]) => (this.products = res), (res: HttpErrorResponse) => this.onError(res.message));
  }

  updateForm(sale: ISale) {
    this.editForm.patchValue({
      id: sale.id,
      quantity: sale.quantity,
      products: sale.products
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const sale = this.createFromForm();
    if (sale.id !== undefined) {
      this.subscribeToSaveResponse(this.saleService.update(sale));
    } else {
      this.subscribeToSaveResponse(this.saleService.create(sale));
    }
  }

  private createFromForm(): ISale {
    const entity = {
      ...new Sale(),
      id: this.editForm.get(['id']).value,
      quantity: this.editForm.get(['quantity']).value,
      products: this.editForm.get(['products']).value
    };
    return entity;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ISale>>) {
    result.subscribe((res: HttpResponse<ISale>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }

  trackProductById(index: number, item: IProduct) {
    return item.id;
  }

  getSelected(selectedVals: Array<any>, option: any) {
    if (selectedVals) {
      for (let i = 0; i < selectedVals.length; i++) {
        if (option.id === selectedVals[i].id) {
          return selectedVals[i];
        }
      }
    }
    return option;
  }
}
