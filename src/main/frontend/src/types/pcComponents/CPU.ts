import Item from "./Item";

export default class CPU extends Item {
    public constructor(name: string, price: number, id: number) {
        super(name, price, id);
    }
}