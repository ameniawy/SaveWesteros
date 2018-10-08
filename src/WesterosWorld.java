
public class WesterosWorld {
	private String[][] world; //2D array representing the grid
	private int capacityOfDG; //capacity of dragon class Jon Snow can hold
	private int whiteWalkersCapacity;
	private int worldRows;
	private int worldCols;
	
	public WesterosWorld(int x, int y) {
		this.world = this.genGrid(x, y);
	}
	public int getWorldRows() {
		return worldRows;
	}
	public void setWorldRows(int worldRows) {
		this.worldRows = worldRows;
	}
	public int getWorldCols() {
		return worldCols;
	}
	public void setWorldCols(int worldCols) {
		this.worldCols = worldCols;
	}
	public void setWorld(String[][] world) {
		this.world = world;
	}
	//getter method for the grid
	public String[][] getWorld() {
		return world;
	}

	//getter method for the capacity
	public int getCapacityOfDG() {
		return capacityOfDG;
	}
	
	public int getWhiteWalkersCapacity() {
		return whiteWalkersCapacity;
	}

	public String[][] genGrid(int x, int y){
		
		this.capacityOfDG = (int)(Math.random()*5) +1; //random capacity between 1->5
		//int worldRows = (int)(Math.random()*7) +4; //randomly picking rows
		//int worldCols = (int)(Math.random()*7) +4; //randomly picking cols
		this.worldRows = y;
		this.worldCols = x;
		this.whiteWalkersCapacity = (int)(Math.random()*((worldRows*worldCols)/2))+1; //randomly picking ww capcity up to 1/2 the world
		//this.whiteWalkersCapacity = 1;
		int obstaclesCapacity = (int)(Math.random()*((worldRows*worldCols)/8))+1; //randomly picking obstacles capcity up to 1/8 the world
		
		//generate empty world with Jon Snow
		String[][] world = new String[worldRows][worldCols];
		
		for(int i=0; i<world.length; i++)
		{
			for(int j=0; j<world[i].length; j++)
			{
				if(i==world.length-1 && j==world[i].length -1)
					world[i][j] = "J";
				else
					world[i][j]="E";
			}
		}
		
		//decide position of DragonStone
		int dSRow = (int)(Math.random()*worldRows);
		int dSCol = (int)(Math.random()*worldCols);
		while(dSRow == worldRows-1 && dSCol == worldCols-1)
		{
			dSRow = (int)(Math.random()*worldRows);
			dSCol = (int)(Math.random()*worldCols);
		}
		world[dSRow][dSCol] = "D";
		
		//position white walkers
		int whiteWalkersCreated = 0;
		int obstaclesCreated = 0;
		while(whiteWalkersCreated<whiteWalkersCapacity)
		{
			int randomRow = (int)(Math.random()*worldRows);			
			int randomCol = (int)(Math.random()*worldCols);
			if(world[randomRow][randomCol] == "E")
			{
				world[randomRow][randomCol] = "W";
				whiteWalkersCreated++;
			}
		}
		
		//position obstacles
		while(obstaclesCreated<obstaclesCapacity)
		{
			int randomRow = (int)(Math.random()*worldRows);			
			int randomCol = (int)(Math.random()*worldCols);
			if(world[randomRow][randomCol] == "E")
			{
				world[randomRow][randomCol] = "O";
				obstaclesCreated++;
			}
		}
		
		// infinite loop case
//		world = new String [][]{{"E", "O", "E", "E"}, {"E", "W", "E", "E"}, {"D", "W", "W", "E"}, {"E", "O", "W", "J"}};
//		whiteWalkersCapacity = 4;
//		obstaclesCapacity = 2;
//		capacityOfDG = 5;
		
		
		return world;
	}
}
