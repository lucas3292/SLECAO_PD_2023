import { useState } from "react"
import axiosInstance from "../../data/services/axios_instance"
import Input from "../input/Input"
import Button from "../button/Button"
import Axios from "axios"
import './BoxUpdate.css'
interface BoxInfo{
    title:string;
    user:object;
    open:()=> void;
    att:()=>void;
}
export default function BoxUpdate(props:BoxInfo){
    const[name,setName] =  useState("")
    const updateVal = async (e:any) =>{
        e.preventDefault()
        console.log(name)
        await Axios.put('http://localhost:8080/api/user',{
            id:props.user.id,
            name:name
        })
        .then((res)=>{
            console.log(res)
            props.att()
        })
        .catch((res)=>console.log(res, props.user))
    }
    const handleInputNameChange = (event:any) => {
        setName(event.target.value)
    };
    return(
        <>
            <div className='container_sections_update'onClick={props.open} ></div>
            <div className="container_box_update">
                <h1 className="title_box">
                    Editar Responsável
                </h1>
                <form className="container_form" action="http://localhost:8080/api/user" method="post">
                    <div className="container_inputs">
                        <Input setValues={handleInputNameChange} title="Novo Nome do Responsavel:" place="Nome do responsavel pela despesa..."/>
                    </div>
                    <div className="container_buttons">
                        <Button title="enviar" send={updateVal}/>
                    </div>
                </form>
                
            </div>
        </>
    )
}