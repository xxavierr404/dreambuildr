import Item from "../types/pcComponents/Item";
import axios from 'axios';

export default async function (type: string) : Promise<Item[]> {
    return await axios.get(`http://localhost:8080/catalogue/${type}s/getAll`)
        .then((value) => {
            return value.data.map((val: object) => {
                return val as Item;
            })
        });
}