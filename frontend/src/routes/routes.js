
import { action as formAction } from "../components/templates/NewGameTemplate";
import ActiveGames from "../pages/ActiveGames";
import NewGame from "../pages/NewGame";
import SendInvitations from "../pages/SendInvitations";
import StartGame from "../pages/StartGame";

export const routes = [
    {
        path: "/",
        element: <StartGame/>
    },
    {
        path: "/newgame",
        element: <NewGame />,
        action: formAction
    },
    {
        path: "/sendinvitations/:numberOfPlayers",
        element: <SendInvitations />
    },
    {
        path: "/activegames",
        element: <ActiveGames />
    }
    // {
    //     path: "/livegame",
    //     element: 
    // },
];
