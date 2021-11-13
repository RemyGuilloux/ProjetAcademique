import { Garden } from './Garden';


export class Gardener {
    constructor(
        name: string,
        lastname: string,
        mail: string,
        phone: string,
        gender: string,
        localisation: string,
        type: string

                ) {

                    this.name = name;
                    this.lastname = lastname;
                    this.mail = mail;
                    this.phone = phone;
                    this.gender = gender;
                    this.localisation = localisation;
                    this.type = type;

    }
    id: number;
    name: string;
    lastname: string;
    mail: string;
    phone: string;
    gender: string;
    localisation: string;
    type: string;
}



