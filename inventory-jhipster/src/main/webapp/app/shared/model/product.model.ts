import { IStock } from 'app/shared/model/stock.model';
import { ISale } from 'app/shared/model/sale.model';

export interface IProduct {
  id?: number;
  name?: string;
  price?: string;
  stock?: IStock;
  sales?: ISale[];
}

export class Product implements IProduct {
  constructor(public id?: number, public name?: string, public price?: string, public stock?: IStock, public sales?: ISale[]) {}
}
