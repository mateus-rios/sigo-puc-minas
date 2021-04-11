import { Component, OnInit } from '@angular/core';
import { NormasService } from 'src/app/core/normas.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent implements OnInit {

  items: any[] = []
  constructor(
    private normasService: NormasService,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.normasService.listAll()
    .subscribe(
      res => {
        this.items = res
      }
    )
  }

  delete(item, index) {
    this.normasService.delete(item.id)
    .subscribe( () => {
      this.items.splice(index, 1)
      this.items = [...this.items]
      this.snackBar.open('Norma removida com sucesso', 'OK', { duration: 3000 })
    },
    () => {
      this.snackBar.open('Ocorreu um erro ao realizar a operação, tente novamente mais tarde', 'OK', { duration: 3000 })
    })
  }

}
