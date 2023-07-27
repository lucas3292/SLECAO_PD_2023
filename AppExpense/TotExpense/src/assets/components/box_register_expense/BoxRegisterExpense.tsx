import { useState } from 'react'
import Input from '../input/Input'
import { motion, AnimatePresence } from "framer-motion"
import './BoxRegisterExpense.css'
import Button from '../button/Button'
import {BsFillInfoCircleFill} from "react-icons/bs"
import {AiFillDelete} from "react-icons/ai"
import axiosInstance from '../../data/services/axios_instance'
import { useNavigate } from 'react-router-dom';
interface InterfaceBox{
    infEx:Object;
    infUser:Object;
}

export default function BoxRegisterExpense(props:InterfaceBox){
    const[mod,setMode] = useState(false)
    const[name,setName] = useState()
    const[description,setDescription] = useState()
    const[val,setVal] = useState()
    const[dateDay,setDateDay] = useState()
    const navigate = useNavigate();
    const updateVal = async (e:any) =>{
        e.preventDefault()
        await axiosInstance.put('expense',{
            id:props.infEx.id,
            name:name,
            description:description,
            val:val,
            expenseDay:dateDay,
            usersExpense:{id:props.infUser.id}
        })
        .then((res)=>{
            console.log(res)
            navigate('/user')
        })
        .catch((res)=>console.log(res))
    }
    const createRegister = async (e:any) =>{
        e.preventDefault()
        await axiosInstance.post('expense',{
            name:name,
            description:description,
            val:val,
            expenseDay:dateDay,
            usersExpense:{id:props.infUser.id}
        })
        .then((res)=>{
            console.log(res)
            navigate('/user')
        })
        .catch((res)=>console.log(res))
    }
    const deletUser = async () =>{
        await axiosInstance.delete('expense',{
            //@ts-ignore
            data: {id:props.infEx.id},
        })
        .then((res)=>{
            console.log(res)
            navigate('/user')
        })
        .catch((res)=>console.log(res))
    }
    const handleInputDateChange = (event:any) => {
        setDateDay(event.target.value)
    };
    const handleInputValChange = (event:any) => {
        setVal(event.target.value)
    };
    const handleInputDescriptionChange = (event:any) => {
        setDescription(event.target.value)
    };
    const handleInputNameChange = (event:any) => {
        setName(event.target.value)
    };
    const handleSetMode = () => {
        setMode(!mod)
    };
    return(
        <div className="container_box_register_expense">
            <div className="container_apresentation_expense">
                <h1 className="title_register_expense">
                    {"Despesa "}
                </h1>
                <div className="container_options_butons">
                    {
                        props.infEx.name? 
                        <>
                        <BsFillInfoCircleFill color="white" size="30px" style={{margin:"0 2%", cursor:"pointer"}} onClick={handleSetMode}/>
                        <AiFillDelete color="white" size="30px" style={{margin:"0 2%", cursor:"pointer"}} onClick={deletUser}/>
                        </>:null

                    }
                </div>
            </div>
            <AnimatePresence>
            {mod? 
                <motion.div  key={0} initial={{ opacity: 0}} animate={{ opacity: 1 }} exit={{ opacity: 0 }}>
                    <div className="container_labels">
                        <strong>Nome da despesa:</strong>
                        <p>{props.infEx.name}</p>
                    </div>
                    <div className="container_labels">
                        <strong className='container_strong'>Nome do responsavel pela despesa:
                        </strong>
                        <p>{props.infUser.name}</p>
                    </div>
                    <div className="container_labels">
                        <strong>Descrição:</strong> 
                        <p>{props.infEx.description}</p>
                    </div>
                    <div className="container_labels">
                        <strong>Valor:</strong>
                        <p>{props.infEx.val} $</p>
                    </div>
                    <div className="container_labels">
                        <strong>Dia que a despesa foi feita:</strong> 
                        <p>{props.infEx.expenseDay}</p>
                    </div>
                </motion.div>:
                <motion.form className="container_form_expense"  key={0} initial={{ opacity: 0 }} animate={{ opacity: 1}} exit={{ opacity: 0}}>
                    <Input title="Nome da Despesa:" place={props.infEx.name} setValues={handleInputNameChange}/>
                    <Input title="Descrição da Despesa:" place={props.infEx.description} setValues={handleInputDescriptionChange}/>
                    <Input title="Valor da Despesa:" place={props.infEx.val} setValues={handleInputValChange}/>
                    <Input title="Dia da que Despesa Foi Feita:" place={props.infEx.expenseDay} setValues={handleInputDateChange}/>
                    <div className="container_buttons_expense">
                        {props.infEx.name? 
                        <Button title={"enviar"} send={updateVal} />:<Button title={"registrar"} send={createRegister} />}
                    </div>
                </motion.form>
            }
            </AnimatePresence >
        </div>
    )
}