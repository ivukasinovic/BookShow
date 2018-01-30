import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './/app-routing.module';
import {FunpageComponent} from './fanpage/funpage.component';
import {PropListComponent} from './fanpage/prop-list/prop-list.component';
import {PropDetailComponent} from './fanpage/prop-detail/prop-detail.component';
import {HttpClientModule} from '@angular/common/http';
import {FanpageService} from './fanpage/fanpage-services/fanpage.service';



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
  providers: [FanpageService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
