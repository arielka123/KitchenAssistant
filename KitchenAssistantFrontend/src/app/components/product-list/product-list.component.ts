import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/common/product';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  currentCutegoryId: number = 1;
  products: Product[] = [];
  searchMode: boolean = false;

  constructor(private productService: ProductService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }

  listProducts() {

    this.searchMode = this.route.snapshot.paramMap.has('keyword');

    if(this.searchMode){
      this.handleSearchProducts();
    }
    else{
      this.handleListProducts();
    }


  }

handleListProducts(){
      //check if "id" parameter is available
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');

    if(hasCategoryId){
      //get the 'id' param
      this.currentCutegoryId =+ this.route.snapshot.paramMap.get('id')!;

      //get the products form the given category
      this.productService.getProductListByCategory(this.currentCutegoryId).subscribe(
      data => {
        this.products = data;
      }
    )

    }
    else{
      //default value
      // this.currentCutegoryId = 1;

      this.productService.getAllProductList().subscribe(
        data => {
          this.products = data;
        }
      )
    }
}

handleSearchProducts(){
  const theKeyword: string = this.route.snapshot.paramMap.get('keyword')!;

  this.productService.searchProducts(theKeyword).subscribe(
        data => {
          this.products = data;
        }
      );
}




}
