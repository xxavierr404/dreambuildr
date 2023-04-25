import Item from "./Item";

export default class PowerUnit extends Item {
    private _voltage: number;

    public constructor(name: string,
                       price: number,
                       id: number,
                       voltage: number) {
        super(name, price, id);
        this._voltage = voltage;
    }

    get voltage(): number {
        return this._voltage;
    }
}