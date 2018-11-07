package Game;

import Rooms.Room;

public class Board {
    private Room[][] rooms;
    public Board(Room[][] rooms){
        this.rooms = rooms;
    }
    public Board(int height,int width ){
        rooms = new Room[height][width];
    }
    public void printBoard(){
        for(Room[] i : rooms){
            for(Room j : i){
                System.out.print(j);
            }
        }
    }
    @Override
    public String toString(){
        String output = "";
        for(Room[] roomarr : rooms){
            for(Room Room : roomarr){
                output += Room + " ";
            }
            output += "\n";
        }
        return output;
    }
}
