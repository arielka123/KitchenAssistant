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
  previousCategoryId: number = 1;
  products: Product[] = [];
  searchMode: boolean = false;
  
  thePageNumber: number = 1;
  thePageSize: number = 10;
  theTotalElements: number = 0;


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

      //check if we have current category than previous


      //if diffrent categoryId then set thePagenumber back to 1
      if(this.previousCategoryId != this.currentCutegoryId){
        this.thePageNumber = 1;
      }
      
      this.previousCategoryId = this.currentCutegoryId;

      console.log(`currentCategoryId=${this.currentCutegoryId}, thePageNumber=${this.thePageNumber},thePageSize=${this.thePageSize} `)

      //get product for the given category od

      // this.productService.getProductList().subscribe(
      //   data => {
      //     this.products = data;
      //   }
      // )

      this.productService.getProductListPagination(this.thePageNumber-1, 
                                                  this.thePageSize, 
                                                  this.currentCutegoryId)
                                                  .subscribe(
                                                    data =>{
                                                      this.products = data._emebeded.products;
                                                      this.thePageNumber = data.page.number + 1;
                                                      this.thePageSize = data.page.size;
                                                      this.theTotalElements = data.page.totalElements;
                                                    }
                                                  );

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
