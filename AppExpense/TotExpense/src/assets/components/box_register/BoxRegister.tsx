import React, { useEffect, useState } from "react";
import "./BoxRegister.css"
import Input from "../input/Input";
import Button from "../button/Button";


interface BoxInfo{
    title:string;
    listFunctions: ((e:any) => void)[];
}

export default function BoxRegister(props:BoxInfo) {
    return(
        <>
            <div className="container_box">
                <h1 className="title_box">
                    {props.title}
                </h1>
                <form className="container_form" action="http://localhost:8080/api/user" method="post">
                    <div className="container_inputs">
                        <Input setValues={props.listFunctions[0]} title="Nome do Responsavel:" place="Nome do responsavel pela despesa..."/>
                    </div>
                    <div className="container_buttons">
                        <Button title="enviar" send={props.listFunctions[1]} att={props.listFunctions[2]}/>
                    </div>
                </form>
                
            </div>
        </>
    )
}