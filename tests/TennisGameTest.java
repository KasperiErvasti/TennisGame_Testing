import static org.junit.Assert.*;

import org.junit.Test;

public class TennisGameTest {

// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	/* 
	 You should now start to implement additional unit tests to increase the coverage rates.
	 Follow the given examples unit tests. You should implement unit tests at least to check
	 that player 1 wind and player two wins. Try also to implement unit test for the situation
	 when one player has the advantage over the other player. If you find a bug in the SUT code
	 with the help of your tests, you may modify the SUT code. Remember that you should modify
	 the SUT if, and only if you find a bug.

	Once you have implemented a new unit test, check to see the different coverage rates again.
	Were you able to improve the coverage rates? You can then implement another unit test and
	check the coverage rates again. Try to fix the errors, update your test and increase the
	coverage rates as much as possible. Is it possible to reach 100% coverage? Note your
	improved coverage rates into the report under Task 1 together with your proof/reasoning
	regarding 100% coverage.
	 * */
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}
	
	@Test
	public void testTennisGame_Player1Wins() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		
		String score = game.getScore();
		assertEquals("Incorrect winner", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2Wins() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		game.player2Scored();
		
		String score = game.getScore();
		assertEquals("Incorrect winner", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_Player1HasAdvantage() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		
		String score = game.getScore();
		assertEquals("Incorrect advantage", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player2HasAdvantage() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		
		String score = game.getScore();
		assertEquals("Incorrect advantage", "player2 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Score30() throws TennisGameException{
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		
		String score = game.getScore();
		assertEquals("Incorrect advantage", "player2 has advantage", score);
	}
	
	
}
