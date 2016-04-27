import java.util.ArrayList;

public class CD {
  private String mTitle;
  private String mArtist;
  private static ArrayList<CD> CDList = new ArrayList<CD>();
  private int mID;

  public CD(String title) {
    mTitle = title;
    CDList.add(this);
    mID = CDList.size();
    mArtist = "test";
  }

  public String getTitle() {
    return mTitle;
  }

  public String getArtist() {
    return mArtist;
  }

  public void setArtist(String artist) {
    mArtist = artist;
  }

  public static ArrayList<CD> all() {
    return CDList;
  }

  public int getId() {
    return mID;
  }

  public static CD find(int id) {
    try {
      return CDList.get(id -1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static ArrayList<CD> searchByArtist(String artist) {
    ArrayList<CD> newList = new ArrayList<CD>();
    for(CD cd : CDList) {
      if (cd.getArtist() == artist) {
        newList.add(cd);
      }
    }
    return newList;
  }
}
