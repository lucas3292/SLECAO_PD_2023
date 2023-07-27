import React, { useState } from "react";
import {AiFillDelete} from "react-icons/ai"
import {BsCaretDownFill,BsFillCaretUpFill,BsFillInfoCircleFill,BsFillBarChartLineFill} from "react-icons/bs"
import {Link } from "react-router-dom";
import {motion} from "framer-motion"
import { useNavigate } from 'react-router-dom';
import './ContainerModal.css'
import CardExpense from "../card_expense/CardExpense";
import axiosInstance from "../../data/services/axios_instance";
import BoxUpdate from "../box_update/BoxUpdate";
import ButtonModal from "../button_modal/ButtonModal";

interface InterfaceContainerModal{
    user: object;
    att:()=>void;
}

export default function ContainerModal(props:InterfaceContainerModal){
    const [openBox, setOpenBox] = useState(false)
    const [openNavUp, setOpenNavUp] = useState(false)
    const navigate = useNavigate();
    const navigateToExpense = () => {
        navigate("/expense",{state: {user: props.user}})
    }
    const navigateToGraph = () => {
        navigate("/graph",{state: {user: props.user}})
    }
    const deletUser = async () =>{
        await axiosInstance.delete('user',{
            //@ts-ignore
            data: {id:props.user.id},
        })
        .then((res)=>{
            console.log(res)
            props.att()
        })
        .catch((res)=>console.log(res))
    }
    const handleOpenNavUp = ()=>{
        setOpenNavUp(!openNavUp)
    }
    return(
        <>
        {openNavUp?<> <BoxUpdate title="Responsáveis" user={props.user} open={handleOpenNavUp} att={ props.att}/> </>:<></>}  
        <div className="container_links">
            <Link to={openBox?"/user" : "/user/"+props.user.id} className="links"  onClick={()=>setOpenBox(!openBox)} style={{ textDecoration:"none"}}>
                {props.user.name}
            </Link>
            <div className="container_icon">
                {openBox?  
                <BsFillCaretUpFill size="30px" /> : <BsCaretDownFill size="30px"/>}
                <BsFillBarChartLineFill style={{marginLeft:'20%', cursor:'pointer'}} size="40px" onClick={navigateToGraph}/>
                <BsFillInfoCircleFill style={{marginLeft:'20%', cursor:'pointer'}} size="40px" onClick={()=>setOpenNavUp(!openNavUp)}/>
                <AiFillDelete style={{marginLeft:'20%', cursor:'pointer'}} size="40px" onClick={
                    deletUser
                    }>
                </AiFillDelete>
            </div>
        </div>
        <motion.div className="container_inf" initial={{opacity:0}} animate={{ opacity:openBox?1:0, height:openBox?'auto':'0px'}} exit={{height:'0px'}}>
            {props.user.expenses.map((expense:object)=><CardExpense key={expense.id} expense={expense} user={props.user} expand={openBox}/>)}
            {openBox?
                 <div className="card_expense_container" style={{height:openBox?'auto':'0px'}}>
                    <ButtonModal title="+" confStyles={["20px",'20px','17px','3%']} listFunctions={navigateToExpense}/>
                    <p style={{color:'aliceblue',marginTop:'3%'}}>Adicionar despesas</p>
                 </div>:null
            }
        </motion.div>
        </>
    )
}