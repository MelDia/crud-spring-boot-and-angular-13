import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../classes/product';

const URL = "http://localhost:8080/api/products";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(
    private http : HttpClient
  ) { }

  getAll() : Observable<Product[]> {
    return this.http.get<Product[]>(URL);
  }

  getProduct(id: any): Observable<Product> {
    return this.http.get(`${URL}/${id}`);
  }

  createProduct(data:any) : Observable<any> {
    return this.http.post(URL, data);
  }

  updateProduct(id:any, data:any) : Observable<any> {
    return this.http.put(`${URL}/${id}`, data);
  }

  deteleProduct(id:any) : Observable<any> {
    return this.http.delete(`${URL}/${id}`);
  }

  deleteAll() : Observable<any> {
    return this.http.delete(URL);
  }

  searchTitle(title:any) : Observable<Product[]> {
    return this.http.get<Product[]>(`${URL}?title=${title}`);
  }
}
