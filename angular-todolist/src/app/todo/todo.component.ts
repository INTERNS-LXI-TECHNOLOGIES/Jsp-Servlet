import { Component, OnInit } from '@angular/core';

import { Todo } from '../Todo';
import { TodoService } from '../services/todo.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todo:Todo[];
  constructor(private todoService:TodoService) { }

  ngOnInit() {
    this.todo=this.todoService.getTodo();
  }

}
