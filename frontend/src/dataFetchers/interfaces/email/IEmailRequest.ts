import IEmailListRequest from "./IEmailListRequest";

export default interface IEmailRequest {
	gameId: string;
	gameName: string;
	emailList: IEmailListRequest[];
}