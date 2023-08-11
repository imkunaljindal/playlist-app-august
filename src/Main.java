import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album arjitAlbum = new Album("Arijit Singh", "Arijit's album");
        Album alanAlbum = new Album("Alan Walker", "Walker's Album");

        arjitAlbum.addSongToAlbum("Kesaria", 3.5);
        arjitAlbum.addSongToAlbum("Tum Kya Mile", 4.2);
        arjitAlbum.addSongToAlbum("Lal Ishq",5.1);

        alanAlbum.addSongToAlbum("Faded",3.5);
        alanAlbum.addSongToAlbum("Alone",4.1);
        alanAlbum.addSongToAlbum("Darkside",2.5);


        LinkedList<Song> myPlayList = new LinkedList<>();  //myPlaylist

        System.out.println(arjitAlbum.addToPlaylistFromAlbum("Kesaria",myPlayList));
        System.out.println(arjitAlbum.addToPlaylistFromAlbum(2,myPlayList));
        System.out.println(arjitAlbum.addToPlaylistFromAlbum(5,myPlayList));  // wrong song
        System.out.println(alanAlbum.addToPlaylistFromAlbum("Alone",myPlayList));
        System.out.println(alanAlbum.addToPlaylistFromAlbum(3,myPlayList));
        
        play(myPlayList);
    }

    private static void play(LinkedList<Song> myPlayList) {

        if(myPlayList.size()==0){
            System.out.println("Your playlist is empty");
            return;
        }


        ListIterator<Song> itr = myPlayList.listIterator();
        System.out.println("Now playing: "+itr.next());
        boolean wasNext = true;

        Scanner sc = new Scanner(System.in);
        printMenu();

        boolean quit = false;
        while(!quit){
            System.out.println("Please enter your choice");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    printMenu();
                    break;
                case 2:
                    if(wasNext==false){
                        itr.next();
                        wasNext = true;
                    }
                    if(!itr.hasNext()){
                        System.out.println("You have reached the end of the playlist");
                    }
                    else{
                        System.out.println("Currently playing: "+itr.next());
                        wasNext = true;
                    }
                    break;
                case 3:
                    if(wasNext==true){
                        itr.previous();
                        wasNext = false;
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("You are the start of the playlist.");
                    }
                    else{
                        System.out.println("Currently playing: "+itr.previous());
                        wasNext = false;
                    }
                    break;
                case 4:
                    if(wasNext==true){
                        System.out.println("Currently playing: "+itr.previous());
                        wasNext = false;
                    }
                    else{
                        System.out.println("Currently playing: "+itr.next());
                        wasNext = true;
                    }
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(myPlayList);
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice. Please select again");
            }
        }
        return;
    }

    private static void printSongs(LinkedList<Song> myPlayList) {

        for(Song song: myPlayList){
            System.out.println(song);
        }
        return;
    }

    private static void printMenu() {

        System.out.println("1. Show the menu again");
        System.out.println("2. Play next song");
        System.out.println("3. Play previous song");
        System.out.println("4. Play current song again");
        System.out.println("5. Delete current song from playlist");
        System.out.println("6. Print all the songs in playlist");
        System.out.println("7. Quit application");
    }
}