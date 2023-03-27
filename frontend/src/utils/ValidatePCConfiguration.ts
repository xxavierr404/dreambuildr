import {ConfigurationDTO} from "../types/ConfigurationDTO";
import axios from 'axios';

export default async function validatePCConfiguration(config: ConfigurationDTO): Promise<any> {
    return await axios.post("http://localhost:8080/utils/pc-configuration/verify", config);
}