// Class storing and printing player statistics
public class Stats {
    private int assist;
    private int made2ptShots;
    private int missed2ptShots;
    private int defence;
    private int offensiveRebounds;
    private int defensiveRebounds;

    public Stats(int assist, int made2ptShots, int missed2ptShots, int defence, int offensiveRebounds, int defensiveRebounds) {
        this.assist = assist;
        this.made2ptShots = made2ptShots;
        this.missed2ptShots = missed2ptShots;
        this.defence = defence;
        this.offensiveRebounds = offensiveRebounds;
        this.defensiveRebounds = defensiveRebounds;
    }

    public void clearStats() {
        this.assist = 0;
        this.made2ptShots = 0;
        this.missed2ptShots = 0;
        this.defence = 0;
        this.offensiveRebounds = 0;
        this.defensiveRebounds = 0;
    }

    public void setAverageStats(Stats stats) {
        this.assist += stats.getAssist();
        this.made2ptShots += stats.getMade2ptShots();
        this.missed2ptShots += stats.getMissed2ptShots();
        this.defence += stats.getDefence();
        this.offensiveRebounds += stats.getOffensiveRebounds();
        this.defensiveRebounds += stats.getDefensiveRebounds();
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public int getMade2ptShots() {
        return made2ptShots;
    }

    public void setMade2ptShots(int made2ptShots) {
        this.made2ptShots = made2ptShots;
    }

    public int getMissed2ptShots() {
        return missed2ptShots;
    }

    public void setMissed2ptShots(int missed2ptShots) {
        this.missed2ptShots = missed2ptShots;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public void setOffensiveRebounds(int offensiveRebounds) {
        this.offensiveRebounds = offensiveRebounds;
    }

    public int getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(int defensiveRebounds) {
        this.defensiveRebounds = defensiveRebounds;
    }

    public String printStats(int nrOfGames) {
        return  "Made shots: " + Math.round(((double)made2ptShots/(nrOfGames))*100.0)/100.0 +
                "\nMissed shots: " + Math.round(((double)missed2ptShots/(nrOfGames))*100.0)/100.0 +
                "\nField goal percentage: " + Math.round(((double)made2ptShots/(made2ptShots+missed2ptShots))*10000.0)/100.0 + "%"+
                "\nAssists: " + Math.round(((double)assist/(nrOfGames))*100.0)/100.0 +
                "\nSteals: " + Math.round(((double)defence/(nrOfGames))*100.0)/100.0;
    }

    public String printStatsCenter(int nrOfGames) {
        return  "Made shots: " + Math.round(((double)made2ptShots/(nrOfGames))*100.0)/100.0 +
                "\nMissed shots: " + Math.round(((double)missed2ptShots/(nrOfGames))*100.0)/100.0 +
                "\nField goal percentage: " + Math.round(((double)made2ptShots/(made2ptShots+missed2ptShots))*10000.0)/100.0 + "%"+
                "\nAssists: " + Math.round(((double)assist/(nrOfGames))*100.0)/100.0 +
                "\nBlocks: " + Math.round(((double)defence/(nrOfGames))*100.0)/100.0 +
                "\nOffensive Rebounds: " + Math.round(((double)offensiveRebounds/(nrOfGames))*100.0)/100.0 +
                "\nDefensive Rebounds: " + Math.round(((double)defensiveRebounds/(nrOfGames))*100.0)/100.0;
    }
}
