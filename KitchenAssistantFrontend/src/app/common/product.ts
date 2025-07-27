import { Category } from "./category";

export class Product {
    constructor(
                public id: number,
                public name: string,
                public image: string,
                public codeBar: string,
                public category: Category
    ){

    }
}
