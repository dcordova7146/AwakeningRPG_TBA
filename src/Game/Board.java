package Game;

import Tiles.Tile;

public class Board {
    private Tile[][] tiles;
    public Board(Tile[][] tiles){
        this.tiles = tiles;
    }
    public Board(int height,int width ){
        tiles = new Tile[height][width];
    }

    public void printBoard(){
        for(Tile[] i : tiles){
            for(Tile j : i){
                System.out.print(j);
            }
        }
    }
    @Override
    public String toString(){
        String output = "";
        for(Tile[] roomarr : tiles){
            for(Tile Tile : roomarr){
                output += Tile + " ";
            }
            output += "\n";
        }
        return output;
    }
    // if(x !== null){
    //                    return "[@]";
    //                }else{
    //                    return "[_]";
    //                }
}
