import Item from "./Item";

export default class CPU extends Item {
    private readonly _socketType: string;
    private readonly _frequency: number;

    public constructor(name: string,
                       price: number,
                       id: number,
                       socketType: string,
                       frequency: number) {
        super(name, price, id);
        this._socketType = socketType;
        this._frequency = frequency;
    }

    get socketType(): string {
        return this._socketType;
    }

    get frequency(): number {
        return this._frequency;
    }
}