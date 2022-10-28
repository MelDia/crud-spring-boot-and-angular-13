import { HttpClient } from '@angular/common/http';
import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/classes/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  @Input() viewMode = false;

  @Input() currentProduct: Product = {
    id: '',
    title: '',
    description: '',
    price: '',
    status: false,
    images: ''
  };

  msg = '';

  constructor(
    private service: ProductService,
    private route: ActivatedRoute,
    private router: Router,
  ) { }

  ngOnInit(): void {
    console.log(this.getProduct("2"));
    console.log('CURRENT PRODUCT ->', this.currentProduct.id)
  
    if (!this.viewMode) {
      this.msg = '';
      this.getProduct(this.route.snapshot.params["id"]);
      console.log('X ->', this.getProduct(this.route.snapshot.params["id"]))
    }
  }

  getProduct(id: any) {

    this.service.getProduct(id).subscribe(
      res => {
        console.log('PRODUCT -> ', res);
        this.currentProduct = res;
        
      }
    )
  }

  update(status: boolean) {
    const data = {
      title: this.currentProduct.title,
      description: this.currentProduct.description,
      price: this.currentProduct.price,
      status: status
    };

    this.msg = '';

    this.service.updateProduct(this.currentProduct.id, data).subscribe(
      res => {
        this.currentProduct.status = status;
        this.msg = res.message ? res.message : 'The stock was updated successfully!'
      }
    )
  }

  updateProduct() {
    this.msg = '';

    this.service.updateProduct(this.currentProduct.id, this.currentProduct).subscribe(
      res => {
        this.msg = res.message ? res.message : 'The product was updated successfully!'
        //this.router.navigate(['/products']);
      }
    )
  }

  deleteProduct() {
    this.service.deteleProduct(this.currentProduct.id).subscribe(
      res => {
        this.router.navigate(['/products']);
      }
    )
  }

}
