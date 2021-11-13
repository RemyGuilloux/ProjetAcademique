import { Garden } from 'src/app/models/garden';
import { Address } from 'src/app/models/address';
import { Gender} from 'src/app/models/gender';

export class Profil{
    id: number;
    localisation: string;
    name: string;
    lastname: string;
    phone: string;
    mail: string;
    gender: Gender;
    active: boolean;
    garden: Garden;
    address: Address;


}