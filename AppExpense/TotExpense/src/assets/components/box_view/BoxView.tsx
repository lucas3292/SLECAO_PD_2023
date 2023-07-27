import React, { useState } from "react";
import './BoxView.css'
import Button from "../button/Button";
import ContainerModal from "../container_modal/ContainerModal";
import ButtonModal from "../button_modal/ButtonModal";
import BoxRegister from "../box_register/BoxRegister";
import axiosInstance from "../../data/services/axios_instance";
import { useNavigate } from 'react-router-dom';
import { useEffect } from "react";

interface confBox{
    title:string;
}

export default function BoxView( props:confBox){
    const[registerBox,setRegisterBox] = useState(false)
    const[name,setName] =  useState("")
    const[listNames,setListNames] = useState([])
    const navigate = useNavigate();
    const insertVal = async (e:any) =>{
        e.preventDefault()
        await axiosInstance.post('user',{
            name:name
        })
        .then((res)=>{console.log(res)
            getVal()
        })
        .catch((res)=>console.log(res))
    }
    const handleInputNameChange = (event:any) => {
        setName(event.target.value)
    };
    const openBoxRegister = ()=>{
        setRegisterBox(!registerBox)
    }
    
    const getVal = async () =>{
        await axiosInstance.get('user')
            .then((res)=>{
                console.log("att aqui")
                setListNames(res.data)
            })
            .catch((res)=>console.log(res))
    }
    useEffect(()=>{
        getVal();
    },[])
    const listFunctionsSet = [handleInputNameChange,insertVal,getVal]
    return(
        <>
            {registerBox? <>
            <div className='container_sections_view' onClick={()=>{
                setRegisterBox(false)
                navigate("/user")
                getVal()
                }}></div>
            <BoxRegister title="Responsáveis" listFunctions={listFunctionsSet}/>
            </>:<></>}  
            <div className="container_box_view">
                <h1 className="title_box">
                    {props.title}
                </h1>
                {listNames.map((user)=><ContainerModal key={user.id} user={user} att={getVal} />)}
                <div className="container_buttons_view">
                    <ButtonModal title="+" listFunctions={openBoxRegister} confStyles={["40px",]}/>
                </div>
            </div>
        </>
    )
}