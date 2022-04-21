import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {MDBBootstrapModule} from 'angular-bootstrap-md';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {HeaderComponent} from './components/navigation/header/header.component';
import {FooterComponent} from './components/navigation/footer/footer.component';
import {KanbanComponent} from './components/kanban/kanban.component';
import {HomeComponent} from './components/home/home.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatCardModule} from "@angular/material/card";
import {CardComponent} from './components/card/card.component';
import {MatIconModule} from "@angular/material/icon";
import {MatChipsModule} from "@angular/material/chips";
import {AddCardComponent} from './components/navigation/modal/add-card/add-card.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatDialogModule} from "@angular/material/dialog";
import {MatButtonModule} from "@angular/material/button";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {EditCardComponent} from './components/navigation/modal/edit-card/edit-card.component';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import { AddKanbanComponent } from './components/navigation/modal/add-kanban/add-kanban.component';
import {MatSelectModule} from "@angular/material/select";
import { AddUserComponent } from './components/navigation/modal/add-user/add-user.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    KanbanComponent,
    HomeComponent,
    CardComponent,
    AddCardComponent,
    EditCardComponent,
    AddKanbanComponent,
    AddUserComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MDBBootstrapModule.forRoot(),
    BrowserAnimationsModule,
    MatCardModule,
    MatIconModule,
    MatChipsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDialogModule,
    MatButtonModule,
    FormsModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    MatNativeDateModule,
    MatSelectModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
