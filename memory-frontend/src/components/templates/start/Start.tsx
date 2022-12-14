import React from "react";
import Button from "../../generics/button/Button";
import "./start.css"

export default function Start(props: any) {
    return (
        <div className="start--page">

            <div>
                <div className="dolphin--image">
                    <img src={props.dataImages[0].img} alt="dolphin" />
                </div>

                <div className="game--title">
                    <h2>{props.dataStart[0].text}</h2>
                </div>

                <p>{props.dataStart[1].text}</p>

                <p>{props.dataStart[2].text}</p>
            </div>




            <footer>
                <Button
                    className={props.dataStart[3].text}
                    text={props.dataStart[4].text}
                />
                <Button
                    className={props.dataStart[5].text}
                    text={props.dataStart[6].text}
                />
            </footer>

        </div>
    );
}