import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/products'
  constructor(private httpClient: HttpClient) {}

  getProductListByCategory(theCategoryId: number): Observable<Product[]>{
  const searchUrl = `${this.baseUrl}?categoryId=${theCategoryId}`;
    return this.httpClient.get<any>(searchUrl);
  }

  getAllProductList(): Observable<Product[]>{
    return this.httpClient.get<any>(this.baseUrl);
  }

  searchProducts(theKeyword: string): Observable<Product[]> {
    const searchUrl = `${this.baseUrl}?search=${theKeyword}`;
    return this.httpClient.get<any>(searchUrl);
  }


}

