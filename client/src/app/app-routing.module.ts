import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FanpageComponent} from './fanpage/fanpage.component';
import {UsedPropDetailComponent} from './fanpage/used-prop-detail/used-prop-detail.component';
import {NewPropDetailComponent} from './fanpage/new-prop-detail/new-prop-detail.component';

const routes: Routes = [
  // fun page routes
  {path: 'fanpage/usedProp/:id', component: UsedPropDetailComponent },
  {path: 'fanpage/newProp/:id', component: NewPropDetailComponent },
  {path: 'fanpage', component: FanpageComponent}

];

@NgModule({
  exports: [RouterModule],
  imports: [RouterModule.forRoot(routes)]
})
export class AppRoutingModule {
}
