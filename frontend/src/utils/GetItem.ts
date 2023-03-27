import axios from 'axios';
import Item from "../types/pcComponents/Item";

export default async function (id: number, type: string) : Promise<Item> {
    return axios.get(`http://localhost:8080/catalogue/${type}s/getOne?id=${id}`).then((value) => value.data);
}