package edu.hsfulda.gameoflife;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import edu.hsfulda.gameoflife.Cell.CellState;


/**
 * Unit test for Game of Life.
 */
public class CellTest {

	private Cell cell;
	private Collection<Cell> neighbours;
	
	@Mock
	private Cell neighbour1;
	
	@Mock
	private Cell neighbour2;
	
	@Mock
	private Cell neighbour3;
	
	@Mock
	private Cell neighbour4;
	
	@Before
	public void setup () {
		initMocks(this);
	}
	
	@Test
	public void rule1_liveCellWillDieIfLiveNeighboursAreFewerThanTwo () {
		
		// assign
		neighbours = new LinkedList<Cell>();
		neighbours.addAll(Arrays.asList(neighbour1, neighbour2));
		
		when(neighbour1.getCurrentState()).thenReturn(CellState.ALIVE);
		when(neighbour2.getCurrentState()).thenReturn(CellState.DEAD);
		
		cell = Cell.getInstance(CellState.ALIVE, neighbours);
		
		// act
		cell.goToNextState();
		
		// assert
		CellState result = cell.getCurrentState();
		
		assertEquals("cell state is not changed", CellState.DEAD, result);
	}
	
	@Test
	public void rule2_liveCellWillDieIfLiveNeighboursAreMoreThanThree () {
		
		// assign
		neighbours = new LinkedList<Cell>();
		neighbours.addAll(Arrays.asList(neighbour1, neighbour2, neighbour3, neighbour4));
		
		when(neighbour1.getCurrentState()).thenReturn(CellState.ALIVE);
		when(neighbour2.getCurrentState()).thenReturn(CellState.ALIVE);
		when(neighbour3.getCurrentState()).thenReturn(CellState.ALIVE);
		when(neighbour4.getCurrentState()).thenReturn(CellState.ALIVE);
		
		cell = Cell.getInstance(CellState.ALIVE, neighbours);
		
		// act
		cell.goToNextState();
		
		// assert
		CellState result = cell.getCurrentState();
		
		assertEquals("cell state is not changed", CellState.DEAD, result);
	}
	
	@Test
	public void rule3_liveCellWillRemainLiveIfLiveNeighboursAreTwo () {
		
		// assign
		neighbours = new LinkedList<Cell>();
		neighbours.addAll(Arrays.asList(neighbour1, neighbour2));
		
		when(neighbour1.getCurrentState()).thenReturn(CellState.ALIVE);
		when(neighbour2.getCurrentState()).thenReturn(CellState.ALIVE);
		
		cell = Cell.getInstance(CellState.ALIVE, neighbours);
		
		// act
		cell.goToNextState();
		
		// assert
		CellState result = cell.getCurrentState();
		
		assertEquals("cell state is changed", CellState.ALIVE, result);
	}
	
	@Test
	public void rule3_liveCellWillRemainLiveIfLiveNeighboursAreThree () {
		
		// assign
		neighbours = new LinkedList<Cell>();
		neighbours.addAll(Arrays.asList(neighbour1, neighbour2, neighbour3));
		
		when(neighbour1.getCurrentState()).thenReturn(CellState.ALIVE);
		when(neighbour2.getCurrentState()).thenReturn(CellState.ALIVE);
		when(neighbour3.getCurrentState()).thenReturn(CellState.ALIVE);
		
		cell = Cell.getInstance(CellState.ALIVE, neighbours);
		
		// act
		cell.goToNextState();
		
		// assert
		CellState result = cell.getCurrentState();
		
		assertEquals("cell state is changed", CellState.ALIVE, result);
	}
	
	@Test
	public void rule4_deadCellWillBecomeLiveIfLiveNeighboursAreThree () {
		
		// assign
		neighbours = new LinkedList<Cell>();
		neighbours.addAll(Arrays.asList(neighbour1, neighbour2, neighbour3));
		
		when(neighbour1.getCurrentState()).thenReturn(CellState.ALIVE);
		when(neighbour2.getCurrentState()).thenReturn(CellState.ALIVE);
		when(neighbour3.getCurrentState()).thenReturn(CellState.ALIVE);
		
		cell = Cell.getInstance(CellState.DEAD, neighbours);
		
		// act
		cell.goToNextState();
		
		// assert
		CellState result = cell.getCurrentState();
		
		assertEquals("cell state is not changed", CellState.ALIVE, result);
	}
	
	@Test
	public void rule4_deadCellWillRemainDeadIfLiveNeighboursAreFewerThanThree () {
		
		// assign
		neighbours = new LinkedList<Cell>();
		neighbours.addAll(Arrays.asList(neighbour1, neighbour2));
		
		when(neighbour1.getCurrentState()).thenReturn(CellState.ALIVE);
		when(neighbour2.getCurrentState()).thenReturn(CellState.ALIVE);
		
		cell = Cell.getInstance(CellState.DEAD, neighbours);
		
		// act
		cell.goToNextState();
		
		// assert
		CellState result = cell.getCurrentState();
		
		assertEquals("cell state is changed", CellState.DEAD, result);
	}
	
	@Test
	public void rule4_deadCellWillRemainDeadIfLiveNeighboursAreMoreThanThree () {
		
		// assign
		neighbours = new LinkedList<Cell>();
		neighbours.addAll(Arrays.asList(neighbour1, neighbour2, neighbour3, neighbour4));
		
		when(neighbour1.getCurrentState()).thenReturn(CellState.ALIVE);
		when(neighbour2.getCurrentState()).thenReturn(CellState.ALIVE);
		when(neighbour3.getCurrentState()).thenReturn(CellState.ALIVE);
		when(neighbour4.getCurrentState()).thenReturn(CellState.ALIVE);
		
		cell = Cell.getInstance(CellState.DEAD, neighbours);
		
		// act
		cell.goToNextState();
		
		// assert
		CellState result = cell.getCurrentState();
		
		assertEquals("cell state is changed", CellState.DEAD, result);
	}
}
