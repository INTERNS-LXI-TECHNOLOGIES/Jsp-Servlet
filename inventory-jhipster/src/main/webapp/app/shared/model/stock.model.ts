import { IProduct } from 'app/shared/model/product.model';

export interface IStock {
  id?: number;
  quantity?: number;
  product?: IProduct;
}

export class Stock implements IStock {
  constructor(public id?: number, public quantity?: number, public product?: IProduct) {}
}
