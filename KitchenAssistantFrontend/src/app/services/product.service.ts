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

  getProductListPagination(thePage: number, 
                           thePageSize:number, 
                           theCategoryId: number ): Observable<GetResponseProducts>{
    
    const searchUrl = `${this.baseUrl}?categoryId=${theCategoryId}`
                    + `&page=${thePage}&size=${thePageSize}`;

    return this.httpClient.get<GetResponseProducts>(searchUrl);
  }
  
  getProductListByCategory(theCategoryId: number): Observable<Product[]>{
    const searchUrl = `${this.baseUrl}?categoryId=${theCategoryId}`;
    return this.httpClient.get<any>(searchUrl);
  }

  getProductList(): Observable<Product[]>{
    return this.httpClient.get<any>(this.baseUrl);
  }

  searchProducts(theKeyword: string): Observable<Product[]> {
    const searchUrl = `${this.baseUrl}?search=${theKeyword}`;
    return this.httpClient.get<any>(searchUrl);
  }

  getProduct(theProductId: number): Observable<Product> {
    const productUrl = `${this.baseUrl}/${theProductId}`;
    return this.httpClient.get<Product>(productUrl);
  }

}

interface GetResponseProducts {
  _emebeded: {
    products: Product[];
  }, 
  page: {
    size: number,
    totalElements: number,
    totalPages: number,
    number: number;
  }
}
