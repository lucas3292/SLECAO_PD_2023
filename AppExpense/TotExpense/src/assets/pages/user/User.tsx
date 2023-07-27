
import { useEffect, useState } from 'react'
import './User.css'
import Menu from '../../components/menu/Menu'
import BoxView from '../../components/box_view/BoxView';


export default function User() {
   
    return (
        <>
            <Menu/>
            <main className='container_main'>
                <div className='container_sections'>
                    <BoxView title="Lista de Responsáveis"/>
                </div>       
            </main>
        </>
    )
}


