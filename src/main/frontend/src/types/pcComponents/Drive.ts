import Item from "./Item";

export default class Drive extends Item {
    private readonly _type: string;
    private readonly _gigabytes: number;

    public constructor(name: string,
                       price: number,
                       id: number,
                       type: string,
                       gigabytes: number) {
        super(name, price, id);
        this._type = type;
        this._gigabytes = gigabytes;
    }

    get type(): string {
        return this._type;
    }

    get gigabytes(): number {
        return this._gigabytes;
    }
}