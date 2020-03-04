package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {
    static final public String[] EVEN_RESULTS = new String[]{"Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Deuce"};
    static final public String[] SCORE_RESULTS = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    private String handleAdvantageOrWin() {
        int minusResult = player1Score - player2Score;
        String target = minusResult > 0 ? player1Name : player2Name;
        String situation = Math.abs(minusResult) == 1 ? "Advantage" : "Win for";
        return situation + " " + target;
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return EVEN_RESULTS[player1Score];
        }

        if (player1Score >= 4 || player2Score >= 4) {
            return handleAdvantageOrWin();
        }

        return SCORE_RESULTS[player1Score] + "-" + SCORE_RESULTS[player2Score];
    }
}