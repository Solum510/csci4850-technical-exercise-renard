package datamodel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Song Name, Artist, Album Name, 
//a short description of why I like the song, 
//and a link to youtube to listen to the song.


/**
 * @since J2SE-1.8
 CREATE TABLE JazzBlog (
  id INT NOT NULL AUTO_INCREMENT,    
  SONG_NAME VARCHAR(30) NOT NULL,
  ARTIST_NAME VARCHAR(30) NOT NULL,   
  ALBUM_NAME VARCHAR(30) NOT NULL,
  SONG_DESC VARCHAR(255) NOT NULL,
  YT_LINK VARCHAR(30) NOT NULL,
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "JazzBlog")
public class BlogEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "SONG_NAME")
	private String songName;
	
	@Column(name = "ARTIST_NAME")
	private String artistName;
	
	@Column(name = "ALBUM_NAME")
	private String albumName;
	
	@Column(name = "SONG_DESC")
	private String desc;
	
	@Column(name = "YT_LINK")
	private String ytLink;
	
	public BlogEntry() {
	}
	
	public BlogEntry(Integer id, String songName, String artistName, String albumName, String desc, String ytLink) {
		this.id = id;
		this.songName = songName;
		this.artistName = artistName;
		this.albumName = albumName;
		this.desc = desc;
		this.setYtLink(ytLink);
	}
	
	public BlogEntry(String songName, String artistName, String albumName, String desc, String ytLink) {
		this.songName = songName;
		this.artistName = artistName;
		this.albumName = albumName;
		this.desc = desc;
		this.setYtLink(ytLink);
	}
	
	public BlogEntry(String songName, String artistName, String albumName, String ytLink) {
		this.songName = songName;
		this.artistName = artistName;
		this.albumName = albumName;
		this.setYtLink(ytLink);
	}
	
	public void setSongName(String songName) {
		this.songName = songName;
	}
	
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setYtLink(String ytLink) {
		/*String pattern = "(?<=.=)(.+)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(ytLink);
		this.ytLink = m.group(0);*/
		this.ytLink = ytLink.substring(ytLink.indexOf('=') + 1);

	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSongName() {
		return this.songName;
	}
	
	public String getArtistName() {
		return this.artistName;
	}
	
	public String getAlbumName() {
		return this.albumName;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getYtLink() {
		return this.ytLink;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String toString() {
		return "id: " + this.id + ", song: " + this.songName + ", artist: " + this.artistName + ", album: " + this.albumName + ", desc: " + this.desc + "youtube: " + this.ytLink;
	}
	
	public static boolean checkYtLink(String link) {
		return link.indexOf('=') > -1;
	}
	public String toHtml() {
		return "<div align=center class=\"entry\">"+ 
				"<big>" + this.songName + "</big>" + 
				"<p>" + this.artistName +  " - " + this.albumName + "<br>" + 
				this.desc + "</p><br>" + 
				"<iframe width=\"420\" height=\"315\"" + 
				"src=\"https://www.youtube.com/embed/" + this.ytLink + "\">" + 
				"</iframe>" + 
				"<br><br>" + 
				"</div>";
	}
}
