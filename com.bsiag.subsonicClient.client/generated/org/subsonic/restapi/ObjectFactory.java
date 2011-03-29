//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.29 at 03:08:50 PM MESZ 
//


package org.subsonic.restapi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.subsonic.restapi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SubsonicResponse_QNAME = new QName("http://subsonic.org/restapi", "subsonic-response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.subsonic.restapi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Child }
     * 
     */
    public Child createChild() {
        return new Child();
    }

    /**
     * Create an instance of {@link ChatMessages }
     * 
     */
    public ChatMessages createChatMessages() {
        return new ChatMessages();
    }

    /**
     * Create an instance of {@link Artist }
     * 
     */
    public Artist createArtist() {
        return new Artist();
    }

    /**
     * Create an instance of {@link Directory }
     * 
     */
    public Directory createDirectory() {
        return new Directory();
    }

    /**
     * Create an instance of {@link RandomSongs }
     * 
     */
    public RandomSongs createRandomSongs() {
        return new RandomSongs();
    }

    /**
     * Create an instance of {@link SearchResult2 }
     * 
     */
    public SearchResult2 createSearchResult2() {
        return new SearchResult2();
    }

    /**
     * Create an instance of {@link NowPlaying }
     * 
     */
    public NowPlaying createNowPlaying() {
        return new NowPlaying();
    }

    /**
     * Create an instance of {@link License }
     * 
     */
    public License createLicense() {
        return new License();
    }

    /**
     * Create an instance of {@link Indexes }
     * 
     */
    public Indexes createIndexes() {
        return new Indexes();
    }

    /**
     * Create an instance of {@link ChatMessage }
     * 
     */
    public ChatMessage createChatMessage() {
        return new ChatMessage();
    }

    /**
     * Create an instance of {@link Playlist }
     * 
     */
    public Playlist createPlaylist() {
        return new Playlist();
    }

    /**
     * Create an instance of {@link PlaylistIdAndName }
     * 
     */
    public PlaylistIdAndName createPlaylistIdAndName() {
        return new PlaylistIdAndName();
    }

    /**
     * Create an instance of {@link NowPlayingEntry }
     * 
     */
    public NowPlayingEntry createNowPlayingEntry() {
        return new NowPlayingEntry();
    }

    /**
     * Create an instance of {@link Lyrics }
     * 
     */
    public Lyrics createLyrics() {
        return new Lyrics();
    }

    /**
     * Create an instance of {@link MusicFolder }
     * 
     */
    public MusicFolder createMusicFolder() {
        return new MusicFolder();
    }

    /**
     * Create an instance of {@link Index }
     * 
     */
    public Index createIndex() {
        return new Index();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link SearchResult }
     * 
     */
    public SearchResult createSearchResult() {
        return new SearchResult();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link MusicFolders }
     * 
     */
    public MusicFolders createMusicFolders() {
        return new MusicFolders();
    }

    /**
     * Create an instance of {@link Playlists }
     * 
     */
    public Playlists createPlaylists() {
        return new Playlists();
    }

    /**
     * Create an instance of {@link AlbumList }
     * 
     */
    public AlbumList createAlbumList() {
        return new AlbumList();
    }

    /**
     * Create an instance of {@link JukeboxPlaylist }
     * 
     */
    public JukeboxPlaylist createJukeboxPlaylist() {
        return new JukeboxPlaylist();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://subsonic.org/restapi", name = "subsonic-response")
    public JAXBElement<Response> createSubsonicResponse(Response value) {
        return new JAXBElement<Response>(_SubsonicResponse_QNAME, Response.class, null, value);
    }

}
