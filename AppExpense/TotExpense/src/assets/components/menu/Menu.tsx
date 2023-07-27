import React from "react";
import {BiMoney} from "react-icons/bi"
import {Link, useNavigate} from "react-router-dom";
import "./Menu.css"
export default function Menu() {
    const navigate = useNavigate()
    const toHome = ()=>{
        navigate("/")
    }
    return (
        <>
            <header className="container_hearder">
                <div className="container_icons_menu">
                    <BiMoney size="35" style={{cursor:"pointer"}} onClick={toHome}/>
                </div>
                <div className="container_options">
                    <nav className="container_nav">
                        <Link className="links_menu" to={"/user"}>Despesas</Link>
                    </nav>
                </div>
            </header>
        </>
    )
  }