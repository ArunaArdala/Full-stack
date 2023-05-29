import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { RootComponentComponent } from './root-component/root-component.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { HomeComponent } from './home/home.component';
import { UpdateParticipantStatusComponent } from './update-participant-status/update-participant-status.component';

@NgModule({
  declarations: [
    AppComponent,
    RootComponentComponent,
    SignInComponent,
    HomeComponent,
    UpdateParticipantStatusComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
