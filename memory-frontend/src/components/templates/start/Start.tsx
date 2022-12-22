import React from "react";
import {Button} from "../../generics/button/Button";
import StyledParagraph from "../../generics/paragraphs/StyledParagraph";
import { Title } from "../../generics/titles/StyledTitle";
import { DolphinImage, StartFooter, StartPage } from "./StyledStart";

interface StartProps {
    
}

export default function Start(props: any) {
    return (
        <StartPage>
            <div>
                <DolphinImage>
                    <img src={props.dataImages[0].img} alt="dolphin" />
                </DolphinImage>

                <div>
                    <Title start={true}>{props.dataStart[0].text}</Title>
                </div>

                <StyledParagraph startParagraph>{props.dataStart[1].text}</StyledParagraph>

                <StyledParagraph startParagraph>{props.dataStart[2].text}</StyledParagraph>
            </div>




            <StartFooter>
                <Button
                    start={true}
                    join={false}
                    text={props.dataStart[3].text}
                />
                <Button
                    start={false}
                    join={true}
                    text={props.dataStart[4].text}
                />
            </StartFooter>

        </StartPage>
    );
}