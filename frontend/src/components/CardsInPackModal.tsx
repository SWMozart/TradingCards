import Modal from 'react-bootstrap/Modal';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Col, Form, Row} from "react-bootstrap";
import "./CardsInPackModal.css"
import React, {ChangeEvent, FormEvent, useState} from "react";
import {Card} from "../model/Card";
import LegendCardsInPack from "./LegendCardsInPack";
type CardsInPackModalProps = {
    show:boolean;
    onHide:()=>void;
    cards : Card[];
}
export default function CardsInPackModal(props:CardsInPackModalProps) {


    const handleSubmit=(event:FormEvent<HTMLFormElement>)=> {
        event.preventDefault();


    }

    return(
        <Modal show={props.show} animation={true}
               size="xl"
               aria-labelledby="contained-modal-title-vcenter"
               centered>
            <Modal.Header closeButton>
                <Modal.Title>Your Cards!</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <LegendCardsInPack cards={props.cards}/>
            </Modal.Body>
            <Modal.Footer>

                <form onSubmit={handleSubmit}>
                    <input type={"button"} onClick={props.onHide} value={"Close"}/>

                </form>
            </Modal.Footer>
        </Modal>
    )
}

/* for 37 <input className={"btn-save"} type={"submit"} value={"Save Changes"}/>*/