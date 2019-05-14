import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'product',
        loadChildren: './product/product.module#InventoryProductModule'
      },
      {
        path: 'sale',
        loadChildren: './sale/sale.module#InventorySaleModule'
      },
      {
        path: 'stock',
        loadChildren: './stock/stock.module#InventoryStockModule'
      },
      {
        path: 'product',
        loadChildren: './product/product.module#InventoryProductModule'
      },
      {
        path: 'sale',
        loadChildren: './sale/sale.module#InventorySaleModule'
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ],
  declarations: [],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class InventoryEntityModule {}
