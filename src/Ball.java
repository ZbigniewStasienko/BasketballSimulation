/*Class responsible for the Ball object
  Contains information about the team, the player currently in its possession, and
  a player who had it previously (needed to count assists)*/

public class Ball {
    private int playerId;
    private int teamId;
    private int lastPlayerWithBall = 0;
    public Ball() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getLastPlayerWithBall() {
        return lastPlayerWithBall;
    }

    public void setLastPlayerWithBall(int lastPlayerWithBall) {
        this.lastPlayerWithBall = lastPlayerWithBall;
    }
}
