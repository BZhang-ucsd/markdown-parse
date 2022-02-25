import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MarkdownParseTest{
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks1() throws IOException{
        String file=Files.readString(Path.of("test-file.md"));
        assertEquals(MarkdownParse.getLinks(file), List.of("https://something.com","some-page.html"));
    }
    @Test
    public void testGetLinks2() throws IOException{
        String file=Files.readString(Path.of("test-file2.md"));
        assertEquals(MarkdownParse.getLinks(file), 
        List.of("https://www.youtube.com/watch?v=dQw4w9WgXcQ","https://www.google.com/maps"));
    }
    @Test
    public void testGetLinks3() throws IOException{
        String file=Files.readString(Path.of("test-file3.md"));
        assertEquals(MarkdownParse.getLinks(file), 
        List.of("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
    }
    @Test
    public void testGetLinksBulk() throws IOException{
        String file=Files.readString(Path.of("test-file4.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of());
        file=Files.readString(Path.of("test-file6.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of());
        file=Files.readString(Path.of("test-file7.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of());
        //tests below are bugged
        file=Files.readString(Path.of("test-file8.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of("a link on the first line"));
        file=Files.readString(Path.of("test-file5.md"));
        assertEquals(MarkdownParse.getLinks(file),List.of());
    }


/** @Test 
public void testgetLinks1() throws IOException {

    Path file = Path.of("test-file.md");
    String content = Files.readString(file);
    assertEquals(MarkdownParse.getLinks(content), List.of("https://something.com","some-page.html"));
}

@Test
public void testgetLinks2() throws IOException {

    Path file = Path.of("test-file2.md");
    String content = Files.readString(file);
    assertEquals(MarkdownParse.getLinks(content), List.of("https://something.com","some-page.html"));

}
@Test
public void testgetLinks3() throws IOException {

    Path file = Path.of("test-file3.md");
    String content = Files.readString(file);
    assertEquals(MarkdownParse.getLinks(content), List.of());

}

@Test
public void testgetLinks4() throws IOException {

    Path file = Path.of("test-file4.md");
    String content = Files.readString(file);
    assertEquals(MarkdownParse.getLinks(content), List.of("link goes here!"));

}

@Test
public void testgetLinks5() throws IOException {

    Path file = Path.of("test-file5.md");
    String content = Files.readString(file);
    assertEquals(MarkdownParse.getLinks(content), List.of("page.com"));

}

@Test
public void testgetLinks6() throws IOException {

    Path file = Path.of("test-file6.md");
    String content = Files.readString(file);
    assertEquals(MarkdownParse.getLinks(content), List.of("page.com"));
}

@Test
public void testgetLinks7() throws IOException {

    Path file = Path.of("test-file7.md");
    String content = Files.readString(file);
    assertEquals(MarkdownParse.getLinks(content), List.of());

}

@Test
public void testgetLinks8() throws IOException {

    Path file = Path.of("test-file8.md");
    String content = Files.readString(file);
    assertEquals(MarkdownParse.getLinks(content), List.of("a link on the first line"));

}
*/
}