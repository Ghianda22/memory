import IEmailRequest from "./interfaces/email/IEmailRequest"

export default async function sendEmail(request: IEmailRequest): Promise<string> {
	const response = await fetch(`http://localhost:8080/email_invitations/send_email`, {
		method: "POST",
		mode: "cors", // no-cors, *cors, same-origin
		headers: {
		"Content-Type": "application/json",
		},
		body: JSON.stringify(request)
	})
    if (!response.ok) {
        throw new Error('Network response was not ok')
    }
    return response.json()
}