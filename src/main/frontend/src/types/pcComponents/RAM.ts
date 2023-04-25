import Item from "./Item";

export default class RAM extends Item {
    private readonly _type: string;
    private readonly _frequency: number;
    private readonly _gigabytes: number;

    public constructor(name: string,
                       price: number,
                       id: number,
                       type: string,
                       frequency: number,
                       gigabytes: number) {
        super(name, price, id);
        this._type = type;
        this._frequency = frequency;
        this._gigabytes = gigabytes;
    }

    get type(): string {
        return this._type;
    }

    get frequency(): number {
        return this._frequency;
    }

    get gigabytes(): number {
        return this._gigabytes;
    }
}