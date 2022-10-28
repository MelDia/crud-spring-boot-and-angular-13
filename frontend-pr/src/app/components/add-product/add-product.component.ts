import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/classes/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  prod: Product = {
    title: '',
    description: '',
    price: '',
    status: false
  };

  submit = false;

  constructor(
    private service: ProductService,
    private router: Router,
  ) { }

  ngOnInit(): void {
  }

  saveProduct() {
    const data = {
      title: this.prod.title,
      description: this.prod.description,
      price: this.prod.price
    };

    this.service.createProduct(data).subscribe(
      res => {
        this.submit = true;
        console.log('CREATE ->', res)
      },
      err => {
        console.error('ERROR:', err)
      }
    )
  }

  newProduct() {
    this.submit = false;
    this.prod = {
      title: '',
      description: '',
      price: '',
      status: false
    }
  }

  back() {
    this.router.navigate(['/products']);
  }

}
