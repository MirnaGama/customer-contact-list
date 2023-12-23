export interface CustomerContact {
    fullname: string;
    street: string;
    houseNumber: number;
    cep: string;
    neighborhood: string;
    city: string;
    state: string;
    telephones: Telephone[]
}

export interface Telephone {
    number: string;
}

