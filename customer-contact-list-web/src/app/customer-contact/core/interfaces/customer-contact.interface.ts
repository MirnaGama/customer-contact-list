export interface Customer {
    id?: string;
    fullname: string;
    street: string;
    houseNumber: number;
    cep: string;
    neighborhood: string;
    city: string;
    state: string;
}

export interface Telephone {
    id?: string;
    number: string;
    customerId?: string;
}

