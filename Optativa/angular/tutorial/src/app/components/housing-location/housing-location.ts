// src/app/components/housing-location/housing-location.ts
import { Component, Input } from '@angular/core';
import { Housinglocation } from '../housinglocation'; // Importa tu interfaz

@Component({
  selector: 'app-housing-location',
  templateUrl: './housing-location.html',
  styleUrl: './housing-location.css',
})
export class HousingLocationComponent { 
  @Input() housingLocation!: Housinglocation; 
}