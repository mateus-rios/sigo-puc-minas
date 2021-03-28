import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-action-button',
  templateUrl: './action-button.component.html',
  styleUrls: ['./action-button.component.css']
})
export class ActionButtonComponent implements OnInit {

  @Input() labelWhileExecute: string
  @Input() label: string
  @Input() execute: boolean
  @Output() functionToExecute = new EventEmitter()

  constructor() { }

  ngOnInit(): void {
  }

  action() {
    this.functionToExecute.emit();
  }

}
