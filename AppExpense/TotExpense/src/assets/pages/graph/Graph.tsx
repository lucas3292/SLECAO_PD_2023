import React, { useEffect, useState } from "react"
import {  BarChart, Bar,LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts'
import axiosInstance from "../../data/services/axios_instance";
import { useLocation} from 'react-router-dom';
import Menu from "../../components/menu/Menu";
import './Graph.css'

export default function Graph(){
    const DadosExemplo = [
        { nome: 'Janeiro', valor: 100 },
        { nome: 'Fevereiro', valor: 200 },
        { nome: 'Março', valor: 150 },
        { nome: 'Abril', valor: 300 },
        { nome: 'Maio', valor: 180 },
        { nome: 'Junho', valor: 250 },
    ]; 
    const DadosExemplo2 = [
        { nome: 'Item 1', quantidade: 10 },
        { nome: 'Item 2', quantidade: 20 },
        { nome: 'Item 3', quantidade: 15 },
        { nome: 'Item 4', quantidade: 5 },
    ];
    const location = useLocation();
    const [dataVal,setDataVal ]= useState([])
    const getGraph = async () =>{
        await axiosInstance.get('user/graph/'+location.state.user.id)
        .then((res)=>{
            console.log(res)
            setDataVal(res.data)
        })
        .catch((res)=>console.log(res))
    }
    useEffect(()=>{
        getGraph()
    },[])
    console.log(dataVal)
    return(
        <>
            <Menu/>
            <main className="container_chard">
                <div className="content_chard">
                    <h1>Custo X Tempo (Barras)</h1>
                    <BarChart width={500} height={300} data={dataVal} margin={{ top: 20, right: 30, left: 20, bottom: 5 }}>
                        <CartesianGrid strokeDasharray="3 3" />
                        <XAxis dataKey="dayExpense" />
                        <YAxis />
                        <Tooltip />
                        <Legend />
                        <Bar dataKey="val" fill="#333333" />
                    </BarChart>
                </div>
                <div className="content_chard">
                    <h1>Custo X Tempo (Linha)</h1>
                    <LineChart width={500} height={300} data={dataVal} margin={{ top: 20, right: 30, left: 20, bottom: 5 }}>
                        <CartesianGrid strokeDasharray="3 3" />
                        <XAxis dataKey="dayExpense" />
                        <YAxis />
                        <Tooltip />
                        <Legend />
                        <Line type="monotone" dataKey="val" stroke="#333333" activeDot={{ r: 8 }} />
                    </LineChart>
                </div>
            </main>
        </>
    )
}