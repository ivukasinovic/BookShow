import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FanpageComponent} from './fanpage/fanpage.component';
import {UsedPropDetailComponent} from './fanpage/used-prop-detail/used-prop-detail.component';
import {NewPropDetailComponent} from './fanpage/new-prop-detail/new-prop-detail.component';
import {LoginComponent} from './login/login.component';
import {AuthGuardService} from './auth-guard.service';
import {AdminFanProfileComponent} from './fanpage/admin-fan-profile/admin-fan-profile.component';
import {RoleGuardService} from './role-guard.service';

const routes: Routes = [
  // ivan
  {path: 'login', component: LoginComponent},
  // fun page routes
  {path: 'fanpage/usedProp/:id', component: UsedPropDetailComponent},
  {path: 'fanpage/newProp/:id', component: NewPropDetailComponent},
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
  }
  // vlada
  // marko

];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule {
}
