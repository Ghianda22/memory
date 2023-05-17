export default interface IPlayingCardProps {
    cardImage: string,
    isFaceUp: boolean,
    toggleFunction: () => void
}

export type toggleFunction = (cardIndex: number) => void