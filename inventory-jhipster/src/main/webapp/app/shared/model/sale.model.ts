import { IProduct } from 'app/shared/model/product.model';

export interface ISale {
  id?: number;
  quantity?: number;
  products?: IProduct[];
}

export class Sale implements ISale {
  constructor(public id?: number, public quantity?: number, public products?: IProduct[]) {}
}
