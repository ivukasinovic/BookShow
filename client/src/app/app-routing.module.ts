import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FunpageComponent} from './funpage/funpage.component';
import {PropDetailComponent} from './funpage/prop-detail/prop-detail.component';

const routes: Routes = [
  // fun page routes
  {path: 'funpage/detail/:id', component: PropDetailComponent},
  {path: 'funpage', component: FunpageComponent}

];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule {
}
