import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FanpageComponent} from './fanpage/fanpage.component';
import {UsedPropDetailComponent} from './fanpage/used-prop-detail/used-prop-detail.component';
import {NewPropDetailComponent} from './fanpage/new-prop-detail/new-prop-detail.component';
import {LoginComponent} from './login/login.component';
import {AuthGuardService} from './auth-guard.service';
import {AdminFanProfileComponent} from './fanpage/admin-fan-profile/admin-fan-profile.component';
import {RoleGuardService} from './role-guard.service';
import { ShowsTheatreComponent } from './shows/shows-theatre/shows-theatre.component';
import { ShowsCinemaComponent } from './shows/shows-cinema/shows-cinema.component';
import { CinemaRepertoireComponent } from './shows/shows-cinema/cinema-repertoire/cinema-repertoire.component';
import { NewMovieComponent } from './shows/shows-cinema/cinema-repertoire/new-movie/new-movie.component';
import {MyAdsComponent} from './fanpage/my-ads/my-ads.component';
import {BidListComponent} from './fanpage/bid-list/bid-list.component';
import {NewPropsConfigComponent} from './fanpage/admin-fan-profile/new-props-config/new-props-config.component';
import {UsedPropsConfigComponent} from './fanpage/admin-fan-profile/used-props-config/used-props-config.component';
import {CreateNewPropComponent} from './fanpage/admin-fan-profile/create-new-prop/create-new-prop.component';

const routes: Routes = [
  // ivan
  {path: 'login', component: LoginComponent},
  // fun page routes
  {path: 'fanpage/used-prop/:id', component: UsedPropDetailComponent},
  {path: 'fanpage/used-prop/:id/bids', component: BidListComponent},
  {path: 'fanpage/new-prop/:id', component: NewPropDetailComponent},
  {
    path: 'fanpage',
    component: FanpageComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'adminfan',
    component: AdminFanProfileComponent,
    canActivate: [RoleGuardService],
    data: {
      expectedRole: 'ADMINFAN'
    }
  },
  {path: 'fanpage/my-ads', component: MyAdsComponent},
  {path: 'adminfan/new-props-config', component: NewPropsConfigComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINFAN'}},
  {path: 'adminfan/new-prop', component: CreateNewPropComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINFAN'}},
  {path: 'adminfan/used-props-config', component: UsedPropsConfigComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINFAN'}},
  // vlada
  // marko
  {path: 'shows-theatre', component: ShowsTheatreComponent},
  {path: 'shows-cinema', component: ShowsCinemaComponent},
  {path: 'shows-cinema/:id', component: CinemaRepertoireComponent},
  {path: 'shows-cinema/:id/new-movie', component: NewMovieComponent}

];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule {
}
