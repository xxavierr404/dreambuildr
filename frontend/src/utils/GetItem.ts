import axios from 'axios';
import Item from "../types/pcComponents/Item";

export default async function (id: bigint, type: string) : Promise<Item> {
    console.log(`Getting item with id ${id}`);
    return axios.get(`http://localhost:8080/catalogue/${type}s/getOne?id=${id}`).then((value) => value.data);
}