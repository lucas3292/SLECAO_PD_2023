import React from "react";
import { useNavigate } from 'react-router-dom';
import "./CardExpense.css"

interface InterfaceCardExpense{
    user:Object;
    expense:Object;
    expand:boolean;
}

export default function CardExpense(props:InterfaceCardExpense){
    const navigate = useNavigate();
    const object = {user:props.user, expense:props.expense}
    return(
        <>
            {props.expand ?
                <button className="card_expense_button" onClick={()=>{
                    navigate('/expense', { state: object});
                }}>
                    <span className="name_expense">
                        {props.expense.name}
                    </span>
                </button>
            : null}
        </>
    )
}