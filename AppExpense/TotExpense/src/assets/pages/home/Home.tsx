import React,{ useEffect, useState } from "react";
import Menu from "../../components/menu/Menu";
import { motion } from "framer-motion";
import './Home.css'
import Button from "../../components/button/Button";
import { useNavigate } from "react-router-dom";
import Foot from "../../components/foot/Foot";

export default function Home(){
    const navigate = useNavigate()
    const toNavigateUsers = ()=>{
        navigate('/user')
    }
    const [mousePosition, setMousePosition] = useState({ x: 0, y: 0 });

    useEffect(() => {
        const updateMousePosition = (e:any) => {
        setMousePosition({ x: e.clientX, y: e.clientY });
        };

        window.addEventListener("mousemove", updateMousePosition);

        return () => {
            window.removeEventListener("mousemove", updateMousePosition);
        };
    }, []);
    return(
        <>
            <Menu/>
            <div className="container_apresentation">
                <motion.h1 className="content_propagram" initial={{opacity:0,y:200}} animate={{opacity:1,y:0}} transition={{delay: 0.5}}>
                    Dá Pro Gasto?
                    
                </motion.h1>
                <motion.img src="/public/Money.gif" width="190"
                        style={{
                            position: "absolute",
                            left: mousePosition.x<1070?mousePosition.x:1070,
                            top: mousePosition.y>100?mousePosition.y:100,
                             // Adicionamos o atraso de 0.2 segundos (200 milissegundos)
                        }}
                />
            </div>
            <motion.main className="container_page"  initial={{ opacity: 0 }} whileInView={{ opacity: 1 }} viewport={{ once: true }} transition={{ delay: 0.5}}>
                <div className="container_info">
                    <h1 className="title_home_page">
                        Que tal gerenciar seus gastos?
                    </h1>
                    <p className="text_home">
                        Bem-vindo ao nosso site de despesas pessoais! Aqui, nosso objetivo é ajudá-lo a manter o controle total de suas finanças de forma simples e eficiente. Com a nossa ferramenta intuitiva, você pode registrar e categorizar suas despesas diárias, acompanhar seus gastos mensais, e visualizar gráficos detalhados para entender melhor seus hábitos financeiros.
                    </p>
                    <Button title="Começar" send={toNavigateUsers}/>
                </div>
                <div className="container_img">
                    <img src="/public/Preise.jpg" width="590"/>
                </div>
            </motion.main>
            <Foot/>
        </>
    )
}