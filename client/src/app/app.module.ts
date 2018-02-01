import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AppComponent} from './app.component';
import {FanpageComponent} from './fanpage/fanpage.component';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import { UsedPropListComponent } from './fanpage/used-prop-list/used-prop-list.component';
import { NewPropListComponent } from './fanpage/new-prop-list/new-prop-list.component';
import { NewPropDetailComponent } from './fanpage/new-prop-detail/new-prop-detail.component';
import { UsedPropDetailComponent } from './fanpage/used-prop-detail/used-prop-detail.component';
import {PropService} from './fanpage/prop.service';
import { CreateAdComponent } from './fanpage/create-ad/create-ad.component';



@NgModule({
  declarations: [
    AppComponent,
    FanpageComponent,
    UsedPropListComponent,
    NewPropListComponent,
    NewPropDetailComponent,
    UsedPropDetailComponent,
    CreateAdComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [PropService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
