package edu.hsfulda.gameoflife;

import java.util.Collection;

public class Cell {

	private CellState state;
	private final Collection<Cell> neighbours;
	
	private Cell(CellState state, Collection<Cell> neighbours) {
		this.state = state;
		this.neighbours = neighbours;
	}
	
	public static Cell getInstance (CellState state, final Collection<Cell> neighbours) {
		return new Cell(state, neighbours);
	}

	enum CellState {
		ALIVE, DEAD
	}

	public CellState getCurrentState() {
		return this.state;
	}

	public void goToNextState() {
		long aliveNeighboursCount = neighbours.stream()
											.filter(neighbour -> CellState.ALIVE.equals(neighbour.getCurrentState()))
											.count();
		
		this.state = (2 > aliveNeighboursCount || 3 < aliveNeighboursCount || 
				(CellState.DEAD.equals(this.state) && 3 > aliveNeighboursCount)) ? CellState.DEAD : CellState.ALIVE; 
	}

	public Object getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

}
