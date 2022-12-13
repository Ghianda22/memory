import React from "react";

export default function  Button(props : any){
    return (
        <div>
            <button className={props.className} onClick = {props.function}>
                <p>{props.text}</p>
            </button>
        </div>

    );
}