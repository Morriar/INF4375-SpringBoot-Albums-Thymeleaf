package ca.uqam.inf4375;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class AlbumsController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AlbumsController.class, args);
    }

    private List<Album> albums = new ArrayList<Album>();

    public AlbumsController() {
        albums.add(new Album("x01", "Album1", "Artist1", 1998, 10.0));
        albums.add(new Album("x02", "Album2", "Artist2", 1990, 11.9));
        albums.add(new Album("x03", "Album3", "Artist3", 2005, 7.5));
        albums.add(new Album("x04", "Album4", "Artist4", 2001, 18.0));
        albums.add(new Album("x05", "Album5", "Artist5", 1999, 10.5));
    }

    public Album getById(String id) {
        for(Album album : albums) {
            if(album.getId().equals(id)) {
                return album;
            }
        }
        return null;
    }

    @RequestMapping("/albums")
    public String albums(Map<String, Object> model) {
        model.put("albums", albums);
        return "albums";
    }

    @RequestMapping("/albums/{id}")
    public String list(@PathVariable("id") String id, Map<String, Object> model) {
        Album album = getById(id);
        model.put("album", album);
        return "album";
    }

}
