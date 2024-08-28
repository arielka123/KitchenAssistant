import { Category } from "./category";

export class Product {
    constructor(public name: string,
                public image: string,
                public codeBar: string,
                public category: Category
    ){

    }
}
