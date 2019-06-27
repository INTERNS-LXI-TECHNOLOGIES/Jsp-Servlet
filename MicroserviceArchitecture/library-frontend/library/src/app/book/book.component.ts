import { Component, OnInit, Input } from '@angular/core';
import { QueryResourceServiceService } from '../api/services';
import { Book } from '../api/models';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  books : Book[] = [];
  //@Input() book :Book;

  constructor(private query : QueryResourceServiceService) { }

  ngOnInit() {
    this.getAllBooks();
  }
  
  getAllBooks() : void{
    this.query.findAllBooksUsingGET()
    .subscribe(books => {
      this.books = books;
      console.log(books);
    })
  }
  createContact(name :string) : void{
    this.query.createBookUsingPOST({name} as Book)
    .subscribe(book => this.books.push(book));
  }
}
