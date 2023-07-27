import React from "react";
import './ButtonModal.css'

interface confBox{
    title?:string;
    listFunctions?:((e: any) => void);
    promisseFunction?:((e: any) => Promise<void>);
    confStyles:string[]
}

export default function ButtonModal(props:confBox){
    return(
        <button className="button_modal" onClick={props.listFunctions} style={{height:props.confStyles[0], width:props.confStyles[1], fontSize:props.confStyles[2], marginTop:props.confStyles[3]}}>{props.title}</button>
    )
}