public class BeerSong {

  private static String multipleBeersOnTheWallStart;
  private static String multipleBeersOnTheWallEnd;
  private static String oneBeerOnTheWallStart;
  private static String oneBeerOnTheWallEnd;
  private static String noMoreBeerOnTheWallGoToStore;
  private static String takeOneDown;
  private static String takeItDown;

  static {
    multipleBeersOnTheWallStart = " bottles of beer on the wall, ";
    multipleBeersOnTheWallEnd = " bottles of beer on the wall.\n\n";
    oneBeerOnTheWallStart =  " bottle of beer on the wall, ";
    oneBeerOnTheWallEnd =  " bottle of beer on the wall.\n\n";
    noMoreBeerOnTheWallGoToStore = "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n\n";
    takeOneDown = " bottles of beer.\nTake one down and pass it around, ";
    takeItDown = " bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n\n";
  }

  public static String verse(int nthVerse) {
    String verse = new String();
    if (nthVerse > 2) {
      verse = String.valueOf(nthVerse) + BeerSong.multipleBeersOnTheWallStart + String.valueOf(nthVerse) + BeerSong.takeOneDown +
              String.valueOf(nthVerse - 1) + BeerSong.multipleBeersOnTheWallEnd;
    } else if (nthVerse > 1) {
      verse = String.valueOf(nthVerse) + BeerSong.multipleBeersOnTheWallStart + String.valueOf(nthVerse) + BeerSong.takeOneDown +
              String.valueOf(nthVerse - 1) + BeerSong.oneBeerOnTheWallEnd;
    } else if (nthVerse > 0) {
      verse = String.valueOf(nthVerse) + BeerSong.oneBeerOnTheWallStart + String.valueOf(nthVerse) + BeerSong.takeItDown;
    } else if (nthVerse == 0) {
      verse = BeerSong.noMoreBeerOnTheWallGoToStore;
    }
    return verse;
  }

  public static String sing(int from, int to) {
    String verses = new String();
    for (int i=from; i >= to; --i) {
      verses += BeerSong.verse(i);
    }
    return verses;
  }

  public static String singSong() {
    return BeerSong.sing(99, 0);
  }

}