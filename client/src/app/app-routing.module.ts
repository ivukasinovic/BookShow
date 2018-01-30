import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FunpageComponent} from './fanpage/funpage.component';
import {PropDetailComponent} from './fanpage/prop-detail/prop-detail.component';

const routes: Routes = [
  // fun page routes
  {path: 'fanpage/detail/:id', component: PropDetailComponent},
  {path: 'fanpage', component: FunpageComponent}

];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule {
}
