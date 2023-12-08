import {Directive, ElementRef, Input, Renderer2} from '@angular/core';

@Directive({
  selector: '[restaurantColored]',
  standalone: true
})
export class RestaurantColoredDirective {

  @Input()
  set restaurantColored(value: string) {
   
    if (parseInt(value) > 2 ) {
      this.renderer.setStyle(this.elRef.nativeElement, "color", "yellow");
    } else if (parseInt(value) < 1 && parseInt(value) >= 0){
      this.renderer.setStyle(this.elRef.nativeElement, "color", "red");
    }
  }

  constructor(private elRef: ElementRef, private renderer: Renderer2) {
  }

}
