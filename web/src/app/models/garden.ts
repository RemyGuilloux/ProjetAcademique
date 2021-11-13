import { Address } from 'src/app/models/Address';
import { Profil } from 'src/app/models/profil';
export class Garden {
    id: number;
    name: string;
    size: number;
    localisation: string;
    typeOfGarden: string;
    address: Address;
    addressId: Address;
    profilId: Profil;
}