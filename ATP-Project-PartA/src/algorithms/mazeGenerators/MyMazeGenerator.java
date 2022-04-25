package algorithms.mazeGenerators;
import java.util.*;

public class MyMazeGenerator extends AMazeGenerator
{
    public MyMazeGenerator() {
    }

    @Override
    public Maze generate(int row, int column)
    {
        Random random = new Random();
        int [][] maze=new  int[row][column];
        int i,j;
        for(i=0;i<row;i++)//maze full of "1"
            for(j=0;j<column;j++)
                maze[i][j]=1;
        Position start = new Position((int) (0), (int) (Math.random() * column));//random start point
        Position end=new Position(row,column);

        ArrayList<Position> arrPos =new ArrayList<Position>();//neighbors
        for (int x = -1; x <= 1; x++)
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0 || x != 0 && y != 0)
                    continue;
                try {
                    if (maze[start.row + x][start.column + y] == '.') continue;
                } catch (Exception e) { // ignore ArrayIndexOutOfBounds
                    continue;
                }
                // add eligible points to frontier
                arrPos.add(new Position(start.row + x, start.column + y));
            }
//        while (!arrPos.isEmpty()){
//            Position temp = arrPos.remove(random.nextInt(arrPos.size()));
//            int rw = temp.row;
//            int cl = temp.column;
//            if (maze[rw][cl] == 1){
//                maze[rw][cl] =0;
//                if(rw >=2 && maze[rw-2][cl] == 1){
//                    arrPos.add(new Position(rw-1,cl));
//                    //arrPos.add( new Position(rw-2,cl));
//                }
//                if (cl >=2 && maze[rw][cl-2]==1){
//                    arrPos.add(new Position(rw,cl-1));
//                    //arrPos.add( new Position(rw,cl-2));
//                }
//                if(rw <row-2 && maze[rw+2][cl] == 1){
//                    arrPos.add(new Position(rw+1,cl));
//                    //arrPos.add( new Position(rw+2,cl));
//                }
//                if (cl <column-2 && maze[rw][cl+2]==1){
//                    arrPos.add(new Position(rw,cl+1));
//                    //arrPos.add( new Position(rw,cl+2));
//                }
//            }
//        }

        Position last = null;
        while (!arrPos.isEmpty()) {

            // pick current node at random

            Position cu = arrPos.remove((int)(Math.random() * arrPos.size()));
            Position op=cu.opposite(cu);


            try {
                // if both node and its opposite are walls
                if (maze[cu.row][cu.column] == 1) {
                    if (maze[op.row][op.column] == 1) {

                        // open path between the nodes
                        maze[cu.row][cu.column] = 0;
                        maze[op.row][op.column] = 0;

                        // store last node in order to mark it later
                        last = op;

                        // iterate through direct neighbors of node, same as earlier
                        for (int x = -1; x <= 1; x++)
                            for (int y = -1; y <= 1; y++) {
                                if (x == 0 && y == 0 || x != 0 && y != 0)
                                    continue;
                                try {
                                    if (maze[op.row + x][op.column + y] == '.') continue;
                                } catch (Exception e) {
                                    continue;
                                }
                                arrPos.add(new Position(op.row + x, op.column + y));
                            }
                    }
                }
            } catch (Exception e) { // ignore NullPointer and ArrayIndexOutOfBounds
            }


        }

        Maze maze1=new Maze(start,end,maze);


        return maze1;
    }

}
