package xml.dom;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import xml.Track;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ItunesParserDemo {

    private static final String XPATH_TRACKS = "/plist/dict/dict/dict";
    private static final String FILE_PATH = "src/main/resources/xml/sample-library-copy.xml";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static final List<Track> tracks = new ArrayList<>();

    public static void main(String[] args) throws DocumentException {
        File file = new File(FILE_PATH);

        // Parse tracks via Handler
        SAXReader reader = new SAXReader();
        reader.addHandler("/plist/dict/dict/dict", getTrackHandler());
        reader.read(file);
        System.out.println("tracks.size() = " + tracks.size());

        // Parse tracks via Document nodes
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(file);
        Element rootElement = document.getRootElement();
        List<Node> nodes = rootElement.selectNodes(XPATH_TRACKS);

        for (Node node : nodes) {
            Element element = (Element) node;
            List<Element> elements = element.elements();
            for (int i = 0; i < elements.size(); i++) {
                String key = elements.get(i).getText();
                i++;
                String value = elements.get(i).getText();
                System.out.printf("%s: %s\n", key, value);
            }
        }
    }

    private static ElementHandler getTrackHandler() {
        return new ElementHandler() {
            @Override
            public void onStart(ElementPath elementPath) {
            }

            @Override
            public void onEnd(ElementPath elementPath) {
                Track track = new Track();
                addPropertiesToTrack(track, elementPath);
                tracks.add(track);
            }
        };
    }

    private static void addPropertiesToTrack(Track track, ElementPath elementPath) {
        List<Element> elements = elementPath.getCurrent().elements();

        for (int i = 0; i < elements.size(); i++) {
            String key = elements.get(i).getText();
            i++;
            String value = elements.get(i).getText();

            try {
                addTrackProperty(track, key, value);
            } catch (ParseException | MalformedURLException e) {
                System.out.println("Error while parsing a Track property: " + e.getMessage());
            }
        }
    }

    private static void addTrackProperty(Track track, String key, String value) throws ParseException, MalformedURLException {
        switch (key) {
            case "Album":
                track.setAlbum(value);
                break;
            case "Album Artist":
                track.setAlbumArtist(value);
                break;
            case "Album Rating":
                track.setAlbumRating(Integer.parseInt(value));
                break;
            case "Album Rating Computed":
            case "Rating Computed":
                track.setAlbumRatingComputed(Boolean.parseBoolean(value));
                break;
            case "Artist":
                track.setArtist(value);
                break;
            case "Artwork Count":
                track.setArtworkCount(Integer.parseInt(value));
                break;
            case "Bit Rate":
                track.setBitRate(Integer.parseInt(value));
                break;
            case "BPM":
                track.setBpm(Integer.parseInt(value));
                break;
            case "Comments":
                track.setComments(value);
                break;
            case "Compilation":
                track.setCompilation(Boolean.parseBoolean(value));
                break;
            case "Composer":
                track.setComposer(value);
                break;
            case "Clean":
                track.setClean(Boolean.parseBoolean(value));
                break;
            case "Date Added":
                track.setDateAdded(DATE_FORMAT.parse(value));
                break;
            case "Date Modified":
                track.setDateModified(DATE_FORMAT.parse(value));
                break;
            case "Disc Count":
                track.setDiscCount(Integer.parseInt(value));
                break;
            case "Disc Number":
                track.setDiscNumber(Integer.parseInt(value));
                break;
            case "Disabled":
                track.setDisabled(Boolean.parseBoolean(value));
                break;
            case "Episode":
                track.setEpisode(value);
                break;
            case "Episode Order":
                track.setEpisodeOrder(Integer.parseInt(value));
                break;
            case "Equalizer":
                track.setEqualizer(value);
                break;
            case "Explicit":
                track.setExplicit(Boolean.parseBoolean(value));
                break;
            case "File Folder Count":
                track.setFileFolderCount(Integer.parseInt(value));
                break;
            case "File Type":
                track.setFileType(Long.parseLong(value));
                break;
            case "Genre":
                track.setGenre(value);
                break;
            case "Grouping":
                track.setGrouping(value);
                break;
            case "Kind":
                track.setKind(value);
                break;
            case "Library Folder Count":
                track.setLibraryFolderCount(Integer.parseInt(value));
                break;
            case "Location":
                track.setLocation(new URL(value));
                break;
            case "Loved":
                track.setLoved(Boolean.parseBoolean(value));
                break;
            case "Name":
                track.setName(value);
                break;
            case "Normalization":
                track.setNormalization(Integer.parseInt(value));
                break;
            case "Part Of Gapless Album":
                track.setPartOfGaplessAlbum(Boolean.parseBoolean(value));
                break;
            case "Persistent ID":
                track.setPersistentID(value);
                break;
            case "Play Count":
                track.setPlayCount(Integer.parseInt(value));
                break;
            case "Play Date":
                track.setPlayDate(Long.parseLong(value));
                break;
            case "Play Date UTC":
                track.setPlayDateUTC(DATE_FORMAT.parse(value));
                break;
            case "Podcast":
                track.setPodcast(Boolean.parseBoolean(value));
            case "Purchased":
                track.setPurchased(Boolean.parseBoolean(value));
                break;
            case "Rating":
                track.setRating(Integer.parseInt(value));
                break;
            case "Release Date":
                track.setReleaseDate(DATE_FORMAT.parse(value));
                break;
            case "Sample Rate":
                track.setSampleRate(Integer.parseInt(value));
                break;
            case "Size":
                track.setSize(Long.parseLong(value));
                break;
            case "Skip Count":
                track.setSkipCount(Integer.parseInt(value));
                break;
            case "Skip Date":
                track.setSkipDate(DATE_FORMAT.parse(value));
                break;
            case "Season":
                track.setSeason(Integer.parseInt(value));
                break;
            case "Series":
                track.setSeries(value);
                break;
            case "Sort Album":
                track.setSortAlbum(value);
                break;
            case "Sort Album Artist":
                track.setSortAlbumArtist(value);
                break;
            case "Sort Artist":
                track.setSortArtist(value);
                break;
            case "Sort Composer":
                track.setSortComposer(value);
                break;
            case "Sort Name":
                track.setSortName(value);
                break;
            case "Sort Series":
                track.setSortSeries(value);
                break;
            case "Start Time":
                track.setStartTime(Long.parseLong(value));
                break;
            case "Stop Time":
                track.setStopTime(Long.parseLong(value));
                break;
            case "Total Time":
                track.setTotalTime(Long.parseLong(value));
                break;
            case "Track Count":
                track.setTrackCount(Integer.parseInt(value));
                break;
            case "Track ID":
                track.setTrackID(Integer.parseInt(value));
                break;
            case "Track Number":
                track.setTrackNumber(Integer.parseInt(value));
                break;
            case "Track Type":
                track.setTrackType(value);
                break;
            case "Volume Adjustment":
                track.setVolumeAdjustment(Integer.parseInt(value));
                break;
            case "Year":
                track.setYear(Integer.parseInt(value));
                break;
            default:
                log.warn("Unknown track property:\"{}\" with value \"{}\"'", key, value);
                break;
        }
    }
}