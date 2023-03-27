export default class Item {
    private readonly name: string;
    private readonly price: number;

    public constructor(name: string, price: number) {
        this.name = name;
        this.price = price;
    }

    public getName() : string {
        return this.name;
    }

    public getPrice() : number {
        return this.price;
    }
}