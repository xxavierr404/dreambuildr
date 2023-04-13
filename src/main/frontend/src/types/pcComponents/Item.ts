export default abstract class Item {
    private readonly _name: string;
    private readonly _price: number;
    private readonly _id: number;

    protected constructor(name: string, price: number, id: number) {
        this._name = name;
        this._price = price;
        this._id = id;
    }

    get name(): string {
        return this._name;
    }

    get price(): number {
        return this._price;
    }

    get id(): number {
        return this._id;
    }
}