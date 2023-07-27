import React from "react";
import {BsWhatsapp,BsInstagram,BsLinkedin,BsLink, BsGithub} from "react-icons/bs"
import './Foot.css'
export default function Foot(){
    return(
        <>
            <footer className="container_footer">
                <div className="container_icons">
                    <a href="https://api.whatsapp.com/send?phone=5592984304444" className="container_links_externs">
                        <BsWhatsapp size="24" style={{margin:"0 2%", cursor:"pointer"}} />
                    </a>
                    <a href="https://www.instagram.com/lucast98n/" className="container_links_externs">
                        <BsInstagram size="24" style={{margin:"0 2%", cursor:"pointer"}}/>
                    </a>
                    <a href="https://www.linkedin.com/in/lucas-nascimento-960342184/" className="container_links_externs">
                        <BsLinkedin size="24" style={{margin:"0 2%",cursor:"pointer"}}/>
                    </a>
                    <a href="https://63c33ecedf14f660e97d2c66--lucas-teixeira-nascimento-port1f0l1o.netlify.app/" className="container_links_externs">
                        <BsLink  size="24" style={{margin:"0 2%", cursor:"pointer"}}/>
                    </a>
                    <a href="https://github.com/lucas3292" className="container_links_externs">
                        <BsGithub  size="24" style={{margin:"0 2%", cursor:"pointer"}}/>
                    </a>
                </div>
                <hr color="gray" width="90%"></hr>
                <div className="container_final">
                    <span className="content_final">
                        © 2023, Lucas Teixeira Nascimento, Inc. All rights reserved. "Da Pro Gasto?" are Lucas Teixeira Nascimento trademarks or registered trademarks in the BR and elsewhere.  
                    </span>
                </div>
            </footer>
        </>
    )
}