/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { InventoryTestModule } from '../../../test.module';
import { SaleDetailComponent } from 'app/entities/sale/sale-detail.component';
import { Sale } from 'app/shared/model/sale.model';

describe('Component Tests', () => {
  describe('Sale Management Detail Component', () => {
    let comp: SaleDetailComponent;
    let fixture: ComponentFixture<SaleDetailComponent>;
    const route = ({ data: of({ sale: new Sale(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [InventoryTestModule],
        declarations: [SaleDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(SaleDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(SaleDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.sale).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
