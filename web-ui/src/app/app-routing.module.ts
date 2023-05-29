import { NgModel } from '@angular/forms';
import {Routes, RouterModule} from '@angular/router';
import {NgModule} from '@angular/core';
import { RootComponentComponent } from './root-component/root-component.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { HomeComponent } from './home/home.component';
import { UpdateParticipantStatusComponent } from './update-participant-status/update-participant-status.component';


const routes : Routes = [
    {
        path : '',
        component : RootComponentComponent,
        pathMatch : 'full'

    },
    {
        path : 'signin',
        component : SignInComponent,
    },
    {
        path : 'app-home',
        component : HomeComponent
    },
    {
        path : 'update/status',
        component : UpdateParticipantStatusComponent
    }
];

@NgModule({
    imports : [RouterModule.forRoot(routes)],
    exports : [RouterModule]
})

export class AppRoutingModule{ }