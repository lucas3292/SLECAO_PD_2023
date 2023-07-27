import React from "react";
import './Butoon.css'
interface infButton{
    type?:string;
    title:string;
    send:(e:any)=>void;
    att?:(e:any)=>void;
}
export default function Button(props:infButton){
    return(
        <>
            <button type="submit" onClick={(e)=>{
                props.send(e)
                }}>
                {props.title}
            </button>
        </>
       
    )
}