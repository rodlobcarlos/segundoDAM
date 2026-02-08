import { Component } from '@angular/core';
import { HousingLocationComponent } from '../housing-location/housing-location'; 
import { Housinglocation } from '../housinglocation';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HousingLocationComponent], 
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  readonly baseUrl = 'https://angular.dev/assets/images/tutorials/common';

  housinglocation: Housinglocation [] = [
    
  ];
}