import { Component } from '@angular/core';
import { HousingLocationComponent } from '../housing-location/housing-location'; 
import { Housinglocation } from '../housinglocation';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, HousingLocationComponent], 
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  readonly baseUrl = 'https://angular.dev/assets/images/tutorials/common';

housinglocationList: Housinglocation[] = [
  {
    id: 0,
    name: 'Acme Fresh Start Housing',
    city: 'Chicago',
    state: 'IL',
    photo: `${this.baseUrl}/bernard-hermant-CLKGGwIBTaY-unsplash.jpg`,
    availableUnits: 4,
    wifi: true,
    laundry: true
  },
  {
    id: 1,
    name: 'A113 Transitional Housing',
    city: 'Santa Monica',
    state: 'CA',
    photo: `${this.baseUrl}/brandon-griggs-wR11KBaB86U-unsplash.jpg`,
    availableUnits: 0,
    wifi: false,
    laundry: true
  },
  {
    id: 4,
    name: 'Happy Homes Group',
    city: 'Gary',
    state: 'IN',
    photo: `${this.baseUrl}/krzysztof-hepner-978RAXoXnH4-unsplash.jpg`,
    availableUnits: 2,
    wifi: true,
    laundry: true
  }
];
}