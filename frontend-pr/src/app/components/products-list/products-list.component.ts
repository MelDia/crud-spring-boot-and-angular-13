import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/classes/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent implements OnInit {

  products?: Product[];
  currentProduct: Product = {};
  index = -1;
  title = '';

  constructor(
    private service: ProductService
  ) { }

  ngOnInit(): void {
    this.retrieveProducts();
  }

  retrieveProducts() {

    this.service.getAll().subscribe(
      data => {
        this.products = data;
        console.log('ALL PRODUCTS ->', data)
      }),
      (err: any) => {
        console.error("ERROR:", err);
      }
  }

  refresh() {
    this.retrieveProducts();
    this.currentProduct = {};
    this.index = -1;
  }

  setActiveProduct(product: Product, index: number) {
    console.log('PRODUCT ->', product);
    console.log('INDEX ->', index)
    this.currentProduct = product;
    this.index = index;
  }

  searchTitle() {
    this.currentProduct = {};
    this.index = -1;

    this.service.searchTitle(this.title).subscribe(
      title => {
        this.products = title;
        console.log('TITLE -> ', title)
      },
      (err: any) => {
        console.error("ERROR:", err);
      }
    )
  }


}
