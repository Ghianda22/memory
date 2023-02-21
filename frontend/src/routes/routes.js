
import NewGameTemplate, { action as formAction } from "../components/templates/NewGameTemplate";
import SendInvitationsTemplate from "../components/templates/SendInvitationsTemplate";
import ActiveGames from "../pages/ActiveGames";
import CreateGame from "../pages/CreateGame";
import NewGame from "../pages/NewGame";
import SendInvitations from "../pages/SendInvitations";
import StartGame from "../pages/StartGame";

export const routes = [
	{
		path: "/",
		element: <StartGame />
	},
	{
		path: "/newgame",
		element: <CreateGame />,
		children: [
			{
				index: true,
				element: <NewGameTemplate/>
			},
			{
				path: "/newgame/sendinvitations",
				element: <SendInvitationsTemplate />
			},
		],
	},
	{
		path: "/activegames",
		element: <ActiveGames />
	},
	// {
	//     path: "/livegame",
	//     element:
	// },
];
