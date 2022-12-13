import React from "react";
import Button from "../../generics/button/Button";

export default function Start(props : any){
    return(
        <div className="start--page">

            <div className="dolphin--image">
                <img src={props.dolphin} alt="dolphin" />
            </div>

            <div className="game--title">
                <h2>{props.startTitle}</h2>
            </div>

            <p>{props.text1}</p>

            <p>{props.text2}</p>

            <footer>
                <Button 
                    className = {props.className1}
                />
                <Button 
                    className = {props.className2}
                />
            </footer>

        </div>
    );
}