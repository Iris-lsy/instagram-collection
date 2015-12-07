package Bean;
public class Pic {
	private String url;
	private String link;
	public Pic() {
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		return "[link: " + link + " url: " + url + "]";
	}
	

}
