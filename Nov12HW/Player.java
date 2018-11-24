public interface Player {
	/**
	 * Make a move on the tic tac toe board based on the move made by your
	 * opponent, or make the first move yourself. Assume that this method will
	 * be called if the game is already over or the move parameter is invalid.
	 * 
	 * @param move The move made by the opponent this turn in the format "RC",
	 *             where R is the row and C is the column in which the opponent
	 *             made their move, and R and C are integers from 0 to 2
	 *             inclusive. If move is null, then you make the first move of
	 *             the game.
	 * @return The move in which you would like to make, in the same String
	 *         format as the move the opponent makes. This cannot be null.
	 */
	public String move(String move);

	/**
	 * Reset this instance so that a new game can be played. If this class uses
	 * any fields to store the state of the board, this method should clear
	 * those fields and the instance should be ready to start a new game.
	 */
	public void reset();
	
	/**
	 * Get the name of the person who wrote this class.
	 * 
	 * @return Your first and last name, capitalized, with a space in between.
	 */
	public String getName();
}
