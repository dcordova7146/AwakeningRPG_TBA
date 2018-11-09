package Tiles;

public class Board {
    Tile[][] tiles;
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
            for(Tile tile : roomarr){
                output += tile + " ";
            }
            output += "\n";
        }
        return output;
    }
   public Tile getTile(int x, int y){
        return tiles[x][y];
   }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }
    public Tile[] getTileRow(int x){
        return tiles[x];
    }
    public int getHeight() {
        return tiles.length;
    }

}
