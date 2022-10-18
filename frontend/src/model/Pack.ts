import {Card} from "./Card";


export type Pack = {
    id: string;
    category: string;
    name: string;
    cardsInAPack: Card[];
}