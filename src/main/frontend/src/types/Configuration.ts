import CPU from "./pcComponents/CPU";
import Drive from "./pcComponents/Drive";
import Motherboard from "./pcComponents/Motherboard";
import PowerUnit from "./pcComponents/PowerUnit";
import RAM from "./pcComponents/RAM";
import Videocard from "./pcComponents/Videocard";

export type Configuration = {
    cpu: CPU,
    motherboard: Motherboard,
    ram: RAM,
    drive: Drive,
    powerUnit: PowerUnit,
    videocard: Videocard,
}