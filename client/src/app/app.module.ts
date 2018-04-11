import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AppComponent} from './app.component';
import {FanpageComponent} from './fanpage/fanpage.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {UsedPropListComponent} from './fanpage/used-prop-list/used-prop-list.component';
import {NewPropListComponent} from './fanpage/new-prop-list/new-prop-list.component';
import {NewPropDetailComponent} from './fanpage/new-prop-detail/new-prop-detail.component';
import {UsedPropDetailComponent} from './fanpage/used-prop-detail/used-prop-detail.component';
import {PropService} from './fanpage/prop.service';
import {CreateAdComponent} from './fanpage/create-ad/create-ad.component';
import {BidListComponent} from './fanpage/bid-list/bid-list.component';
import {FormsModule} from '@angular/forms';
import {LoginComponent} from './login/login.component';
import {TokenInterceptor} from './token-interceptor';
import {NavbarComponent} from './navbar/navbar.component';
import {AuthGuardService} from './auth-guard.service';
import {AuthService} from './auth.service';
import {AdminFanProfileComponent} from './fanpage/admin-fan-profile/admin-fan-profile.component';
import {RoleGuardService} from './role-guard.service';
import { ShowsTheatreComponent } from './shows/shows-theatre/shows-theatre.component';
import { ShowsCinemaComponent } from './shows/shows-cinema/shows-cinema.component';
import {MyAdsComponent} from './fanpage/my-ads/my-ads.component';
import {SharedService} from './fanpage/shared.service';
import { NewPropsConfigComponent } from './fanpage/admin-fan-profile/new-props-config/new-props-config.component';
import { UsedPropsConfigComponent } from './fanpage/admin-fan-profile/used-props-config/used-props-config.component';
import { CreateNewPropComponent } from './fanpage/admin-fan-profile/create-new-prop/create-new-prop.component';
import { RegistracijaComponent } from './registracija/registracija.component';
import {RegService} from './reg.service';
import { ProfilComponent } from './profil/profil.component';
import { NameChangeComponent } from './profil/name-change/name-change.component';
import { SurnameChangeComponent } from './profil/surname-change/surname-change.component';
import { EmailChangeComponent } from './profil/email-change/email-change.component';
import { CityChangeComponent } from './profil/city-change/city-change.component';
import { NumberChangeComponent } from './profil/number-change/number-change.component';
import { PasswordChangeComponent } from './profil/password-change/password-change.component';


@NgModule({
  declarations: [
    AppComponent,
    FanpageComponent,
    UsedPropListComponent,
    NewPropListComponent,
    NewPropDetailComponent,
    UsedPropDetailComponent,
    CreateAdComponent,
    BidListComponent,
    LoginComponent,
    NavbarComponent,
    AdminFanProfileComponent,
    ShowsTheatreComponent,
    ShowsCinemaComponent,
    MyAdsComponent,
    NewPropsConfigComponent,
    UsedPropsConfigComponent,
    CreateNewPropComponent,
    RegistracijaComponent,
    ProfilComponent,
    NameChangeComponent,
    SurnameChangeComponent,
    EmailChangeComponent,
    CityChangeComponent,
    NumberChangeComponent,
    PasswordChangeComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    PropService, {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    AuthGuardService,
    AuthService,
    RegService, 
    RoleGuardService,
    SharedService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
