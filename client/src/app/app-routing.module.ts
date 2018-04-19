import { EditProjectionComponent } from './shows/shows-cinema/cinema-repertoire/edit-projection/edit-projection.component';
import { EditShowComponent } from './shows/edit-show/edit-show.component';
import { BuisnessReportComponent } from './shows/shows-cinema/cinema-repertoire/buisness-report/buisness-report.component';
import { NewProjectionComponent } from './shows/shows-cinema/cinema-repertoire/new-projection/new-projection.component';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FanpageComponent} from './fanpage/fanpage.component';
import {UsedPropDetailComponent} from './fanpage/used-prop-detail/used-prop-detail.component';
import {LoginComponent} from './login/login.component';
import {RegistracijaComponent}  from './registracija/registracija.component';
import {AuthGuardService} from './auth-guard.service';
import {AdminFanProfileComponent} from './fanpage/admin-fan-profile/admin-fan-profile.component';
import {RoleGuardService} from './role-guard.service';
import { ShowsCinemaComponent } from './shows/shows-cinema/shows-cinema.component';
import { CinemaRepertoireComponent } from './shows/shows-cinema/cinema-repertoire/cinema-repertoire.component';
import { NewMovieComponent } from './shows/shows-cinema/cinema-repertoire/new-movie/new-movie.component';
import {MyAdsComponent} from './fanpage/my-ads/my-ads.component';
import {BidListComponent} from './fanpage/bid-list/bid-list.component';
import {NewPropsConfigComponent} from './fanpage/admin-fan-profile/new-props-config/new-props-config.component';
import {UsedPropsConfigComponent} from './fanpage/admin-fan-profile/used-props-config/used-props-config.component';
import {CreateNewPropComponent} from './fanpage/admin-fan-profile/create-new-prop/create-new-prop.component';
import {ProfilComponent}  from './profil/profil.component';
import { NameChangeComponent } from './profil/name-change/name-change.component';
import { SurnameChangeComponent } from './profil/surname-change/surname-change.component';
import { EmailChangeComponent } from './profil/email-change/email-change.component';
import { CityChangeComponent } from './profil/city-change/city-change.component';
import { NumberChangeComponent } from './profil/number-change/number-change.component';
import { PasswordChangeComponent } from './profil/password-change/password-change.component';
import {PersonalEditComponent} from './fanpage/admin-fan-profile/personal-edit/personal-edit.component';
import {ChangePasswordComponent} from './fanpage/admin-fan-profile/change-password/change-password.component';
import { EditMovieComponent } from './shows/shows-cinema/cinema-repertoire/edit-movie/edit-movie.component';
import {AdminSysComponent} from './admin-sys/admin-sys.component';
import {RegisterShowComponent} from './admin-sys/register-show/register-show.component';
import {RegisterAdminComponent} from './admin-sys/register-admin/register-admin.component';
import {HomePageComponent} from './profil/home-page/home-page.component';
import {FriendsComponent} from './profil/friends/friends.component';
import {SearchUsersComponent} from './profil/friends/search-users/search-users.component';
import { ProfileOtherUserComponent } from './profil/profile-other-user/profile-other-user.component';
import { RequestsComponent } from './profil/friends/requests/requests.component';
import { PendingComponent } from './profil/friends/pending/pending.component';
import {ReservedPropsListComponent} from './fanpage/reserved-props-list/reserved-props-list.component';
import {SetRatingComponent} from './admin-sys/set-rating/set-rating.component';


const routes: Routes = [
  // ivan
  {path: 'login', component: LoginComponent},
  {path: 'fanpage/used-prop/:id', component: UsedPropDetailComponent},
  {path: 'fanpage/used-prop/:id/bids', component: BidListComponent},
  {path: 'fanpage/my-reserved-props', component: ReservedPropsListComponent},
  {path: 'fanpage', component: FanpageComponent,
    canActivate: [AuthGuardService], data: {expectedRole: 'ADMINFAN'}},
  {path: 'adminfan', component: AdminFanProfileComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINFAN'}},
  {path: 'fanpage/my-ads', component: MyAdsComponent},
  {path: 'adminfan/new-props-config', component: NewPropsConfigComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINFAN'}},
  {path: 'adminfan/new-prop', component: CreateNewPropComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINFAN'}},
  {path: 'adminfan/edit-new-prop/:id', component: CreateNewPropComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINFAN'}},
  {path: 'adminfan/used-props-config', component: UsedPropsConfigComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINFAN'}},
  {path: 'adminfan/personal-edit', component: PersonalEditComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINFAN'}},
  {path: 'adminfan/change-password', component: ChangePasswordComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINFAN'}},
  {path: 'adminsys', component: AdminSysComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINSYS'}},
  {path: 'adminsys/register-show', component: RegisterShowComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINSYS'}},
  {path: 'adminsys/register-admin', component: RegisterAdminComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINSYS'}},
  {path: 'adminsys/set-rating', component: SetRatingComponent,
    canActivate: [RoleGuardService], data: {expectedRole: 'ADMINSYS'}},
  // jovas
  {path: 'registracija', component: RegistracijaComponent},
  {path: 'search-users', component: SearchUsersComponent},
  {path: 'requests', component: RequestsComponent},
  {path: 'pending', component: PendingComponent},
  {path: 'profile-other-user/:username', component: ProfileOtherUserComponent},
  {path: 'friends', component: FriendsComponent},
  {path: 'profil', component: ProfilComponent},
  {path: 'password-change', component: PasswordChangeComponent},
  {path: 'name-change', component: NameChangeComponent},
  {path: 'surname-change', component: SurnameChangeComponent},
  {path: 'email-change', component: EmailChangeComponent},
  {path: 'city-change', component: CityChangeComponent},
  {path: 'number-change', component: NumberChangeComponent},
  {path: 'home-page', component: HomePageComponent},
  // marko
  {path: 'shows/:type', component: ShowsCinemaComponent},
  {path: 'shows/:type/:id', component: CinemaRepertoireComponent},
  {path: 'shows/:type/:id/new-movie', component: NewMovieComponent,
  canActivate: [RoleGuardService], data: {expectedRole: 'ADMINSHOW'}},
  {path: 'shows/:type/:id/edit-movie/:movieId', component: EditMovieComponent,
  canActivate: [RoleGuardService], data: {expectedRole: 'ADMINSHOW'}},
  {path: 'shows/:type/:id/new-projection/:date', component: NewProjectionComponent,
  canActivate: [RoleGuardService], data: {expectedRole: 'ADMINSHOW'}},
  {path: 'shows/:type/:id/buisness-report', component: BuisnessReportComponent,
  canActivate: [RoleGuardService], data: {expectedRole: 'ADMINSHOW'}},
  {path: 'shows/:type/edit/:id', component: EditShowComponent,
  canActivate: [RoleGuardService], data: {expectedRole: 'ADMINSHOW'}},
  {path: 'shows/:type/:id/edit/:projectionId', component: EditProjectionComponent,
  canActivate: [RoleGuardService], data: {expectedRole: 'ADMINSHOW'}}

];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule {
}
