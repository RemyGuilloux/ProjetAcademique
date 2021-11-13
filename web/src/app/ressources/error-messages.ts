export const ErrorMessages = {
    lastname: [
        { type: 'required', message: 'Doit être rempli ' },
        { type: 'minlength', message: '3 caractères minimum' },
        { type: 'maxlength', message: '20 caractères maximum' },
        { type: 'pattern', message: 'doit contenir que des nombres et des lettres' },
        { type: 'usernameTaken', message: 'Désolé, se nom est déjà utilisé' }
    ],
    name: [
        { type: 'required', message: 'Doit être rempli ' },
        { type: 'minlength', message: '3 caractères minimum sans espace' },
        { type: 'maxlength', message: '20 caractères maximum' },
        { type: 'pattern', message: ', doit contenir que des nombres et des lettres' },
        { type: 'usernameTaken', message: 'Désolé, se nom est déjà utilisé' }
    ],
    username: [
        { type: 'required', message: 'Doit être rempli ' },
        { type: 'minlength', message: '3 caractères minimum' },
        { type: 'maxlength', message: '20 caractères maximum' },
        { type: 'pattern', message: 'doit contenir que des nombres et des lettres' },
        { type: 'usernameTaken', message: 'Désolé, se nom est déjà utilisé' }
    ],
    mail: [
        { type: 'required', message: 'Doit être rempli' },
        { type: 'pattern', message: 'Incorrect format de mail !Exemple: example@email.com' },
        { type: 'emailTaken', message: 'Désolé, cet mail est déja utilisé' }
    ],
    phone: [
        { type: 'required', message: 'Doit être rempli' },
        { type: 'pattern', message: 'Incorrect format ne doit contenir que des chiffres' },
        { type: 'phoneTaken', message: 'Désolé, ce numéro de téléphone appartient à une autre personne' }
    ],
    gender: [
        { type: 'required', message: 'Doit être rempli' }
    ],
    localisation: [
        { type: 'required', message: 'Doit être rempli ' },
        { type: 'minlength', message: '3 caractères minimum' },
        { type: 'maxlength', message: '20 caractères maximum' },
        { type: 'pattern', message: ' ne doit contenir que des lettres' },
        { type: 'usernameTaken', message: 'Désolé, se nom est déjà utilisé' }
    ],
    type: [
        { type: 'required', message: 'Doit au minimun contenir 2 services ' },
        { type: 'minlength', message: '6 caractères minimum' },
        { type: 'maxlength', message: '20 caractères maximum' },
        { type: 'pattern', message: ' ne doit contenir que des lettres' },
        { type: 'usernameTaken', message: 'Désolé, se nom est déjà utilisé' }
    ],
    confirm: [
        { type: 'areEqual', message: 'Mot de passe incorrect' }
       
    ],
    password: [
        { type: 'required', message: 'Doit être rempli ' },
        { type: 'minlength', message: '6 caractères minimun' },
        { type: 'maxlength', message: '25 caractères maximum' },
        { type: 'pattern', message: ', doit contenir au moins une lettre minuscule,masjuscule et un nombre ' }
    ],
    terms: [ { type: 'pattern', message: 'You must accept terms and conditions' } ],
    title: [ { type: 'pattern', message: 'You need to add a name before getting started' } ],
    description: [ { type: 'pattern', message: 'You must accept terms and conditions' } ],
    maxAmount: [ { type: 'pattern', message: 'must be between 0 and 50' } ],
    goal: [ { type: 'pattern', message: 'You must accept terms and conditions' } ],
    endDate: [ { type: 'pattern', message: 'You must accept terms and conditions' } ],
    members: [ { type: 'pattern', message: 'You must accept terms and conditions' } ]
};