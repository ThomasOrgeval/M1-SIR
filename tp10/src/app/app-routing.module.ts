import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import {KanbanComponent} from "./components/kanban/kanban.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'kanban/:id', component: KanbanComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
