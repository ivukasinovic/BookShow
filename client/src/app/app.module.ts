import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './/app-routing.module';
import {FunpageComponent} from './funpage/funpage.component';
import {PropListComponent} from './funpage/prop-list/prop-list.component';
import {PropDetailComponent} from './funpage/prop-detail/prop-detail.component';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    FunpageComponent,
    PropListComponent,
    PropDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
