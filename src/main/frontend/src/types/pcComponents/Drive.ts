import Item from "./Item";

export default class Drive extends Item {
    public constructor(name: string, price: number, id: number) {
        super(name, price, id);
    }
}