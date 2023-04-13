import Item from "./Item";

export default class Videocard extends Item {
    public constructor(name: string, price: number, id: number) {
        super(name, price, id);
    }
}