//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.29 at 03:08:50 PM MESZ 
//


package org.subsonic.restapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for User complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="User">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="username" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="adminRole" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="settingsRole" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="downloadRole" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="uploadRole" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="playlistRole" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="coverArtRole" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="commentRole" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="podcastRole" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="streamRole" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="jukeboxRole" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User")
public class User {

    @XmlAttribute(required = true)
    protected String username;
    @XmlAttribute(required = true)
    protected boolean adminRole;
    @XmlAttribute(required = true)
    protected boolean settingsRole;
    @XmlAttribute(required = true)
    protected boolean downloadRole;
    @XmlAttribute(required = true)
    protected boolean uploadRole;
    @XmlAttribute(required = true)
    protected boolean playlistRole;
    @XmlAttribute(required = true)
    protected boolean coverArtRole;
    @XmlAttribute(required = true)
    protected boolean commentRole;
    @XmlAttribute(required = true)
    protected boolean podcastRole;
    @XmlAttribute(required = true)
    protected boolean streamRole;
    @XmlAttribute(required = true)
    protected boolean jukeboxRole;

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the adminRole property.
     * 
     */
    public boolean isAdminRole() {
        return adminRole;
    }

    /**
     * Sets the value of the adminRole property.
     * 
     */
    public void setAdminRole(boolean value) {
        this.adminRole = value;
    }

    /**
     * Gets the value of the settingsRole property.
     * 
     */
    public boolean isSettingsRole() {
        return settingsRole;
    }

    /**
     * Sets the value of the settingsRole property.
     * 
     */
    public void setSettingsRole(boolean value) {
        this.settingsRole = value;
    }

    /**
     * Gets the value of the downloadRole property.
     * 
     */
    public boolean isDownloadRole() {
        return downloadRole;
    }

    /**
     * Sets the value of the downloadRole property.
     * 
     */
    public void setDownloadRole(boolean value) {
        this.downloadRole = value;
    }

    /**
     * Gets the value of the uploadRole property.
     * 
     */
    public boolean isUploadRole() {
        return uploadRole;
    }

    /**
     * Sets the value of the uploadRole property.
     * 
     */
    public void setUploadRole(boolean value) {
        this.uploadRole = value;
    }

    /**
     * Gets the value of the playlistRole property.
     * 
     */
    public boolean isPlaylistRole() {
        return playlistRole;
    }

    /**
     * Sets the value of the playlistRole property.
     * 
     */
    public void setPlaylistRole(boolean value) {
        this.playlistRole = value;
    }

    /**
     * Gets the value of the coverArtRole property.
     * 
     */
    public boolean isCoverArtRole() {
        return coverArtRole;
    }

    /**
     * Sets the value of the coverArtRole property.
     * 
     */
    public void setCoverArtRole(boolean value) {
        this.coverArtRole = value;
    }

    /**
     * Gets the value of the commentRole property.
     * 
     */
    public boolean isCommentRole() {
        return commentRole;
    }

    /**
     * Sets the value of the commentRole property.
     * 
     */
    public void setCommentRole(boolean value) {
        this.commentRole = value;
    }

    /**
     * Gets the value of the podcastRole property.
     * 
     */
    public boolean isPodcastRole() {
        return podcastRole;
    }

    /**
     * Sets the value of the podcastRole property.
     * 
     */
    public void setPodcastRole(boolean value) {
        this.podcastRole = value;
    }

    /**
     * Gets the value of the streamRole property.
     * 
     */
    public boolean isStreamRole() {
        return streamRole;
    }

    /**
     * Sets the value of the streamRole property.
     * 
     */
    public void setStreamRole(boolean value) {
        this.streamRole = value;
    }

    /**
     * Gets the value of the jukeboxRole property.
     * 
     */
    public boolean isJukeboxRole() {
        return jukeboxRole;
    }

    /**
     * Sets the value of the jukeboxRole property.
     * 
     */
    public void setJukeboxRole(boolean value) {
        this.jukeboxRole = value;
    }

}
