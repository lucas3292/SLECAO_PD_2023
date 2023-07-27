import React, { useState } from "react"
import './Input.css'
interface InputInterface{
    setValues:(e:any)=>void,
    title:string,
    place:string
}
export default function Input(props:InputInterface){
    return(
        <>
            <label>{props.title}</label>
            <input type="text" placeholder={props.place} onChange={props.setValues} />
        </>
    )
}