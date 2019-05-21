import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor() { }

  getTodo(){
    return [
      {
        id:1,
        title:'Excercise',
        completed:true

      },
      {
        id:2,
        title:'Get ready',
        completed:false
      },
      {
        id:3,
        title:'Work',
        completed:false
      }
    ]
  }
}
