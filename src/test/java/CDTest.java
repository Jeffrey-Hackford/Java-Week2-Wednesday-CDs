import org.junit.*;
import static org.junit.Assert.*;


public class CDTest {

  @Test
  public void CD_CDInstantiatesCorrectly_true() {
    CD myCD = new CD("Who Cares");
    assertEquals(true, myCD instanceof CD);
  }

  @Test
  public void CD_getTitle_String() {
    CD myCD = new CD ("whatever");
    assertEquals("whatever", myCD.getTitle());
  }

  @Test
  public void CD_getListOfCDs_true() {
    CD firstCD = new CD ("Anything");
    CD secondCD = new CD ("Other Thing");
    assertTrue(CD.all().contains(firstCD));
    assertTrue(CD.all().contains(secondCD));
  }
}
