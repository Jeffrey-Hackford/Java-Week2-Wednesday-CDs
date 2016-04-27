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
}
