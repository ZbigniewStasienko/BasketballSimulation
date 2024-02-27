public class StartPositions {

    // Function that randomly selects starting positions for players at the start of the action
    public static void startingPositions(Player playerWithBallOffence, Player playerWithBallDefence, Player playerWithoutBallOffence1, Player playerWithoutBallDefence1, Player playerWithoutBallOffence2, Player playerWithoutBallDefence2){
        Randomize randomize = new Randomize();
        switch (randomize.randomRange(1,3)){
            case 1:
                playerWithBallOffence.setPositionX(5);
                playerWithBallOffence.setPositionY(2);
                playerWithBallDefence.setPositionX(6);
                playerWithBallDefence.setPositionY(2);
                switch (randomize.randomRange(1,2)) {
                    case 1:
                        playerWithoutBallOffence1.setPositionX(5);
                        playerWithoutBallOffence1.setPositionY(9);
                        playerWithoutBallDefence1.setPositionX(6);
                        playerWithoutBallDefence1.setPositionY(9);
                        switch (randomize.randomRange(1,2)) {
                            case 1:
                                playerWithoutBallOffence2.setPositionX(3);
                                playerWithoutBallOffence2.setPositionY(5);
                                playerWithoutBallDefence2.setPositionX(4);
                                playerWithoutBallDefence2.setPositionY(5);
                                break;
                            case 2:
                                playerWithoutBallOffence2.setPositionX(3);
                                playerWithoutBallOffence2.setPositionY(6);
                                playerWithoutBallDefence2.setPositionX(4);
                                playerWithoutBallDefence2.setPositionY(6);
                                break;
                            default:
                                break;
                        }
                        break;

                    case 2:
                        playerWithoutBallOffence2.setPositionX(5);
                        playerWithoutBallOffence2.setPositionY(9);
                        playerWithoutBallDefence2.setPositionX(6);
                        playerWithoutBallDefence2.setPositionY(9);
                        switch (randomize.randomRange(1,2)) {
                            case 1:
                                playerWithoutBallOffence1.setPositionX(3);
                                playerWithoutBallOffence1.setPositionY(5);
                                playerWithoutBallDefence1.setPositionX(4);
                                playerWithoutBallDefence1.setPositionY(5);
                                break;
                            case 2:
                                playerWithoutBallOffence1.setPositionX(3);
                                playerWithoutBallOffence1.setPositionY(6);
                                playerWithoutBallDefence1.setPositionY(6);
                                playerWithoutBallDefence1.setPositionX(4);
                                break;
                            default:
                                break;
                        }
                        break;

                    default:
                        break;
                }

                break;
            case 2:
                playerWithoutBallOffence1.setPositionX(5);
                playerWithoutBallOffence1.setPositionY(2);
                playerWithoutBallDefence1.setPositionX(6);
                playerWithoutBallDefence1.setPositionY(2);
                switch (randomize.randomRange(1,2)) {
                    case 1:
                        playerWithoutBallOffence2.setPositionX(5);
                        playerWithoutBallOffence2.setPositionY(9);
                        playerWithoutBallDefence2.setPositionX(6);
                        playerWithoutBallDefence2.setPositionY(9);
                        switch (randomize.randomRange(1,2)) {
                            case 1:
                                playerWithBallOffence.setPositionX(3);
                                playerWithBallOffence.setPositionY(5);
                                playerWithBallDefence.setPositionX(4);
                                playerWithBallDefence.setPositionY(5);
                                break;
                            case 2:
                                playerWithBallOffence.setPositionX(3);
                                playerWithBallOffence.setPositionY(6);
                                playerWithBallDefence.setPositionX(4);
                                playerWithBallDefence.setPositionY(6);
                                break;
                            default:
                                break;
                        }
                        break;

                    case 2:
                        playerWithBallOffence.setPositionX(5);
                        playerWithBallOffence.setPositionY(9);
                        playerWithBallDefence.setPositionX(6);
                        playerWithBallDefence.setPositionY(9);
                        switch (randomize.randomRange(1,2)) {
                            case 1:
                                playerWithoutBallOffence2.setPositionX(3);
                                playerWithoutBallOffence2.setPositionY(5);
                                playerWithoutBallDefence2.setPositionX(4);
                                playerWithoutBallDefence2.setPositionY(5);
                                break;
                            case 2:
                                playerWithoutBallOffence2.setPositionX(3);
                                playerWithoutBallOffence2.setPositionY(6);
                                playerWithoutBallDefence2.setPositionX(4);
                                playerWithoutBallDefence2.setPositionY(6);
                                break;
                            default:
                                break;
                        }
                        break;

                    default:
                        break;
                }
                break;


            case 3:
                playerWithoutBallOffence2.setPositionX(5);
                playerWithoutBallOffence2.setPositionY(2);
                playerWithoutBallDefence2.setPositionX(6);
                playerWithoutBallDefence2.setPositionY(2);
                switch (randomize.randomRange(1,2)) {
                    case 1:
                        playerWithoutBallOffence1.setPositionX(5);
                        playerWithoutBallOffence1.setPositionY(9);
                        playerWithoutBallDefence1.setPositionX(6);
                        playerWithoutBallDefence1.setPositionY(9);
                        switch (randomize.randomRange(1,2)) {
                            case 1:
                                playerWithBallOffence.setPositionX(3);
                                playerWithBallOffence.setPositionY(5);
                                playerWithBallDefence.setPositionX(4);
                                playerWithBallDefence.setPositionY(5);
                                break;
                            case 2:
                                playerWithBallOffence.setPositionX(3);
                                playerWithBallOffence.setPositionY(6);
                                playerWithBallDefence.setPositionX(4);
                                playerWithBallDefence.setPositionY(6);
                                break;
                            default:
                                break;
                        }
                        break;

                    case 2:
                        playerWithBallOffence.setPositionX(5);
                        playerWithBallOffence.setPositionY(9);
                        playerWithBallDefence.setPositionX(6);
                        playerWithBallDefence.setPositionY(9);
                        switch (randomize.randomRange(1,2)) {
                            case 1:
                                playerWithoutBallOffence1.setPositionX(3);
                                playerWithoutBallOffence1.setPositionY(5);
                                playerWithoutBallDefence1.setPositionX(4);
                                playerWithoutBallDefence1.setPositionY(5);
                                break;
                            case 2:
                                playerWithoutBallOffence1.setPositionX(3);
                                playerWithoutBallOffence1.setPositionY(6);
                                playerWithoutBallDefence1.setPositionY(6);
                                playerWithoutBallDefence1.setPositionX(4);
                                break;
                            default:
                                break;
                        }
                        break;

                    default:
                        break;
                }
                break;

            default:
                break;
        }
    }
}
