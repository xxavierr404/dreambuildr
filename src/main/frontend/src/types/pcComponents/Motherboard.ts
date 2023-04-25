import Item from "./Item";

export default class Motherboard extends Item {
    private readonly _ramType: string;
    private readonly _slotsCount: number;
    private readonly _socket: string;

    public constructor(name: string,
                       price: number,
                       id: number,
                       ramType: string,
                       ramSlotsCount: number,
                       socketType: string) {
        super(name, price, id);
        this._slotsCount = ramSlotsCount;
        this._socket = socketType;
        this._ramType = ramType
    }

    get ramType(): string {
        return this._ramType;
    }

    get slotsCount(): number {
        return this._slotsCount;
    }

    get socket(): string {
        return this._socket;
    }
}