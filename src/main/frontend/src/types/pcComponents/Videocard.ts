import Item from "./Item";

export default class Videocard extends Item {
    private _vRam: number;
    private _frequency: number;

    public constructor(name: string,
                       price: number,
                       id: number,
                       vRam: number,
                       frequency: number) {
        super(name, price, id);
        this._vRam = vRam;
        this._frequency = frequency;
    }

    get vRam(): number {
        return this._vRam;
    }

    get frequency(): number {
        return this._frequency;
    }
}