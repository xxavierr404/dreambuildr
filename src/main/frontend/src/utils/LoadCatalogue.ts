import Item from "../types/pcComponents/Item";
import axios from 'axios';

export default async function (type: string, start: number, end: number) : Promise<Item[]> {
    return await axios.get(`http://localhost:8080/catalogue/${type}s/getBunch?start=${start}&end=${end}`)
        .then((value) => {
            return value.data.map((val: object) => {
                return val as Item;
            })
        });
}