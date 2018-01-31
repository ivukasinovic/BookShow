import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {FanpageComponent} from './fanpage/fanpage.component';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import { UsedPropListComponent } from './fanpage/used-prop-list/used-prop-list.component';
import { NewPropListComponent } from './fanpage/new-prop-list/new-prop-list.component';
import { NewPropDetailComponent } from './fanpage/new-prop-detail/new-prop-detail.component';
import { UsedPropDetailComponent } from './fanpage/used-prop-detail/used-prop-detail.component';



@NgModule({
  declarations: [
    AppComponent,
    FanpageComponent,
    UsedPropListComponent,
    NewPropListComponent,
    NewPropDetailComponent,
    UsedPropDetailComponent
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
