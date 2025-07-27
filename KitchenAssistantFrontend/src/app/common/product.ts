import { Category } from "./category";
import { Nutrients } from "./nutrients";

export class Product {
    constructor(
                public id: number,
                public name: string,
                public image: string,
                public codeBar: string,
                public category: Category,
                public nutrients: Nutrients
    ){

    }
}
