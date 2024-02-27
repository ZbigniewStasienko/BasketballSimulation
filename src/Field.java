/*Class responsible for creating and displaying an array simulating basketball court*/
public class Field {
    private String[][] court = new String[11][12];
    private StringBuilder textAreaBuilder = new StringBuilder("");
    FieldWindow window = new FieldWindow();
    public static int delay = 970;
    // Array used to print players - for each player
    // there is an appropriate number informing about the color to be printed
    private int colour[] = new int[6];
    private String[] playerNumbers = new String[6];

    // Function for loading players' numbers and formatting them to String
    public void setPlayerNumbers(int[] playerNumber) {
        for (int i = 0; i < 6; i++) {
            playerNumbers[i] = String.valueOf(playerNumber[i]);
        }
    }

    // Function that adds blank spaces to correct shape of court
    public String correctNumber(String playerNumber) {
        int num = Integer.parseInt(playerNumber);
        if (num < 10) {
            return "&nbsp;&nbsp;";
        }
        return "&nbsp;";
    }

    public void updateWindow() {
        window.update(textAreaBuilder.toString());
        try {
            Thread.sleep(1000 - delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Creating an empty playing field - the board will contain only side lines,
    // three-point line and three-second violation line
    public void createPlayground() {

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 12; j++) {
                court[i][j] = " ";
            }
        }

        for (int i = 0; i < 11; i++) {
            court[i][0] = "X";
            court[i][11] = "X";
        }
        for (int i = 1; i < 11; i++) {
            court[0][i] = "X";
            court[10][i] = "X";
        }
        for (int i = 9; i > 6; i--) {
            court[i][2] = "*";
            court[i][4] = "*";
            court[i][7] = "*";
            court[i][9] = "*";
        }

        court[6][2] = "*";
        court[6][5] = "*";
        court[6][6] = "*";
        court[6][9] = "*";
        court[5][3] = "*";
        court[5][8] = "*";

        for (int i = 4; i < 8; i++) {
            court[4][i] = "*";
        }

    }

    // Function that prints the content currently stored in the array
    public void printField() {
        textAreaBuilder = new StringBuilder("");
        // Each field is examined and printed separately. Depending on what's in it
        // function print the appropriate symbol with the appropriate color
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 12; j++) {
                // Examining a field that is one of the court lines
                if (court[i][j] == "X" || court[i][j] == "*") {
                    if (i < 10 && j < 10) {
                        if (court[i][j + 1] == "STE" || court[i][j + 1] == "BLO" || court[i][j + 1] == "SH2" || court[i][j + 1] == "SH" || court[i][j + 1] == "WE" || court[i][j + 1] == "IN1" || court[i][j + 1] == "MIS") {
                            // Display correction needed to keep the pitch in shape
                            textAreaBuilder.append("<font face='monospace' color='blue'>X&nbsp;</font>");
                        } else {
                            textAreaBuilder.append("<font face='monospace' color='blue'>X&nbsp;&nbsp;</font>");
                        }
                    } else {
                        textAreaBuilder.append("<font face='monospace' color='blue'>X&nbsp;&nbsp;</font>");
                    }
                    // There is a Guard on the field in the table
                } else if (court[i][j] == "G1") {
                    // Player has the ball - printing its number in yellow colour
                    if (colour[0] == 1) {
                        textAreaBuilder.append("<font face='monospace' color='yellow'>" + playerNumbers[0] + correctNumber(playerNumbers[0]) + "</font>");
                    }
                    // Players team is on the attack - printing its number in green colour
                    else if (colour[0] == 2) {
                        textAreaBuilder.append("<font face='monospace' color='green'>" + playerNumbers[0] + correctNumber(playerNumbers[0]) + "</font>");
                    }
                    // Player is in defence - printing its number in red colour
                    else {
                        textAreaBuilder.append("<font face='monospace' color='red'>" + playerNumbers[0] + correctNumber(playerNumbers[0]) + "</font>");
                    }
                } else if (court[i][j] == "F1") {
                    if (colour[1] == 1) {
                        textAreaBuilder.append("<font face='monospace' color='yellow'>" + playerNumbers[1] + correctNumber(playerNumbers[1]) + "</font>");
                    } else if (colour[1] == 2) {
                        textAreaBuilder.append("<font face='monospace' color='green'>" + playerNumbers[1] + correctNumber(playerNumbers[1]) + "</font>");
                    } else {
                        textAreaBuilder.append("<font face='monospace' color='red'>" + playerNumbers[1] + correctNumber(playerNumbers[1]) + "</font>");
                    }
                } else if (court[i][j] == "C1") {
                    if (colour[2] == 1) {
                        textAreaBuilder.append("<font face='monospace' color='yellow'>" + playerNumbers[2] + correctNumber(playerNumbers[2]) + "</font>");
                    } else if (colour[2] == 2) {
                        textAreaBuilder.append("<font face='monospace' color='green'>" + playerNumbers[2] + correctNumber(playerNumbers[2]) + "</font>");
                    } else {
                        textAreaBuilder.append("<font face='monospace' color='red'>" + playerNumbers[2] + correctNumber(playerNumbers[2]) + "</font>");
                    }
                } else if (court[i][j] == "G2") {
                    if (colour[3] == 1) {
                        textAreaBuilder.append("<font face='monospace' color='yellow'>" + playerNumbers[3] + correctNumber(playerNumbers[3]) + "</font>");
                    } else if (colour[3] == 2) {
                        textAreaBuilder.append("<font face='monospace' color='green'>" + playerNumbers[3] + correctNumber(playerNumbers[3]) + "</font>");
                    } else {
                        textAreaBuilder.append("<font face='monospace' color='red'>" + playerNumbers[3] + correctNumber(playerNumbers[3]) + "</font>");
                    }
                } else if (court[i][j] == "F2") {
                    if (colour[4] == 1) {
                        textAreaBuilder.append("<font face='monospace' color='yellow'>" + playerNumbers[4] + correctNumber(playerNumbers[4]) + "</font>");
                    } else if (colour[4] == 2) {
                        textAreaBuilder.append("<font face='monospace' color='green'>" + playerNumbers[4] + correctNumber(playerNumbers[4]) + "</font>");
                    } else {
                        textAreaBuilder.append("<font face='monospace' color='red'>" + playerNumbers[4] + correctNumber(playerNumbers[4]) + "</font>");
                    }
                } else if (court[i][j] == "C2") {
                    if (colour[5] == 1) {
                        textAreaBuilder.append("<font face='monospace' color='yellow'>" + playerNumbers[5] + correctNumber(playerNumbers[5]) + "</font>");
                    } else if (colour[5] == 2) {
                        textAreaBuilder.append("<font face='monospace' color='green'>" + playerNumbers[5] + correctNumber(playerNumbers[5]) + "</font>");
                    } else {
                        textAreaBuilder.append("<font face='monospace' color='red'>" + playerNumbers[5] + correctNumber(playerNumbers[5]) + "</font>");
                    }
                }
                // Check whether one of the messages is in our field
                else if (court[i][j] == "SH") {
                    textAreaBuilder.append("<font face='monospace' color='green'>&nbsp;SH</font>");
                } else if (court[i][j] == "OT") {
                    textAreaBuilder.append("<font face='monospace' color='green'>OT&nbsp;&nbsp;</font>");
                } else if (court[i][j] == "WE") {
                    textAreaBuilder.append("<font face='monospace' color='green'>&nbsp;WE</font>");
                } else if (court[i][j] == "NT") {
                    textAreaBuilder.append("<font face='monospace' color='green'>NT&nbsp;&nbsp;</font>");
                } else if (court[i][j] == "IN1") {
                    textAreaBuilder.append("<font face='monospace' color='green'>&nbsp;&nbsp;I</font>");
                } else if (court[i][j] == "IN2") {
                    textAreaBuilder.append("<font face='monospace' color='green'>N&nbsp;&nbsp;&nbsp;</font>");
                } else if (court[i][j] == "MIS") {
                    textAreaBuilder.append("<font face='monospace' color='red'>MIS</font>");
                } else if (court[i][j] == "SED") {
                    textAreaBuilder.append("<font face='monospace' color='red'>SED&nbsp;</font>");
                } else if (court[i][j] == "SH2") {
                    textAreaBuilder.append("<font face='monospace' color='red'>&nbsp;SH</font>");
                } else if (court[i][j] == "OT2") {
                    textAreaBuilder.append("<font face='monospace' color='red'>OT&nbsp;&nbsp;</font>");
                } else if (court[i][j] == "BLO") {
                    textAreaBuilder.append("<font face='monospace' color='red'>BLO</font>");
                } else if (court[i][j] == "KED") {
                    textAreaBuilder.append("<font face='monospace' color='red'>CK!&nbsp;</font>");
                } else if (court[i][j] == "STE") {
                    textAreaBuilder.append("<font face='monospace' color='red'>STE</font>");
                } else if (court[i][j] == "AL!") {
                    textAreaBuilder.append("<font face='monospace' color='red'>AL!&nbsp;</font>");
                }
                // Field is empty
                else {
                    textAreaBuilder.append("<font face='monospace' color='black'>" + "&nbsp;&nbsp;&nbsp;" + "</font>");
                }
            }
            // Move to the next line and continue examining the array
            textAreaBuilder.append("<br>");
        }
        updateWindow();
    }

    // Function that places the player in the table based on his coordinates (X,Y) and his unique id number
    // It also contains information about what color we should use when printing
    public void setCourtWithPlayer(int posX, int posY, int id, int idOfBall) {
        if (id == 1) {
            court[posX][posY] = "G1";
            if (idOfBall > 3) {
                colour[0] = 3;
            } else if (idOfBall == 1) {
                colour[0] = 1;
            } else {
                colour[0] = 2;
            }
        }
        if (id == 2) {
            court[posX][posY] = "F1";
            if (idOfBall > 3) {
                colour[1] = 3;
            } else if (idOfBall == 2) {
                colour[1] = 1;
            } else {
                colour[1] = 2;
            }
        }
        if (id == 3) {
            court[posX][posY] = "C1";
            if (idOfBall > 3) {
                colour[2] = 3;
            } else if (idOfBall == 3) {
                colour[2] = 1;
            } else {
                colour[2] = 2;
            }
        }
        if (id == 4) {
            court[posX][posY] = "G2";
            if (idOfBall < 4) {
                colour[3] = 3;
            } else if (idOfBall == 4) {
                colour[3] = 1;
            } else {
                colour[3] = 2;
            }
        }
        if (id == 5) {
            court[posX][posY] = "F2";
            if (idOfBall < 4) {
                colour[4] = 3;
            } else if (idOfBall == 5) {
                colour[4] = 1;
            } else {
                colour[4] = 2;
            }
        }
        if (id == 6) {
            court[posX][posY] = "C2";
            if (idOfBall < 4) {
                colour[5] = 3;
            } else if (idOfBall == 6) {
                colour[5] = 1;
            } else {
                colour[5] = 2;
            }
        }
    }

    // Functions that set information about a given message to appropriate cells in the array
    // to be displayed when printing the array

    public void steal() {
        court[9][5] = "STE";
        court[9][6] = "AL!";
    }

    public void block() {
        court[9][5] = "BLO";
        court[9][6] = "KED";
    }

    public void miss() {
        court[8][5] = "MIS";
        court[8][6] = "SED";
        court[9][5] = "SH2";
        court[9][6] = "OT2";
    }

    public void made() {
        court[7][5] = "SH";
        court[7][6] = "OT";
        court[8][5] = "WE";
        court[8][6] = "NT";
        court[9][5] = "IN1";
        court[9][6] = "IN2";
    }
}
