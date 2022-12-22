import React, { useEffect } from "react";
import "./background.css";

export default function Background() {

    const [windowWidth, setWindowWidth] = React.useState(document.documentElement.clientWidth);
    const [windowHeight, setWindowHeight] = React.useState(document.documentElement.clientHeight);

    useEffect(() => {

        window.addEventListener("resize", () => {
            setWindowHeight(document.documentElement.clientHeight);
            setWindowWidth(document.documentElement.clientWidth);
        })
        // prendere dimensione schermo

        // fare resize dell'svg sulla base delle dimensione

        // rimuovere listener
    }, [])


    return (
        
        <svg className='grey--background' xmlns="http://www.w3.org/2000/svg" width={windowWidth} height={windowHeight} viewBox="0 0 282 294" fill="none">
            <path fillRule="evenodd" clipRule="evenodd" d="M158.558 0.92924C182.811 3.21796 205.042 12.6018 225.185 26.3064C245.922 40.4147 265.892 56.8257 275.046 80.182C284.533 104.386 283.743 131.404 276.122 156.259C268.407 181.419 249.467 199.643 232.303 219.586C209.131 246.511 193.44 286.181 158.558 292.86C123.111 299.649 89.265 274.828 60.9875 252.392C33.6553 230.707 9.822 202.919 2.25765 168.851C-4.94946 136.392 6.09932 103.01 21.2476 73.4137C34.6229 47.2814 56.1711 26.5075 82.1265 12.806C105.501 0.466756 132.246 -1.55389 158.558 0.92924Z" fill="url(#paint0_linear_603_5717)" />
            <defs>
                <linearGradient id="paint0_linear_603_5717" x1="221.636" y1="251.609" x2="140.982" y2="293.965" gradientUnits="userSpaceOnUse">
                    <stop stopColor="#F8F8FA" />
                    <stop offset="1" stopColor="#F8F8FA" stopOpacity="0" />
                </linearGradient>
            </defs>
        </svg>
    );
}