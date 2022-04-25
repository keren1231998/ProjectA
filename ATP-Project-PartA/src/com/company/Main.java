package com.company;
import algorithms.mazeGenerators.*;

public class Main {

    public static void main(String[] args)
    {
        MyMazeGenerator m1=new MyMazeGenerator();
        Maze maze1=m1.generate(6,6);
        maze1.print();



//	int maze[][]={{0,0,1,1},
//                  {0,0,1,1},
//                  {0,0,1,1},
//                  {0,0,1,1}
//
//
//    };
//    Position start=new Position(0,0);
//    Position end=new Position(4,3);
//
//    SimpleMazeGenerator s1=new SimpleMazeGenerator();
//   // EmptyMazeGenerator e1 = new EmptyMazeGenerator();
//    Maze maze1=s1.generate(12,12);
//
//
//    Maze maze1 =new Maze(start,end,maze);
//    maze1.print();

    }
}
